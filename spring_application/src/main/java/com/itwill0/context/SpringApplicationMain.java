package com.itwill0.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationMain {

	public static void main(String[] args) {
		/*
		 * Spring Container 객체생성(얘네들이 대신 객체생성)
		 *  - ApplicationContext[BeanFactory]객체생성
		 */
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/itwill0/context/0.application_context.xml");
		
	}

}
