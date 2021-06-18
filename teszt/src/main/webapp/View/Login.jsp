<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Login</title>
<script> 
	//A validaciot segíto metodus.
	function validator() { 
	     var mail = document.form.email.value; 
	     var psw = document.form.password.value;
	 
	     if (mail==null || mail=="") { 
	     	alert("Please add an email."); 
	     	return false; 
	     } else if(psw==null || psw=="") { 
		    alert("Please add a password."); 
		    return false; 
	     } 
	}
</script> 
</head>
<body>
    <div style="text-align:center"><h1>Login</h1></div>
    <br>
    <form name="form" method="POST" action="LoginServlet"  onsubmit="return validator()">
        <table align="center">
         <tr>
	         <td>Email</td>
	         <td><input type="text" name="email" /></td>
         </tr>
         <tr>
	         <td>Password</td>
	         <td><input type="password" name="password" /></td>
         </tr>
         <tr>
         	<td><input type="submit" value="Login"></td>
         </tr>
        </table>
    </form>
</body>
</html>