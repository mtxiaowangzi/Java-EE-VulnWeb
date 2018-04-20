<%@page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body style="text-align: center;">
<h1>注册</h1>
	<hr>
	<form action="${pageContext.request.contextPath }/RegisterServlet"
		method="post">
		账户：<input type="text" name="username"><br /> 密码：<input
			type="password" name="password"><br /> <input type="submit"
			value="注册">
	</form>
</body>
</html>