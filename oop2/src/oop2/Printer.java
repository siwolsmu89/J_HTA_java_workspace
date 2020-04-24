package oop2;

public class Printer {

	String name;		// 제품명
	String maker;		// 제조사
	int price;			// 가격
	int speed;			// 분당 출력수
	
	// final 키워드가 있는 메소드는 후손 클래스에서 재정의할 수 없다.
	final void on() {
		System.out.println("전원을 켭니다.");
	}
	
	// final 키워드가 있는 메소드는 후손 클래스에서 재정의할 수 없다.
	final void off() {
		System.out.println("전원을 끕니다.");
	}
	
	void print() {
		System.out.println("흑백으로 내용을 출력합니다.");
	}
	
}
