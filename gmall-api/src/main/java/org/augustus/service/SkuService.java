package org.augustus.service;

import org.augustus.bean.PmsSkuInfo;

import java.util.Map;

/**
 * @author LinYongJin
 * @date 2020/3/1 16:30
 */
public interface SkuService {

    String saveSkuInfo(PmsSkuInfo skuInfo);

    PmsSkuInfo findSkuInfo(String skuId);

    Map<String, String> getSkuAndValueIdMapping(Long spuId);
}
