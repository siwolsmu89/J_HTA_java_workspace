package oop3;

public class PhoneDemo2Note {
	public static void main(String[] args) {
		// Iphone 객체를 생성해서 Iphone 객체 내의 모든 멤버를 사용하겠다.
		Iphone p1 = new Iphone();
		// Galaxy 객체를 생성해서 Galaxy 객체 내의 모든 멤버를 사용하겠다.
		Galaxy p2 = new Galaxy();
		
		
		// 인터넷 기능이 지원되는 SmartPhone류 객체를 생성해서 SmartPhone 타입의 변수에 저장하고,
		// SmartPhone류 객체들이 지원하는 멤버를 사용하겠다.
		SmartPhone p3 = new SmartPhone();
		p3.internet();
		// Iphone 객체 내에서 인터넷 기능을 써 보고 싶을 때
		p3 = new Iphone();
		p3.internet();
		// Galaxy 객체 내에서 인터넷 기능을 써 보고 싶을 때
		p3 = new Galaxy();
		p3.internet();
		
		// 사진촬영 기능이 지원되는 폰류의 객체를 생성해서 사진 촬영을 해보고, 성능을 테스트해보자.
		FeaturePhone p4 = new FeaturePhone();
		p4.photo();
		p4 = new Iphone();
		p4.photo();
		p4 = new Galaxy();
		p4.photo();
		
		// applemusic() 기능을 사용하고 싶다 : Iphone류 객체를 생성 - Iphone, Iphone8, IphoneX, Iphone11
		// fingerScan() 기능을 사용하고 싶다 : Iphone8류 객체를 생성 - Iphone8
		// faceScan() 기능을 사용하고 싶다	  : IphoneX류 객체를 생성 - IphoneX, Iphone11
 		
	}
}
