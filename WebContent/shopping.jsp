<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="shopping">
	<ul>
		<li><input type="checkbox" name="cart" id="" value="书籍" />书籍</li>
		<li><input type="checkbox" name="cart" id="" value="水果" />水果</li>
		<li><input type="checkbox" name="cart" id="" value="饰品" />饰品</li>
	</ul>
	<button class="btn btn-default" onclick="addCart()">添加</button>
	<a href="" class="btn btn-default">查询</a>
</div>
<script>
	function addCart() {
		var checkdom = $("input[name='cart']:checked");
		var checked = [];
		checkdom.each(function(index, ele) {
			checked.push(ele.value);
		});
		
		var json = {};
		json.cart = checked;
		var jsonstr = JSON.stringify(json);
		console.log(jsonstr);
		$.ajax({
			type: "post",
			contentType: "aplication/json;charset=utf-8", 
			url : "http://localhost:8080/ShoppingWebsite/Cart",
			data: jsonstr,
			dataType : "json",
			success: function (rep) {
				console.log(rep);
				alert(rep.msg);
			}
		});
	}
</script>