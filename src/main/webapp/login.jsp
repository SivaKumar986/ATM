<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
body {font-family: Arial, Helvetica, sans-serif,bold;
       text-align : center;
       font-weight:bold}
form {border: 3px solid #f1f1f1;
    }
table{
margin-left: auto; 
  margin-right: auto;}

input[type=text] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}
input[type=submit] {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}
input[type=submit]:hover {
  opacity: 0.8;
}

</style>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
</head>
<body>
<div class="loginform">
<h1 id="head">LOGIN FORM</h1>
<form action="Login" method="post">

<table>
<tr><td><label>User Name</label><br><input type="text" name="uname"></td></tr>
<tr><td><label>User Password</label><br><input type="text" name="upass"></td></tr>
<tr><td id="but">
<input type="checkbox" required>Do you accepted terms and condition<br>
<tr><td><input type="submit" id="but"name="login" value="Login"></td></tr>

<tr><td id="but"><p>--------------------or--------------------</p><br>
<input type="submit" name="signin" value="sign">
</td></tr>

</table>
</form>
<form action="admin" method="post">
<label></label><input type="text" name="apass">
<input type="submit" value="AdminLogIn">
</form>
</div>
</body>
</html>