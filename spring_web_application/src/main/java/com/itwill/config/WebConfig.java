package com.itwill.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //이 클래스가 스프링 구성 파일임을 나타냅니다.
public class WebConfig implements WebMvcConfigurer{ //WebMvcConfigurer 인터페이스를 구현하여 스프링 MVC 구성에 관련된 메서드를 구현할 수 있습니다.
	/*
	 * weclome file 설정 "/"로 들어오면 forward시켜줘야함  
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) { //addViewControllers() 메서드는 ViewControllerRegistry를 인자로 받아, ViewControllerRegistry에 URL 경로와 뷰 이름을 등록하는 역할을 합니다. 이 메서드에서는 "/" 경로로 들어오는 요청을 index.jsp로 포워딩합니다. 
		registry.addViewController("/").setViewName("forward:/index.jsp");//따라서, 루트 URL에 접속하면 index.jsp가 표시됩니다.
	}
}
