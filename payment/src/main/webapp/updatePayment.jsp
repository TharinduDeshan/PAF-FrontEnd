<%@page import="model.payment" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%    
    //update part
 if (request.getParameter("PayID") != null)
 {
 payment paymentObj = new payment();
 String stsMsg = paymentObj.updatePayment(request.getParameter("PayID"),

	request.getParameter("minUnit"),
	request.getParameter("maxUnit"),
	request.getParameter("unitPrice"));
 session.setAttribute("statusMsg", stsMsg);
 }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container" style="width:30%; border:1px solid black; padding:40px 20px; border-radius:10px">
<h3><center>Card Registration</center></h3>
<br>
<form method="post" action="updatePayment.jsp">

    <div class="form-group">
	    <label for="exampleInputEmail1">Payment ID</label>
	    <input name="PayID" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter no of units used">
	 </div>
	 
  <div class="form-group">
    <label for="exampleInputEmail1">MIN UNIT</label>
     <select name="minUnit" class="custom-select my-1 mr-sm-2" id="inlineFormCustomSelectPref">
	    <option selected>Choose...</option>
	    <option value="0">0</option>
	    <option value="30">30</option>
	    <option value="60">60</option>
	    <option value="90">90</option>
	    <option value="120">120</option>
	  </select>
   </div>

   <div class="form-group">
    <label for="exampleInputEmail1">MAX UNIT</label>
      <select name="maxUnit" class="custom-select my-1 mr-sm-2" id="inlineFormCustomSelectPref">
	    <option selected>Choose...</option>
	    <option value="30">30</option>
	    <option value="60">60</option>
	    <option value="90">90</option>
	    <option value="120">120</option>
	    <option value="180">180</option>
	  </select>
   </div>
 
    <div class="form-group">
	    <label for="exampleInputEmail1">UNIT PRICE</label>
	    <input name="unitPrice" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter no of units used">
	 </div>
  <br>
<div class="text-center">
 <input class="btn btn-primary" style="width:120px; font-weight:bold" name="btnSubmit" type="submit" value="Submit">
</div>
</form>
</div>

<%-- 
<form method="post" action="updatePayment.jsp">
 PayID:<input name="PayID" type="text"><br><br> 
 MIN UNIT: <input name="minUnit" type="text"><br><br> 
 MAX UNIT:   <input name="maxUnit" type="text"><br><br>
 UNIT PRICE:   <input name="unitPrice" type="text"><br><br> 
 
 <input name="btnSubmit" type="submit" value="Submit"><br><br>
</form>
--%>
<%
 out.print(session.getAttribute("statusMsg"));
%>


<br>
<%
 payment paymentObj = new payment();
 out.print(paymentObj.readPayment());
%>
</body>
</html>