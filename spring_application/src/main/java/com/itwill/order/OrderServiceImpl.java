package com.itwill.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired		
	private OrderDao orderDao;
	
	@Override
	public List<Order> list() {
		// TODO Auto-generated method stub
		return orderDao.list();
	}
	
}
