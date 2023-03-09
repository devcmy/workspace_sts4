<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%
	//서버
	String id=request.getParameter("id");
	System.out.println(request.getMethod()+" 요청.."+id); //요청이 들어왔는지 확인하는 코드
	if(id==null)id="";
	String msg="";
	if(id.startsWith("guard")){
		msg="사용가능";
	}else{
		msg="사용불가능";
	}
	//Thread.sleep(1000);
%>
<%=msg%>