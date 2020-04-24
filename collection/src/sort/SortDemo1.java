package sort;

import java.util.Arrays;

public class SortDemo1 {
	
	public static void main(String[] args) {

		String[] arr = { "이순신", "류관순", "강감찬", "김유신", "안중근", "김구" };
		
		// 가나다순으로 정렬
		Arrays.sort(arr);

		for(String value : arr) {
			System.out.print(value+"\t");
		}
		
	}
}
