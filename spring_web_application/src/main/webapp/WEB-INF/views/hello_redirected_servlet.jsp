<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello_redirected_servlet.jsp</h1><hr>
<ol>
	<li>부라우져 --> hello_redirect_servlet요청</li>
	<li>redirect:hello_redirected_servlet redirect 부라우져로 응답</li>
	<li>부라우져 -->hello_redirected_servlet 요청</li>
	<li>controller에 등록된 hello_redirected_servlet 메소드의 forward:/WEB-INF/views/hello_redirected_servlet.jsp 로 forward 함</li>
	<li>forward:/WEB-INF/views/hello_redirected_servlet.jsp 출력</li>
</ol>
</body>
</html>