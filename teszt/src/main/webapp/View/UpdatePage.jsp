<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
<jsp:useBean id="updateAdv" class="teszt.data.Advertisement" scope="request"></jsp:useBean>
<jsp:setPriority name="updateAdv" property="*"></jsp:setPriority>
<jsp:forward page="updateAdvertisement"></jsp:forward>
</body>
</html>