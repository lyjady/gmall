package org.augustus.search;

import org.augustus.search.bean.EsPmsSkuAttrValue;
import org.augustus.search.bean.EsPmsSkuInfo;
import org.augustus.search.repository.SkuRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class GmallSearchServiceApplicationTests {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private SkuRepository skuRepository;

    @Test
    void contextLoads() {
        EsPmsSkuInfo skuInfo = new EsPmsSkuInfo();
        skuInfo.setId(1L).setSkuName("宝可梦: 剑").setSkuDesc("垃圾游戏, GF吃屎").setPrice(new BigDecimal(235));
        EsPmsSkuAttrValue av = new EsPmsSkuAttrValue();
        av.setAttrId(1L).setValueId(12L);
        EsPmsSkuAttrValue av2 = new EsPmsSkuAttrValue();
        av2.setAttrId(2L).setValueId(23L);
        List<EsPmsSkuAttrValue> attrValues = Stream.of(av, av2).collect(Collectors.toList());
        skuInfo.setSkuAttrValueList(attrValues);
        skuRepository.save(skuInfo);
    }

}
