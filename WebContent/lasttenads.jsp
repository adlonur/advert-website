<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
  <jsp:include page="WEB-INF/view/head.jsp"/>
  
  <c:forEach items="${ad}" var="ad">
	<h2>${ad.header}</h2>
	<p>${ad.details} </p>
	<h3>Contact</h3>
	<c:forEach items="${userdetail}" var="user">
	<p>${user.firstname}</p> <p>${user.lastname}</p>
	<p>${user.email }</p>
	</c:forEach>
</c:forEach>
  
  <br/>
  <br/>
  
  <p>Number of like :${count}</p>


  <c:if test="${not empty user}" >
		<c:url value="/like" var="likelink">
		<c:param name="likeid" value="${user.id}"/>
		<c:param name="lastid" value="${lastid}"/>
		</c:url>
			
			<a href="${likelink}" >Like</a>
			
		</c:if>
  
  
  
  </div>
		<jsp:include page="WEB-INF/view/footer.jsp"/>