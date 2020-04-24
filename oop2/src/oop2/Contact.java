package oop2;

public class Contact {

	String name;
	String tel;
	String email;

	Contact() {
	}

	Contact(String name, String tel) {
		this(name, tel, null);
	}

	Contact(String name, String tel, String email) {
		this.name = name;
		this.tel = tel;
		this.email = email;
	}
	
	// Object로부터 상속받은 toString() 메소드를 재정의함
	// "클래스이름@해시코드"를 반환하도록 구현되어 있는 Object의 toString 메소드를
	// Contact 객체의 name, tel, email 멤버변수에 현재 저장된 값이 문자열로 이어서 반환되도록 재정의함
	@Override
	public String toString() {
		return "Contact [name=" + name + ", tel=" + tel + ", email=" + email + "]";
	}


}
