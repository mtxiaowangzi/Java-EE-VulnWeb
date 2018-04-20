<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
body {
	text-align: center;
	margin: 0px;
	padding: 0px;
}
</style>
<title>show1</title>
</head>
<body>
	<table border="1" cellspacing="1" width="20%">
		<c:forEach var="entry" items="${hMap}">
			<tr>
<%-- 				<td><c:out value="${entry.key}" /></td>
				<td><c:out value="${entry.value}"/></td> --%>
				
				<td>${entry.key}</td>
				<td>${entry.value}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>