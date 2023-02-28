package com.itwill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloAnnotationMultiRequestMappingController {
	
	//controller는 한개 controll안에 여러개 매핑가능
	//handler mapping안에는 한개의 메소드에 한개가 mapping됨
	
	@RequestMapping("/hello3")
	public String hello3() {
		return "forward:/WEB-INF/views/hello3.jsp";
	}
	
	@RequestMapping("/hello4") //mapping이 중복되면 error임
	public String hello4() {
		return "forward:/WEB-INF/views/hello4.jsp";
	}
	
	@RequestMapping("/hello5")
	public String hello5() {
		return "forward:/WEB-INF/views/hello5.jsp";
	}
	
	/*
	 * redirect(브라우저에서 요청) -> redirect -> forward 하는 법
	 */
	
	@RequestMapping("/hello_redirect_servlet")
	public String hello_redirect_servlet() {
		return "redirect:/hello_redirected_servlet"; //redirect는 browser에서 요청하는것, //controller에 등록된 url
	}

	@RequestMapping("/hello_redirected_servlet")
	public String hello_redirected_servlet() {
		return "forward:/WEB-INF/views/hello_redirected_servlet.jsp"; 
	}
	
	/*
	 * forward -> forward 하는 방법(브라우저에서는 표시안됨)
	 */
	
	@RequestMapping("/hello_servlet_forward") 
	public String hello_servlet_forward() {
		return "forward:hello_servlet_forwarded"; //Controller의 URL //->dispatcherServlet이 받음
	}
	
	@RequestMapping("/hello_servlet_forwarded") //->여기로 매핑
	public String hello_servlet_forwarded() {
		return "forward:/WEB-INF/views/hello_servlet_forwarded.jsp"; //JSP
	} 
	
	//모든 매핑은 dispatcherServlet이 담당하지만, ".jsp"는 안찾음( tomcat 설정 관련)
	
	
	/*
	 * .jsp가 아닌 /hello_redirect_jsp 방법
	 */
	
	
	@RequestMapping("/hello_redirect_jsp")
	public String hello_redirect_jsp() {
		return "redirect:hello_redirected.jsp";
	}
	
	
	
}











