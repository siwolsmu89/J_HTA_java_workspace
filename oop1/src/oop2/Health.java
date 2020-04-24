package oop2;

/**
 * 건강관련 지수를 계산하는 기능을 제공하는 클래스다.
 * @author JHTA
 *
 */
public class Health {

	/**
	 * 체질량지수를 계산해서 그 값을 반환한다.
	 * @param weight 몸무게, Kg단위
	 * @param height 키, m단위
	 * @return 체질량지수
	 */
	double bmi(double weight, double height) {
		double bodyMassIndex = weight/(height*height);
		
		return bodyMassIndex;
	}
	
	/**
	 * 체질량지수를 계산해서, 지수에 따라 비만, 정상, 저체중 등의 값을 반환한다.
	 * @param weight 몸무게, Kg단위
	 * @param height 키, m단위
	 * @return 체질량지수, 고도비만/중증도비만/경도비만/과체중/정상/저체중 중 하나를 반환
	 */
	String bmiText(double weight, double height) {
		String bmiGrade = "";
		double bmi = bmi(weight, height);
		
		if (bmi>=40) {
			bmiGrade = "고도 비만";
		} else if (bmi>=35) {
			bmiGrade = "중증도 비만";
		} else if (bmi>=30) {
			bmiGrade = "경도 비만";
		} else if (bmi>=25) {
			bmiGrade = "과체중";
		} else if (bmi>=18.5) {
			bmiGrade = "정상";
		} else {
			bmiGrade = "저체중";
		}
		
		
		return bmiGrade;
		
	}
	
}
