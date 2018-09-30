package com.example.demo.domain;

import java.math.BigDecimal;
import java.util.Date;

public class OrderInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.id
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.user_id
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.goods_id
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    private Long goodsId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.delivery_addr_id
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    private Long deliveryAddrId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.goods_name
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    private String goodsName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.goods_count
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    private Integer goodsCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.goods_price
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    private BigDecimal goodsPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.order_channel
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    private Byte orderChannel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.status
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    private Byte status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.create_time
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.pay_time
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    private Date payTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.id
     *
     * @return the value of order_info.id
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.id
     *
     * @param id the value for order_info.id
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.user_id
     *
     * @return the value of order_info.user_id
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.user_id
     *
     * @param userId the value for order_info.user_id
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.goods_id
     *
     * @return the value of order_info.goods_id
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    public Long getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.goods_id
     *
     * @param goodsId the value for order_info.goods_id
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.delivery_addr_id
     *
     * @return the value of order_info.delivery_addr_id
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    public Long getDeliveryAddrId() {
        return deliveryAddrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.delivery_addr_id
     *
     * @param deliveryAddrId the value for order_info.delivery_addr_id
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    public void setDeliveryAddrId(Long deliveryAddrId) {
        this.deliveryAddrId = deliveryAddrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.goods_name
     *
     * @return the value of order_info.goods_name
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.goods_name
     *
     * @param goodsName the value for order_info.goods_name
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.goods_count
     *
     * @return the value of order_info.goods_count
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    public Integer getGoodsCount() {
        return goodsCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.goods_count
     *
     * @param goodsCount the value for order_info.goods_count
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.goods_price
     *
     * @return the value of order_info.goods_price
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.goods_price
     *
     * @param goodsPrice the value for order_info.goods_price
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.order_channel
     *
     * @return the value of order_info.order_channel
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    public Byte getOrderChannel() {
        return orderChannel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.order_channel
     *
     * @param orderChannel the value for order_info.order_channel
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    public void setOrderChannel(Byte orderChannel) {
        this.orderChannel = orderChannel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.status
     *
     * @return the value of order_info.status
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.status
     *
     * @param status the value for order_info.status
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.create_time
     *
     * @return the value of order_info.create_time
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.create_time
     *
     * @param createTime the value for order_info.create_time
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.pay_time
     *
     * @return the value of order_info.pay_time
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.pay_time
     *
     * @param payTime the value for order_info.pay_time
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
}