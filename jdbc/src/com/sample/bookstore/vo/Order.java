package com.sample.bookstore.vo;

import java.util.Date;

public class Order {
	
	private int orderNo;
	private String userId;
	private int bookNo;
	private int price;
	private int amount;
	private Date registredDate;
	
	public Order() {
		
	}
	
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getRegistredDate() {
		return registredDate;
	}
	public void setRegistredDate(Date registredDate) {
		this.registredDate = registredDate;
	}
	
}
