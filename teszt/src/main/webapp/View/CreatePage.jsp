<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Advertisement</title>
</head>
<body>
	<jsp:useBean id="addAdv" class="teszt.data.Advertisement" scope="request"></jsp:useBean>
	<jsp:setPriority name="addAdv" property="*"></jsp:setPriority>
	<jsp:forward page="addAdvertisement"></jsp:forward>
</body>
</html>