package com.itwill.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringModelController {
	@RequestMapping("/model_request")
	public String request(HttpServletRequest request) {
		request.setAttribute("req", "리퀘스트데이타");
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	@RequestMapping("/model_model")
	public String model(Model model) {
		
		/*
		request.setAttribute("model", "모델데이타"); request대신 윗방식을 쓰는게 어떠한가?
		 */
		model.addAttribute("model", "모델데이타");
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	@RequestMapping("/model_map")
	public String map(Map map) {
		System.out.println(map.getClass().getSimpleName());
		map.put("map", "맵 데이타"); //request객체보다 테스트 하기 편하다.
		/*
		request.setAttribute("map", "맵데이타"); request대신 윗방식을 쓰는게 어떠한가?
		 */
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	@RequestMapping("/model_modelmap")
	public String modelmap(ModelMap modelMap) {
		modelMap.put("modelmap", "모델맵데이타");
		
		/*
		request.setAttribute("modelmap", "모델맵데이타"); request대신 윗방식을 쓰는게 어떠한가? new해서 생성x, put으로 넣어줘라.
		 */
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	
	@RequestMapping("/model_modelandview")
	public ModelAndView modelandview() { //view도 model data도 리턴
		
		/*
		request.setAttribute("modelandview", "모델앤뷰데이타"); //유일하게 내가만들어서 넣을수 있는 객체
		 */
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("modelandview","모델앤뷰데이타");
		modelAndView.setViewName("forward:/WEB-INF/views/spring_model.jsp"); //뷰 설정
		return modelAndView;
	}
	@RequestMapping("/model_all")
	public String model_all(HttpServletRequest request,
							Model model,
							Map map,
							ModelMap modelMap) {
		request.setAttribute("req", "리퀘스트데이타");
		model.addAttribute("model","모델데이타");
		map.put("map", "맵데이타아~");
		modelMap.addAttribute("modelmap", "모델맵데이타");
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	
}












