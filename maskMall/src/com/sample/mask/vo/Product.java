package com.sample.mask.vo;

public class Product {
	public int maskNo;
	public String maskName;
	public int stock=200;
	public static int PRICE = 1500;
	
	public Product (){	}

	public Product (int maskNo, String maskName, int stock){
		this.maskNo = maskNo;
		this.maskName = maskName;
		this.stock = stock;
	}
	
}
