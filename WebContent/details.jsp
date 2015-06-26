<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="WEB-INF/view/head.jsp"></jsp:include>


<c:forEach items="${listads}" var="listad">
	<div>
	<h2></h2>
	<tr>
		<td><p> ${listad.details} </p> </td>
	</tr>
	</div>
</c:forEach>
</div>
<jsp:include page="WEB-INF/view/footer.jsp"></jsp:include>