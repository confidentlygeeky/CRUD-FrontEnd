<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CRUD Application</title>
</head>
<body>
<center>

<!-- Add details -->
	
		
		<h2>Enter your details</h2>
		<c:if test="${person != null}">
	
         <form action="updateuser" method="post">
        </c:if>
        <c:if test="${person == null}">
		<form action="adduser" method="post">
		</c:if>
	
		User ID:<br>
		<input type="text" id="id" name="id" value="${person.id}" /> 
		
		<br>
		Name:<br>
		<input type="text" id="name" name="name" value="${person.name}"/>
		
		<br>
		Email:<br>
		<input type="text" id="email" name="email" value="${person.email}"/>
		
		<br>
		
		Password:<br>
		<input type="password" id="password" name="password" value="${person.password}"/>
		<br>
		<br>
		
	<c:if test="${person!=null and person!=''}">
					<input type="submit" value="Update user"/></td>
				</c:if>
				<c:if test="${person==null or person==''}">
	<input type="Submit" value="Create user">	
	</c:if>  
	
	</form>
	
	<center>
	<br>
	
	<!-- Show users-->
	<h2>List of users</h2>

	<table border=1px black">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${listOfPersons}" var="l">
		
			<tr>
				<td>${l.id}</td>
				<td>${l.name}</td>
				<td>${l.email}</td>
				<td>${l.password}</td>
				 <td><a href="edituser?id=${l.id}">Update</a></td>
				<td><a href="deleteuser?id=${l.id}">Delete</a></td>
			
			</tr>
			
		</c:forEach>
		

	</table>
	
	
	<br>
	 <form action="login" method="post">
	 <input type="Submit" value="Log out">	
	 </form>
</body>
</html>