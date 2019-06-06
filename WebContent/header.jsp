<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="./static/css/header.css" />
<header> 
	<a href="/ShoppingWebsite/index.jsp" class="header_logo"></a> 
	<div class="user">
		
		<%if (session.getAttribute("username") !=null){ %>
			<%=session.getAttribute("username") %> ，<a href="/ShoppingWebsite/LoginOut" class="btn btn-default" role="button">注销</a>
		<%}else{%>
			<button onclick="login()" class="btn btn-default">登录</button>
			<button onclick="registered()" class="btn btn-default">注册</button>
		<% }%>
		
	</div>
</header>