package datatype;

public class DataTypeDemo10 {

	public static void main(String[] args) {
	
		/*
		 * 홍길동은 이번 시험에서 국어 80점, 영어 60점, 수학 45점을 획득했다.
		 * 
		 * 아래와 같이 출력되게 하시오
		 * 이름 	국어	 영어	  수학	  총점	    평균
		 * 홍길동 	80	 60	 45	 185  61
		 */

		String name = "홍길동";
		int kor = 80;
		int eng = 60;
		int math = 45;
		int total = kor+eng+math;
		int average = (int) (total/3);
		
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\n"+name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+total+"\t"+average);
	
	}
	
}
