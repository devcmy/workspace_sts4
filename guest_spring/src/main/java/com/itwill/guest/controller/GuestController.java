package com.itwill.guest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
      String forwardPath = "guest_main";
      return forwardPath;
   }
   
   @RequestMapping("/guest_list")
   public String guest_list(HttpServletRequest request) throws Exception {
      List<Guest> guestList = guestService.selectAll();
      request.setAttribute("guestList", guestList);
      String forwardPath = "guest_list";
      return forwardPath;
   }
   @RequestMapping("/guest_error")
   public String guest_error() {
      String forwardPath = "guest_error";
      return forwardPath;
   }

 

   @RequestMapping("/guest_modify_action")
   public String guest_modify_action(Guest guest) throws Exception {
      guestService.updateGuest(guest);
      String forwardPath = "redirect:guest_view?guest_no="+ guest.guest_no;
      return forwardPath;
   }
   
  
   
   @RequestMapping("/guest_modify_form")
   public String guest_modify_form(int guest_no, Model model) throws Exception {
      Guest modifyGuest = guestService.selectByNo(guest_no);
      model.addAttribute("guest", modifyGuest);
      String forwardPath = "guest_modify_form";
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
      String forwardPath = "guest_view";
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
      String forwardPath = "guest_write_form";
      return forwardPath;

   }

   //모아서 get방식으로 들어오면 main으로 redirect 하겟다
   @GetMapping(value = {"guest_modify_form","guest_modify_action","guest_wrtie_action","guest_remove_action"})
   public String guest_get() {
	   String forwardPaht="redirect:guest_main";
	   return forwardPaht;
   }
}