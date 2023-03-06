package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.exception.ExistedUserException;
import com.itwill.user.exception.PasswordMismatchException;
import com.itwill.user.exception.UserNotFoundException;

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

      
	@RequestMapping(value = "/")
	public String user_welcome() { //welcome file
		return "forward:/index.jsp";
	}

	@RequestMapping(value = "/user_main")
	public String user_main() {
		return "user_main";
	}
	@RequestMapping("/user_write_form")
	public String user_write_form() {
		String forward_path = "user_write_form";
		return forward_path;
	}
	@PostMapping("/user_write_action")
	public String user_write_action_post(@ModelAttribute("fuser") User user, Model model) throws Exception {
		String forward_path = "";
		try {
				int rowCount = userService.create(user);
				forward_path="redirect:user_login_form";
				
		}catch (ExistedUserException e) { //아이디 중복 -> 사용자 정의 exception (catch로 사용자정의 Exception(비즈니스 상 Error) 잡아야한다)
				forward_path="user_write_form";
				model.addAttribute("msg",e.getMessage()); //해당 exception파일안에 msg가 담겨있다.
				//model.addAttribute("fuser",user); - @ModelAttribute("fuser") 라고 기술해줌으로써, 작성할 필요가 없다. 
		}
		
		return forward_path;
	}
	@RequestMapping("/user_login_form")
	public String user_login_form() {
		String forward_path = "user_login_form";
		return forward_path;
	}
	@RequestMapping("/user_login_action")
	public String user_login_action_post(@ModelAttribute("fuser") User user, Model model,HttpSession session) throws Exception {
		String forwardPath = "";
		try {
			userService.login(user.getUserId(), user.getPassword());
			session.setAttribute("sUserId", user.getUserId());
			forwardPath="redirect:user_main"; //굳이 forward 로  할 이유가 없어서, redirect로 하거나, jsp로 넘겨주는 방법을 택한다.
		}catch (UserNotFoundException e) {
			e.printStackTrace();
			model.addAttribute("msg1",e.getMessage());
			forwardPath="user_login_form";
		}catch (PasswordMismatchException e) {
			e.printStackTrace();
			model.addAttribute("msg2",e.getMessage());
			forwardPath="user_login_form";
		}
		return forwardPath;
	}
	
	@LoginCheck
	@RequestMapping("/user_view")
	public String user_view(HttpServletRequest request) throws Exception {
		String forwardPath = "";
		/************** login check **************/
		/****************************************/
		String sUserId =(String)request.getSession().getAttribute("sUserId");
		User loginUser=userService.findUser(sUserId);
		request.setAttribute("loginUser", loginUser);
		forwardPath="user_view";
		
		return forwardPath;
	}
	@LoginCheck
	@RequestMapping("/user_modify_form")
	public String user_modify_form_post(HttpServletRequest request, Model model) throws Exception {
		/************** login check **************/
		/****************************************/
		
		String loginUser = (String)request.getSession().getAttribute("sUserId");
		model.addAttribute("loginUser",userService.findUser(loginUser));
		String forwardPath = "user_modify_form";

		return forwardPath;
	}
	@LoginCheck
	@RequestMapping("/user_modify_action")
	public String user_modify_action_post(HttpServletRequest request, User user) throws Exception {
		String forwardPath = "";
		/************** login check **************/
		/****************************************/
		
		userService.update(user); //session의 data를 쓰기 때문에, (jsp로) 넘기지 않는다.
		forwardPath = "redirect:user_view";
		return forwardPath;
	}
	@LoginCheck
	@RequestMapping("/user_remove_action")
	public String user_remove_action_post(HttpSession session, HttpServletRequest request, Model model) throws Exception {
		String forwardPath = "";
		/************** login check **************/
		/****************************************/
		String loginUser = (String)request.getSession().getAttribute("sUserId");
		userService.remove(loginUser);
		request.getSession().invalidate();
		forwardPath="redirect:user_main";
		return forwardPath;
	}
	@LoginCheck
	@RequestMapping("/user_logout_action")
	public String user_logout_action(HttpServletRequest request, HttpSession session) {
		String forwardPath = "";
		/************** login check **************/
		/****************************************/
		request.getSession(false).invalidate();
		return forwardPath;
	}
	/**************** GET방식들어오면 USER_MAIN REDIRECTION *********/
	@GetMapping(value = {"user_modify_form","user_modify_action","user_write_action","user_remove_action","user_login_actoin"})
	public String user_action_get() {
		String forwardPath = "redirect:user_main";
		return forwardPath;
	}
	
	/**************************Local Exception Handler *********************/
	@ExceptionHandler(Exception.class)
	public String user_exception_handler(Exception e) {
		return "user_error";
	}
	

	
	
	
}
