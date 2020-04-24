package array;

import java.util.Scanner;

public class ArrayDemo8 {

	public static void main(String[] args) {
		/*
		 *  5개의 정수를 입력받아서 그 중 가장 큰 값을 출력하시오
		 */
		
		// 배열 생성
		int[] inputNums = new int[5];
		
		// 5번 반복해서 숫자를 입력받고 배열에 담기
		Scanner scanner = new Scanner(System.in);
		for (int i=0; i<5; i++) {
			System.out.print("정수를 입력하세요.: ");
			inputNums[i] = scanner.nextInt();
		}
		
		// 최대값 구하기
		int max = 0, min=inputNums[0];
		for (int num : inputNums) {
			if(num>max) {
				max = num;
			} else if (num<min) {
				min = num;
			}
		}
		
		System.out.println("입력받은 값 중 가장 큰 값은: "+max+" 입니다.");
		System.out.println("입력받은 값 중 가장 작은 값은: "+min+" 입니다.");
	}
}
