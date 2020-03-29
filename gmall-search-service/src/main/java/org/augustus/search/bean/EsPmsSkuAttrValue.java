package org.augustus.search.bean;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.StringJoiner;

/**
 * @author LinYongJin
 * @date 2020/3/29 18:26
 */
public class EsPmsSkuAttrValue {

    @Field(type = FieldType.Long, store = true)
    private Long attrId;

    @Field(type = FieldType.Long, store = true)
    private long valueId;

    public Long getAttrId() {
        return attrId;
    }

    public EsPmsSkuAttrValue setAttrId(Long attrId) {
        this.attrId = attrId;
        return this;
    }

    public long getValueId() {
        return valueId;
    }

    public EsPmsSkuAttrValue setValueId(long valueId) {
        this.valueId = valueId;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", EsPmsSkuAttrValue.class.getSimpleName() + "[", "]")
                .add("attrId=" + attrId)
                .add("valueId=" + valueId)
                .toString();
    }
}
