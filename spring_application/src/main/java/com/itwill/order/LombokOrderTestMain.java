package com.itwill.order;

import java.util.Date;

public class LombokOrderTestMain {

	public static void main(String[] args) {
		Order order = new Order();
		order.setOrderNo(0);
		order.setOrderTitle(null);
		order.setOrderDate(new Date());
		
		System.out.println(order);
		Order order2 = new Order(2, "PHONE외..", new Date());
		System.out.println(order2);
				
	}

}
