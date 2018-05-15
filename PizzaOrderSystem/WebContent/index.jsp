<%
	request.setAttribute("msg", "");
	request.setAttribute("state", "login");
	request.setAttribute("infoMessage", "Welcome, I hope you have a great day!!");
%>
<jsp:forward page="/WEB-INF/view/home.jsp"></jsp:forward>