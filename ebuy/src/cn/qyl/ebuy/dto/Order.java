package cn.qyl.ebuy.dto;

import org.springframework.format.annotation.DateTimeFormat;

public class Order {

	private int id;
	private String orderCode;
	private java.util.Date createDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private java.util.Date sendDate;
	private int tradingStatus;
	private double totalAmount;
	private int userId;
	private int alipay;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public java.util.Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	public java.util.Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(java.util.Date sendDate) {
		this.sendDate = sendDate;
	}
	public int getTradingStatus() {
		return tradingStatus;
	}
	public void setTradingStatus(int tradingStatus) {
		this.tradingStatus = tradingStatus;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAlipay() {
		return alipay;
	}
	public void setAlipay(int alipay) {
		this.alipay = alipay;
	}
	
}
