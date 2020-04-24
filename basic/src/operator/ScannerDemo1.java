package operator;

import java.util.Scanner;

public class ScannerDemo1 {

	public static void main(String[] args) {
		// Scanner sc 				->	 변수 sc는 Scanner 설계도로 생성된 객체의 주소값을 담는 변수다. 
		// new Scanner(System.in) 	-> 	 new는 Scanner 설계도로 객체를 생성하고,
		//								객체의 주소값을 sc에 대입한다.
		// 								System.in은 표준입력장치(키보드)를 가리킨다.
		// 								따라서, 키보드 입력을 스캔하는 객체를 생성한 것이다.
		Scanner sc = new Scanner(System.in);
		
		/*
		 * 상품명, 가격, 구매수량, 고객등급을 입력받는다.
		 * 출력내용
		 * 		상품명, 가격, 구매수량, 구매가격, 고객등급, 구매가격, 적립포인트를 출력한다.
		 * 		* 적립 포인트는 플래티넘 고객 5%, 그 외에는 3% 적립한다.
		 */
		
		System.out.print("상품명을 입력하세요:");
		String productName = sc.next();
		
		System.out.print("가격을 입력하세요:");
		int price = sc.nextInt();
		
		System.out.print("구매수량을 입력하세요: ");
		int amount = sc.nextInt();
	
		System.out.print("고객의 등급을 입력하세요(일반, 로얄, 플래티넘 중 하나): ");
		String grade = sc.next();
		
		int orderPrice = price * amount;
		int point = grade.equals("플래티넘") ? (int)(orderPrice*0.05) : (int)(orderPrice*0.03);
		
		System.out.println();
		System.out.println("------ 상세 정보 ------");
		System.out.println("상 품 명 : " + productName);
		System.out.println("가      격: " + price);
		System.out.println("구매수량: " + amount);
		System.out.println("고객등급: " + grade);
		System.out.println("구매금액: " + orderPrice);
		System.out.println("포 인 트 : " + point);

	}
	
}
