package datatype;

public class DataTypeDemo9 {

	public static void main(String[] args) {
		
		/*
		 * 홍길동 고객은
		 * 		3만원짜리 셔츠 3장
		 * 		10만원짜리 청바지 2장
		 * 		50만원짜리 구두 1켤레를 구매했다.
		 * 홍길동 고객의 총구매금액을 출력하기
		 * 해당 사이트에서는 구매금액의 3%를 포인트로 적립시킨다. (포인트는 정수값만 사용한다.)
		 * 홍길동 고객이 이번 주문에서 적립한 포인트를 출력하기
		 */
		
		int shirtsPrice = 30000;
		int jeansPrice = 100000;
		int shoesPrice = 500000;
		
		int shirtsNumber = 3;
		int jeansNumber = 2;
		int shoesNumber = 1;
		
		double pointRate = 0.03;

		int shirtsOrderPrice = shirtsPrice*shirtsNumber;
		int jeansOrderPrice = jeansPrice*jeansNumber;
		int shoesOrderPrice = shoesPrice*shoesNumber;
						
		int totalOrderPrice = shirtsOrderPrice+jeansOrderPrice+shoesOrderPrice;
		int orderPoint = (int) (totalOrderPrice * pointRate);
		
		System.out.println("총구매가격: "+totalOrderPrice+"원");
		System.out.println("적립포인트: "+orderPoint+"점");
		
	}
}
