package com.sample.bookstore.vo;

import java.util.Date;

public class Review {
	private int no;
	private String content;
	private Date registeredDate;
	private Book book;
	private double point;
	private User user;
	
	public Review() {
		
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	public double getPoint() {
		return point;
	}
	
	public void setPoint(double point) {
		this.point = point;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}	
