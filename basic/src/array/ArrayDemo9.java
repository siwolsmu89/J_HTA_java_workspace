package array;

import java.util.Scanner;

public class ArrayDemo9 {

	public static void main(String[] args) {
		/*
		 * 숫자를 10개 입력받아서 그 중에 짝수들의 합계만 구해서 출력하기
		 */
		int[] inputNums = new int[10];
		Scanner scanner = new Scanner(System.in);
		
		for (int i=0; i<inputNums.length; i++) {
			
			System.out.print("정수를 입력하세요: ");
			inputNums[i] = scanner.nextInt();
		}
		
		int sum=0;
		for (int num : inputNums) {
			if (num%2 == 0) {
				sum += num;
			}
		}
		
		System.out.println("입력하신 숫자들 중 짝수의 합은: "+sum+" 입니다.");
	}
}
