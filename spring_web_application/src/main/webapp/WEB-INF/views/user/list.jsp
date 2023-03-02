<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>user/list.jsp</h1><hr>
<ol>
	<li><a href="view">KIM</a></li>
	<li><a href="view">LEE</a></li>
	<li><a href="view">CIM</a></li>
</ol>
<hr>
<ol>
	<li><a href="/spring_web_application/user/view">KIM</a></li>
	<li><a href="/spring_web_application/user/view">LEE</a></li>
	<li><a href="/spring_web_application/user/view">CIM</a></li>
</ol>
<hr>
<ol>
	<li><a href="<c:url value='/user/view'/>">KIM</a></li> <!-- /user/view는 에러가 뜬다 localhost:80(브라우저가 붙혀줌)/user/view 로 기술되어버려서, 에러가 됨-->
	<li><a href="<c:url value='/user/view'/>">LEE</a></li> <!-- JSTL - URL을 사용해서 출력 -->
	<li><a href="<c:url value='/user/view'/>">CIM</a></li> <!-- USER/VIEW, PRODUCT/VIEW 등  -->
</ol>
</body>
</html>