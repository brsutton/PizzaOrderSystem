 

<form action="UserRegistrationController" method="post">
	<table border="0" cellpadding="5" cellspacing="3">
	
		<tr>
			<td>Name</td>
			<td><input type="text" name="name" required="required" /></td>
		</tr>
		<tr>
			<td>Contact</td>
			<td><input type="text" name="contact" required="required" /></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" name="email" required="required" /></td>
		</tr>
		<tr>
			<td>Address</td>
			<td><textarea name="address" rows="3" cols="20"
					required="required"></textarea></td>
		</tr>
		<tr>
			<td>LOGIN NAME</td>
			<td><input type="text" name="login_name" / required="required"></td>
		</tr>

		<tr>
			<td>PASSWORD</td>
			<td><input type="password" name="password" / required="required"></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: right"><input type="submit"
				value="Register" /></td>
		</tr>
	</table>
</form>
