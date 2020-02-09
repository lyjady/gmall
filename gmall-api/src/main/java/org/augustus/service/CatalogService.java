package org.augustus.service;

import org.augustus.bean.PmsBaseCatalog1;
import org.augustus.bean.PmsBaseCatalog2;
import org.augustus.bean.PmsBaseCatalog3;

import java.util.List;

/**
 * @author LinYongJin
 * @date 2020/2/9 16:31
 */
public interface CatalogService {

    List<PmsBaseCatalog1> getCatalog1();

    List<PmsBaseCatalog2> getCatalog2(Integer id);

    List<PmsBaseCatalog3> getCatalog3(Integer id);
}
