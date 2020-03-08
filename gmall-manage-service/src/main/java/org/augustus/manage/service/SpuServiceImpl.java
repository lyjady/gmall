package org.augustus.manage.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.augustus.bean.*;
import org.augustus.manage.mapper.*;
import org.augustus.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author LinYongJin
 * @date 2020/2/13 16:27
 */
@Service
@Component
public class SpuServiceImpl implements SpuService {

    @Autowired
    private PmsProductInfoMapper productInfoMapper;

    @Autowired
    private PmsProductImageMapper productImageMapper;

    @Autowired
    private PmsBaseSaleAttrMapper baseSaleAttrMapper;

    @Autowired
    private PmsProductSaleAttrMapper productSaleAttrMapper;

    @Autowired
    private PmsProductSaleAttrValueMapper productSaleAttrValueMapper;

    @Autowired
    private PmsSkuInfoMapper skuInfoMapper;

    @Override
    public List<PmsProductInfo> getSpuList(Long catalog3Id) {
        return productInfoMapper.getSpuList(catalog3Id);
    }

    @Override
    public List<PmsProductImage> getSpuImageList(Long spuId) {
        return productImageMapper.getSpuImageList(spuId);
    }

    @Override
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        return baseSaleAttrMapper.baseSaleAttrList();
    }

    @Override
    @Transactional
    public String saveSpuInfo(PmsProductInfo productInfo) {
        try {
            // 1.保存spu信息
            productInfoMapper.insertSelective(productInfo);
            // 2.保存图片信息
            List<PmsProductImage> spuImageList = productInfo.getSpuImageList();
            spuImageList.forEach(image -> {
                image.setProductId(productInfo.getId());
                productImageMapper.insertSelective(image);
            });
            // 3.保存商品销售属性
            List<PmsProductSaleAttr> spuSaleAttrList = productInfo.getSpuSaleAttrList();
            spuSaleAttrList.forEach(attr -> {
                attr.setProductId(productInfo.getId());
                productSaleAttrMapper.insertSelective(attr);
                List<PmsProductSaleAttrValue> spuSaleAttrValueList = attr.getSpuSaleAttrValueList();
                spuSaleAttrValueList.forEach(value -> {
                    value.setProductId(productInfo.getId());
                    productSaleAttrValueMapper.insertSelective(value);
                });
            });
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId) {
        return productSaleAttrMapper.getSpuSaleAttrList(Integer.parseInt(spuId));
    }

    @Override
    public Long getSpuIdBySkuId(long skuId) {
        return skuInfoMapper.getSpuIdBySkuId(skuId);
    }

    @Override
    public List<PmsProductSaleAttr> getSaleAttrListCheck(Long spuId, Long skuId) {
        return productSaleAttrMapper.getSaleAttrListCheck(spuId, skuId);
    }
}
