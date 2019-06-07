<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Welcome</title>
<link rel="icon" href="./favicon.ico" />
<link rel="stylesheet" href="./static/bootstrap/css/bootstrap.min.css" />
<script src="./static/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./static/css/index.css" />
<link rel="stylesheet" href="./static/css/header.css" />
<script src="./static/js/jquery.js"></script>
</head>
<body>
	
	<%@ include file="./header.jsp" %>
	<div id="main">
	<noscript><h1>请确认浏览器可以使用JavaScript脚本</h1></noscript>
		<%if(session.getAttribute("username") != null){ %>
			<%@ include file="./shopping.jsp" %>
		<%}else{ %>
			<%@ include file="./login.jsp" %>
		<%} %>
	</div>
	<script src="./static/js/index.js" ></script>
</body>
</html>