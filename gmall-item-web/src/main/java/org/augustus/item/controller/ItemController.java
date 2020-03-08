package org.augustus.item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.augustus.bean.PmsProductSaleAttr;
import org.augustus.bean.PmsSkuInfo;
import org.augustus.service.SkuService;
import org.augustus.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @author LinYongJin
 * @date 2020/3/1 17:43
 */
@Controller
public class ItemController {

    @Reference
    private SkuService skuService;

    @Reference
    private SpuService spuService;

    @RequestMapping("/{skuId}.html")
    public String itemInfo(@PathVariable String skuId, ModelMap modelMap) {
        PmsSkuInfo skuInfo = skuService.findSkuInfo(skuId);
        Long spuId = spuService.getSpuIdBySkuId(Long.parseLong(skuId));
        List<PmsProductSaleAttr> pmsProductSaleAttrs = spuService.spuSaleAttrList(String.valueOf(spuId));
        Map<String, String> skuIdValueIdMapping = skuService.getSkuAndValueIdMapping(spuId);
        modelMap.put("spuSaleAttrListCheckBySku", pmsProductSaleAttrs);
        modelMap.put("skuInfo", skuInfo);
        modelMap.put("skuHash", JSON.toJSONString(skuIdValueIdMapping));
        return "item";
    }
}
