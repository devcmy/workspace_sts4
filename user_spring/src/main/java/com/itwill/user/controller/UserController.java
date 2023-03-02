package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String user_write_action_post(User user, Model model) throws Exception {
		String forward_path = "";
		int CreateR = userService.create(user);
		if (CreateR == -1) {
			String msg = user.getUserId()+ "는 이미 사용중인 아이디입니다.";
			model.addAttribute("msg",msg);
			model.addAttribute("fuser",user);
			forward_path = "user_write_form";
		}else {
			model.addAttribute("user",user);
			forward_path = "redirect:user_login_form";
		}
		return forward_path;
	}
	@RequestMapping("/user_login_form")
	public String user_login_form() {
		String forward_path = "user_login_form";
		return forward_path;
	}
	@RequestMapping("/user_login_action")
	public String user_login_action_post(User user, HttpSession session,Model model) throws Exception {
		String userId = user.getUserId();
		String pass = user.getPassword();
		int loginResult = userService.login(userId,pass);
		String forwardPath = "";
		
		if(loginResult == 0) {
			String msg1=userId+" 는 존재하지 않는 아이디입니다.";
			model.addAttribute("msg1",msg1);
			model.addAttribute("fuser",user);
			forwardPath = "user_login_form";
		}else if (loginResult == 1) {
			String msg2="비밀번호가 일치하지 않습니다.";
			model.addAttribute("msg2",msg2);
			model.addAttribute("fuser",user);
			forwardPath = "user_login_form";
		}else if (loginResult == 2) {
			session.setAttribute("sUserId", userId);
			forwardPath = "user_main";
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

	@RequestMapping("/user_modify_form")
	public String user_modify_form_post(HttpSession session, HttpServletRequest request,Model model) throws Exception {
		/************** login check **************/
		session = request.getSession();
		String loginUser = (String)session.getAttribute("sUserId");
		
		model.addAttribute("loginUser",userService.findUser(loginUser));
		String forwardPath = "user_modify_form";

		return forwardPath;
	}
	@RequestMapping("/user_modify_action")
	public String user_modify_action_post(HttpSession session, HttpServletRequest request, Model model, User user) throws Exception {
		/************** login check **************/
		session = request.getSession();
		String loginUser = (String)session.getAttribute("sUserId");
		model.addAttribute("loginUser", userService.update(user));
		String forwardPath = "redirect:user_view";
		return forwardPath;
	}
	@RequestMapping("/user_remove_action")
	public String user_remove_action_post(HttpSession session, HttpServletRequest request, Model model) throws Exception {
		/************** login check **************/
		session = request.getSession();
		String loginUser = (String)session.getAttribute("sUserId");
		model.addAttribute("loginUser",userService.remove(loginUser));
		session.invalidate();
		String forwardPath = "redirect:user_main";
		return forwardPath;
	}
	@RequestMapping("/user_logout_action")
	public String user_logout_action(HttpSession session, HttpServletRequest request) {
		/************** login check **************/
		session = request.getSession();
		session.getAttribute("sUserId");
		session.invalidate();
		String forwardPath = "redirect:user_main";
		return forwardPath;
	}
	@GetMapping(value = {"user_modify_form","user_modify_action","user_write_action","user_remove_action"})
	public String user_action_get() {
		String forwardPath = "redirect:user_main";
		return forwardPath;
	}


}
