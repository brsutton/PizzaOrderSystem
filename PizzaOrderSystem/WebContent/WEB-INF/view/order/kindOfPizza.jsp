<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<form action="OrderControler" method="post">
	<table>
		<th>Type Of Pizza</th>
		<th>Sm | Md | Lg</th>

		<tr>
			<td><select name="pizzaType" style="background-color: white">
					<c:forEach items="${pizzaTypes}" var="pizza">
						<option value="${pizza[0]}">
							${pizza[0]}</option>
					</c:forEach></select></td>
			<td><input type="radio" name="pizzaSize" value="small">
				<input type="radio" name="pizzaSize" value="medium" checked="checked"> <input
				type="radio" name="pizzaSize" value="large"></td>
		</tr>
		
		<tr> <td colspan="2" style="text-align: right"><input type="submit"value="Next"></td> </tr>
	</table>
</form>