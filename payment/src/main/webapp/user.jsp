<%@page import="model.user" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <% 
    
//Insert Payment----------------------------------
if (request.getParameter("payDate") != null)
 {
 user userObj = new user();
 String stsMsg = userObj.insertUser(

 request.getParameter("userName"),
 request.getParameter("noOfUnits"));
 session.setAttribute("statusMsg", stsMsg);
 }
 
 

//Delete Payment----------------------------------
if (request.getParameter("UserID") != null)
{
user paymentObj = new user();
String stsMsg = paymentObj.deleteUser(request.getParameter("UserID"));
session.setAttribute("statusMsg", stsMsg);
}   

%>

   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Management</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>

<body>
<br><br>
<div class="container" style="width:30%; border:1px solid black; padding:40px 20px; border-radius:10px">
<h3><center>Card Registration</center></h3>
<br><br>

<form method="post" action="user.jsp">
  <div class="form-group">
    <label for="exampleInputEmail1">USER NAME</label>
    <input type="text" name="userName" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter user name">

  </div>
   <div class="form-group">
    <label for="exampleInputEmail1">NO OF UNITS</label>
    <input name="noOfUnits" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter no of units used">

  </div>
  <br>
<div class="text-center">
 <input class="btn btn-primary" style="width:120px; font-weight:bold" name="btnSubmit" type="submit" value="Submit">
</div>
</form>
<br>


<%-- 
<form method="post" action="user.jsp">
 
 USER NAME: <input name="userName" type="text"><br><br> 
 NO OF UNITS:   <input name="noOfUnits" type="text"><br><br> 
 
 <input name="btnSubmit" type="submit" value="Submit"><br><br>
</form>
--%>


</div>

<br>
<%
 out.print(session.getAttribute("statusMsg"));
%>

</body>
</html>