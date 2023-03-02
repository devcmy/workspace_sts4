package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwill.user.User;
import com.itwill.user.UserService;
/*
 * /user_main 
 * /user_write_form 
 * /user_write_action 
 * /user_login_form
 * /user_login_action 
 * /user_logout_action 
 * /user_view /user_modify_form
 * /user_modify_action 
 * /user_remove_action
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;


	@RequestMapping(value = "/user_main")
	public String user_main() {
		return "user_main";
	}
	@RequestMapping("/user_write_form")
	public String user_write_form() {
		String forward_path = "user_write_form";
		return forward_path;
	}
	@RequestMapping("/user_write_action")
	public String user_write_action_post(User user) throws Exception {
		userService.create(user);
		String forward_path = "user_main";
		return forward_path;
	}
	@RequestMapping("/user_login_form")
	public String user_login_form() {
		String forward_path = "user_login_form";
		return forward_path;
	}
	@RequestMapping("/user_login_action")
	public String user_login_action_post(User user, HttpSession session) throws Exception {
		int loginResult = userService.login(user.getUserId(), user.getPassword());
		String forwardPath = "user_main";
		
		if (loginResult == 2) {
			session.setAttribute("sUserId", user.getUserId());
		}
		return forwardPath;
	}
	@RequestMapping("/user_view")
	public String user_view(User user, HttpSession session, HttpServletRequest request, Model model) throws Exception {
		/************** login check **************/
		session = request.getSession();
		String loginUser = (String)session.getAttribute("sUserId");
		
		
		model.addAttribute("loginUser",userService.findUser(loginUser));
		
		String forwardPath = "user_view";
		return forwardPath;
	}


	public String user_modify_form_post(HttpSession session, HttpServletRequest request) throws Exception {
		/************** login check **************/
		session = request.getSession();
		String loginUser = (String)session.getAttribute("sUserId");

		String forwardPath = "";

		return forwardPath;
	}

	public String user_modify_action_post(HttpSession session) throws Exception {
		/************** login check **************/
		
		String forwardPath = "";
		return forwardPath;
	}

	public String user_remove_action_post(HttpSession session) throws Exception {
		/************** login check **************/
		
		String forwardPath = "";
		return forwardPath;
	}

	public String user_logout_action(HttpSession session) {
		/************** login check **************/
		
		String forwardPath = "";
		return forwardPath;
	}

	public String user_action_get() {
		String forwardPath = "";
		return forwardPath;
	}


}
