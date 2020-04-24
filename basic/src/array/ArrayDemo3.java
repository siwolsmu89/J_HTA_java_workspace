package array;

public class ArrayDemo3 {

	public static void main(String[] args) {
		// 배열의 길이 조회하기
		//		배열이름.length로 조회만 할 수 있다.
		// 		* 배열의 길이는 불변이다. 배열의 길이를 변경할 수 없다.
		String[] names = {"이순신", "김유신", "강감찬"};
		// 배열의 길이
		int len = names.length;
		System.out.println("배열의 길이: "+ len);
		System.out.println("배열의 길이: "+ names.length);

		// 배열의 길이를 활용해서 배열의 각 요소값 조회하기
		System.out.println(names[0]);
		System.out.println(names[1]);
		System.out.println(names[2]);
		
		for (int i=0; i<names.length; i++) {
			System.out.println(names[i]);
		}
		
		int[] scores = {80, 50, 67, 70, 40, 30, 23, 19, 58, 100};
		int totalScore = 0;
		for(int i = 0; i<scores.length; i++) {
			System.out.println("점수: " +scores[i]);
			totalScore += scores[i];
		}
		
		System.out.println("총점: " +totalScore);
	
		
	}
}
