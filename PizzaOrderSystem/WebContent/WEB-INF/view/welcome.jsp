<%
	request.setAttribute("msg", null);
	request.setAttribute("infoMessage", "Hello Again, What Would You Like To Do???");
	request.setAttribute("state", "welcome");
%>

<jsp:forward page="home"></jsp:forward>