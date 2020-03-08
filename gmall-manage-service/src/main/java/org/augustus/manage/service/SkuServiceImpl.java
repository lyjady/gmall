package org.augustus.manage.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.augustus.bean.*;
import org.augustus.manage.mapper.PmsSkuAttrValueMapper;
import org.augustus.manage.mapper.PmsSkuImageMapper;
import org.augustus.manage.mapper.PmsSkuInfoMapper;
import org.augustus.manage.mapper.PmsSkuSaleAttrValueMapper;
import org.augustus.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LinYongJin
 * @date 2020/3/1 16:30
 */
@Service
@Component
public class SkuServiceImpl implements SkuService {

    @Autowired
    private PmsSkuInfoMapper skuInfoMapper;

    @Autowired
    private PmsSkuImageMapper skuImageMapper;

    @Autowired
    private PmsSkuAttrValueMapper skuAttrValueMapper;

    @Autowired
    private PmsSkuSaleAttrValueMapper skuSaleAttrValueMapper;

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

    @Override
    public PmsSkuInfo findSkuInfo(String skuId) {
        PmsSkuInfo skuInfo = skuInfoMapper.selectByPrimaryKey(Long.parseLong(skuId));
        List<PmsSkuImage> skuImages = skuImageMapper.selectImageBySkuId(Long.parseLong(skuId));
        skuInfo.setSkuImageList(skuImages);
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
