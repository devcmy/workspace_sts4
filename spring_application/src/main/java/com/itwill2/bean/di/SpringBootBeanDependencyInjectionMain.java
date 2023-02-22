package com.itwill2.bean.di;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.guest.GuestService;
import com.itwill.order.OrderService;
import com.itwill.user.UserService;


@SpringBootApplication
@ComponentScan({"com.itwill.guest","com.itwill.user","com.itwill.order"})

public class SpringBootBeanDependencyInjectionMain {

	public static void main(String[] args) throws Exception {
		System.out.println("-----Spring Container 초기화 시작[ApplicationContext객체생성 시작]-------");
		ApplicationContext applicationContext = SpringApplication.run(SpringBootBeanDependencyInjectionMain.class, args);
		
		/* SpringApplication application = new SpringApplication(SpringBootBeanDependencyInjectionMain.class);
		 application.setBannerMode(Banner.Mode.OFF);
		 ApplicationContext applicationContext=application.run(args); */
		 
		System.out.println("-----Spring Container 초기화 끝[ApplicationContext객체생성 끝]-------");
		//Injection없이 작업
		GuestService guestService = applicationContext.getBean(GuestService.class);
		
		System.out.println("------Constructor Injection(생성자 주입)----------");
		guestService.selectAll();
		
		System.out.println("------Setter      Injection(생성자 주입)----------");
		UserService userService = (UserService)applicationContext.getBean(UserService.class);
		userService.create(null);
		
		System.out.println("------Field      Injection(생성자 주입)----------");
		OrderService orderService = (OrderService)applicationContext.getBean(OrderService.class);
		System.out.println(orderService.list()); //tostring lombok이 구현해줌 //injection이 null.pointer.exception 발생됨
		
		
		
		
	}

}
