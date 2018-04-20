<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VulnWeb</title>
</head>
<body>

	<div style="text-align: center;">
		<h1>VulnWeb</h1>
		<hr>
		<a href="${pageContext.request.contextPath }/RegisterServletUI">注册</a>
		<a href="${pageContext.request.contextPath }/LoginServletUI">登录</a><br/>
		<a href="${pageContext.request.contextPath }/xss.jsp">XSS演示</a><br/>
		<a href="${pageContext.request.contextPath }/cmd.jsp">命令执行演示</a><br/>
		<a href="${pageContext.request.contextPath }/uploadfile.jsp">任意文件上传演示</a><br/>
		<a href="${pageContext.request.contextPath }/downloadfile.jsp">文件包含演示</a><br/>
	</div>
</body>
</html>