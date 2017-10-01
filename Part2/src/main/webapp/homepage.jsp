<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Page</title>
<style>
h1 {
	color: #00cc00;
	text-shadow: 10px 10px 10px red;
}

div {
	background-color: #ff0000;
	width: 100px;
	height: 100px;
	border-radius: 100%;
	box-shadow: 10px 10px 10px #000000;
	position: relative;
	-webkit-animation: myfirst 8s;
	animation-iteration-count:infinite;
}

@-webkit-keyframes myfirst {
0% { left:0px; top:0px; background:red; }
25% { left:200px; top:0px; background:green; }
50% { left:200px; top:200px; background:pink; }
75% { left:0px; top:200px; background:gray; }
100% { left:0px; top:0px; background:green; }
}

div:hover {
	background-color: #0000ff;
	width: 300px;
	height: 300px;
}

body {
background: linear-gradient(pink, gray);
}

</style>
</head>
<body>
<h1>Assignment 3 Example</h1>
<div></div>
</body>
</html>