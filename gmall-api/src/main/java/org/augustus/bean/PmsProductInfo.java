package org.augustus.bean;

import java.io.Serializable;
import java.util.List;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table pms_product_info
 */
public class PmsProductInfo implements Serializable {
    /**
     * Database Column Remarks:
     *   商品id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_info.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   商品名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_info.product_name
     *
     * @mbg.generated
     */
    private String productName;

    /**
     * Database Column Remarks:
     *   商品描述(后台简述）
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_info.description
     *
     * @mbg.generated
     */
    private String description;

    /**
     * Database Column Remarks:
     *   三级分类id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_info.catalog3_id
     *
     * @mbg.generated
     */
    private Long catalog3Id;

    /**
     * Database Column Remarks:
     *   品牌id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_info.tm_id
     *
     * @mbg.generated
     */
    private Long tmId;

    private List<PmsProductImage> spuImageList;

    private List<PmsProductSaleAttr> spuSaleAttrList;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pms_product_info
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_info.id
     *
     * @return the value of pms_product_info.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_info.id
     *
     * @param id the value for pms_product_info.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_info.product_name
     *
     * @return the value of pms_product_info.product_name
     *
     * @mbg.generated
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_info.product_name
     *
     * @param productName the value for pms_product_info.product_name
     *
     * @mbg.generated
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_info.description
     *
     * @return the value of pms_product_info.description
     *
     * @mbg.generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_info.description
     *
     * @param description the value for pms_product_info.description
     *
     * @mbg.generated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_info.catalog3_id
     *
     * @return the value of pms_product_info.catalog3_id
     *
     * @mbg.generated
     */
    public Long getCatalog3Id() {
        return catalog3Id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_info.catalog3_id
     *
     * @param catalog3Id the value for pms_product_info.catalog3_id
     *
     * @mbg.generated
     */
    public void setCatalog3Id(Long catalog3Id) {
        this.catalog3Id = catalog3Id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_info.tm_id
     *
     * @return the value of pms_product_info.tm_id
     *
     * @mbg.generated
     */
    public Long getTmId() {
        return tmId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_info.tm_id
     *
     * @param tmId the value for pms_product_info.tm_id
     *
     * @mbg.generated
     */
    public void setTmId(Long tmId) {
        this.tmId = tmId;
    }

    public List<PmsProductImage> getSpuImageList() {
        return spuImageList;
    }

    public void setSpuImageList(List<PmsProductImage> spuImageList) {
        this.spuImageList = spuImageList;
    }

    public List<PmsProductSaleAttr> getSpuSaleAttrList() {
        return spuSaleAttrList;
    }

    public void setSpuSaleAttrList(List<PmsProductSaleAttr> spuSaleAttrList) {
        this.spuSaleAttrList = spuSaleAttrList;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product_info
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
        sb.append(", productName=").append(productName);
        sb.append(", description=").append(description);
        sb.append(", catalog3Id=").append(catalog3Id);
        sb.append(", tmId=").append(tmId);
        sb.append(", spuImageList=").append(spuImageList);
        sb.append(", spuSaleAttrList=").append(spuSaleAttrList);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}