<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import ="teszt.data.Advertisement" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Update Advertisement</title>
</head>
<body>
	<div style="text-align:center"><h1>Update Advertisement</h1></div>
	<div class="container">
		<% Advertisement adv = (Advertisement)request.getAttribute("adv"); %>
		<form method="POST" action="updatePage.jsp">
			<table>
				<tr>
					<td>Title:</td>
					<td><%=adv.getTitle()%> <input type="text" value="<%=adv.getTitle()%>" name="title"></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><%=adv.getDesc()%> <input type="text" value="<%=adv.getDesc()%>" name="desc"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Update"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>