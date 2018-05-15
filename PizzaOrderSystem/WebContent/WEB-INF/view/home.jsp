<!-- This is the home page that contains all UI content for the application 
	 This will be shown based on the state -->
<%
	response.addHeader("Expires", "-1");
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

<title>Pizza Order System</title>
<style type="text/css">
.message {
	color: red;
	font-weight: bold
}

table {
	border-collapse: collapse;
	background-color: hsla(120, 100%, 75%, 0.4);;
}

table, th, td {
	border: 1px solid black;
}

td {
	padding: 7px;
	text-align: left;
}

tr:nth-child(odd) {
	background-color: lightGreen;
}

th {
	background-color: darkGreen;
	color: white;
}

span {
	color: red;
}

input, button {
	padding: 9px 20px;
	border-radius: 8px;
	border-color: lightGray;
}

input[type=submit]:HOVER {
	border-color: yellow;
	opacity: 0.8;
	color: blue;
}
button:HOVER {
	border-color: yellow;
	opacity: 0.8;
	color: blue;
}

a {
	text-decoration: none;
	font-size: 25px;
	background-color: lightGreen;
}

a:link {
	color: black;
	font: bolder;
}

a:visited {
	color: black;
	font: bolder;
}

a:hover {
	color: white;
}

a:active {
	color: red;
}
html
{
   
   font-family: Times New Roman;
}
body {
	background-image: url(images/pizza.jpg);
	background-size: cover;
	background-repeat: no-repeat;
	background-position: center center;
}
</style>
<META HTTP-EQUIV="Cache-Control" CONTENT="NO-CACHE">

</head>

<!-- <body background="images/pizza.jpg"> -->
	<table border="1" width="80%" align="center">
		<tr>
			<td height="30"><h2>Pizza Order Service</h2></td>
		</tr>
		<tr>
			<td height="20"><%@include file="menu_top.jsp"%>
			</td>
		</tr>
		<tr>
			<td><%=request.getAttribute("infoMessage")%></td>
		</tr>
		<tr>
			<td><span> <%
 	if (request.getAttribute("msg") != null) {
 		out.println(request.getAttribute("msg"));
 	}
 %>
			</span></td>
		</tr>
		<c:if test="${state == 'login'}">
			<tr>
				<td height="20"><%@include file="loginForm.jsp"%>
				</td>
			</tr>
		</c:if>

		</tr>


		<c:if test="${state == 'welcome'}">
			<tr>
				<td height="20"><h2>Welcome to the Pizza Order System Lets Get Some
					Pizza In You!!!!!.</h2></td>
			</tr>
		</c:if>

		<c:if test="${state == 'registration'}">
		<tr><td><h2>Registration Form</h2></td></tr>
			<tr>
				<td height="20"><%@include file="registrationForm.jsp"%>
				</td>
			</tr>
		</c:if>
		<c:if test="${state == 'validUser'}">
			<tr>
				<td height="20"><%@include file="welcome.jsp"%>
				</td>
			</tr>
		</c:if>
		<c:if test="${state == 'newOrder'}">
			<tr>
				<td height="20"><%@include file="orderForm.jsp"%></td>
			</tr>
		</c:if>

		<c:if test="${state == 'orderConfimed'}">
			<tr>
				<td height="20"><%@include file="orderConfirmed.jsp"%></td>
			</tr>
		</c:if>

		<c:if test="${state == 'showAllOrders'}">
		<tr><td><h2>All Orders</h2></td></tr>
			<tr>
				<td height="20"><%@include file="showAllOrders.jsp"%></td>
			</tr>
		</c:if>

		<c:if test="${state == 'orderUpdate'}">
		<tr><td><h2> Order Update</h2></td></tr>
			<tr>
				<td height="20"><%@include file="showAllOrders.jsp"%></td>
			</tr>
		</c:if>

		<c:if test="${state == 'listUserOrders'}">
		<tr><td><h2>Your Orders</h2></td></tr>
			<tr>
				<td height="20"><%@include file="listUserOrders.jsp"%>
				</td>
			</tr>
		</c:if>

		<c:if test="${state == 'about'}">
			<tr>
				<td height="20"><%@include file="aboutForm.jsp"%>
				</td>
			</tr>
		</c:if>
	</table>
</body>
</html>
