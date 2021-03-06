package org.augustus.service;

import org.augustus.bean.PmsBaseSaleAttr;
import org.augustus.bean.PmsProductImage;
import org.augustus.bean.PmsProductInfo;
import org.augustus.bean.PmsProductSaleAttr;

import java.util.List;

/**
 * @author LinYongJin
 * @date 2020/2/13 16:18
 */
public interface SpuService {

    List<PmsProductInfo> getSpuList(Long catalog3Id);

    List<PmsProductImage> getSpuImageList(Long spuId);

    List<PmsBaseSaleAttr> baseSaleAttrList();

    String saveSpuInfo(PmsProductInfo productInfo);

    List<PmsProductSaleAttr> spuSaleAttrList(String spuId);

    Long getSpuIdBySkuId(long skuId);

    List<PmsProductSaleAttr> getSaleAttrListCheck(Long spuId, Long skuId);
}
