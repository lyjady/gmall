package org.augustus.manage.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.augustus.bean.PmsSkuAttrValue;
import org.augustus.bean.PmsSkuImage;
import org.augustus.bean.PmsSkuInfo;
import org.augustus.bean.PmsSkuSaleAttrValue;
import org.augustus.manage.mapper.PmsSkuAttrValueMapper;
import org.augustus.manage.mapper.PmsSkuImageMapper;
import org.augustus.manage.mapper.PmsSkuInfoMapper;
import org.augustus.manage.mapper.PmsSkuSaleAttrValueMapper;
import org.augustus.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
