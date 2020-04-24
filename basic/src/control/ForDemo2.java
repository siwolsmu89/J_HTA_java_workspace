package control;

public class ForDemo2 {
	
	public static void main(String[] args) {
		/*
		 * 1부터 i까지의 합계를 계산하기
		 */
		int sum = 0;
		
		for (int i=1; i<=1000; i++) {
			System.out.print("["+i+"] ["+sum+"] ---->");
			sum += i;
			System.out.println("["+sum+"]");
		}
		
		
	}

}
