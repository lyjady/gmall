package org.augustus.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.augustus.bean.PmsBaseCatalog1;
import org.augustus.bean.PmsBaseCatalog2;
import org.augustus.bean.PmsBaseCatalog3;
import org.augustus.service.CatalogService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LinYongJin
 * @date 2020/2/9 16:37
 */
@RestController
@CrossOrigin
public class CatalogController {

    @Reference
    private CatalogService catalogService;

    @PostMapping("/getCatalog1")
    public List<PmsBaseCatalog1> getCatalog1() {
        return catalogService.getCatalog1();
    }

    @PostMapping("/getCatalog2")
    public List<PmsBaseCatalog2> getCatalog2(Integer catalog1Id) {
        return catalogService.getCatalog2(catalog1Id);
    }

    @PostMapping("/getCatalog3")
    public List<PmsBaseCatalog3> getCatalog3(Integer catalog2Id) {
        return catalogService.getCatalog3(catalog2Id);
    }
}
