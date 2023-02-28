package com.itwill.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestMappingGETPOSTController {
	
	//@RequestMapping(method = RequestMethod.GET)
	@GetMapping("/login")  //get으로 들어오면, form을 보여주고
	public String get_login_form() {
		return "forward:/WEB-INF/views/get_login_form.jsp";
	}
	@PostMapping("/login") //post로 들어오면 action
	public String post_login_action(@RequestParam String id,
									@RequestParam(name = "password") String pass,
									HttpSession session) {//form의 name 과 일치해야한다(param(name))
		System.out.println("### id       parameter:"+id);
		System.out.println("### password parameter:"+pass);
		boolean isLogin=true;
		if(isLogin) {
			session.setAttribute("sUserId", id);
		}
		return "forward:/WEB-INF/views/post_login_result.jsp";
	}
}
