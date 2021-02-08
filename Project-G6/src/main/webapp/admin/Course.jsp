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
<script>
var flag=0;
function fin(a) {
	if(flag==0){
		 document.getElementsByClassName(a)[0].disabled=false;
		document.getElementsByClassName(a)[1].disabled=false;
		
		 
		 //alert("content editable");
		flag=1;
		return false;	
		

	}
	else{
		flag=0;
		return true;
	}
		
		
		

	
	
	
}
</script>
</head>
<body>
	<h1>
		welcome
		<%=request.getRemoteUser()%></h1>
	<a href="<%=request.getContextPath()%>/AdminController/Course_getway">Add
		Course</a>
	
	<br>
	<table border="1">
		<tr>
				<td ></td>
			<td>Course name</td>
			<td>Course Description</td>
			<td>Course image</td>
			<td>Choose new file</td>
			<td>Category name</td>
			<td>Update</td>
			<td>Delete</td>
			<!-- <td><a href="#">Update</a></td>
			<td><a href="#">Delete</a></td> -->
		</tr>

		<c:forEach var="u" items="${courses}">
			<tr>
				<form enctype="multipart/form-data" method="post" onsubmit="return fin('${u.id}')" action=<%= request.getContextPath()%>/AdminController/update_course >
					<td><input type="text" value="${u.id}"  hidden name="course_id"></td>
				<td><input type"text" value="${u.name }" disabled class="${u.id }" name="course_name"></td>
				<td><input type"text" value="${u.desc }" disabled class="${u.id }" name="course_desc"></td>
				<td>
					<input type="image" src="data:image/jpeg;base64,${u.encode}" height="100px">
					</td>
					<td>
					<input type="file" name="image" class="${u.id }">
					</td>
				<td><input type"text" value="${u.category }" disabled></td>
				<td><input type="submit" value="update"></td>
				<td><a href="<%=request.getContextPath() %>/AdminController/delete_course?id=${u.id}" onclick="window.confirm('Are you sure')">Delete</a></td>
				<%-- <td><a href="<%=request.getContextPath() %>/UserController/edit?id=${u.id}">Update</a></td> --%>
				<%-- <td><a
					href="<%=request.getContextPath() %>/AdminController/delete_course?id=${u.id}">Delete</a></td> --%>
				</form>
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