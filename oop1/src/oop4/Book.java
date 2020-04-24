package oop4;

public class Book {

	String title;
	String writer;
	String publisher;
	int price;
	String genre;

	//생성자 메소드
	// 기본 생성자 메소드
	//	- 클래스에 정의된 생성자가 하나도 없을 때 컴파일러가 자동으로 추가하는 생성자 메소드다.
	Book(){
		publisher = "한빛미디어"; // 거의 대부분의 책이 한빛미디어에서 출판하기 때문에 
									  // Book 객체가 생성되면 publisher를 "한빛미디어"로 설정해버리자.
	}
	
	Book(String inputTitle, String inputWriter, int inputPrice, String inputGenre){
		title = inputTitle;
		writer = inputWriter;
		publisher = "한빛미디어";
		price = inputPrice;
		genre = inputGenre;
				
	}
	Book(String inputTitle, String inputWriter, String inputPublisher, int inputPrice, String inputGenre){
		title = inputTitle;
		writer = inputWriter;
		publisher = inputPublisher;
		price = inputPrice;
		genre = inputGenre;
		
	}
	
	
	// 일반 멤버 메소드 (인스턴스 메소드)
	void printBookInfo() {
		System.out.println("------ 도서 정보 ------");
		System.out.println("제  목: " + title);
		System.out.println("저  자: " + writer);
		System.out.println("출판사: " + publisher);
		System.out.println("가  격: " + price);
		System.out.println("장  르: " + genre);
		System.out.println("-------------------");
	}

}
