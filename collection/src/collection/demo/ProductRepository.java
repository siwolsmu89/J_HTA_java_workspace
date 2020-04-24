package collection.demo;

import java.util.ArrayList;

import vo.Product;

public class ProductRepository {
	// 서비스는 생략

	// 상품정보를 저장하는 ArrayList객체를 생성
	private ArrayList<Product> db = new ArrayList<Product>();
	private int sequence = 100000;

	// 새 상품 등록 기능
	public void insertProduct(Product product) {
		product.setNo(sequence++); 	// 상품번호 자동증가
		db.add(product);
	}

	// 등록된 모든 상품을 반환하는 기능
	public ArrayList<Product> getAllProducts() {
		return db;
	}

	// 전달받은 상품번호에 해당하는 상품을 반환하는 기능
	public Product getProductByNo(int productNo) {
		Product found = null;
		
		for (Product p : db) {
			int no = p.getNo();
			if (productNo==no) {
				found = p;
				break;
			}
		}
		
		return found;
	}

	// 전달받은 검색어에 해당하는 상품들을 반환하는 기능
	public ArrayList<Product> searchProducts(String keyword) {
		ArrayList<Product> found = new ArrayList<Product>();

		for (Product p : db) {
			String productName = p.getName();
			String productMaker = p.getMaker();
			
			if(productName.contains(keyword)||productMaker.contains(keyword)) {
				found.add(p);
			}
		}
		
		return found;
	}

	// 전달받은 상품번호에 해당하는 상품을 삭제하는 기능
	public void deleteProduct(int productNo) {
		
	}

}
