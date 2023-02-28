package com.itwill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.dto.Guest;


public class RequestParamModelAttributeController {
	
	public String parameter_guest_write_action() {
		
		/*
		<< 방명록쓰기 >>
		  << @RequestParam("guest_name") String name >>
		      String name = request.getParameter("guest_name");
		  << @RequestParam String guest_email >>     
			  String guest_email = request.getParameter("guest_email");
			  String guest_homepage = request.getParameter("guest_homepage");
			  String guest_title = request.getParameter("guest_title");
			  String guest_content = request.getParameter("guest_content");
		 */
		
	
		/*
		 * GuestService 메쏘드호출
		 */
		return "";
	}
	
	public String model_attribute_guest_write_action() {
		
		/*
		 << 방명록쓰기 >>
		   1. Guest guest=new Guest();
		 
		   2. String guest_name = request.getParameter("guest_name");
			  String guest_email = request.getParameter("guest_email");
			  String guest_homepage = request.getParameter("guest_homepage");
			  String guest_title = request.getParameter("guest_title");
			  String guest_content = request.getParameter("guest_content");
		   
		   3. guest.setGuest_name(guest_name);
		      guest.setGuest_email(guest_email);
		      guest.setGuest_homepage(guest_homepage);
		      guest.setGuest_title(guest_title);
		      guest.setGuest_content(guest_content);
		   
		   4. request.setAttribute("guest",guest);    
		 */
		/*
		   1. 인자로선언된DTO객체[Guest]생성(기본생성자)
		   2. 모든 파라메타 받기
		   3. 받은파라메타 데이타를 파라메타이름과 일치하는
		      Guest객체의 속성메쏘드(setter method)호출해서대입
		   4. Guest클래스이름 첫글자를 소문자로변경한이름(guest)으로
		      request객체에 속성(attribute)등록
		      request.setAttribute("guest",guest);
		 */
	
		return "";
	}
	
	
	
}
