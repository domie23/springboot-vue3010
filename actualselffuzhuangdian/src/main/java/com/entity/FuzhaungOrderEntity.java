package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 服装订单
 *
 * @author 
 * @email
 */
@TableName("fuzhaung_order")
public class FuzhaungOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FuzhaungOrderEntity() {

	}

	public FuzhaungOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 订单号
     */
    @TableField(value = "fuzhaung_order_uuid_number")

    private String fuzhaungOrderUuidNumber;


    /**
     * 收货地址
     */
    @TableField(value = "address_id")

    private Integer addressId;


    /**
     * 服装
     */
    @TableField(value = "fuzhaung_id")

    private Integer fuzhaungId;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 购买数量
     */
    @TableField(value = "buy_number")

    private Integer buyNumber;


    /**
     * 实付价格
     */
    @TableField(value = "fuzhaung_order_true_price")

    private Double fuzhaungOrderTruePrice;


    /**
     * 快递公司
     */
    @TableField(value = "fuzhaung_order_courier_name")

    private String fuzhaungOrderCourierName;


    /**
     * 订单快递单号
     */
    @TableField(value = "fuzhaung_order_courier_number")

    private String fuzhaungOrderCourierNumber;


    /**
     * 订单类型
     */
    @TableField(value = "fuzhaung_order_types")

    private Integer fuzhaungOrderTypes;


    /**
     * 支付类型
     */
    @TableField(value = "fuzhaung_order_payment_types")

    private Integer fuzhaungOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单号
	 */
    public String getFuzhaungOrderUuidNumber() {
        return fuzhaungOrderUuidNumber;
    }
    /**
	 * 获取：订单号
	 */

    public void setFuzhaungOrderUuidNumber(String fuzhaungOrderUuidNumber) {
        this.fuzhaungOrderUuidNumber = fuzhaungOrderUuidNumber;
    }
    /**
	 * 设置：收货地址
	 */
    public Integer getAddressId() {
        return addressId;
    }
    /**
	 * 获取：收货地址
	 */

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    /**
	 * 设置：服装
	 */
    public Integer getFuzhaungId() {
        return fuzhaungId;
    }
    /**
	 * 获取：服装
	 */

    public void setFuzhaungId(Integer fuzhaungId) {
        this.fuzhaungId = fuzhaungId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：购买数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }
    /**
	 * 获取：购买数量
	 */

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getFuzhaungOrderTruePrice() {
        return fuzhaungOrderTruePrice;
    }
    /**
	 * 获取：实付价格
	 */

    public void setFuzhaungOrderTruePrice(Double fuzhaungOrderTruePrice) {
        this.fuzhaungOrderTruePrice = fuzhaungOrderTruePrice;
    }
    /**
	 * 设置：快递公司
	 */
    public String getFuzhaungOrderCourierName() {
        return fuzhaungOrderCourierName;
    }
    /**
	 * 获取：快递公司
	 */

    public void setFuzhaungOrderCourierName(String fuzhaungOrderCourierName) {
        this.fuzhaungOrderCourierName = fuzhaungOrderCourierName;
    }
    /**
	 * 设置：订单快递单号
	 */
    public String getFuzhaungOrderCourierNumber() {
        return fuzhaungOrderCourierNumber;
    }
    /**
	 * 获取：订单快递单号
	 */

    public void setFuzhaungOrderCourierNumber(String fuzhaungOrderCourierNumber) {
        this.fuzhaungOrderCourierNumber = fuzhaungOrderCourierNumber;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getFuzhaungOrderTypes() {
        return fuzhaungOrderTypes;
    }
    /**
	 * 获取：订单类型
	 */

    public void setFuzhaungOrderTypes(Integer fuzhaungOrderTypes) {
        this.fuzhaungOrderTypes = fuzhaungOrderTypes;
    }
    /**
	 * 设置：支付类型
	 */
    public Integer getFuzhaungOrderPaymentTypes() {
        return fuzhaungOrderPaymentTypes;
    }
    /**
	 * 获取：支付类型
	 */

    public void setFuzhaungOrderPaymentTypes(Integer fuzhaungOrderPaymentTypes) {
        this.fuzhaungOrderPaymentTypes = fuzhaungOrderPaymentTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "FuzhaungOrder{" +
            "id=" + id +
            ", fuzhaungOrderUuidNumber=" + fuzhaungOrderUuidNumber +
            ", addressId=" + addressId +
            ", fuzhaungId=" + fuzhaungId +
            ", yonghuId=" + yonghuId +
            ", buyNumber=" + buyNumber +
            ", fuzhaungOrderTruePrice=" + fuzhaungOrderTruePrice +
            ", fuzhaungOrderCourierName=" + fuzhaungOrderCourierName +
            ", fuzhaungOrderCourierNumber=" + fuzhaungOrderCourierNumber +
            ", fuzhaungOrderTypes=" + fuzhaungOrderTypes +
            ", fuzhaungOrderPaymentTypes=" + fuzhaungOrderPaymentTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
