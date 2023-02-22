package com.itwill2.bean.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.guest.GuestService;


@SpringBootApplication
@ComponentScan({"com.itwill.guest"})
public class SpringBootBeanDependencyInjectionMain {

	public static void main(String[] args) throws Exception {
		System.out.println("-----Spring Container 초기화 시작[ApplicationContext객체생성 시작]-------");
		ApplicationContext applicationContext = SpringApplication.run(SpringBootBeanDependencyInjectionMain.class, args);
		System.out.println("-----Spring Container 초기화 끝[ApplicationContext객체생성 끝]-------");
		//Injection없이 작업
		GuestService guestService = applicationContext.getBean(GuestService.class);
		
		//guestService.selectAll();
		System.out.println("------Constructor Injection(생성자 주입)----------");
		
		System.out.println("------Setter      Injection(생성자 주입)----------");
		
		
		
		
		
	}

}
