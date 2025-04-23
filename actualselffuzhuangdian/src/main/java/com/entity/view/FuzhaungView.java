package com.entity.view;

import com.entity.FuzhaungEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 服装
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("fuzhaung")
public class FuzhaungView extends FuzhaungEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 服装类型的值
		*/
		private String fuzhaungValue;
		/**
		* 是否上架的值
		*/
		private String shangxiaValue;



	public FuzhaungView() {

	}

	public FuzhaungView(FuzhaungEntity fuzhaungEntity) {
		try {
			BeanUtils.copyProperties(this, fuzhaungEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 服装类型的值
			*/
			public String getFuzhaungValue() {
				return fuzhaungValue;
			}
			/**
			* 设置： 服装类型的值
			*/
			public void setFuzhaungValue(String fuzhaungValue) {
				this.fuzhaungValue = fuzhaungValue;
			}
			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
			}












}
