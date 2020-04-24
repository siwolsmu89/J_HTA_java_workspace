package oop3;

public class IphoneTesterDemo {
	public static void main(String[] args) {
		
		IphoneTester tester = new IphoneTester();
		Iphone p1 = new Iphone();
		Iphone8 p2 = new Iphone8();
		IphoneX p3 = new IphoneX();
		Iphone11 p4 = new Iphone11();
		
		System.out.println("#### Iphone 객체 테스트 실시");
		tester.testIphone(p1);
		System.out.println("#### Iphone8 객체 테스트 실시");
		tester.testIphone(p2);
		System.out.println("#### Iphonex 객체 테스트 실시");
		tester.testIphone(p3);
		System.out.println("#### Iphone11 객체 테스트 실시");
		tester.testIphone(p4);

		// 매개변수의 타입 또는 그 타입류를 전해주어야 함
		// Galaxy는 Iphone류 타입이 아니므로 오류발생
//		Galaxy p5 = new Galaxy();
//		tester.testIphone(p5);
		
	}
}
