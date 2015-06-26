<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="WEB-INF/view/head.jsp" />

<c:forEach items="${category}" var="category">
<h2>${category.category_name}</h2>
</c:forEach>
<c:forEach items="${listads}" var="listad">
	<div>
		<tr>
		<td>
		 <c:url value="/lasttendetails" var="lasttenlink">
   		<c:param name="lastid" value="${listad.id }" />
   	</c:url>
   	  <a href="${lasttenlink}" >${listad.header}
 
		</a>  </td>
	</tr>
	</div>
</c:forEach>



</div>
<jsp:include page="WEB-INF/view/footer.jsp" />