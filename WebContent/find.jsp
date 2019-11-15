<!DOCTYPE html>
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./head.jsp" %>
<link rel="stylesheet" href="./static/css/index.css" />
</head>
<body>
	<%@ include file="./header.jsp" %>
	<div id="main">
	<noscript><h1>请确认浏览器可以使用JavaScript脚本</h1></noscript>
		<%if(session.getAttribute("username") != null){ %>
			<div id="findWapper">
				你的购物车中已有商品：
				<div id="cart"></div>
			</div>
		<%}else{ %>
			<%@ include file="./login.jsp" %>
		<%} %>
	</div>
	<script src="./static/js/index.js" ></script>
	<script>
		$(document).ready(function() {
			$("#find").addClass("active");
			$.ajax({
				url: "http://localhost:8080/ShoppingWebsite/Find",
				type: "get",
				success: function(response) {
					$("#cart").text(response);
				}
			})
		});
	</script>
</body>
</html>