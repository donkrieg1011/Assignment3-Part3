<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Parking Reservation</title>
</head>
<body>

You have successfully logged in<br/>
<h2>Enter your Information:</h2>
	<form method="post" action="CarCheck">
		<table>
			<tr>
				<td> Car Registration Number:</td>
				<td><input type="text" name ="car_rego"></td>
			</tr>
			<tr>
				<td> Parking Address:</td>
				<td><input type="text" name ="park_address"></td>
			</tr>
			<tr>
				<td> Day (e.g. Monday):</td>
				<td><input type="text" name ="day"></td>
			</tr>
			<tr>
				<td> Start Time (HH:MM format):</td>
				<td><input type="text" name ="start_time"></td>
			</tr>
			<tr>
				<td> End Time (HH:MM format):</td>
				<td><input type="text" name ="end_time"></td>
			</tr>
			<tr>
				<td> Handicap Permit? (Y or N)</td>
				<td><input type="text" name ="is_handicapped"></td>
			</tr>
			<tr>
				<td> Use Handicapped Spot? (Y or N):</td>
				<td><input type="text" name ="handicapped_spot"></td>
			</tr>
			<tr>
				<td> Fees ($1.5 per hour):</td>
				<td><input type="text" name ="fees_paid"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name ="Enter"></td>
			</tr>
		</table>
	</form>
</body>
</html>