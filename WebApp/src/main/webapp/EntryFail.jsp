<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Parking Spot Didn't Register</title>
</head>
<body>
<h2>Data entry failed!</h2>
<%
	if (( request.getParameter("car_rego") == "" || request.getParameter("park_address") == "" || request.getParameter("day") == "" || request.getParameter("start_time") == "" || request.getParameter("end_time") == "" || request.getParameter("is_handicapped") == "" || request.getParameter("handicapped_spot") == "" || request.getParameter("fees_paid") == "" ))
	{ 
		System.out.println(request.getParameter("car_rego"));
		System.out.println(request.getParameter("park_address"));
		System.out.println(request.getParameter("day"));
		System.out.println(request.getParameter("start_time"));
		System.out.println(request.getParameter("end_time"));
		System.out.println(request.getParameter("is_handicapped"));
		System.out.println(request.getParameter("handicapped_spot"));
		System.out.println(request.getParameter("fees_paid"));
		
	%>
		One or more fields are incomplete!<br/><br/>
	<%}
%>
<%
	if((Integer)request.getAttribute("overtime") == 1)
	{%>
		You parked overtime!<br/><br/>
	<%}
%>
<%
	if((Integer)request.getAttribute("wrongTime") == 1)
	{%>
		This is not the time to park!<br/><br/>
	<%}
%>
<%
	if((Integer)request.getAttribute("rippedOff") == 1)
	{%>
		You don't have to pay on Saturday and Sunday!<br/><br/>
	<%}
%>
<%
	if((Integer)request.getAttribute("hasNotPaid") == 1)
	{%>
		You haven't paid enough money yet!<br/><br/>
	<%}
%>
<%
	if((Integer)request.getAttribute("overpaid") == 1)
	{%>
		You paid too much!<br/><br/>
	<%}
%>
<a href="Entry.jsp">Try Again</a>
</body>
</html>