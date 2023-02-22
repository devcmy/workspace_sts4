package com.itwill1.bean.create;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/*
 * 현재 클래스가 위치하는 패키지와 하위패키지의 클래스의 @Annotation을 스캔해서 
 * 초기화(객체생성, 의존성 주입)	
 */
@SpringBootApplication
public class SpringBootBeanCreateApplicationMain {

	public static void main(String[] args) {
		System.out.println("-----Spring Container 초기화 시작[ApplicationContext객체생성 시작]-------");
		ApplicationContext applicationContext = SpringApplication.run(SpringBootBeanCreateApplicationMain.class, args);
		System.out.println("-----Spring Container 초기화 끝[ApplicationContext객체생성 끝]-------");
		
	}

}
