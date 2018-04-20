<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CMD Demo</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/CmdServlet">
		<input type="text" name="cmd">
		<input type="submit" value="执行试试">
	</form>
</body>
</html>