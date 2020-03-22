package org.augustus.manage.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.apache.commons.lang3.StringUtils;
import org.augustus.bean.*;
import org.augustus.manage.mapper.PmsSkuAttrValueMapper;
import org.augustus.manage.mapper.PmsSkuImageMapper;
import org.augustus.manage.mapper.PmsSkuInfoMapper;
import org.augustus.manage.mapper.PmsSkuSaleAttrValueMapper;
import org.augustus.service.SkuService;
import org.augustus.utils.CommonUtils;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author LinYongJin
 * @date 2020/3/1 16:30
 */
@Service
@Component
public class SkuServiceImpl implements SkuService {

    private final Logger logger = LoggerFactory.getLogger(SkuServiceImpl.class);

    @Autowired
    private PmsSkuInfoMapper skuInfoMapper;

    @Autowired
    private PmsSkuImageMapper skuImageMapper;

    @Autowired
    private PmsSkuAttrValueMapper skuAttrValueMapper;

    @Autowired
    private PmsSkuSaleAttrValueMapper skuSaleAttrValueMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    private final static String REDIS_SKU_PREFIX = "sku:";

    private final static String REDIS_SKU_SUFFIX = ":info";

    private final static String REDIS_LOCK_SUFFIX = ":lock";

    @Override
    @Transactional
    public String saveSkuInfo(PmsSkuInfo skuInfo) {
        skuInfoMapper.insertSelective(skuInfo);
        // 保存图片
        List<PmsSkuImage> skuImageList = skuInfo.getSkuImageList();
        skuImageList.forEach(image -> {
            image.setSkuId(skuInfo.getId());
            skuImageMapper.insertSelective(image);
        });
        // 保存平台属性
        List<PmsSkuAttrValue> skuAttrValueList = skuInfo.getSkuAttrValueList();
        skuAttrValueList.forEach(attrValue -> {
            attrValue.setSkuId(skuInfo.getId());
            skuAttrValueMapper.insertSelective(attrValue);
        });
        // 保存销售属性
        List<PmsSkuSaleAttrValue> skuSaleAttrValueList = skuInfo.getSkuSaleAttrValueList();
        skuSaleAttrValueList.forEach(saleAttrValue -> {
            saleAttrValue.setSkuId(skuInfo.getId());
            skuSaleAttrValueMapper.insertSelective(saleAttrValue);
        });
        return "success";
    }

