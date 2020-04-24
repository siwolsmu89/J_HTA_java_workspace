package operator;

public class OpDemo4 {

	public static void main(String[] args) {
		// 대입연산자(이항 연산자)
		// = += -= *= /= %=
		// 대입연산자는 모든 연산자들 중에서 연산 우선순위가 가장 낮은 연산자다.
		
		int num1 = 10;
		num1 = num1 + 1;		// num1++;
		
		int num2 = 10;
		num2 = num2 + 2;
		System.out.println("num2: " + num2);
		num2 = num2 + 2;
		System.out.println("num2: " + num2);
		num2 = num2 + 2;
		System.out.println("num2: " + num2);

		int num3 = 10;
		num3 += 2;
		System.out.println("num3: " + num3);
		num3 += 2;
		System.out.println("num3: " + num3);
		num3 += 2;
		System.out.println("num3: " + num3);
		
		int itemPrice1 = 1000;
		int itemPrice2 = 4000;
		int itemPrice3 = 12000;
		int itemPrice4 = 6500;
		int itemPrice5 = 2700;
		
		int totalPrice = 0;
		totalPrice += itemPrice1;
		totalPrice += itemPrice2;
		totalPrice += itemPrice3;
		totalPrice += itemPrice4;
		totalPrice += itemPrice5;
		System.out.println("총 판매금액: " + totalPrice);
		
	}
}
