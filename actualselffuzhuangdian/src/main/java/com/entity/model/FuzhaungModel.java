package com.entity.model;

import com.entity.FuzhaungEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 服装
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FuzhaungModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 服装编号
     */
    private String fuzhaungUuidNumber;


    /**
     * 服装名称
     */
    private String fuzhaungName;


    /**
     * 服装照片
     */
    private String fuzhaungPhoto;


    /**
     * 服装类型
     */
    private Integer fuzhaungTypes;


    /**
     * 服装库存
     */
    private Integer fuzhaungKucunNumber;


    /**
     * 购买获得积分
     */
    private Integer fuzhaungPrice;


    /**
     * 服装原价
     */
    private Double fuzhaungOldMoney;


    /**
     * 现价/积分
     */
    private Double fuzhaungNewMoney;


    /**
     * 点击次数
     */
    private Integer fuzhaungClicknum;


    /**
     * 服装介绍
     */
    private String fuzhaungContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer fuzhaungDelete;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：服装编号
	 */
    public String getFuzhaungUuidNumber() {
        return fuzhaungUuidNumber;
    }


    /**
	 * 设置：服装编号
	 */
    public void setFuzhaungUuidNumber(String fuzhaungUuidNumber) {
        this.fuzhaungUuidNumber = fuzhaungUuidNumber;
    }
    /**
	 * 获取：服装名称
	 */
    public String getFuzhaungName() {
        return fuzhaungName;
    }


    /**
	 * 设置：服装名称
	 */
    public void setFuzhaungName(String fuzhaungName) {
        this.fuzhaungName = fuzhaungName;
    }
    /**
	 * 获取：服装照片
	 */
    public String getFuzhaungPhoto() {
        return fuzhaungPhoto;
    }


    /**
	 * 设置：服装照片
	 */
    public void setFuzhaungPhoto(String fuzhaungPhoto) {
        this.fuzhaungPhoto = fuzhaungPhoto;
    }
    /**
	 * 获取：服装类型
	 */
    public Integer getFuzhaungTypes() {
        return fuzhaungTypes;
    }


    /**
	 * 设置：服装类型
	 */
    public void setFuzhaungTypes(Integer fuzhaungTypes) {
        this.fuzhaungTypes = fuzhaungTypes;
    }
    /**
	 * 获取：服装库存
	 */
    public Integer getFuzhaungKucunNumber() {
        return fuzhaungKucunNumber;
    }


    /**
	 * 设置：服装库存
	 */
    public void setFuzhaungKucunNumber(Integer fuzhaungKucunNumber) {
        this.fuzhaungKucunNumber = fuzhaungKucunNumber;
    }
    /**
	 * 获取：购买获得积分
	 */
    public Integer getFuzhaungPrice() {
        return fuzhaungPrice;
    }


    /**
	 * 设置：购买获得积分
	 */
    public void setFuzhaungPrice(Integer fuzhaungPrice) {
        this.fuzhaungPrice = fuzhaungPrice;
    }
    /**
	 * 获取：服装原价
	 */
    public Double getFuzhaungOldMoney() {
        return fuzhaungOldMoney;
    }


    /**
	 * 设置：服装原价
	 */
    public void setFuzhaungOldMoney(Double fuzhaungOldMoney) {
        this.fuzhaungOldMoney = fuzhaungOldMoney;
    }
    /**
	 * 获取：现价/积分
	 */
    public Double getFuzhaungNewMoney() {
        return fuzhaungNewMoney;
    }


    /**
	 * 设置：现价/积分
	 */
    public void setFuzhaungNewMoney(Double fuzhaungNewMoney) {
        this.fuzhaungNewMoney = fuzhaungNewMoney;
    }
    /**
	 * 获取：点击次数
	 */
    public Integer getFuzhaungClicknum() {
        return fuzhaungClicknum;
    }


    /**
	 * 设置：点击次数
	 */
    public void setFuzhaungClicknum(Integer fuzhaungClicknum) {
        this.fuzhaungClicknum = fuzhaungClicknum;
    }
    /**
	 * 获取：服装介绍
	 */
    public String getFuzhaungContent() {
        return fuzhaungContent;
    }


    /**
	 * 设置：服装介绍
	 */
    public void setFuzhaungContent(String fuzhaungContent) {
        this.fuzhaungContent = fuzhaungContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getFuzhaungDelete() {
        return fuzhaungDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setFuzhaungDelete(Integer fuzhaungDelete) {
        this.fuzhaungDelete = fuzhaungDelete;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
