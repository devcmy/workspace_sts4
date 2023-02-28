package com.itwill.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class SpringModelController {

	public String request() {
		
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	
	public String model() {
		
		/*
		request.setAttribute("model", "모델데이타");
		 */
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	
	public String map() {
		
		/*
		request.setAttribute("map", "맵데이타");
		 */
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	
	public String modelmap() {
		
		/*
		request.setAttribute("modelmap", "모델맵데이타");
		 */
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	
	
	public ModelAndView modelandview() {
		
		/*
		request.setAttribute("modelandview", "모델앤뷰데이타");
		 */
		
		return null;
	}

	public String model_all() {
		
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	
}












