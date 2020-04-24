package control;

public class ContinueDemo {

	public static void main(String[] args) {
		// continue
		// 반복문 안에 있는 수행문을 실행하던 도중 continue가 실행되면
		// 남아 있는 수행문의 실행을 취소하고 증감식으로 이동해 다음 번 반복을 하러 간다.
		
		for (int i = 1; i <= 10; i++) {
			if(i%3 == 0) {
				System.out.println("3의 배수");
				continue;
			}
			System.out.println(i);
		}
		
	}
}
