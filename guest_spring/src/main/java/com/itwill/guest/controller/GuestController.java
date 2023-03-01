package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
@Controller
public class GuestController {
	@Autowired
	private GuestService guestService;
	
	public GuestController() {
		
		System.out.println(">>>GuestController");
		
	}
	@RequestMapping("/guest_main")
	public String guest_main() {
		String forwardPath = "forward:/WEB-INF/views/guest_main.jsp";

		return forwardPath;
	}
	@RequestMapping("/guest_list")
	public String guest_list(@ModelAttribute Guest guest) {
		String forwardPath = "forward:/WEB-INF/views/guest_list.jsp";
		return forwardPath;
	}
	@RequestMapping("/guest_error")
	public String guest_error() {
		String forwardPath = "forward:/WEB-INF/views/guest_error.jsp";

		return forwardPath;
	}
	@GetMapping("/guest_modify_action")
	public String guest_modify_action_get() throws Exception {
		String forwardPath = "redirect:guest_main.jsp";
		return forwardPath;
	}
	@PostMapping("/guest_modify_action")
	public String guest_modify_action(Guest guest) throws Exception{
		guestService.updateGuest(guest);
		String forwardPath = "forward:/WEB-INF/views/guest_view.jsp";

		return forwardPath;
	}
	@GetMapping("/guest_modify_form")
	public String guest_modify_get() throws Exception {
		
		String forwardPath = "redirect:guest_main.jsp";

		return forwardPath;
	}
	@PostMapping("/guest_modify_form")
	public String guest_modify_form() {
		String forwardPath = "forward:/WEB-INF/views/guest_modify_form.jsp";
		return forwardPath;
	}
	@GetMapping("/guest_remove_action")
	public String guest_remove_action_get() throws Exception {
		String forwardPath = "redirect:guest_main.jsp";
		return forwardPath;
	}

	@PostMapping("/guest_remove_action")
	public String guest_remove_action(@RequestParam int guest_no,
			   						  @RequestParam(name = "guest_name") String guest_name,
			                          @RequestParam String guest_email,
			                          @RequestParam String guest_homepage,
			                          @RequestParam String guest_title,
			                          @RequestParam String guest_content) throws Exception {
		String forwardPath = "redirect:guest_list.jsp";
		guestService.deleteGuest(guest_no);
		
		return forwardPath;
	}
	@RequestMapping("/guest_view")
	public String guest_view() {
		String forwardPath = "forward:/WEB-INF/views/guest_view.jsp";

		return forwardPath;
	}
	
	@GetMapping("/guest_write_action")
	public String guest_write_action_get() {
		String forwardPath = "forward:/WEB-INF/views/guest_write_form.jsp";
		return forwardPath;
	}
	@PostMapping("/guest_write_action")
	public String guest_write_action(@ModelAttribute Guest guest) {
		String forwardPath = "forward:/WEB-INF/views/guest_view.jsp";

		return forwardPath;
	}

	@RequestMapping("/guest_write_form")
	public String guest_write(Guest guest) {
		String forwardPath = "forward:/WEB-INF/views/guest_write_form.jsp";
		return forwardPath;

	}

}
