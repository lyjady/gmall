package org.augustus.bean;

import java.io.Serializable;

/**
 * Database Table Remarks:
 *   sku平台属性值关联表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table pms_sku_attr_value
 */
public class PmsSkuAttrValue implements Serializable {
    /**
     * Database Column Remarks:
     *   编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_sku_attr_value.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   属性id（冗余)
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_sku_attr_value.attr_id
     *
     * @mbg.generated
     */
    private Long attrId;

    /**
     * Database Column Remarks:
     *   属性值id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_sku_attr_value.value_id
     *
     * @mbg.generated
     */
    private Long valueId;

    /**
     * Database Column Remarks:
     *   skuid
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_sku_attr_value.sku_id
     *
     * @mbg.generated
     */
    private Long skuId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pms_sku_attr_value
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_sku_attr_value.id
     *
     * @return the value of pms_sku_attr_value.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_sku_attr_value.id
     *
     * @param id the value for pms_sku_attr_value.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_sku_attr_value.attr_id
     *
     * @return the value of pms_sku_attr_value.attr_id
     *
     * @mbg.generated
     */
    public Long getAttrId() {
        return attrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_sku_attr_value.attr_id
     *
     * @param attrId the value for pms_sku_attr_value.attr_id
     *
     * @mbg.generated
     */
    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_sku_attr_value.value_id
     *
     * @return the value of pms_sku_attr_value.value_id
     *
     * @mbg.generated
     */
    public Long getValueId() {
        return valueId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_sku_attr_value.value_id
     *
     * @param valueId the value for pms_sku_attr_value.value_id
     *
     * @mbg.generated
     */
    public void setValueId(Long valueId) {
        this.valueId = valueId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_sku_attr_value.sku_id
     *
     * @return the value of pms_sku_attr_value.sku_id
     *
     * @mbg.generated
     */
    public Long getSkuId() {
        return skuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_sku_attr_value.sku_id
     *
     * @param skuId the value for pms_sku_attr_value.sku_id
     *
     * @mbg.generated
     */
    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_sku_attr_value
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", attrId=").append(attrId);
        sb.append(", valueId=").append(valueId);
        sb.append(", skuId=").append(skuId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}