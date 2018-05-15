
<%
	response.addHeader("Expires", "-1");
%>
<%@include file="imports.jsp"%>
<c:if test="${loggedInUser==null}">
	<%--user is not logged in--%>
	<a href="welcome">HOME</a> 
<a href="regForm">REGISTRATION</a> 
<a href="index.jsp">LOGIN</a> 
<a href="about">ABOUT</a> 
</c:if>

<c:if test="${loggedInUser!=null}">
	<%--user is logged in--%>
	<a href="welcome">HOME</a> 
<a href="newOrder">ORDER PIZZA</a> 
<a href="ListOrders">MY PIZZA ORDERS</a> 
	
	<c:if test="${loggedInUser.role == 'worker'}">
	<a href="DisplayAllOrders">SHOW ALL ORDERS</a> 
	</c:if>
	<a href="LogOutController">LOGOUT</a> 
	
</c:if>