package control;

import java.util.Scanner;

public class IfDemo6 {
	public static void main(String[] args) {
		
		/*
		 *  switch문
		 *  	비교값과 일치하는 다양한 경우를 간결한 표현으로 처리할 수 있다.
		 *  	
		 *  	switch(조건식) {
		 *  		case 값1:
		 *  			비교값이 값1과 일치하는 경우 실행되는 수행문;
		 *  		case 값2:
		 *  			비교값이 값1과 일치하는 경우 실행되는 수행문;
		 *  		dafault:
		 *  			비교값이 제시된 값과 일치하는 것이 없는 경우 실행되는 수행문;
		 *  	}
		 *  	* 비교값으로 사용가능한 값은 정수, 문자, 문자열 만 가능하다.
		 *  	* case에 제시된 값은 상수 혹은 리터럴값이어야 한다.
		 *  	* break문은 switch문을 벗어나게 한다.
		 */
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("등급을 입력하세요:");
		String grade = scanner.next();
		
		switch (grade) {
			case "vvip" :
				System.out.println("vvip고객님 방문을 환영합니다.");
				System.out.println("오늘은 10분 한정 프리미엄 포도주 증정이 있습니다.");
				break;
			case "vip" :
				System.out.println("vip고객님 방문을 환영합니다.");
				System.out.println("오늘은 30분 한정 고급 식기세트 증정이 있습니다.");
				break;
			case "classic" :
				System.out.println("classic고객님 방문을 환영합니다.");
				System.out.println("오늘은 50분 한정 면마스크 증정이 있습니다.");
				break;
			default:
				System.out.println("고객님 방문을 환영합니다.");
				System.out.println("오늘은 100분 한정 주차권할인 행사가 있습니다.");
		}
		scanner.close();
	}

}
