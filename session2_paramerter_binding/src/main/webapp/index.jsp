<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>参数绑定</title>
	</head>
	
	<body>
		<h3>测试基本类型和String</h3>
		<a href="param/testPrimitive?username=tom&age=18">测试基本类型和String</a>
		<hr/>
		
		<h3>测试User</h3>
		<form action="param/saveUser" method="post">
			username: <input name="username" type="text"> <br>
			password: <input name="password" type="password"> <br>
			<input type="submit" name="提交"><br>
		</form>
		
		
		<h3>测试Account(内部有一个user对象)</h3>
		<form action="param/saveAccount" method="post">
			<%-- 设置内部对象属性 --%>
			username: <input name="owner.username" type="text"> <br>
			password: <input name="owner.password" type="password"> <br>
			账号余额: <input name="money" type="text">
			<input type="submit" name="提交"><br>
		</form>
		
		<h3>测试带有账户的User</h3>
		<form action="param/saveUserWithAccounts" method="post">
			username: <input name="username" type="text"> <br>
			password: <input name="password" type="password"> <br>
			
			<%-- 将money属性封装到accounts集合的i个account中 --%>
			账号1余额: <input name="accounts[0].money" type="text"> <br>
			账号2余额: <input name="accounts[1].money" type="text"> <br>
			账号3余额: <input name="accounts[2].money" type="text"> <br>
			<input type="submit" name="提交"><br>
		</form>
		
		
		<h3>测试日期类</h3>
		<form action="param/testDate" method="get">
			输入今天的日期: <input type="text" name="today">
			<input type="submit" name="提交"><br>
		</form>
		
		<h3>获取req,resp</h3>
		<a href="param/testReqResp">获取req,resp</a>
	</body>
</html>