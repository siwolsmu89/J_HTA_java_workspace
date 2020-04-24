package demo3;

public class DepositRateDemo {

	public static void main(String[] args) {
		User user1 = new User("홍길동", DepositRate.BRONZE, 1200000);
		User user2 = new User("강감찬", DepositRate.GOLD, 500000);
		User user3 = new User("김유신", DepositRate.VIP, 450000);
		
		int point1 = (int) (user1.getOrderPrice() * user1.getDepositRate().getValue());
		int point2 = (int) (user2.getOrderPrice() * user2.getDepositRate().getValue());
		int point3 = (int) (user3.getOrderPrice() * user3.getDepositRate().getValue());
		
		System.out.println("홍길동의 적립율: " + user1.getDepositRate().getValue());
		System.out.println("강감찬의 적립율: " + user2.getDepositRate().getValue());
		System.out.println("김유신의 적립율: " + user3.getDepositRate().getValue());
		
		System.out.println(point1);
		System.out.println(point2);
		System.out.println(point3);
	}
}
