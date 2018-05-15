<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- <h2>Status Page</h2> -->

<form action="OrderConfirmedController" method="post">
	<table border="0" cellpadding="5" cellspacing="3">

		<tr>
			<th>Order Number</th>
			<th>Pizza</th>
			<th>You Order Status!</th>
			
		</tr>
		<c:if test="${order.status == 'Boxing'}">
			<tr>
				<td>
					<div colspan="5" id="readyItems"></div>
				<td>
			</tr>

		</c:if>
		<tr>
		    <td><c:out value="${sessionScope.CurrentOrder.id}"></c:out>
		    <td><c:out value="${sessionScope.CurrentOrder.pizzaType}"></c:out>
			<td><c:out value="${sessionScope.CurrentOrder.status}"></c:out>
			</td>
		</tr><tr>
		<td colspan="3" style="text-align: right"><input type="submit" name="submit" value="Refresh"></td>
		</tr>
	</table>
</form>

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