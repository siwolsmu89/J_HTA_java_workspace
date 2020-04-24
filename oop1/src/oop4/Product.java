package oop4;

public class Product {

	String name;
	String maker;
	String category;
	int price;
	int stock;
	double discountRate;
	boolean isSoldOut;
 	
	
	// 기본 생성자
	Product() {}
	
	// 신제품 객체의 멤버변수 초기화에 적합한 생성자 메소드 (할인율0, 절판x)
	Product(String name, String maker, String category, int price, int stock){
		this(name, maker, category, price, stock, 0.0, false);
	}

	// 이월 상품 객체의 멤버변수 초기화에 적합한 생성자 메소드(절판x)
	Product (String name, String maker, String category, int price, int stock, double discountRate){
		this(name, maker, category, price, stock, discountRate, false);
	}
	
	// 모든 멤버변수를 초기화하는 생성자를 만들어놓고, 일부 멤버를 초기화하는 생성자에 가져가서 해당사항이 없는 멤버들은 초기값을 주고 사용
	Product(String name, String maker, String category, int price, int stock, double discountRate, boolean isSoldOut) {
		this.name = name;
		this.maker = maker;
		this.category = category;
		this.price = price;
		this.stock = stock;
		this.discountRate = discountRate;
		this.isSoldOut = isSoldOut;
	}
	
	// 상품정보 조회 기능
	void display() {
		String soldOut;
		if (isSoldOut) {
			soldOut = "품절됨";
		} else {
			soldOut = "재고 보유 중";
		}
		
		System.out.print(name + "\t");
		System.out.print(maker + "\t");
		System.out.print(category + "\t");
		System.out.print(price + "\t");
		System.out.print(stock + "\t");
		System.out.print(discountRate + "\t");
		System.out.println(soldOut);
	}
	
	
	
}
