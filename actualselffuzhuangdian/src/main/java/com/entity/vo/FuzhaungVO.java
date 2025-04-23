package com.entity.vo;

import com.entity.FuzhaungEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 服装
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fuzhaung")
public class FuzhaungVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 服装编号
     */

    @TableField(value = "fuzhaung_uuid_number")
    private String fuzhaungUuidNumber;


    /**
     * 服装名称
     */

    @TableField(value = "fuzhaung_name")
    private String fuzhaungName;


    /**
     * 服装照片
     */

    @TableField(value = "fuzhaung_photo")
    private String fuzhaungPhoto;


    /**
     * 服装类型
     */

    @TableField(value = "fuzhaung_types")
    private Integer fuzhaungTypes;


    /**
     * 服装库存
     */

    @TableField(value = "fuzhaung_kucun_number")
    private Integer fuzhaungKucunNumber;


    /**
     * 购买获得积分
     */

    @TableField(value = "fuzhaung_price")
    private Integer fuzhaungPrice;


    /**
     * 服装原价
     */

    @TableField(value = "fuzhaung_old_money")
    private Double fuzhaungOldMoney;


    /**
     * 现价/积分
     */

    @TableField(value = "fuzhaung_new_money")
    private Double fuzhaungNewMoney;


    /**
     * 点击次数
     */

    @TableField(value = "fuzhaung_clicknum")
    private Integer fuzhaungClicknum;


    /**
     * 服装介绍
     */

    @TableField(value = "fuzhaung_content")
    private String fuzhaungContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "fuzhaung_delete")
    private Integer fuzhaungDelete;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：服装编号
	 */
    public String getFuzhaungUuidNumber() {
        return fuzhaungUuidNumber;
    }


    /**
	 * 获取：服装编号
	 */

    public void setFuzhaungUuidNumber(String fuzhaungUuidNumber) {
        this.fuzhaungUuidNumber = fuzhaungUuidNumber;
    }
    /**
	 * 设置：服装名称
	 */
    public String getFuzhaungName() {
        return fuzhaungName;
    }


    /**
	 * 获取：服装名称
	 */

    public void setFuzhaungName(String fuzhaungName) {
        this.fuzhaungName = fuzhaungName;
    }
    /**
	 * 设置：服装照片
	 */
    public String getFuzhaungPhoto() {
        return fuzhaungPhoto;
    }


    /**
	 * 获取：服装照片
	 */

    public void setFuzhaungPhoto(String fuzhaungPhoto) {
        this.fuzhaungPhoto = fuzhaungPhoto;
    }
    /**
	 * 设置：服装类型
	 */
    public Integer getFuzhaungTypes() {
        return fuzhaungTypes;
    }


    /**
	 * 获取：服装类型
	 */

    public void setFuzhaungTypes(Integer fuzhaungTypes) {
        this.fuzhaungTypes = fuzhaungTypes;
    }
    /**
	 * 设置：服装库存
	 */
    public Integer getFuzhaungKucunNumber() {
        return fuzhaungKucunNumber;
    }


    /**
	 * 获取：服装库存
	 */

    public void setFuzhaungKucunNumber(Integer fuzhaungKucunNumber) {
        this.fuzhaungKucunNumber = fuzhaungKucunNumber;
    }
    /**
	 * 设置：购买获得积分
	 */
    public Integer getFuzhaungPrice() {
        return fuzhaungPrice;
    }


    /**
	 * 获取：购买获得积分
	 */

    public void setFuzhaungPrice(Integer fuzhaungPrice) {
        this.fuzhaungPrice = fuzhaungPrice;
    }
    /**
	 * 设置：服装原价
	 */
    public Double getFuzhaungOldMoney() {
        return fuzhaungOldMoney;
    }


    /**
	 * 获取：服装原价
	 */

    public void setFuzhaungOldMoney(Double fuzhaungOldMoney) {
        this.fuzhaungOldMoney = fuzhaungOldMoney;
    }
    /**
	 * 设置：现价/积分
	 */
    public Double getFuzhaungNewMoney() {
        return fuzhaungNewMoney;
    }


    /**
	 * 获取：现价/积分
	 */

    public void setFuzhaungNewMoney(Double fuzhaungNewMoney) {
        this.fuzhaungNewMoney = fuzhaungNewMoney;
    }
    /**
	 * 设置：点击次数
	 */
    public Integer getFuzhaungClicknum() {
        return fuzhaungClicknum;
    }


    /**
	 * 获取：点击次数
	 */

    public void setFuzhaungClicknum(Integer fuzhaungClicknum) {
        this.fuzhaungClicknum = fuzhaungClicknum;
    }
    /**
	 * 设置：服装介绍
	 */
    public String getFuzhaungContent() {
        return fuzhaungContent;
    }


    /**
	 * 获取：服装介绍
	 */

    public void setFuzhaungContent(String fuzhaungContent) {
        this.fuzhaungContent = fuzhaungContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getFuzhaungDelete() {
        return fuzhaungDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setFuzhaungDelete(Integer fuzhaungDelete) {
        this.fuzhaungDelete = fuzhaungDelete;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
