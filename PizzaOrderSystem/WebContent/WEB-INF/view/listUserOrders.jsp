<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--This page shows the list of the logged in users pizzas  -->
<table border="0" cellpadding="5" cellspacing="3">

	<tr>
		<th>ID</th>
		<th>PIZZA</th>
		<th>COST</th>
		<th>SIZE</th>
		<th>STATUS</th>
	</tr>

	<c:forEach items="${userOrders}" var="order">
		<c:if test="${order.status == 'Boxing'}">
			<tr>
				<td>
					<div colspan="5" id="readyItems"></div>
				<td>
			</tr>

		</c:if>
		<tr>
			<td>${order.id}</td>
			<td>${order.pizzaType}</td>
			<td>${order.cost}</td>
			<td>${order.size}</td>
			<td>${order.status}</td>
		</tr>

	</c:forEach>
	<tr>
		<td colspan="5" style="text-align: right"><button id="refresh"
				value="Refresh" class="button2">Refresh</button></td>
	</tr>
</table>

<script>
	var $ = function(name) {
		return document.getElementById(name);
	};

	var refreshButtonPressed = function() {

		window.location = "ListOrders";
	};

	window.onload = function() {
		$("refresh").onclick = refreshButtonPressed;

		if ($("readyItems") != null) {
			window.alert("You Have A Pizza That Is Ready");
		}

	};
</script>