package com.itwill0.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationMain {

	public static void main(String[] args) {
		/*
		 * Spring Container 객체생성(얘네들이 대신 객체생성(우리가직접작성x)
		 *  - ApplicationContext[BeanFactory]객체생성
		 */
		
		/*
		 * 1. Spring Bean 설정파일을 읽어서 SpringContainer 객체생성
		 */
		System.out.println("---------------------ApplicationContext 생성시작-----------------------------------------------------");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/itwill0/context/0.application_context.xml");
		System.out.println("---------------------ApplicationContext 생성끝-----------------------------------------------------");
		
		
		
		
	}

}
