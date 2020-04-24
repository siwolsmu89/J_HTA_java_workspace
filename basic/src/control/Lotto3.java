package control;

import java.util.Scanner;

public class Lotto3 {

	public static void main(String[] args) {
		int n1 = 0; // 1번째 로또번호
		int n2 = 0; // 2번째 로또번호
		int n3 = 0; // 3번째 로또번호
		int n4 = 0; // 4번째 로또번호
		int n5 = 0; // 5번째 로또번호
		int n6 = 0; // 6번째 로또번호
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("로또 번호 발매기");
		System.out.print("금액을 1000원 단위로 입력하세요: ");
		int income = scanner.nextInt();
		
		int setCount = income/1000;
		
		for (int i=1;i<=setCount*6;i++) {
			
			int num = (int) (Math.random()*45 + 1);

			if (n1==num||n2==num||n3==num||n4==num||n5==num||n6==num) { // num이 이미 있는 숫자랑 같으면
				i--; // i값을 감소시킨다
			} else {			// 그렇지않으면 실행
				if (i%6==1) {
					n1 = num;
					System.out.print(n1+", ");
				}
				else if (i%6==2) {
					n2 = num;
					System.out.print(n2+", ");
				}
				else if (i%6==3) {
					n3 = num;
					System.out.print(n3+", ");
				}
				else if (i%6==4) {
					n4 = num;
					System.out.print(n4+", ");
				}
				else if (i%6==5) {
					n5 = num;
					System.out.print(n5+", ");
				}
				else if (i%6==0) {
					n6 = num;
					System.out.println(n6);
				}
			}
						
		}
		
		
	}
}
