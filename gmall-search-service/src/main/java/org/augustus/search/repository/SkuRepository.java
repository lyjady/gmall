package org.augustus.search.repository;

import org.augustus.search.bean.EsPmsSkuInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author LinYongJin
 * @date 2020/3/29 18:33
 */
@Repository
public interface SkuRepository extends ElasticsearchRepository<EsPmsSkuInfo, Long> {
}
