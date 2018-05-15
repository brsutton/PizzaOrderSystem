<%
	request.setAttribute("msg", "");
request.setAttribute("infoMessage", "Lets Order Pizza");
	request.setAttribute("state", "newOrder");
%>

<jsp:forward page="OrderFormController"></jsp:forward>