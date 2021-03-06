package org.augustus.bean;

import java.io.Serializable;
import java.util.List;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table pms_product_sale_attr
 */
public class PmsProductSaleAttr implements Serializable {
    /**
     * Database Column Remarks:
     *   id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_sale_attr.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   商品id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_sale_attr.product_id
     *
     * @mbg.generated
     */
    private Long productId;

    /**
     * Database Column Remarks:
     *   销售属性id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_sale_attr.sale_attr_id
     *
     * @mbg.generated
     */
    private Long saleAttrId;

    /**
     * Database Column Remarks:
     *   销售属性名称(冗余)
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_sale_attr.sale_attr_name
     *
     * @mbg.generated
     */
    private String saleAttrName;

    private List<PmsProductSaleAttrValue> spuSaleAttrValueList;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pms_product_sale_attr
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_sale_attr.id
     *
     * @return the value of pms_product_sale_attr.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_sale_attr.id
     *
     * @param id the value for pms_product_sale_attr.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_sale_attr.product_id
     *
     * @return the value of pms_product_sale_attr.product_id
     *
     * @mbg.generated
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_sale_attr.product_id
     *
     * @param productId the value for pms_product_sale_attr.product_id
     *
     * @mbg.generated
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_sale_attr.sale_attr_id
     *
     * @return the value of pms_product_sale_attr.sale_attr_id
     *
     * @mbg.generated
     */
    public Long getSaleAttrId() {
        return saleAttrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_sale_attr.sale_attr_id
     *
     * @param saleAttrId the value for pms_product_sale_attr.sale_attr_id
     *
     * @mbg.generated
     */
    public void setSaleAttrId(Long saleAttrId) {
        this.saleAttrId = saleAttrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_sale_attr.sale_attr_name
     *
     * @return the value of pms_product_sale_attr.sale_attr_name
     *
     * @mbg.generated
     */
    public String getSaleAttrName() {
        return saleAttrName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_sale_attr.sale_attr_name
     *
     * @param saleAttrName the value for pms_product_sale_attr.sale_attr_name
     *
     * @mbg.generated
     */
    public void setSaleAttrName(String saleAttrName) {
        this.saleAttrName = saleAttrName == null ? null : saleAttrName.trim();
    }

    public List<PmsProductSaleAttrValue> getSpuSaleAttrValueList() {
        return spuSaleAttrValueList;
    }

    public void setSpuSaleAttrValueList(List<PmsProductSaleAttrValue> spuSaleAttrValueList) {
        this.spuSaleAttrValueList = spuSaleAttrValueList;
    }
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product_sale_attr
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
        sb.append(", productId=").append(productId);
        sb.append(", saleAttrId=").append(saleAttrId);
        sb.append(", saleAttrName=").append(saleAttrName);
        sb.append(", spuSaleAttrValueList=").append(spuSaleAttrValueList);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}