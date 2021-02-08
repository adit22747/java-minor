<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add Course</h1>
<form action="<%=request.getContextPath() %>/AdminController/add_course" method="post"  enctype="multipart/form-data">
	Select Category: 
	<select name="category">
	<option>Select Category</option>
	<c:forEach var="u" items="${categories}">
	
	<option value="${u.id }">${u.name }</option>
	
	</c:forEach>
	</select><br>
	Course_name: <input type="text" name="cname">
	<br>
	Couse_descrption: <input type="text" name="cdesc">
	<br>
	Couse_image: <input type="file" name="cimage" size="500">
	<br>
	<input type="submit" value="Add course">
</form>
</body>
</html>