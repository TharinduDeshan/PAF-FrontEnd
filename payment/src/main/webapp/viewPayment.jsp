<%@page import="model.payment" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="cssbootstrap.min.css">
</head>
<body>
<h1>PAYMENT DETAILS</h1>
<%
//Delete Feedback----------------------------------
	if (request.getParameter("PayID") != null)
	{
		payment paymentObj = new payment();
	String stsMsg = paymentObj.deletePayment(request.getParameter("PayID"));
	session.setAttribute("statusMsg", stsMsg);
	}   
	
 payment paymentObj = new payment();
 out.print(paymentObj.readPayment());
%>

</body>
</html>