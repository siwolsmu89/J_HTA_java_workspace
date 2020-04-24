package control;

public class Lotto {

	public static void main(String[] args) {
		
		System.out.println("로또번호 추첨기");

		int num1 = (int) (Math.random()*45 + 1);
		int num2 = (int) (Math.random()*45 + 1);
		int num3 = (int) (Math.random()*45 + 1);
		int num4 = (int) (Math.random()*45 + 1);
		int num5 = (int) (Math.random()*45 + 1);
		int num6 = (int) (Math.random()*45 + 1);
		
		System.out.println(num1+","+num2+","+num3+","+num4+","+num5+","+num6+",");
		
	}
}
