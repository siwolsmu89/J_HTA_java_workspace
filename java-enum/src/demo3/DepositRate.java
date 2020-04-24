package demo3;

public enum DepositRate {

	BRONZE(0.01), SILVER(0.03), GOLD(0.05), VIP(0.1);
	
	// 열거형의 멤버변수는 반드시 final로 정의해야 한다.
	private final double value;
	
	// 열거형의 생성자는 멤버변수를 초기화해야 한다.(기본 생성자 사용불가)
	// 열거형의 생성자는 오직 private만 가능하다.
	// 열거형의 생성자는 열거형 내부에서만 사용한다.
	private DepositRate(double value) {
		this.value = value;
	}
	
	public double getValue() {
		return value;
	}

}
