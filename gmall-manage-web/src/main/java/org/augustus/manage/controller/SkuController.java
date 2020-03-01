package org.augustus.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.augustus.bean.PmsSkuInfo;
import org.augustus.service.SkuService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LinYongJin
 * @date 2020/3/1 16:29
 */
@RestController
@CrossOrigin
public class SkuController {

    @Reference
    private SkuService skuService;

    @RequestMapping("/saveSkuInfo")
    public String saveSkuInfo(@RequestBody PmsSkuInfo skuInfo) {
        return skuService.saveSkuInfo(skuInfo);
    }
}
