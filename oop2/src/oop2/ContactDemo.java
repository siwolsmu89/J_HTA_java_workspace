package oop2;

public class ContactDemo {

	public static void main(String[] args) {
		
		Contact c1 = new Contact("홍길동", "010-1234-5678", "hong@naver.com");
		Contact c2 = new Contact("김유신", "010-4444-3232", "kimys@naver.com");
		Contact c3 = new Contact("강감찬", "010-1212-4545", "kanggc@naver.com");
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
	}
}
