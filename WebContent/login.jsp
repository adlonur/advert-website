<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="WEB-INF/view/head.jsp"></jsp:include>


<h3>Login</h3>

<form method="post" action="login">
	<table>
		<tr>
			<td>Username:</td>
			<td><input type="text" name="username" /></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="password" /></td>
		</tr>
		
		<tr>
		<td colspan="2"  >
			<input type="submit" value="Go"/>	
		</td>
		</tr>
	</table>

</form>

<p style="color:red;">${errmessage}</p>
</div>
<jsp:include page="WEB-INF/view/footer.jsp"></jsp:include>
