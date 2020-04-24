package array;

public class ArrayDemo6 {

	public static void main(String[] args) {
		
		int[][] scores = {
				{80, 70, 80},			// 김유신의 국어, 영어, 수학점수
				{30, 40, 50},			// 강감찬의 국어, 영어, 수학점수
				{100, 86, 100},			// 이순신의 국어, 영어, 수학점수
		};
		
		int korSum=0, engSum=0, mathSum =0;
		int korAvg=0, engAvg=0, mathAvg =0;

		System.out.println("번호	국어	영어	수학	총점	평균");
		System.out.println("==============================================");
		
		for (int i=0;i<scores.length;i++) {
			System.out.print((i+1)+"\t");
			
			int sum=0, avg=0;
			korSum += scores[i][0];				// 각 행의 0번 열(국어점수)의 값을 누적해서 더함
			engSum += scores[i][1];				// 각 행의 1번 열(영어점수)의 값을 누적해서 더함
			mathSum += scores[i][2];			// 각 행의 2번 열(수학점수)의 값을 누적해서 더함
			korAvg = korSum/scores.length;		// 국어점수의 평균
			engAvg = engSum/scores.length;		// 영어점수의 평균
			mathAvg = mathSum/scores.length;	// 수학점수의 평균

			for (int j=0;j<scores[i].length;j++) {
				sum += scores[i][j];			// 각 행별 점수를 sum에 누적해서 더함
				avg = sum/scores[i].length;		// 각 행별 점수의 평균값
				System.out.print(scores[i][j]+"\t");	// 각 행별 점수를 출력
			}
			System.out.print(sum+"\t");			// 각 행별 총점을 출력
			System.out.print(avg+"\t");			// 각 행별 평균을 출력
			System.out.println();
		}
		System.out.println("==============================================");
		System.out.println("총점:\t"+korSum+"\t"+engSum+"\t"+mathSum);
		System.out.println("평균:\t"+korAvg+"\t"+engAvg+"\t"+mathAvg);
		
	}
}
