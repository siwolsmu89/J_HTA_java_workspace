package com.sample.bookstore.vo;

import java.util.Date;

public class Answer {

	private int no;
	private String content;
	private int questionNo;
	private Date registeredDate;
	
	public Answer() {
		
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

	public int getQuestionNo() {
		return questionNo;
	}
	
	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}
	
	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}
	
	
}
