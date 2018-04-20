<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File Upload Demo</title>
</head>
<body>
  <form action="${pageContext.request.contextPath }/UploadServlet" enctype="multipart/form-data" method="post">
     	用户：<input type="text" name="username"><br/>
    	文件：<input type="file" name="file"><br/>
    	<input type="submit" value="上传试试">
  </form>
</body>
</html>