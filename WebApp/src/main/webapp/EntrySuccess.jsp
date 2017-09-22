<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Parking Spot Entered Successfully</title>
</head>
<body>
	<h2>Information entered to the database, good job!</h2>
<%
	if (( session.getAttribute("car_rego") != null && session.getAttribute("park_address") != null && session.getAttribute("day") != null && session.getAttribute("start_time") != null && session.getAttribute("end_time") != null && session.getAttribute("is_handicapped") != null && session.getAttribute("handicapped_spot") != null && session.getAttribute("fees_paid") != null ))
	{ %>
		You have entered your data!<br/><br/>
    <%}
%>
<a href="Entry.jsp">Enter another entry</a>
</body>
</html>