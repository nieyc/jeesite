/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.trade.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 商户流水Entity
 * @author 聂亚春
 * @version 2016-01-12
 */
public class VShanghuTrade extends DataEntity<VShanghuTrade> {
	
	private static final long serialVersionUID = 1L;
	private Date createTime;		// create_time
	private String shanghu;		// shanghu
	private Long dealType;		// deal_type
	private String extOrderNo;		// ext_order_no
	private String cashAmount;		// cash_amount
	private Long payWay;		// pay_way
	private Long scoreType;		// score_type
	private String realName;		// real_name
	private String userMobile;		// user_mobile
	
	public VShanghuTrade() {
		super();
	}

	public VShanghuTrade(String id){
		super(id);
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Length(min=0, max=2, message="shanghu长度必须介于 0 和 2 之间")
	public String getShanghu() {
		return shanghu;
	}

	public void setShanghu(String shanghu) {
		this.shanghu = shanghu;
	}
	
	@NotNull(message="deal_type不能为空")
	public Long getDealType() {
		return dealType;
	}

	public void setDealType(Long dealType) {
		this.dealType = dealType;
	}
	
	@Length(min=0, max=100, message="ext_order_no长度必须介于 0 和 100 之间")
	public String getExtOrderNo() {
		return extOrderNo;
	}

	public void setExtOrderNo(String extOrderNo) {
		this.extOrderNo = extOrderNo;
	}
	
	public String getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(String cashAmount) {
		this.cashAmount = cashAmount;
	}
	
	public Long getPayWay() {
		return payWay;
	}

	public void setPayWay(Long payWay) {
		this.payWay = payWay;
	}
	
	public Long getScoreType() {
		return scoreType;
	}

	public void setScoreType(Long scoreType) {
		this.scoreType = scoreType;
	}
	
	@Length(min=0, max=100, message="real_name长度必须介于 0 和 100 之间")
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	@Length(min=0, max=30, message="user_mobile长度必须介于 0 和 30 之间")
	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	
}