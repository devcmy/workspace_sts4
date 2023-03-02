package com.itwill.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration //이 클래스가 스프링 구성 파일임을 나타냅니다.
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{ //WebMvcConfigurer 인터페이스를 구현하여 스프링 MVC 구성에 관련된 메서드를 구현할 수 있습니다.
	//재정의받아서 implement받는건 전역설정에 필요한경우도. ( @configuration붙어줘야함)
	/*
	 * weclome file 설정 "/"로 들어오면 forward시켜줘야함  
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) { //addViewControllers() 메서드는 ViewControllerRegistry를 인자로 받아, ViewControllerRegistry에 URL 경로와 뷰 이름을 등록하는 역할을 합니다. 이 메서드에서는 "/" 경로로 들어오는 요청을 index.jsp로 포워딩합니다. 
		registry.addViewController("/").setViewName("forward:/index.jsp");//따라서, 루트 URL에 접속하면 index.jsp가 표시됩니다.
	}
	
	  @Override 
	  public void configureViewResolvers(ViewResolverRegistry registry) {
	  //registry.jsp("/WEB-INF/views",".jsp"); 
	  }
	 
	
	/*****************************Spring MVC객체 등록 *******************************/
	//View Resolver 등록
	@Bean //반환되는 객체가 bean으로 등록
	public BeanNameViewResolver beanNameViewResolver() {
		BeanNameViewResolver beanNameViewResolver = new BeanNameViewResolver();
		beanNameViewResolver.setOrder(0); //우선순위가 가장높음
		return beanNameViewResolver;
	}
	
	@Bean 
	public InternalResourceViewResolver internalResourceViewResolver() { //jsp를 view로 설정하기위해 -> 아래설정을 통해 "return "response_forward_view_name"; 기술해도 된다
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		internalResourceViewResolver.setOrder(1);
		return internalResourceViewResolver;
	}
	
	
	
	/*
	@Bean
	public SimpleUrlHandlerMapping sampleServletMapping() {
		SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
		Properties urlProperties = new Properties();
		urlProperties.put("/hello", "helloController");
		mapping.setMappings(urlProperties);
		return mapping;
	}
	@Bean("helloController")
	public HelloController helloController() {
		return new HelloController();
	}
	*/

}
