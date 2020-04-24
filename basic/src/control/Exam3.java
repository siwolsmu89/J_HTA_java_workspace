package control;

public class Exam3 {
	public static void main(String[] args) {
		// 1 + (-2) + 3 + (-4) + 5 + ... 몇까지 더하면 총합이 100이상?
		int sum = 0;
		int number = 1;
		
		while (true) {
			// number의 값이 홀수면 sum에 그냥 더하고, 아니면 -1를 곱한 후 더한다.
			// sum의 값이 100이상이면 탈출한다.
			// number의 값을 1증가시킨다.
			
			if (number%2 != 0 ) {		// number%2 == 0
				sum += number;
			} else {
				sum += number*(-1);
			}
			if (sum >= 100) {
				
				break;
			}
			number++;
		}
		
		System.out.println(number + "번째 됐을 때 100이 넘는다.");
	}

}
