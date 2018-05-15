<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Status Page</h2>

<form action="UpdatePizza" method="post">
	<table border="0" cellpadding="5" cellspacing="3">

		<tr>
			<th>ID</th>
			<th>COST</th>
			<th>Pizza</th>
			<th>SIZE</th>
			<th>STATUS</th>
			<th>UPDATE</th>
		</tr>


		<c:forEach items="${allOrders}" var="order">

			<tr>

				<td>${order.id}</td>
				<td>${order.cost}</td>
				<td>${order.pizzaType}</td>
				<td>${order.size}</td>
				<td>${order.status}</td>
				<td><input type="submit" id="${order.id}PR" value="Prepare"
					class="updates">

				<input type="submit" id="${order.id}BA" value="Bake" class="updates">
				<input type="submit" id="${order.id}CU" value="Cut" class="updates">
				<input type="submit" id="${order.id}BO" value="Box" class="updates"></td>
			</tr>

		</c:forEach>


		<tr>
			<td></td>
			<td colspan="8" style="text-align: right"><input type="text"
				id="orderId" name="orderId" value="" readonly>
				<button id="refresh" value="Refresh" class="button2">Refresh</button></td>
		</tr>

	</table>
</form>
<script>
	var $ = function(name) {
		return document.getElementById(name);
	};

	var refreshButtonPressed = function() {

		window.location = "DisplayAllOrders";
	};

	var buttonEntered = function() {
		
		$("orderId").value = this.id;
		console.log(this.id);
	};

	window.onload = function() {
		var buttons = document.getElementsByClassName("updates");

		for (var x = 0; x < buttons.length; x++) {
			console.log(buttons[x]);
			buttons[x].onmouseover = buttonEntered;
		}

		$("refresh").onclick = refreshButtonPressed;

	};
</script>
