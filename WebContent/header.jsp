<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header> 
	<a href="/ShoppingWebsite/index.jsp" class="header_logo"></a> 
	<ul>
		<li><a href="/ShoppingWebsite/index.jsp" id="home" class="">首页</a></li>
		<li><a href="/ShoppingWebsite/find.jsp" id="find" class="">查询</a></li>
	</ul>
	<div class="user">
		
		<%if (session.getAttribute("username") !=null){ %>
			<%=session.getAttribute("username") %> ，<a href="/ShoppingWebsite/LoginOut" class="btn btn-default" role="button">注销</a>
		<%}else{%>
			<button onclick="login()" class="btn btn-default">登录</button>
			<button onclick="registered()" class="btn btn-default">注册</button>
		<% }%>
	</div>
</header>