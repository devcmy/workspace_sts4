package com.itwill.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.itwill.user.controller.AuthLoginInterceptor;

@Configuration

public class WebConfig implements WebMvcConfigurer{
	/********************WebMvcConfigurer재정의*********************/
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/index.jsp"); //웰컴파일 설정
	}
	/*
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		 registry.jsp("/WEB-INF/views/",".jsp");
	}
	*/
	
	
	/*
	 * 사용자 정의 필터 등록(사용자 정의 아닌것도 등록가능)
	 */
	@Override //인터셉터 등록
	public void addInterceptors(InterceptorRegistry registry) {
		AuthLoginInterceptor authLoginInterceptor = new AuthLoginInterceptor();
		registry.addInterceptor(authLoginInterceptor)       //mock테스트마냥
		.addPathPatterns("/**") //전체등록
		.excludePathPatterns("/css/**") //제외하는 작업
		.excludePathPatterns("/js/**")
		.excludePathPatterns("/image/**")
		.excludePathPatterns("/user_main")
		.excludePathPatterns("/user_login_form")
		.excludePathPatterns("/user_login_action")
		.excludePathPatterns("/user_write_form")
		.excludePathPatterns("/user_write_Action"); 
	}
	/*************************************************************/
	
	
	
	/*********************Spring MVC 빈객체등록*********************/
	// 1.ViewResolver객체등록
	/*
	@Bean
	public BeanNameViewResolver beanNameViewResolver() {
		BeanNameViewResolver beanNameViewResolver=new BeanNameViewResolver();
		beanNameViewResolver.setOrder(0);
		return beanNameViewResolver;
	}
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver=new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		internalResourceViewResolver.setOrder(1);
		return internalResourceViewResolver;
	}
	*/
	
	
}
