<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="WEB-INF/view/head.jsp"></jsp:include>


<h2>Post An Ad</h2>


<form action="savepostad" method="post">

			<table>
			
			<tr >
					<td> Header :</td>
					<td><input type="text" name="header"></input></td>
				</tr>
			
				<tr>
					<td>Details :</td>
					<td><textarea style="width: 157px; height: 194px;" name="details" rows="5" cols="20">

</textarea></td>

</tr>
<tr>
<td>Category : </td>	
<td> <select name="selectedcategory">
			<c:forEach items="${categories}" var="category">
				<option value="${category.id}">${category.category_name}</option>
			</c:forEach>
		</select>  </td>	

</tr>
			<tr>	
					<td colspan="1"><input type="submit" value="Post"
						name="post"></input></td>
					
				</tr>
				
			</table>
		</form>








</div>
<jsp:include page="WEB-INF/view/footer.jsp"></jsp:include>