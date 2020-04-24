package demo1;

public class CustomerDemo {

	public static void main(String[] args) {
		
		// VIP 등급에 해당하는 숫자 0을 생성자의 파라미터로 제공
		Customer customer1 = new Customer("홍길동", 0);
		// 똑같은 값이 저장되지만 VIP 등급을 지정한다는 것이 명시되므로 가독성이 높아진다.(상수를 정의해서 사용하는 이유)
		Customer customer2 = new Customer("홍길동", Grade.VIP);
		Customer customer3 = new Customer("김유신", Grade.SILVER);
		
		// 상수의 단점
		// 지정된 상수 이외의 값이 대입되는 것을 컴파일러가 체크할 수 없다.
		// (100은 범주를 넘었지만 해당 자리는 int 타입이 들어가는 자리로 인식되므로 오류가 인식되지 않음)
		//		-> 열거형 등장
		Customer customer4 = new Customer("강감찬", 100);

		System.out.println(getPoint1(customer1, 1000000));
		System.out.println(getPoint1(customer2, 1500000));
		System.out.println(getPoint1(customer3, 2000000));
		
	}
	
	public static int getPoint1(Customer customer, int orderPrice) {
		int point = 0;

		if (customer.getGrade() == 0) {
			point = (int)(orderPrice*0.05);
		} else if (customer.getGrade() == 1) {
			point = (int)(orderPrice*0.03);
		} else if (customer.getGrade() == 2) {
			point = (int)(orderPrice*0.02);
		} else if(customer.getGrade() == 1) {
			point = (int)(orderPrice*0.01);
		}
		
		return point;
	}

	public static int getPoint2(Customer customer, int orderPrice) {
		int point = 0;
		
		if (customer.getGrade() == Grade.VIP) {
			point = (int)(orderPrice*0.05);
		} else if (customer.getGrade() == Grade.GOLD) {
			point = (int)(orderPrice*0.03);
		} else if (customer.getGrade() == Grade.SILVER) {
			point = (int)(orderPrice*0.02);
		} else if(customer.getGrade() == Grade.BRONZE) {
			point = (int)(orderPrice*0.01);
		}
		
		return point;
	}
	
}
