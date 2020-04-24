package oop3;

import java.util.Scanner;

public class PhoneDemo2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		SmartPhone testPhone = null;
		
		System.out.println("인터넷 기능을 테스트할 폰을 선택하세요. 테스트를 진행해드립니다.");
		System.out.println("1.그냥 스마트폰  2.아이폰  3.갤럭시");
		int no = scanner.nextInt();
		
		if (no == 1) {
			System.out.println("그냥 스마트폰 객체를 생성해서 테스트를 진행합니다.");
			testPhone = new SmartPhone();
		} else if (no == 2) {
			System.out.println("Iphone 객체를 생성해서 테스트를 진행합니다.");
			testPhone = new Iphone();
		} else if (no == 3) {
			System.out.println("Galaxy 객체를 생성해서 테스트를 진행합니다.");
			testPhone = new Galaxy();
		}
		
		if (testPhone != null) {
			testPhone.internet();
		} else {
			System.out.println("잘못된 번호를 입력하셨습니다.");
		}
		 
		
		
		scanner.close();
	}

}
