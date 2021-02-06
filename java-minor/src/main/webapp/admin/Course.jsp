<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>welcome <%= request.getRemoteUser()  %></h1>
<a href="<%=request.getContextPath()%>/admin/add-course.jsp">Add Course</a>
<a href="<%=request.getContextPath()%>/admin/add-video.jsp">Add video</a>
<br>
<table border="1">
	<tr>
		<td>Course id</td>
		<td>Course name</td>
		<td>Course Description</td>
		<td>Course image</td>
		<td>Category name</td>
		<td><a href="#">Update</a></td>
		<td><a href="#">Delete</a></td> 
	</tr>

	<c:forEach var="u" items="${courses}">
		<tr>
			<td><c:out value="${u.id }"></c:out></td>
			<td><c:out value="${u.name }"></c:out></td>
			<td><c:out value="${u.desc }"></c:out></td>
			<td><img height="100px" src="data:image/jpeg;base64,${u.encode}" /></td> 
			<td contenteditable="false"><c:out value="${u.category }"></c:out></td>
			<%-- <td><a href="<%=request.getContextPath() %>/UserController/edit?id=${u.id}">Update</a></td> --%>
			<td><a href="<%=request.getContextPath() %>/AdminController/delete_course?id=${u.id}">Delete</a></td>
		</tr>
	</c:forEach>

	<%-- <%
		List<User> users = (List) request.getAttribute("users");
		for (User u : users) {
			out.print("<tr>");
			out.print("<td>" + u.getId() + "</td>");
			out.print("<td>" + u.getName() + "</td>");
			out.print("<td>" + u.getAddress() + "</td>");
			/* String delurl = "<td><a href="+request.getContextPath()+"/UserController/delete?id="+u.getId()+">Delete</a></td>";
			String updateurl = "<td><a href="+request.getContextPath()+"/UserController/edit?id="+u.getId()+">update</a></td>";
			out.print(updateurl);
			out.print(delurl); */
			out.print("<tr>");
		}
	%> --%>

</table>
</body>
</html>