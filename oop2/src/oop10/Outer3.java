package oop10;

public class Outer3 {
	int x;
	static int y;
	void m1() {}
	static void m2() {}
	
	void m3() {
		
		int a = 10;
		int b = 10;
		final int c = 10;
		b=20;
		
		class Inner3 {
			int 가;
//			static int 나;						// 클래스 변수를 정의할 수 없다.
			void m4() {}
//			static void m5() {}					// 클래스 메소드를 정의할 수 없다.
			
			void m6() {
				System.out.println(x);			// 외부클래스의 멤버 변수
				System.out.println(y);			// 외부클래스의 클래스 변수
				m1();							// 외부클래스의 멤버 메소드
				Outer3.m2();					// 외부클래스의 클래스 메소드
				System.out.println(a);			// 내부클래스가 정의된 메소드의 변수(값이 한 번도 변하지 않으므로 상수처럼 동작한다고 인식)
//				System.out.println(b);			// 내부클래스가 정의된 메소드의 변수는 값이 변하는 경우 접근 불가(초기값 10에서 20으로 값이 변함)
				System.out.println(c);			// 내부클래스가 정의한 메소드의 상수
			}
		}
	}
}
