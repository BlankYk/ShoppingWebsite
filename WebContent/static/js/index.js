//登录按钮
function login() {
	var loginHTML = $.ajax({url: "./login.jsp",async:false});
	$("#main").html(loginHTML.responseText);
}
//注册按钮
function registered(){
	var regHtml = $.ajax({url: "./registered.html",async: false});
	$("#main").html(regHtml.responseText);
}
