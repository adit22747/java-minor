<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<script src="JS/Video.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
var flag=0;
function fin(a) {
	if(flag==0){
		document.getElementsByClassName(a)[0].disabled=false;
				
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
<h1>welcome <%= request.getRemoteUser()  %></h1>
<a href="<%=request.getContextPath()%>/Admin/add-Category.jsp">Add Category</a>
<br>
<table border="1">
	<tr>
		<td>Category Name</td>
		<td>Category Image</td>
		<td>Select Image to be updated</td>
	
	
		<td>Update</td>
		<td>Delete</td>
		
		<!-- <td><a href="#">Update</a></td>
		<td><a href="#">Delete</a></td> -->
	</tr>

	<c:forEach var="u" items="${categories}">
		<tr>
			<td><form enctype="multipart/form-data" method="post" onsubmit="return fin('${u.name}')" action=<%= request.getContextPath()%>/AdminController/update_category >
			<input type="text" value="${u.name }" disabled class="${u.name }" name="name"></td>
		<td>
		<input type="text" name="id" value="${u.id }" hidden>
					<input type="image" src="data:image/jpeg;base64,${u.encode}" height="100px" alt="not available right now">
					</td>
					<td>
					<input type="file" name="image" class="${u.id }">
					</td>	
			
		<%-- 	<td><input type="text" value="${u.duration}" disabled class="${u.name }" name="duration"></td>
			<td><input type="text" value="${u.course }" disabled ></td> --%>
			<td><input type="submit"></td>
		<%-- 	<input type="text" value="${u.id}" disabled class="${u.name }" name="id" hidden> --%>
			</form>
			
			<%-- <td><a href="<%=request.getContextPath() %>/UserController/edit?id=${u.id}">Update</a></td> --%>
			<td><a href="<%=request.getContextPath() %>/AdminController/delete_category?id=${u.id}" onclick="window.confirm('Are you sure')">Delete</a></td>
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