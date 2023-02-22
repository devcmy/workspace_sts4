package com.itwill0.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.product.ProductService;

public class SpringApplicationMain {

	public static void main(String[] args) {
		//서비스를 주세요 호출해볼꼐
		/*
		 * Spring Container 객체생성(얘네들이 대신 객체생성(우리가직접작성x)
		 *  - ApplicationContext[BeanFactory]객체생성
		 */
		
		/*
		 * 1. Spring Bean 설정파일을 읽어서 SpringContainer 객체생성 -> 1)생성자를 통해 주입 or 2)setter injection 주입해야 가능.
		 */
		System.out.println("---------------------ApplicationContext 생성시작-----------------------------------------------------");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/itwill0/context/0.application_context.xml");
		System.out.println("---------------------ApplicationContext 생성끝-----------------------------------------------------");
		
		/*
		 * 2. Spring Container 객체[ApplicationContext객체]로 부터
		 * 	productService 아이디를 가진 객체 참조 얻기.
		 */
		
		ProductService productService = (ProductService)applicationContext.getBean("productService"); //object타입으로 꺼내져서, 캐스팅함.
		System.out.println(productService.productList());
		System.out.println(productService.productDetail(321));
		System.out.println("-----------------singleton객체(객체가 한번 생성하면 호출될때 같은 객체 반환함----------------");
		System.out.println(applicationContext.getBean("productService"));
		System.out.println(applicationContext.getBean("productService"));
		System.out.println(applicationContext.getBean("productService")); //Container은 기본적으로 같은 객체가 반환됨.(참조변수가 동일)
		
		
	}

}
