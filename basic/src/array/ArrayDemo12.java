package array;

import java.util.Scanner;

public class ArrayDemo12 {

	public static void main(String[] args) {
		/*
		 * 상품명, 가격, 구매수량을 입력받아서 총 구매가격을 출력하는 프로그램
		 */
		Scanner scanner = new Scanner(System.in);
		
		String[] products = new String[3];
		int[] prices = new int[3];
		int[] amounts = new int[3];
		int[] orders = new int[3];
		
		for(int i=0; i<products.length; i++) {
			System.out.print("상품명을 입력하세요: ");
			products[i] = scanner.next();
			System.out.print("가격을 입력하세요: ");
			prices[i] = scanner.nextInt();
			System.out.print("구매수량을 입력하세요: ");
			amounts[i] = scanner.nextInt();
			orders[i] = prices[i]*amounts[i];
		}
		
		int sum=0;
		System.out.println("순번\t상품명\t가격\t구매수량\t구매가격");
		System.out.println("===============================================");
		for (int i=0; i<orders.length; i++) {
			System.out.print((i+1)+"\t");
			System.out.print(products[i]+"\t");
			System.out.print(prices[i]+"\t");
			System.out.print(amounts[i]+"\t");
			System.out.println(orders[i]+"\t");
			sum += orders[i];
		}
		System.out.println("===============================================");
		System.out.println("총 구매가격: 			"+sum);
	}
}
