package oop3;

public class SmartPhone extends FeaturePhone {

	String ip;
	String email;
	
	void mail() {
		System.out.println("메일을 주고받습니다.");
	}
	
	void internet() {
		System.out.println("인터넷에 접속합니다.");
	}
	
}
