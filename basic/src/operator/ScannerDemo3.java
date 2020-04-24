package operator;

import java.util.Scanner;

public class ScannerDemo3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		/*
		 * 고객명, 상품명, 가격, 구매수량, 사용포인트를 입력받는다.
		 * 	출력내용
		 * 		고객명, 상품명, 가격, 구매수량, 구매가격, 사용포인트, 결제금액, 적립포인트	
		 * 		* 사용포인트는 고객이 이미 적립한 포인트가 있다고 가정하고, 임의의 값을 입력받는다.
		 * 		* 결재금액은 구매가격에서 포인트 사용량을 제외한 금액이다.
		 * 		* 적립포인트는 실결제금액의 3%다.
		 */
		
		System.out.print("고객명을 입력하세요: ");
		String name = scanner.next();
		System.out.print("상품명을 입력하세요: ");
		String product = scanner.next();
		System.out.print("가격을 입력하세요: ");
		int price = scanner.nextInt();
		System.out.print("구매 수량을 입력하세요: ");
		int amount = scanner.nextInt();
		System.out.print("사용 포인트을 입력하세요: ");
		int usedPoint = scanner.nextInt();
		
		int totalPrice = price * amount;
		int purchasePrice = totalPrice - usedPoint;
		int depositPoint = (int)(purchasePrice * 0.03);
	
		System.out.println();
		System.out.println("---- 결제내역 ----");
		System.out.println("고   객   명: " + name);
		System.out.println("상   품   명: " + product);
		System.out.println("상 품 가 격: " + price);
		System.out.println("구 매 수 량: " + amount);
		System.out.println("총구매금액: " + totalPrice);
		System.out.println("사용포인트: " + usedPoint);
		System.out.println("결 제 금 액: " + purchasePrice);
		System.out.println("적립포인트: " + depositPoint);
	}
}
