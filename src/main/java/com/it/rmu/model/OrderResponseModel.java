package com.it.rmu.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderResponseModel {
	
	private Integer id;
	private Integer userId;
	private BigDecimal total;
	private String status;
	private Date createDate;
	
	private List<OrderdetailResponseModel> orderDetails;

	public List<OrderdetailResponseModel> getOrderDetails() {
	    return orderDetails;
	}

	public void setOrderDetails(List<OrderdetailResponseModel> orderDetails) {
	    this.orderDetails = orderDetails;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	

}
