package com.sample.mask.repository;

import com.sample.mask.vo.Product;

public class ProductRepository {
	private Product[] db = new Product[200];
	private int position = 0;
	
	public ProductRepository() {
		Product mask1 = new Product(1,"kf80", 200);
		Product mask2 = new Product(2,"kf94", 50);
		
		db[position++] = mask1;
		db[position++] = mask2;
	}
	
	
	public void buyMask(boolean isGoodMask) {
		if(isGoodMask) {
			db[1].stock--;
			System.out.println("우수고객님, "+db[1].maskName+"을 드리겠습니다.");
			System.out.println("재고: "+db[1].stock);
		} else {
			db[0].stock-=2;
			System.out.println(db[0].maskName+"이나 가져 가라");
			System.out.println("재고: "+db[0].stock);
		}
	}
	
	
}
