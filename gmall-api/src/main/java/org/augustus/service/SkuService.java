package org.augustus.service;

import org.augustus.bean.PmsSkuInfo;

/**
 * @author LinYongJin
 * @date 2020/3/1 16:30
 */
public interface SkuService {

    String saveSkuInfo(PmsSkuInfo skuInfo);

    PmsSkuInfo findSkuInfo(String skuId);
}