    /**
     * 为了解决并发问题先从缓存中访问, 若缓存中没有则在访问数据库
     * 为了解决分布式锁的问题现先使用Redis来解决后面改成Redisson
     *
     * 缓存击穿: 一个热点key失效导致全部的请求都怼到数据库(使用分布式锁来限流, 控制访问数据库的请求量)
     * 缓存穿透: 访问一个缓存中不存在的key, 此时访问数据库, 数据库中也不存在。如果此时用这个key攻击系统会导致数据库压力过大(将这个为null的key也写入Redis并设置一个较短的时间)
     * 缓存雪崩: 集体key失效或者Redis宕机, 全部的请求都到数据库(为每个key在基本过期时间的基础上再加上一个随机数)
     *
     * 使用Redis的setnx在释放锁时遇到的问题: 锁是否是自己的, 如何避免误删
     * (使用唯一的token作为判断的条件, 但是这样做要发起两次网络请求, 第一次取key然后本地判断, 相同发起第二次删除的请求.这样有可能网络传输发生了延迟, 在第一次传输回Java服务器的过程中锁就失效了.造成误删)
     * (使用lua脚本进行优化将两次网络传输变成一次, 直接在一次网络请求中在Redis中判断token是否一致, 一致就直接删除)
     *
     * @param skuId
     * @return
     */
    @Override
    public PmsSkuInfo findSkuInfo(String skuId, String userAgent) {
        // 查看缓存中是否有数据
        ValueOperations<String, PmsSkuInfo> forSku = redisTemplate.opsForValue();
        ValueOperations<String, String> stringForSku = stringRedisTemplate.opsForValue();
        String skuKey = REDIS_SKU_PREFIX + skuId + REDIS_SKU_SUFFIX;
        PmsSkuInfo skuInfo = forSku.get(skuKey);
        if (skuInfo == null) {
            logger.info(userAgent + "缓存中没有访问数据库");
            // 缓冲中没有从MySQL中获取
            // 使用Redis的setnx指令来实现分布式锁
            // 判断是否被上锁
            String lockKey = REDIS_SKU_PREFIX + skuId + REDIS_LOCK_SUFFIX;
            // 用token作为锁的value值, 在删除的时候判断token是否一致。一致说明锁是自己上的删除, 不一致则说明锁是别人上的不做任何操作。
            String token = UUID.randomUUID().toString();
            if (!stringRedisTemplate.hasKey(lockKey)) {
                // 没锁并上锁
                stringForSku.set(lockKey, token, 5, TimeUnit.SECONDS);
                // 上锁成功
                logger.info(userAgent + "上锁成功");
                // 访问MySQL
                skuInfo = skuInfoMapper.selectByPrimaryKey(Long.parseLong(skuId));
                if (skuInfo == null) {
                    // 如果为空将null的数据放入redis并设置较短的过期时间, 防止缓存穿透
                    stringForSku.set(skuKey, "null", 5, TimeUnit.MINUTES);
                    return new PmsSkuInfo();
                }
                List<PmsSkuImage> skuImages = skuImageMapper.selectImageBySkuId(Long.parseLong(skuId));
                skuInfo.setSkuImageList(skuImages);
                // 获取完成后放置到缓存中设置过期时间为1个小时, 为了放置缓存雪崩问题, 在一个小时的基础上加上一个随机的数的过期时间单位为分钟
                int randomMinute = CommonUtils.generalRandomMinute(60);
                long ttl = 60 + randomMinute;
                forSku.set(skuKey, skuInfo, ttl, TimeUnit.MINUTES);
                // 释放锁
                logger.info(userAgent + "释放锁");
                String lockToken = stringForSku.get(lockKey);
                if (StringUtils.isNotBlank(lockToken)) {
                    // 通过lockToken来判断当前的锁是不是自己上的, 下面写法发起了两次网络请求, 有可能网络传输发生了延迟.在第一次传输回Java服务器的过程中锁就失效了.造成误删
                    // 使用lua脚本进行优化将两次网络传输变成一次, 直接在一次网络请求中判断token是否一致, 一致就直接删除
                    //if (lockToken.equals(token)) {
                        // 是就释放
                        //stringRedisTemplate.delete(lockKey);
                    //}
                    // lua脚本
                    String luaScript = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
                    DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
                    redisScript.setResultType(Long.class);
                    redisScript.setScriptText(luaScript);
                    stringRedisTemplate.execute(redisScript, Collections.singletonList(lockKey), token);
                }
                return skuInfo;
            } else {
                logger.info(userAgent + "存在锁, 上锁失败, 开始等待准备重新获取");
                // 设置失败存在相应的key
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return findSkuInfo(skuId, userAgent);
            }
        }
        logger.info(userAgent + "缓存中存在直接访问缓存");
        return skuInfo;
    }

    @Override
    public Map<String, String> getSkuAndValueIdMapping(Long spuId) {
        List<PmsSkuSaleAttrValue> pmsSkuSaleAttrValues = skuSaleAttrValueMapper.getSkuAndValueIdMapping(spuId);
        Map<String, String> map = new HashMap<>();
        for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : pmsSkuSaleAttrValues) {
            String value = String.valueOf(pmsSkuSaleAttrValue.getId());
            List<PmsProductSaleAttrValue> pmsProductSaleAttrValues = pmsSkuSaleAttrValue.getPmsProductSaleAttrValues();
            StringBuffer sb = new StringBuffer();
            for (PmsProductSaleAttrValue pmsProductSaleAttrValue : pmsProductSaleAttrValues) {
                sb.append(pmsProductSaleAttrValue.getId()).append("|");
            }
            sb.deleteCharAt(sb.length() - 1);
            map.put(sb.toString(), value);
        }
        return map;
    }
}
