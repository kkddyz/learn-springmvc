<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>常用注解</title>
	</head>
	
	<body>
		<h3>测试RequestParam注解</h3>
		<a href="anno/testRequestParam?oldParamName=张三">测试RequestParam注解</a>
	</body>
	
	<h3>测试RequestBody注解</h3>
	<form action="anno/testRequestBody" method="post">
		username:<input type="text" name="username"><br>
		password:<input type="text" name="password"><br>
		<input type="submit" value="提交"><br>
	</form>
	<br>
	
	<h3>测试pathVariable注解</h3>
	<!-- restful风格: 获取id=1的对象(a标签的方法是GET)-->
	<a href="anno/testPathVariable/1">测试PathVariable注解</a> <br>
	
	
	<h3>测试ModelAttribute注解</h3>
	<form action="anno/testModelAttribute" method="post">
		username:<input type="text" name="username"><br>
		password:<input type="text" name="password"><br>
		<input type="submit" value="提交"><br>
	</form>
	
	<h3>测试SessionAttribute注解</h3>
	<a href="anno/addSessionAttributes">后台存储msg</a> <br>
	<a href="anno/getSessionAttributes">后台获取msg</a> <br>
	<a href="anno/delSessionAttributes">后台删除msg</a> <br>
</html>