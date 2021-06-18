<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import ="teszt.data.Advertisement" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Advertisement Page</title>
</head>
<body>
	<div style="text-align:center"><h1>Home</h1></div>
	<table>
		<tr>
			<td>Title</td>
			<td>Description</td>
			<td><a href="addAdv">Create</a></td>
			<td>Update/Delete</td>
		</tr>
		<%
			List<Advertisement> advs = (List<Advertisement>) request.getAttribute("list");
			Advertisement advId = (Advertisement)request.getAttribute("id");
			for(Advertisement adv : advs) {
		%>
		<tr>
			<td><%=adv.getTitle() %></td>
			<td><%=adv.getDesc() %></td>
		</tr>
		<td>
			<a href="updateAdv?advId=<%=adv.getId()%>">Update</a>
			<a href="deleteAdv?advId=<%=adv.getId()%>">Delete</a>
		</td>
		<% } %>
	</table>
</body>
</html>