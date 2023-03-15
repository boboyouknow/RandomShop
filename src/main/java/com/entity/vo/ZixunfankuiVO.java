package com.entity.vo;

import com.entity.ZixunfankuiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 咨询反馈
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-03-07 07:08:39
 */
public class ZixunfankuiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 商品图片
	 */
	
	private String shangpintupian;
		
	/**
	 * 商家编号
	 */
	
	private String shangjiabianhao;
		
	/**
	 * 咨询反馈
	 */
	
	private String zixunfankui;
		
	/**
	 * 咨询日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date zixunriqi;
		
	/**
	 * 用户名
	 */
	
	private String yonghuming;
		
	/**
	 * 回复内容
	 */
	
	private String shhf;
				
	
	/**
	 * 设置：商品图片
	 */
	 
	public void setShangpintupian(String shangpintupian) {
		this.shangpintupian = shangpintupian;
	}
	
	/**
	 * 获取：商品图片
	 */
	public String getShangpintupian() {
		return shangpintupian;
	}
				
	
	/**
	 * 设置：商家编号
	 */
	 
	public void setShangjiabianhao(String shangjiabianhao) {
		this.shangjiabianhao = shangjiabianhao;
	}
	
	/**
	 * 获取：商家编号
	 */
	public String getShangjiabianhao() {
		return shangjiabianhao;
	}
				
	
	/**
	 * 设置：咨询反馈
	 */
	 
	public void setZixunfankui(String zixunfankui) {
		this.zixunfankui = zixunfankui;
	}
	
	/**
	 * 获取：咨询反馈
	 */
	public String getZixunfankui() {
		return zixunfankui;
	}
				
	
	/**
	 * 设置：咨询日期
	 */
	 
	public void setZixunriqi(Date zixunriqi) {
		this.zixunriqi = zixunriqi;
	}
	
	/**
	 * 获取：咨询日期
	 */
	public Date getZixunriqi() {
		return zixunriqi;
	}
				
	
	/**
	 * 设置：用户名
	 */
	 
	public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
	}
	
	/**
	 * 获取：用户名
	 */
	public String getYonghuming() {
		return yonghuming;
	}
				
	
	/**
	 * 设置：回复内容
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：回复内容
	 */
	public String getShhf() {
		return shhf;
	}
			
}
