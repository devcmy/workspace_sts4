package com.itwill.view;

import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractView;
@Component("xmlView")
public class XMLView extends AbstractView {
	
	public XMLView() {
		System.out.println("XMLView()생성자(등록된거 확인)");
	}
	

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception { //responser로 데이터를 꺼내 직접 출력하는 연습
		// TODO Auto-generated method stub
		/********************** forward************************** 
		 * RequestDispatcher rd = request.getRequestDispatcher("xxx.jsp"); rd.forward(request, response);
		 ********************************************************/
		/********************** redirect************************** 
		 * response.sendRedirect("xxx");
		 ********************************************************/
		ArrayList<String> friendList = (ArrayList<String>)model.get("friendList");
		response.setContentType("text/xml;charset-UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<?xml version='1.0' encoding='UTF-8'?>");
		out.println("<friends>");
		for(String friend : friendList) {
			out.println("<friend>");
			out.println(friend);
			out.println("</friend>");
		}
		out.println("</friends>");
		
		
	}

}
