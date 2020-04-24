package array;

public class ArrayDemo5 {

	public static void main(String[] args) {
		// 2차원 배열
		
		int[][] scores = new int[2][3]; // 2행 3열짜리 int형 배열 scores
		
		// 0번 행은 이순신의 국어, 영어, 수학 점수
		scores[0][0] = 60;
		scores[0][1] = 80;
		scores[0][2] = 90;
		// 1번 행은 김유신의 국어, 영어, 수학 점수
		scores[1][0] = 50;
		scores[1][1] = 40;
		scores[1][2] = 40;
		
	/*					국어		영어		수학
	 * 					[0]		[1]		[2]
	 *	이순신	[0]		60		80		90
	 *	김유신	[1]		50		40		40
	 *	
 	 */
		
		System.out.println("scores.length --> " + scores.length);
		System.out.println("scores[0].length --> " + scores[0].length);
		System.out.println("scores[1].length --> " + scores[1].length);
		
		for (int i=0;i<scores.length;i++) {
			for (int j=0;j<scores[i].length;j++) {
				System.out.println(i+","+j+"--->"+scores[i][j]);
			}
		}
		
		for (int[] a : scores) {
			for (int b : a) {
				System.out.println("enhanced-for문: " + b);
			}
		}
		
		// 이순신의 점수 총점
		int total1=0;
		for (int i = 0; i<3; i++) {
			System.out.println(scores[0][i]);
			total1 += scores[0][i];
		}
		System.out.println("이순신의 총점: "+total1);
		
		// 김유신의 점수 총점
		int total2=0;
		for (int i=0;i<3;i++) {
			System.out.println(scores[1][i]);
			total2 += scores[1][i];
		}
		System.out.println("김유신의 총점: "+total2);
		
		
	}
	
}
