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
<form action="<%=request.getContextPath() %>/AdminController/add_video" method="post"  enctype="multipart/form-data">
	Video_name: <input type="text" name="vname">
	<br>
	Duration: <input type="number" name="duration">
	<br>
	Video_url: <input type="file" name="video" size="50">
	<br>
	<input type="submit" value="Add video">
</form>
</body>
</html>