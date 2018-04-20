<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>XSS Demo</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/XSSServlet"method="post">
		账户：<input type="text" name="username"><br /> 
		密码：<input type="password" name="password"><br /> 
		文本：<textarea name="resume"></textarea><br /> 
		<input type="submit" value="提交试试">
	</form>
</body>
</html>