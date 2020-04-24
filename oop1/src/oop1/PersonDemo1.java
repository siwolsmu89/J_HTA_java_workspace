package oop1;

public class PersonDemo1 {

	public static void main(String[] args) {
		
		// Person 객체 만들기
		// Person p1  
		//		Person 설계도로 생성된 객체의 주소값을 담는 p1 변수를 생성함
		// new Person() 
		//		Person 설계도로 메모리에 객체를 생성하고, 생성된 객체의 주소값을 반환함
		// Person p1 = new Person(); 
		// 		Person 설계도로 메모리에 객체를 생성하고, 생성된 객체의 주소값을
		//		Person 타입의 변수 p1에 대입한다.
		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();
		
		// p1이 참조하는 객체의 속성을 변경하기
		p1.name = "김유신";
		p1.tel = "010-1234-5678";
		p1.email = "kimys@naver.com";
		p1.gender = "남자";
		p1.age = 50;

		p2.name = "이순신";
		p2.tel = "010-1234-4321";
		p2.email = "leesh@gmal.com";
		p2.gender = "남자";
		p2.age = 48;
		
		p3.name = "류관순";
		p3.tel = "010-1234-7654";
		p3.email = "ryugs@daum.net";
		p3.gender = "여자";
		p3.age = 17;
		
		
	}
}
