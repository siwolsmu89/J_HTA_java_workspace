package oop8;

public class Book {
	
	private String title;
	private String writer;
	private int price;
	
	public Book() {}

	// 멤버변수의 값을 반환하는 getter메소드 정의
	public String getTitle() {
		return title;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public int getPrice() {
		return price;
	}
	
	// 멤버변수의 값을 변경하는 setter 메소드 정의
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
