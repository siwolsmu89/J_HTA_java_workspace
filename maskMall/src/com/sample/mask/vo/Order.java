package com.sample.mask.vo;

public class Order {
	
	public int userId;
	public int no;
	public int orderNum=0;
	public boolean isGoodMask = false; // false면 kf 80, true면 95;
	public boolean isWeekend = false; // false면 주중, true면 주말
}
