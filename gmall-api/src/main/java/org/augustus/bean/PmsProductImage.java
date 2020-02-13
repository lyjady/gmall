package org.augustus.bean;

import java.io.Serializable;

/**
 * Database Table Remarks:
 *   商品图片表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table pms_product_image
 */
public class PmsProductImage implements Serializable {
    /**
     * Database Column Remarks:
     *   编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_image.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   商品id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_image.product_id
     *
     * @mbg.generated
     */
    private Long productId;

    /**
     * Database Column Remarks:
     *   图片名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_image.img_name
     *
     * @mbg.generated
     */
    private String imgName;

    /**
     * Database Column Remarks:
     *   图片路径
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_image.img_url
     *
     * @mbg.generated
     */
    private String imgUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pms_product_image
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_image.id
     *
     * @return the value of pms_product_image.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_image.id
     *
     * @param id the value for pms_product_image.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_image.product_id
     *
     * @return the value of pms_product_image.product_id
     *
     * @mbg.generated
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_image.product_id
     *
     * @param productId the value for pms_product_image.product_id
     *
     * @mbg.generated
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_image.img_name
     *
     * @return the value of pms_product_image.img_name
     *
     * @mbg.generated
     */
    public String getImgName() {
        return imgName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_image.img_name
     *
     * @param imgName the value for pms_product_image.img_name
     *
     * @mbg.generated
     */
    public void setImgName(String imgName) {
        this.imgName = imgName == null ? null : imgName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_image.img_url
     *
     * @return the value of pms_product_image.img_url
     *
     * @mbg.generated
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_image.img_url
     *
     * @param imgUrl the value for pms_product_image.img_url
     *
     * @mbg.generated
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product_image
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
        sb.append(", imgName=").append(imgName);
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}