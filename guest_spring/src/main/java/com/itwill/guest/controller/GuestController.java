package com.itwill.guest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
   public String guest_list(HttpServletRequest request) throws Exception {
      List<Guest> guestList = guestService.selectAll();
      request.setAttribute("guestList", guestList);
      String forwardPath = "forward:/WEB-INF/views/guest_list.jsp";
      return forwardPath;
   }
   @RequestMapping("/guest_error")
   public String guest_error() {
      String forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
      return forwardPath;
   }

   @GetMapping("/guest_modify_action")
   public String guest_modify_action_get() {
      String forwardPath = "redirect:guest_error";
      return forwardPath;
   }

   @RequestMapping("/guest_modify_action")
   public String guest_modify_action(Guest guest) throws Exception {
      guestService.updateGuest(guest);
      String forwardPath = "redirect:guest_view?guest_no="+ guest.guest_no;
      return forwardPath;
   }
   
   @GetMapping("/guest_modify")
   public String guest_modify_get() {
      String forwardPath = "redirect:guest_error";
      return forwardPath;
   }
   
   @RequestMapping("/guest_modify_form")
   public String guest_modify_form(int guest_no, Model model) throws Exception {
      Guest modifyGuest = guestService.selectByNo(guest_no);
      model.addAttribute("guest", modifyGuest);
      String forwardPath = "forward:/WEB-INF/views/guest_modify_form.jsp";
      return forwardPath;
   }
   
   @GetMapping("/guest_remove_action")
   public String guest_remove_action_get() {
      String forwardPath = "redirect:guest_error";
      return forwardPath;
   }

   @RequestMapping("/guest_remove_action")
   public String guest_remove_action(int guest_no) throws Exception {
      guestService.deleteGuest(guest_no);
      String forwardPath = "redirect:guest_list";
      return forwardPath;
   }
   
   @RequestMapping("/guest_view")
   public String guest_view(int guest_no, Model model) throws Exception {
      Guest guest = guestService.selectByNo(guest_no);
      model.addAttribute("guest", guest);
      String forwardPath = "forward:/WEB-INF/views/guest_view.jsp";
      return forwardPath;
   }
   
   @GetMapping("/guest_write_action")
   public String guest_write_action_get() {
      String forwardPath = "redirect:guest_error";
      return forwardPath;
   }
   
   @RequestMapping("/guest_write_action")
   public String guest_write_action(Guest guest) throws Exception {
      guestService.insertGuest(guest);
      String forwardPath = "redirect:guest_view?guest_no="+ guest.guest_no;
      return forwardPath;
   }

   @RequestMapping("/guest_write_form")
   public String guest_write_form() {
      String forwardPath = "forward:/WEB-INF/views/guest_write_form.jsp";
      return forwardPath;

   }

}