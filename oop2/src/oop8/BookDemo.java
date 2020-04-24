package oop8;

public class BookDemo {
	
	public static void main(String[] args) {
		Book b1 = new Book();
		b1.setTitle("자바의 정석");
		b1.setWriter("남궁성");
		b1.setPrice(34000);
		
		System.out.println("제목: "+b1.getTitle());
	}
}
