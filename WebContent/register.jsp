<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <jsp:include page="WEB-INF/view/head.jsp"/>
    
    
    <form method="post" action="register">
	<table>
		<tr>
			<td>Username :</td>
			<td><input type="text" name="username" /></td>
		</tr>
		<tr>
			<td>Password :</td>
			<td><input type="password" name="password" /></td>
		</tr>
		
		<tr>
			<td>Name :</td>
			<td><input type="text" name="firstname" /></td>
		</tr>
		<tr>
			<td>Last Name :</td>
			<td><input type="text" name="lastname" /></td>
		</tr>
		
		<tr>
			<td>Email Name :</td>
			<td><input type="text" name="email" /></td>
		</tr>
		
		
		<tr>
		<td colspan="2">
			<input type="submit" value="Register" />	
		</td>
		</tr>
	</table>

</form>
    
    <p style="color:red;">${errmessage}</p>
    
    
    
    	</div>
    
    
    <jsp:include page="WEB-INF/view/footer.jsp"/>