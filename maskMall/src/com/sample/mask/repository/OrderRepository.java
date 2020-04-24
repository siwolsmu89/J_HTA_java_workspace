package com.sample.mask.repository;

import com.sample.mask.vo.Order;

public class OrderRepository {
	Order[] db = new Order[200];
	private int position = 0;
	private int orderSequence = 1001;
	
	
	public void addOrder(int id) {
		Order order = new Order();
		
		order.userId = id;
		order.no = orderSequence++;
		order.orderNum++;
		
		db[position] = order;
		position++;
	}
}
