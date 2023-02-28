package com.itwill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestMappingGETPOSTController {
	
	//@RequestMapping(method = RequestMethod.GET)
	@GetMapping("/login")  //get으로 들어오면, form을 보여주고
	public String get_login_form() {
		return "forward:/WEB-INF/views/get_login_form.jsp";
	}
	@PostMapping("/login") //post로 들어오면 action
	public String post_login_action() {

		return "forward:/WEB-INF/views/get_login_form.jsp";
	}
}
