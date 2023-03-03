package com.itwill.guest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
@Controller
public class GuestController {
   @Autowired
   private GuestService guestService; //서비스 객체 INJECTION
   
   public GuestController() {
      System.out.println(">>>GuestController");
   }
   
   
   @RequestMapping("/guest_main")
   public String guest_main() {
      String forwardPath = "guest_main";
      return forwardPath;
   }
   
   @RequestMapping("/guest_list")
   public String guest_list(Model model) throws Exception {
	  String forwardPath = "guest_list";
      List<Guest> guestList = guestService.selectAll();
      model.addAttribute("guestList",guestList);
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
   /*
    * Parameter에 guest_no가 존재하지 않으면
    */
  @PostMapping(value="/guest_modify_form", params="!guest_no")
  public String guest_modify_form() {
	  return "redirect:guest_main";
  }
   
   
  /*
   * Parameter에 guest_no가 존재하면
   */
   @RequestMapping("/guest_modify_form")
   public String guest_modify_form(@RequestParam int guest_no, Model model) throws Exception {
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
   
   /*
    * Parameter에 guest_no가 존재하지 않으면
    */
   @RequestMapping(value = "/guest_view", params = "!guest_no")
   public String guest_view() {
      return "redirect:guest_main";
   }
   
   
   /*
    * Parameter에 guest_no가 존재하면
    */
   @RequestMapping(value = "/guest_view", params = "guest_no")
   public String guest_view(@RequestParam int guest_no, Model model) throws Exception {
      Guest guest = guestService.selectByNo(guest_no);
      model.addAttribute("guest", guest);
      String forwardPath = "guest_view";    
      return forwardPath;
   }
   
   
   
   @RequestMapping("/guest_write_action") //redirect에 넣어주면, 알아서 붙혀줌. (redirect:guest_view?guest_no=1 대신 사용)
   public String guest_write_action(Guest guest, RedirectAttributes redirectAttributes) throws Exception {
      int guest_no = guestService.insertGuest(guest);
      redirectAttributes.addAttribute("guest_no",guest_no);
      return "redirect:guest_view";
   }
   
   

   //다른컨트롤러 메소드 실행하려면 forward: 붙이면됨 -> prefix, surfix안 타고 다른 컨트롤러의 메소드로 간다.
   //하지만, 이 방식은 비효율적임(계속 들고다니기떄문에)
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
   
   @ExceptionHandler(Exception.class)
   public String guest_exception_handler(Exception e) {
	   return "guest_error";
   }
   
   
   
   
}