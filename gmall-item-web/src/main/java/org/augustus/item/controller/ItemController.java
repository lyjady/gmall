package org.augustus.item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.augustus.bean.PmsSkuInfo;
import org.augustus.service.SkuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LinYongJin
 * @date 2020/3/1 17:43
 */
@Controller
public class ItemController {

    @Reference
    private SkuService skuService;

    @RequestMapping("/{skuId}.html")
    public String itemInfo(@PathVariable String skuId, ModelMap modelMap) {
        PmsSkuInfo skuInfo = skuService.findSkuInfo(skuId);
        modelMap.put("skuInfo", skuInfo);
        return "item";
    }
}
