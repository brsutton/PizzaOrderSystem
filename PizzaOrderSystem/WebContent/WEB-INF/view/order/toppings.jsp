<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:set var="pizzaState" scope="session" value="toppingsSet" />
<form action="OrderControler" method="post">
	<table>
		<th>Quantity</th>
		<th>Topping</th>


		<c:forEach items="${pizzaToppings}" var="topping">


			<tr>
				<td><input type="number" step="1" name="${topping[0]}"
					value="0" style="width: 85px"  min="0" max="9" ></td>
				<td>${topping[0]}</td>
			</tr>


		</c:forEach>
		</td>


		<tr>
			<td colspan="2" style="text-align: right"><input type="submit"
				value="Next"></td>
		</tr>
	</table>
</form>