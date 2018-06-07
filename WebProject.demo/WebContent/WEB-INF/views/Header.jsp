<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
<center>
		<h2>CRUD HOME PAGE</h2>
		<nav>
			<c:if test="${user=='admin'}">
			<h3><a href="${pageContext.request.contextPath}/getuser">ADD USER</a>
			</c:if>
			</h3>
			<br>
			<c:if test="${user==null or user==''}">
			<h3><a href="${pageContext.request.contextPath}/login">LOGIN</a>
			</c:if>
			</h3>
		</nav>
		<br><br>
	</center>
</body>
</html>