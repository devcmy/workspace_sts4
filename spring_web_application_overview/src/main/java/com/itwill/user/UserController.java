package com.itwill.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	@GetMapping(value = "/user_list")   //snakeCase보단,  dash로 쓰는걸 권장         //get방식이면~  //handler mapping이 method 에 함
	public String list() {
		System.out.println("/list --> UserController.list()");
		return "forward:/WEB-INF/views/user_list.jsp"; //forward Path가 return
	}
}
