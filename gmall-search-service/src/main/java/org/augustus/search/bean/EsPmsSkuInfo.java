package org.augustus.search.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author LinYongJin
 * @date 2020/3/29 18:05
 */
@Document(indexName = "sku", type = "PmsSkuInfo", createIndex = false)
public class EsPmsSkuInfo {

    @Id
    private Long id;

    @Field(type = FieldType.Text, store = true, analyzer = "ik_max_word")
    private String skuName;

    @Field(type = FieldType.Text, store = true, analyzer = "ik_smart")
    private String skuDesc;

    @Field(type = FieldType.Long, store = true)
    private Long catalog3Id;

    @Field(type = FieldType.Double, store = true)
    private BigDecimal price;

    @Field(type = FieldType.Keyword, index = false, store = true)
    private String skuDefaultImg;

    @Field(type = FieldType.Double, store = true)
    private double hotScore;

    @Field(type = FieldType.Long, store = true)
    private Long productId;

    @Field(type = FieldType.Object, store = true)
    private List<EsPmsSkuAttrValue> skuAttrValueList;

    public Long getId() {
        return id;
    }

    public EsPmsSkuInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getSkuName() {
        return skuName;
    }

    public EsPmsSkuInfo setSkuName(String skuName) {
        this.skuName = skuName;
        return this;
    }

    public String getSkuDesc() {
        return skuDesc;
    }

    public EsPmsSkuInfo setSkuDesc(String skuDesc) {
        this.skuDesc = skuDesc;
        return this;
    }

    public Long getCatalog3Id() {
        return catalog3Id;
    }

    public EsPmsSkuInfo setCatalog3Id(Long catalog3Id) {
        this.catalog3Id = catalog3Id;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public EsPmsSkuInfo setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getSkuDefaultImg() {
        return skuDefaultImg;
    }

    public EsPmsSkuInfo setSkuDefaultImg(String skuDefaultImg) {
        this.skuDefaultImg = skuDefaultImg;
        return this;
    }

    public double getHotScore() {
        return hotScore;
    }

    public EsPmsSkuInfo setHotScore(double hotScore) {
        this.hotScore = hotScore;
        return this;
    }

    public Long getProductId() {
        return productId;
    }

    public EsPmsSkuInfo setProductId(Long productId) {
        this.productId = productId;
        return this;
    }

    public List<EsPmsSkuAttrValue> getSkuAttrValueList() {
        return skuAttrValueList;
    }

    public EsPmsSkuInfo setSkuAttrValueList(List<EsPmsSkuAttrValue> skuAttrValueList) {
        this.skuAttrValueList = skuAttrValueList;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", EsPmsSkuInfo.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("skuName='" + skuName + "'")
                .add("skuDesc='" + skuDesc + "'")
                .add("catalog3Id=" + catalog3Id)
                .add("price=" + price)
                .add("skuDefaultImg='" + skuDefaultImg + "'")
                .add("hotScore=" + hotScore)
                .add("productId=" + productId)
                .add("skuAttrValueList=" + skuAttrValueList)
                .toString();
    }
}
