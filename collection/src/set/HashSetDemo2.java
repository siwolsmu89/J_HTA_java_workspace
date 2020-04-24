package set;

import java.util.HashSet;
import java.util.Iterator;

import vo.Product;

public class HashSetDemo2 {

	public static void main(String[] args) {

		HashSet<Product> products = new HashSet<Product>();

		Product p1 = new Product(100, "공책", "모나미", 3000);
		Product p2 = new Product(120, "샤프", "모나미", 7000);
		Product p3 = new Product(131, "수첩", "양지다이어리", 13000);
		Product p4 = new Product(121, "색연필", "모나미", 7000);
		Product p5 = new Product(168, "볼펜", "모나미", 3000);

		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);
		products.add(p5);

		Iterator<Product> itr = products.iterator();
		while (itr.hasNext()) {
			Product p = itr.next();
			if (p.getPrice() >= 10000) {
				itr.remove();
			}
		}

		int size = products.size();
		System.out.println("저장된 상품객체 개수: " + size);

		for (Product p : products) {
			System.out.println(p.getNo() + ", " + p.getName() + ", " + p.getPrice());
		}

	}
}
