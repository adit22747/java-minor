<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<%@include file="header.jsp" %>
<style>
* {box-sizing: border-box;}

body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav .search-container {
  float: right;
}

.topnav input[type=text] {
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;
  border: 1px solid #ccc;
}

.topnav .search-container button {
  float: right;
  padding: 6px 10px;
  margin-top: 8px;
  margin-right: 16px;
  background: #ddd;
  font-size: 17px;
  border: none;
  cursor: pointer;
}

.topnav .search-container button:hover {
  background: #ccc;
}
@media screen and (max-width: 600px) {
  .topnav .search-container {
    float: none;
  }
  .topnav a, .topnav input[type=text], .topnav .search-container button {
    float: none;
    display: block;
    text-align: left;
    width: 100%;
    margin: 0;
    padding: 14px;
  }
  
}
</style>


<div class="mySpace">

<div class="topnav">
  <div class="search-container">
    <form action="<%=request.getContextPath()%>/UserController/search">
      <input type="text" placeholder="Search.." name="search">
      <button type="submit"><i class="fa fa-search"></i></button>
    </form>
  </div>
</div>
 <c:if test = "${searchresult == 0}">
 	<a href="<%=request.getContextPath()%>/UserController/main">Go Back</a>
 </c:if>
 <c:if test = "${searchedcategories == null}">
	<c:forEach var="u" items="${allCategories}">
			<!-- card -->
		    <div class="card" style="width:400px">
		      <img class="card-img-top" src="data:image/jpeg;base64,${u.encode}" alt="Card image" style="width:100%">
		      <div class="card-body">
		        <h4 class="card-title"><c:out value="${u.name}"></c:out></h4>
		        <form action="<%=request.getContextPath()%>/UserController/show-courses" method="post">
					<input type="hidden" value="${u.id}" name="category_id">
					<input type="hidden" value="${u.name}" name="category_name">
					<input type="submit" value="Explore more" class="btn btn-primary">
				</form>
		      </div>
		    </div>
	</c:forEach>
 </c:if>
 <c:if test = "${searchedcategories != null}">
 	<c:forEach var="s" items="${searchedcategories}">
			<!-- card -->
		    <div class="card" style="width:400px">
		      <img class="card-img-top" src="${s.category_url}" alt="Card image" style="width:100%">
		      <div class="card-body">
		        <h4 class="card-title"><c:out value="${s.name}"></c:out></h4>
		        <form action="<%=request.getContextPath()%>/UserController/show-courses" method="post">
					<input type="hidden" value="${s.id}" name="category_id">
					<input type="hidden" value="${s.name}" name="category_name">
					<input type="submit" value="Explore more" class="btn btn-primary">
				</form>
		      </div>
		    </div>
	</c:forEach>
 </c:if>
 
 </div>

 <div class="mySpace"></div>
 <%@include file="footer.jsp" %>