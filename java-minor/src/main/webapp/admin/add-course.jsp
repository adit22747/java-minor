<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add user</h1>
<form action="<%=request.getContextPath() %>/AdminController/add_course" method="post"  enctype="multipart/form-data">
	Course_name: <input type="text" name="cname">
	<br>
	Couse_descrption: <input type="text" name="cdesc">
	<br>
	Couse_image: <input type="file" name="cimage" size="50">
	<br>
	<input type="submit" value="Add course">
</form>
</body>
</html>