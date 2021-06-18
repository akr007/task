<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import ="teszt.data.Advertisement" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Advertisement</title>
</head>
<body>
	<div style="text-align:center"><h1>Create Advertisement</h1></div>
	<div class="container">
		<% Advertisement adv = (Advertisement)request.getAttribute("adv"); %>
		<form method="POST" action="createPage.jsp">
			<table>
				<tr>
					<td>Title:</td>
					<td><input type="text" value="title" name="title"></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><input type="text" value="desc" name="desc"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Create"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>