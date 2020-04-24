package com.sample.bookstore.vo;

import java.util.Date;

public class Order {
	
	private int orderNo;
	private User user;
	private Book book;
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
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
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
