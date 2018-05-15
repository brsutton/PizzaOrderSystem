<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h2>Pizza Order Form</h2>

<c:if test="${pizzaState == 'type'}">
	<tr>
		<td height="20"><%@include file="order\kindOfPizza.jsp"%>
		</td>
	</tr>
</c:if>


<c:if test="${pizzaState == 'kindSet'}">
	<tr>
		<td height="20"><%@include file="order\toppings.jsp"%>
		</td>
	</tr>
	
</c:if>

<c:if test="${pizzaState == 'toppingsSet'}">
	<tr>
		<td height="20"><%@include file="order\confirmOrder.jsp"%>
		</td>
	</tr>
	
</c:if>