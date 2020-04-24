package array;

import java.util.Scanner;

public class ArrayDemo11 {

	public static void main(String[] args) {
		
		/*
		 * 숫자 5개를 입력받아서 배열에 저장한다.
		 * 배열의 n번째까지의 합계를 새로운 배열에 저장하고, 새 배열의 값을 전부 출력한다.
		 * 예) [3, 5, 11, 7, 4] ===> [3, 8, 19, 26, 38]
		 */
		int[] inputNums = new int[5];
		Scanner scanner = new Scanner(System.in);
		
		for (int i=0;i<inputNums.length;i++) {
			System.out.print("숫자를 입력: ");
			inputNums[i] = scanner.nextInt();
		}
		
		int[] newNums = new int[5];
		int inputSum = 0;
		for (int i=0; i<newNums.length; i++) {
			inputSum += inputNums[i];
			newNums[i] = inputSum;
		}
	
		System.out.println("원본 배열");
		for (int i : inputNums) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		System.out.println("합계 배열");
		for (int i : newNums) {
			System.out.print(i+" ");
		}
		
	}
}
