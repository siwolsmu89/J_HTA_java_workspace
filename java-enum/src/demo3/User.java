package demo3;

public class User {
	private String name;
	private DepositRate depositRate;
	private int orderPrice;
	
	public User(String name, DepositRate depositRate, int orderPrice) {
		this.name = name;
		this.depositRate = depositRate;
		this.orderPrice = orderPrice;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DepositRate getDepositRate() {
		return depositRate;
	}

	public void setDepositRate(DepositRate depositRate) {
		this.depositRate = depositRate;
	}
	
}
