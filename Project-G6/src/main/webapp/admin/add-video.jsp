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
<h1>Add user</h1>
<form action="<%=request.getContextPath() %>/AdminController/add_video" method="post"  enctype="multipart/form-data">
Select Course : 
	<select name="course">
	<option>Select Course</option>
	<c:forEach var="u" items="${courses}">
	
	<option value="${u.id }">${u.name }</option>
	
	</c:forEach>
	</select><br>
	Video_name: <input type="text" name="vname">
	<br>
	Duration: <input type="number" name="duration">
	<br>
	Video_Location: <input type="text" name="video_url" >
	<br>
	<input type="submit" value="Add video">
</form>
</body>
</html>