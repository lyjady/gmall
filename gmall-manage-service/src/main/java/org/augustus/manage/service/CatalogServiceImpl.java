package org.augustus.manage.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.augustus.bean.PmsBaseCatalog1;
import org.augustus.bean.PmsBaseCatalog2;
import org.augustus.bean.PmsBaseCatalog3;
import org.augustus.manage.mapper.PmsBaseCatalog1Mapper;
import org.augustus.manage.mapper.PmsBaseCatalog2Mapper;
import org.augustus.manage.mapper.PmsBaseCatalog3Mapper;
import org.augustus.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author LinYongJin
 * @date 2020/2/9 16:32
 */
@Service
@Component
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private PmsBaseCatalog1Mapper catalog1Mapper;

    @Autowired
    private PmsBaseCatalog2Mapper catalog2Mapper;

    @Autowired
    private PmsBaseCatalog3Mapper catalog3Mapper;

    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        return catalog1Mapper.findAll();
    }

    @Override
    public List<PmsBaseCatalog2> getCatalog2(Integer id) {
        return catalog2Mapper.findCatalog2ById(id);
    }

    @Override
    public List<PmsBaseCatalog3> getCatalog3(Integer id) {
        return catalog3Mapper.findCatalog3ById(id);
    }
}
