package oop10;

public class Outer2 {
	
	int x;
	static int y;
	void m1() {
		Inner2 i = new Inner2();			// 외부 클래스의 멤버 메소드에서 내부 클래스 사용 가능
	}
	static void m2() {
		Inner2 i = new Inner2();			// 외부 클래스의 멤버 메소드에서 내부 클래스 사용 가능
	}
	
	static class Inner2{
		int a;
		static int b;						// 클래스 변수의 선언이 가능
		void m3() {}
		static void m4() {}					// 클래스 메소드의 선언이 가능
		void m5() {
//			System.out.println(x);			// 멤버 변수 사용 불가능
			System.out.println(Outer2.y);
//			m1();							// 멤버 메소드 사용 불가능
			Outer2.m2();
		}
	}
}
