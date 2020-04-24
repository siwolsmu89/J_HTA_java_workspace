package com.sample.mall.vo;

public class Product {

	public int no;
	public String name;
	public int price;
	public int discountPrice;
	public int stock;
	public int score;
	
	public Product() {}
	
	public Product(String name, int price, int discountPrice, int stock, int score) {
		this.name = name;
		this.price = price;
		this.discountPrice = discountPrice;
		this.stock = stock;
		this.score = score;
	}

	public Product(int no, String name, int price, int discountPrice, int stock, int score) {
		this.no = no;
		this.name = name;
		this.price = price;
		this.discountPrice = discountPrice;
		this.stock = stock;
		this.score = score;
	}
	
	
}
