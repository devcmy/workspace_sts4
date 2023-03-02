package com.itwill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/user") //중복되는 부분을 맵핑
public class RequestMappingUserController {
	@RequestMapping("/list")
	public String user_list() {
		return "forward:/WEB-INF/views/user/list.jsp"; //하위의 directory(user_list -> user/list)
	}
	@RequestMapping("/view")
	public String user_view() {
		return "forward:/WEB-INF/views/user/view.jsp"; //하위의 directory(user_list -> user/view)
	}
}
