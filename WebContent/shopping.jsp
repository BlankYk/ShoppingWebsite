<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="shopping">
		<ul>
			<li><input type="checkbox" name="cart" id="" value="book" />书籍</li>
			<li><input type="checkbox" name="cart" id="" value="fruit" />水果</li>
			<li><input type="checkbox" name="cart" id="" value="accessories" />饰品</li>
		</ul>
		<button class="btn btn-default" onclick="addCart()">添加</button>
		<a href="" class="btn btn-default">查询</a>
</div>
<script>
	function addCart(){
		var checkdom = $("input[name='cart']:checked");
		var checked = [];
		checkdom.each(function(index,ele){
			checked.push(ele.value);
		});
		console.log(checked);
		$.ajax({url:"http://localhost:8080/ShoppingWebsite/"})
	}
</script>