package list;

import java.util.ArrayList;

import utils.CommonUtils;
import vo.Product;

public class ArrayListDemo3 {

	public static void main(String[] args) {

		Product p1 = new Product(10000, "iphone XS", "apple", 1570000);
		Product p2 = new Product(10001, "ipad pro", "apple", 1200000);
		Product p3 = new Product(10002, "apple watch", "apple", 600000);
		Product p4 = new Product(10003, "macbook pro 13", "apple", 1700000);
		Product p5 = new Product(10004, "macbook pro 14", "apple", 3600000);

		ArrayList<Product> products = new ArrayList<Product>();
		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);
		products.add(p5);

		for (Product product : products) {
			System.out.println("상품번호: " + product.getNo());
			System.out.println("상품이름: " + product.getName());
			System.out.println("제 조 사: " + product.getMaker());
			System.out.println("상품가격: " + CommonUtils.numberToString(product.getPrice()));
			System.out.println("등록날짜: " + CommonUtils.simpleDateString(product.getCreatDate()));
			System.out.println();
		}

	}
}
