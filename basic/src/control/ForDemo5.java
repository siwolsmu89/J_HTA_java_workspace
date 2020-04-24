package control;

public class ForDemo5 {

	public static void main(String[] args) {
		// 중첩 for문
		
		for (int i = 1; i <= 3; i++) {
			System.out.println("i값: " + i);
			for (int j = 1; j <= 5; j++) {
				if (j>=3) {
					break; // 중첩 for문에서 break는 해당 for문을 탈출한다.
						   // 바깥쪽 for문에는 영향을 주지 않는다.
				}
				System.out.println("i값: " + i + ", j값: " + j);
			}
		}
	}
}
