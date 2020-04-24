package oop2;

public class HealthDemo {
	public static void main(String[] args) {
	
	Health h = new Health();
	double a = h.bmi(138,1.85);
	System.out.println("bmi지수: "+a);
	
	String b = h.bmiText(138, 1.85);
	System.out.println("bmi등급: "+b);
	
	}

}
