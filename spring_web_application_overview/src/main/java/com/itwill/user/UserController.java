package com.itwill.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@GetMapping(value = "/user_list")   //snakeCase보단,  dash로 쓰는걸 권장         //get방식이면~  //handler mapping이 method 에 함
	public String list(HttpServletRequest request) { //타입이 선언되어있으면 injection 해줌
		System.out.println("/list --> UserController.list()");
		List<User> userList = userService.list();
		request.setAttribute("userList", userList);
		return "forward:/WEB-INF/views/user_list.jsp"; //forward Path가 return
	}
}
