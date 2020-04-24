package map;

import java.util.HashMap;

public class HashMapDemo2 {

	public static void main(String[] args) {

		// 고객등급(bronze, silver, gold)에 따라서 각각 구매금액의 1%, 3%, 5%를 포인트로 지급하기

		String grade = "gold";
		int orderPrice = 34000;
		int point = 0;

		HashMap<String, Double> pointDepositRate = new HashMap<String, Double>();
		pointDepositRate.put("bronze", 0.01);
		pointDepositRate.put("silver", 0.03);
		pointDepositRate.put("gold", 0.05);
		
		double depositRate = pointDepositRate.get(grade);
		point = (int)(orderPrice*depositRate);
		
		// HashMap 사용하기 전에 사용하던 방식
		// 등급의 종류가 늘어날수록 else if 부분이 늘어나야 함
//		if (grade.equals("bronze")) {
//			point = (int) (orderPrice*0.01);
//		} else if (grade.equals("silver")) {
//			point = (int) (orderPrice*0.03);
//		} else if (grade.equals("gold")) {
//			point = (int) (orderPrice*0.05);
//		}
		
		System.out.println("고객등급: " + grade);
		System.out.println("구매금액: " + orderPrice);
		System.out.println("포 인 트: " + point);
	
	
	}
}
