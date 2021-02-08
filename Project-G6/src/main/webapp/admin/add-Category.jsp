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
<h1>Add Category</h1>
<form action="<%=request.getContextPath() %>/AdminController/add_category" method="post"  enctype="multipart/form-data">
	
	Category_name: <input type="text" name="cname">
	<br>
	
	Category_image: <input type="file" name="cimage" size="500">
	<br>
	<input type="submit" value="Add Category">
</form>
</body>
</html>