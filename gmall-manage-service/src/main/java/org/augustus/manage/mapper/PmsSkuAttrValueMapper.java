package org.augustus.manage.mapper;

import org.augustus.bean.PmsSkuAttrValue;

public interface PmsSkuAttrValueMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_sku_attr_value
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_sku_attr_value
     *
     * @mbg.generated
     */
    int insert(PmsSkuAttrValue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_sku_attr_value
     *
     * @mbg.generated
     */
    int insertSelective(PmsSkuAttrValue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_sku_attr_value
     *
     * @mbg.generated
     */
    PmsSkuAttrValue selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_sku_attr_value
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(PmsSkuAttrValue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_sku_attr_value
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(PmsSkuAttrValue record);
}