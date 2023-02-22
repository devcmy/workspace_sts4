package com.itwill.order;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao {
	@Autowired						//생성자 나 setter 메소드 이용안하거나 @autowired 안해주면 null 에러
	private DataSource dataSource;

	@Override
	public List<Order> list() {
		System.out.println("의존성객체인 dataSource:"+dataSource);
		
		return Arrays.asList(new Order(1,"주문1",new Date()), 
						new Order(2,"주문2",new Date()),
						new Order(3,"주문3",new Date())
						);
		
		
	}
}
