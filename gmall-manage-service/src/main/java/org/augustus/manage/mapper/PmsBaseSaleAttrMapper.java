package org.augustus.manage.mapper;

import org.augustus.bean.PmsBaseSaleAttr;

import java.util.List;

public interface PmsBaseSaleAttrMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_base_sale_attr
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_base_sale_attr
     *
     * @mbg.generated
     */
    int insert(PmsBaseSaleAttr record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_base_sale_attr
     *
     * @mbg.generated
     */
    int insertSelective(PmsBaseSaleAttr record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_base_sale_attr
     *
     * @mbg.generated
     */
    PmsBaseSaleAttr selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_base_sale_attr
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(PmsBaseSaleAttr record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_base_sale_attr
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(PmsBaseSaleAttr record);

    List<PmsBaseSaleAttr> baseSaleAttrList();

}