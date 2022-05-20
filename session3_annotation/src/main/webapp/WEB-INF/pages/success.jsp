<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
	<head>
		<title>成功页面</title>
	</head>
	<body>
		<h3>跳转到成功页面</h3>
		
		<%-- 打印request域中的msg--%>
		获取request.msg :  ${requestScope.msg}<br>
		
		<%-- 打印session域中的msg--%>
		获取session.msg : ${sessionScope.msg}<br>
	</body>
</html>
