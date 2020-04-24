package number1;

public class IntegerDemo {

	public static void main(String[] args) {
		
		String text = "1234567.89";
		
		double number1 = Double.parseDouble(text);
		System.out.println(number1);
		
		int number2 = Integer.parseInt("1000000");
		System.out.println(number2);
	}
}
