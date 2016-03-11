/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.trade.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.common.utils.excel.annotation.ExcelField;

/**
 * 商户流水Entity
 * @author 聂亚春
 * @version 2016-01-12
 */
public class VShanghuTrade extends DataEntity<VShanghuTrade> {
	
	private static final long serialVersionUID = 1L;
	private Date createTime;		// create_time
	private String shanghu;		// shanghu
	private String partnerNo;
	/**
	 * @return partnerNo
	 */
	public String getPartnerNo() {
		return partnerNo;
	}

	/**
	 * @param partnerNo
	 */
	public void setPartnerNo(String partnerNo) {
		this.partnerNo = partnerNo;
	}

	private String dealType;		// deal_type
	private String extOrderNo;		// ext_order_no
	private String cashAmount;		// cash_amount
	private String payWay;		// pay_way
	private String scoreType;		// score_type
	private String realName;		// real_name
	private String userMobile;		// user_mobile
	private String product;
	private Date beginCreateTime;		// 开始 create_time
	private Date endCreateTime;		// 结束 create_time
	
	/**
	 * @return beginCreateTime
	 */
	public Date getBeginCreateTime() {
		return beginCreateTime;
	}

	/**
	 * @param beginCreateTime
	 */
	public void setBeginCreateTime(Date beginCreateTime) {
		this.beginCreateTime = beginCreateTime;
	}

	/**
	 * @return endCreateTime
	 */
	public Date getEndCreateTime() {
		return endCreateTime;
	}

	/**
	 * @param endCreateTime
	 */
	public void setEndCreateTime(Date endCreateTime) {
		this.endCreateTime = endCreateTime;
	}

	/**
	 * @return product
	 */
	@ExcelField(title="商品",  align=2, sort=40)
	public String getProduct() {
		return product;
	}

	/**
	 * @param product
	 */
	public void setProduct(String product) {
		this.product = product;
	}

	public VShanghuTrade() {
		super();
	}

	public VShanghuTrade(String id){
		super(id);
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="交易时间", type=1, align=2, sort=1)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Length(min=0, max=2, message="shanghu长度必须介于 0 和 2 之间")
	@ExcelField(title="账户名", align=2, sort=10)
	public String getShanghu() {
		return shanghu;
	}

	public void setShanghu(String shanghu) {
		this.shanghu = shanghu;
	}
	
	@NotNull(message="deal_type不能为空")
	@ExcelField(title="账户类型", align=2, sort=20)
	public String getDealType() {
		return dealType;
	}

	public void setDealType(String dealType) {
		this.dealType = dealType;
	}
	
	@Length(min=0, max=100, message="ext_order_no长度必须介于 0 和 100 之间")
	@ExcelField(title="订单编号", align=2, sort=30)
	public String getExtOrderNo() {
		return extOrderNo;
	}

	public void setExtOrderNo(String extOrderNo) {
		this.extOrderNo = extOrderNo;
	}
	@ExcelField(title="交易金额（元）", align=2, sort=50)
	public String getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(String cashAmount) {
		this.cashAmount = cashAmount;
	}
	@ExcelField(title="支付通道", align=2, sort=60)
	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}
	@ExcelField(title="交易类型", align=2, sort=70)
	public String getScoreType() {
		return scoreType;
	}

	public void setScoreType(String scoreType) {
		this.scoreType = scoreType;
	}
	
	@Length(min=0, max=100, message="real_name长度必须介于 0 和 100 之间")
	@ExcelField(title="客户姓名", align=2, sort=80)
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	@Length(min=0, max=30, message="user_mobile长度必须介于 0 和 30 之间")
	@ExcelField(title="客户手机号", align=2, sort=90)
	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	
}