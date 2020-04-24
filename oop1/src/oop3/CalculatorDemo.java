package oop3;

public class CalculatorDemo {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		
		int result1 = calculator.plus(1, 3);
		System.out.println(result1);
		double result2 = calculator.plus(1.0, 3.0);
		System.out.println(result2);
	}
}
