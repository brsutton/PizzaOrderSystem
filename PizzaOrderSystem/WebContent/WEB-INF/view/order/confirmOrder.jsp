<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%-- 
<% Order order = session.getAttribute("CurrentOrder"); %> --%>
<form action="ComfirmOrder" method="post">
	<table>
		<tr>
			<th>Price</th>
			<th>Pizza</th>
			<th>Toppings</th>
		</tr>

		<tr style="background-color: lightGreen">
			<td><c:out value="${sessionScope.CurrentOrder.cost}"></c:out>__Units</td>
			<td><c:out value="${sessionScope.CurrentOrder.pizzaType}"></c:out></td>
			<td><c:out value="${sessionScope.CurrentOrder.toppings}"></c:out></td>
		</tr>
		<tr>
			<td colspan="3" style="text-align: right"><input type="submit"
				value="Confirm Order"></td>
		</tr>
	</table>
</form>