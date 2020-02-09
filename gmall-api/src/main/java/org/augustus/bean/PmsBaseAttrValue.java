package org.augustus.bean;

import java.io.Serializable;

/**
 * Database Table Remarks:
 *   属性值表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table pms_base_attr_value
 */
public class PmsBaseAttrValue implements Serializable {
    /**
     * Database Column Remarks:
     *   编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_base_attr_value.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   属性值名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_base_attr_value.value_name
     *
     * @mbg.generated
     */
    private String valueName;

    /**
     * Database Column Remarks:
     *   属性id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_base_attr_value.attr_id
     *
     * @mbg.generated
     */
    private Long attrId;

    /**
     * Database Column Remarks:
     *   启用：1 停用：0 1
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_base_attr_value.is_enabled
     *
     * @mbg.generated
     */
    private String isEnabled;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pms_base_attr_value
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_base_attr_value.id
     *
     * @return the value of pms_base_attr_value.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_base_attr_value.id
     *
     * @param id the value for pms_base_attr_value.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_base_attr_value.value_name
     *
     * @return the value of pms_base_attr_value.value_name
     *
     * @mbg.generated
     */
    public String getValueName() {
        return valueName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_base_attr_value.value_name
     *
     * @param valueName the value for pms_base_attr_value.value_name
     *
     * @mbg.generated
     */
    public void setValueName(String valueName) {
        this.valueName = valueName == null ? null : valueName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_base_attr_value.attr_id
     *
     * @return the value of pms_base_attr_value.attr_id
     *
     * @mbg.generated
     */
    public Long getAttrId() {
        return attrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_base_attr_value.attr_id
     *
     * @param attrId the value for pms_base_attr_value.attr_id
     *
     * @mbg.generated
     */
    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_base_attr_value.is_enabled
     *
     * @return the value of pms_base_attr_value.is_enabled
     *
     * @mbg.generated
     */
    public String getIsEnabled() {
        return isEnabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_base_attr_value.is_enabled
     *
     * @param isEnabled the value for pms_base_attr_value.is_enabled
     *
     * @mbg.generated
     */
    public void setIsEnabled(String isEnabled) {
        this.isEnabled = isEnabled == null ? null : isEnabled.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_base_attr_value
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
        sb.append(", valueName=").append(valueName);
        sb.append(", attrId=").append(attrId);
        sb.append(", isEnabled=").append(isEnabled);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}