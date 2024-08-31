package com.it.rmu.model;

public class CheckResponseModel {
	
	private Integer id;
	private byte[] checkImg;
	private Integer paymentId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public byte[] getCheckImg() {
		return checkImg;
	}
	public void setCheckImg(byte[] checkImg) {
		this.checkImg = checkImg;
	}
	public Integer getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	
	
}
