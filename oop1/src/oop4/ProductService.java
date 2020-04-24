package oop4;

public class ProductService {

	Product[] db = new Product[20];
	int position = 0;

	void printList() {
		System.out.println("----------------------------------------------------------------");
		System.out.println("상품명	제조사	카테고리	가격	재고량	할인율	품절여부");
		System.out.println("----------------------------------------------------------------");
	}

	void errorMsg() {
		System.out.println("상품 정보가 없습니다.");

	}

	void errorMsg(String key) {
		System.out.println("검색어 [" + key + "]와 일치하는 제품정보가 없습니다.");
	}

	Product searchProductByName(String name) {
		Product pd = new Product();
		pd = null;
		for (int i = 0; i < position; i++) {
			if (name.equals(db[i].name)) {
				pd = db[i];
			}
		}
		if (pd == null) {
			errorMsg(name);
		}
		return pd;
	}

	void displayAll() {
		printList();

		if (position == 0) {
			errorMsg();
		} else {
			for (int i = 0; i < position; i++) {
				db[i].display();
			}
		}
	}

	void productIn(String name, String maker, String category, int price, int stock, double discountRate) {

		Product pd = new Product(name, maker, category, price, stock, discountRate);
		db[position] = pd;

		System.out.println("이월 상품 [" + name + "]이 입고되었습니다.");
		position++;
	}

	void productIn(String name, String maker, String category, int price, int stock) {
		Product pd = new Product(name, maker, category, price, stock);
		db[position] = pd;

		System.out.println("새 상품 [" + name + "]이 입고되었습니다.");
		position++;
	}

	void stockIn(String name, int amount) {
		Product pd = searchProductByName(name);
		System.out.println("입고 전 상품 [" + name + "]의 재고: " + pd.stock);
		pd.stock += amount;
		System.out.println("입고 후 상품 [" + name + "]의 재고: " + pd.stock);
	}

	void stockOut(String name, int amount) {
		Product pd = searchProductByName(name);
		
		if (pd == null) {
			
		} else if (pd.stock < amount) {
			System.out.println("상품의 재고가 부족합니다. 현재[" + pd.stock + "] 부족한 수량[" + (amount - pd.stock) + "]");
		} else {
			pd.stock = pd.stock - amount;
			System.out.println("출고가 완료되었습니다.");
			System.out.println("출고 후 재고: " + pd.stock);
			if (pd.stock == 0) {
				pd.isSoldOut = true;
			}
		}
	}

	void displayByName(String name) {
		Product pd = searchProductByName(name);
		printList();
		pd.display();
	}

	void displayByMaker(String maker) {
		Product pd = new Product();
		pd = null;
		printList();
		for (int i = 0; i < position; i++) {
			if (maker.equals(db[i].maker)) {
				pd = db[i];
				pd.display();
			}
		}
		if (pd == null) {
			errorMsg(maker);
		}
	}

	void displayByCategory(String category) {
		Product pd = new Product();
		pd = null;
		printList();
		for (int i = 0; i < position; i++) {
			if (category.equals(db[i].category)) {
				pd = db[i];
				pd.display();
			}
		}
		if (pd == null) {
			errorMsg(category);
		}
	}

	void displayByPriceRange(int min, int max) {
		Product pd = new Product();
		pd = null;
		printList();
		for (int i = 0; i < position; i++) {
			if (db[i].price >= min && db[i].price <= max) {
				pd = db[i];
				pd.display();
			}
		}
		if (pd == null) {
			errorMsg();
		}
	}

}
