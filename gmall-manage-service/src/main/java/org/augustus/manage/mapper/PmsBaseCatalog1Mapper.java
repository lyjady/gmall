package org.augustus.manage.mapper;

import org.augustus.bean.PmsBaseCatalog1;

import java.util.List;

public interface PmsBaseCatalog1Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_base_catalog1
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_base_catalog1
     *
     * @mbg.generated
     */
    int insert(PmsBaseCatalog1 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_base_catalog1
     *
     * @mbg.generated
     */
    int insertSelective(PmsBaseCatalog1 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_base_catalog1
     *
     * @mbg.generated
     */
    PmsBaseCatalog1 selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_base_catalog1
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(PmsBaseCatalog1 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_base_catalog1
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(PmsBaseCatalog1 record);

    List<PmsBaseCatalog1> findAll();
}