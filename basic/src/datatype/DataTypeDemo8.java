package datatype;

public class DataTypeDemo8 {

	public static void main(String[] args) {

		// 반지름의 길이가 5, 10, 20인 원들이 있다.
		// 각 원들의 넓이와 원의 둘레길이를 계산해서 출력하기
		// 넓이는 3.14*반지름*반지름, 둘레길이는 2*3.14*반지름
		
		
		
		// Math.PI
		// radius 반지름
		// area 넓이
		// perimeter 둘레 길이
	
// 		int radius;
//		double area = radius*radius*pi;
//		double perimeter = 2*radius*pi;
		double pi = 3.14;
		
//		roundA
		int radiusA = 5;
		double areaA = radiusA*radiusA*pi;
		double perimeterA = 2*radiusA*pi;
		System.out.println("넓이: "+areaA);
		System.out.println("둘레길이: "+perimeterA);
		
//		roundB
		int radiusB = 10;
		double areaB = radiusB*radiusB*pi;
		double perimeterB = 2*radiusB*pi;
		System.out.println("넓이: "+areaB);
		System.out.println("둘레길이: "+perimeterB);
	
//		roundC
		int radiusC = 20;
		double areaC = radiusC*radiusC*pi;
		double perimeterC = 2*radiusC*pi;
		System.out.println("넓이: "+areaC);
		System.out.println("둘레길이: "+perimeterC);
		
/*
 *  int radiusA
 *  int radiusB
 *  int radiusC
 *  (공백)
 *  double areaA
 *  double areaB
 *  double areaC
 *  (공백)
 *  이런 식으로
 */

	}	
}