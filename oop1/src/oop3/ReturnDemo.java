package oop3;

public class ReturnDemo {

	public static void main(String[] args) {
		int[] number = {1, 3, 6, 9, 4, 6, 8};
	}
	
	// 전달받은 배열의 값을 n배로 만들어서 반환하는 메소드
	static int[] multipleArray(int[] src, int num) {
		int[] result = new int[src.length];
		
		for (int i=0; i<src.length; i++) {
			result[i] = src[i]*num;
		} 
		return result;
	}
	
	
	
}
