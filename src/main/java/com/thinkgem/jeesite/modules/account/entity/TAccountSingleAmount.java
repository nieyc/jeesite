/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.account.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 预售票账务汇总Entity
 * @author 聂亚春
 * @version 2016-01-14
 */
public class TAccountSingleAmount extends DataEntity<TAccountSingleAmount> {
	
	private static final long serialVersionUID = 1L;
	private Date tradeDate;		// 交易日
	private String inAmount;		// 进账总额
	private String inDealAmount;		// 进账总笔数
	private String outAmount;		// 支出总额
	private String outDealAmount;		// 支出总笔数
	private String beginingAmount;		// 期初总额
	private String endingAmount;		// 期末总额
	private String alipayAmount;		// 支付宝总额
	private String alipayDealAmount;		// 支付宝总笔数
	private String wechatAmount;		// 微信总额
	private String wechatDealAmount;		// 微信总笔数
	private String panchanAmount;		// 盘缠总额
	private String panchanDealAmount;		// 盘缠总笔数
	private String cmccAmount;		// 中移动总额
	private String cmccDealAmount;		// 中移动总笔数
	private String ticketsAmount;		// 出票总额
	private String ticketsDealAmount;		// 出票总笔数
	private String refundAmount;		// 退款总额
	private String refundDealAmount;		// 退款总笔数
	private Date createTime;		// 创建时间
	private String amountType;		// 账务类型，1为日统计，2为月统计
	private String shanghuCode;		// 商户编码
	private String shanghuName;		// 商户名称
	
	public TAccountSingleAmount() {
		super();
	}

	public TAccountSingleAmount(String id){
		super(id);
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}
	
	public String getInAmount() {
		return inAmount;
	}

	public void setInAmount(String inAmount) {
		this.inAmount = inAmount;
	}
	
	@Length(min=0, max=12, message="进账总笔数长度必须介于 0 和 12 之间")
	public String getInDealAmount() {
		return inDealAmount;
	}

	public void setInDealAmount(String inDealAmount) {
		this.inDealAmount = inDealAmount;
	}
	
	public String getOutAmount() {
		return outAmount;
	}

	public void setOutAmount(String outAmount) {
		this.outAmount = outAmount;
	}
	
	@Length(min=0, max=12, message="支出总笔数长度必须介于 0 和 12 之间")
	public String getOutDealAmount() {
		return outDealAmount;
	}

	public void setOutDealAmount(String outDealAmount) {
		this.outDealAmount = outDealAmount;
	}
	
	public String getBeginingAmount() {
		return beginingAmount;
	}

	public void setBeginingAmount(String beginingAmount) {
		this.beginingAmount = beginingAmount;
	}
	
	public String getEndingAmount() {
		return endingAmount;
	}

	public void setEndingAmount(String endingAmount) {
		this.endingAmount = endingAmount;
	}
	
	public String getAlipayAmount() {
		return alipayAmount;
	}

	public void setAlipayAmount(String alipayAmount) {
		this.alipayAmount = alipayAmount;
	}
	
	@Length(min=0, max=12, message="支付宝总笔数长度必须介于 0 和 12 之间")
	public String getAlipayDealAmount() {
		return alipayDealAmount;
	}

	public void setAlipayDealAmount(String alipayDealAmount) {
		this.alipayDealAmount = alipayDealAmount;
	}
	
	public String getWechatAmount() {
		return wechatAmount;
	}

	public void setWechatAmount(String wechatAmount) {
		this.wechatAmount = wechatAmount;
	}
	
	@Length(min=0, max=12, message="微信总笔数长度必须介于 0 和 12 之间")
	public String getWechatDealAmount() {
		return wechatDealAmount;
	}

	public void setWechatDealAmount(String wechatDealAmount) {
		this.wechatDealAmount = wechatDealAmount;
	}
	
	public String getPanchanAmount() {
		return panchanAmount;
	}

	public void setPanchanAmount(String panchanAmount) {
		this.panchanAmount = panchanAmount;
	}
	
	@Length(min=0, max=12, message="盘缠总笔数长度必须介于 0 和 12 之间")
	public String getPanchanDealAmount() {
		return panchanDealAmount;
	}

	public void setPanchanDealAmount(String panchanDealAmount) {
		this.panchanDealAmount = panchanDealAmount;
	}
	
	public String getCmccAmount() {
		return cmccAmount;
	}

	public void setCmccAmount(String cmccAmount) {
		this.cmccAmount = cmccAmount;
	}
	
	@Length(min=0, max=12, message="中移动总笔数长度必须介于 0 和 12 之间")
	public String getCmccDealAmount() {
		return cmccDealAmount;
	}

	public void setCmccDealAmount(String cmccDealAmount) {
		this.cmccDealAmount = cmccDealAmount;
	}
	
	public String getTicketsAmount() {
		return ticketsAmount;
	}

	public void setTicketsAmount(String ticketsAmount) {
		this.ticketsAmount = ticketsAmount;
	}
	
	@Length(min=0, max=12, message="出票总笔数长度必须介于 0 和 12 之间")
	public String getTicketsDealAmount() {
		return ticketsDealAmount;
	}

	public void setTicketsDealAmount(String ticketsDealAmount) {
		this.ticketsDealAmount = ticketsDealAmount;
	}
	
	public String getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(String refundAmount) {
		this.refundAmount = refundAmount;
	}
	
	@Length(min=0, max=12, message="退款总笔数长度必须介于 0 和 12 之间")
	public String getRefundDealAmount() {
		return refundDealAmount;
	}

	public void setRefundDealAmount(String refundDealAmount) {
		this.refundDealAmount = refundDealAmount;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Length(min=0, max=1, message="账务类型，1为日统计，2为月统计长度必须介于 0 和 1 之间")
	public String getAmountType() {
		return amountType;
	}

	public void setAmountType(String amountType) {
		this.amountType = amountType;
	}
	
	@Length(min=0, max=20, message="商户编码长度必须介于 0 和 20 之间")
	public String getShanghuCode() {
		return shanghuCode;
	}

	public void setShanghuCode(String shanghuCode) {
		this.shanghuCode = shanghuCode;
	}
	
	@Length(min=0, max=200, message="商户名称长度必须介于 0 和 200 之间")
	public String getShanghuName() {
		return shanghuName;
	}

	public void setShanghuName(String shanghuName) {
		this.shanghuName = shanghuName;
	}
	
}