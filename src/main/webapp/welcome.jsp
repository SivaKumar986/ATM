<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="Style.css">
<style>
h1{ margin:300px;
    text-align:center;
    }
</style>
<head>
<meta charset="ISO-8859-1">
<title>MNK ATM SERVICES</title>
</head>
<body>
<h2>MNK ATM SERVICES</h2>
<form action="Money" method="post">
<table>
<tr><td><label>Enter User Name</label><input type="text" placeholder="krishnaveni" name="user"><br></td></tr>
<tr><td><label>Enter Password</label><input type="text" placeholder="krishnavenipassword" name="pass"><br></td></tr>
<tr><td><label>Enter Money</label><p>Enter 0 for minisatement or Enter money <input type="number" name="amount"><br></td></tr>
<tr><td><label>Select Option</label><select name="sele">
      <option value="101">WithDraw</option>
      <option value="102">Deposit</option>
      <option value="103">Mini_Satatement</option>
</select><br></td></tr>
<tr><td><input type="submit" value="Click Here ...."></td></tr>
</table>
</form>

</body>
</html>