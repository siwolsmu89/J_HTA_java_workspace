package control;

public class WhileDemo5 {

	public static void main(String[] args) {
		
		int sum = 0;
		int num = 1;
		
		while(true) {
			if (num%2 == 0) {
				sum -= num;
			} else {
				sum += num;
			}
			if (sum>=100) {
				System.out.println(num);
				break;
			}
			num++;
		}
	}
}
