package array;

import java.util.Arrays;

public class ArrayDemo15 {

	public static void main(String[] args) {
		
		int[] numbers = {10, 29, 1, 5, 23, 75, 31};
		// 배열의 값을 오름차순으로 정렬하기
		Arrays.sort(numbers); 
		
		// 배열의 값을 문자열로 변환해 출력하기
		String text = Arrays.toString(numbers); 
		System.out.println(text);
		
		String[] names = {"이순신", "김유신", "강감찬", "류관순", "안중근"};
		Arrays.parallelSort(names);  
		System.out.println(Arrays.toString(names));
		
		// 배열 복사하기
		// Arrays.copyOf(원본배열, 복사할 값의 갯수);
		// Arrays.copyOfRange(원본배열, 복사시작위치, 복사끝위치); 시작 위치는 포함, 끝위치는 포함 x
	
		numbers = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		int[] arr1 = Arrays.copyOf(numbers, 10);
		int[] arr2 = Arrays.copyOf(numbers, 5);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		
		int[] arr3 = Arrays.copyOfRange(numbers, 0, 3); //0번부터 3번 앞까지(0, 1, 2)
		int[] arr4 = Arrays.copyOfRange(numbers, 4, 7); //4번부터 7번 앞까지(4, 5, 6)
		int[] arr5 = Arrays.copyOfRange(numbers, 0, numbers.length); // == Arrays.copyOf(numbers,10);
		System.out.println(Arrays.toString(arr3));
		System.out.println(Arrays.toString(arr4));
		System.out.println(Arrays.toString(arr5));
	}
}
