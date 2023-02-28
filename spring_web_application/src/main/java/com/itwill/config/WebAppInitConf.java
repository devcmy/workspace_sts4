package com.itwill.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
/*
 * web.xml설정을 대신할 클래스
 * - Tomcat 실행시 기본설정
 */

/*
 * 웹 애플리케이션 초기화 과정에서 Dispatcher Servlet을 등록하는 역할을 합니다.
 */

public class WebAppInitConf implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException { //웹 애플리케이션이 초기화될 때 호출되는 메서드

		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(WebConfig.class);
		
		/*
		 * dispatcherServlet 등록하는 작업 -> xml등록하는걸 지금 작성중 ~_~
		 */
		 ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(context)); //addServlet() 메서드를 사용하여 Dispatcher Servlet을 등록
		 dynamic.setLoadOnStartup(0); //setLoadOnStartup() 메서드를 사용하여 Dispatcher Servlet이 웹 애플리케이션 초기화 과정에서 로드되도록 설정
		 dynamic.addMapping("/");
		 
	}

}
