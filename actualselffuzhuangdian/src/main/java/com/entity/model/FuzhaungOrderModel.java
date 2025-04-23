package com.entity.model;

import com.entity.FuzhaungOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 服装订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FuzhaungOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单号
     */
    private String fuzhaungOrderUuidNumber;


    /**
     * 收货地址
     */
    private Integer addressId;


    /**
     * 服装
     */
    private Integer fuzhaungId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 购买数量
     */
    private Integer buyNumber;


    /**
     * 实付价格
     */
    private Double fuzhaungOrderTruePrice;


    /**
     * 快递公司
     */
    private String fuzhaungOrderCourierName;


    /**
     * 订单快递单号
     */
    private String fuzhaungOrderCourierNumber;


    /**
     * 订单类型
     */
    private Integer fuzhaungOrderTypes;


    /**
     * 支付类型
     */
    private Integer fuzhaungOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：订单号
	 */
    public String getFuzhaungOrderUuidNumber() {
        return fuzhaungOrderUuidNumber;
    }


    /**
	 * 设置：订单号
	 */
    public void setFuzhaungOrderUuidNumber(String fuzhaungOrderUuidNumber) {
        this.fuzhaungOrderUuidNumber = fuzhaungOrderUuidNumber;
    }
    /**
	 * 获取：收货地址
	 */
    public Integer getAddressId() {
        return addressId;
    }


    /**
	 * 设置：收货地址
	 */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    /**
	 * 获取：服装
	 */
    public Integer getFuzhaungId() {
        return fuzhaungId;
    }


    /**
	 * 设置：服装
	 */
    public void setFuzhaungId(Integer fuzhaungId) {
        this.fuzhaungId = fuzhaungId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：购买数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 设置：购买数量
	 */
    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getFuzhaungOrderTruePrice() {
        return fuzhaungOrderTruePrice;
    }


    /**
	 * 设置：实付价格
	 */
    public void setFuzhaungOrderTruePrice(Double fuzhaungOrderTruePrice) {
        this.fuzhaungOrderTruePrice = fuzhaungOrderTruePrice;
    }
    /**
	 * 获取：快递公司
	 */
    public String getFuzhaungOrderCourierName() {
        return fuzhaungOrderCourierName;
    }


    /**
	 * 设置：快递公司
	 */
    public void setFuzhaungOrderCourierName(String fuzhaungOrderCourierName) {
        this.fuzhaungOrderCourierName = fuzhaungOrderCourierName;
    }
    /**
	 * 获取：订单快递单号
	 */
    public String getFuzhaungOrderCourierNumber() {
        return fuzhaungOrderCourierNumber;
    }


    /**
	 * 设置：订单快递单号
	 */
    public void setFuzhaungOrderCourierNumber(String fuzhaungOrderCourierNumber) {
        this.fuzhaungOrderCourierNumber = fuzhaungOrderCourierNumber;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getFuzhaungOrderTypes() {
        return fuzhaungOrderTypes;
    }


    /**
	 * 设置：订单类型
	 */
    public void setFuzhaungOrderTypes(Integer fuzhaungOrderTypes) {
        this.fuzhaungOrderTypes = fuzhaungOrderTypes;
    }
    /**
	 * 获取：支付类型
	 */
    public Integer getFuzhaungOrderPaymentTypes() {
        return fuzhaungOrderPaymentTypes;
    }


    /**
	 * 设置：支付类型
	 */
    public void setFuzhaungOrderPaymentTypes(Integer fuzhaungOrderPaymentTypes) {
        this.fuzhaungOrderPaymentTypes = fuzhaungOrderPaymentTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：订单创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
