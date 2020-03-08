package org.augustus.manage.mapper;

import org.apache.ibatis.annotations.Param;
import org.augustus.bean.PmsProductSaleAttr;

import java.util.List;

public interface PmsProductSaleAttrMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product_sale_attr
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product_sale_attr
     *
     * @mbg.generated
     */
    int insert(PmsProductSaleAttr record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product_sale_attr
     *
     * @mbg.generated
     */
    int insertSelective(PmsProductSaleAttr record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product_sale_attr
     *
     * @mbg.generated
     */
    PmsProductSaleAttr selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product_sale_attr
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(PmsProductSaleAttr record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product_sale_attr
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(PmsProductSaleAttr record);

    List<PmsProductSaleAttr> getSpuSaleAttrList(Integer spuId);

    List<PmsProductSaleAttr> getSaleAttrListCheck(@Param("spuId") Long spuId, @Param("skuId") Long skuId);
}