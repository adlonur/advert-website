<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.Adcategory"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.AdcategoryDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% AdcategoryDao dao = new AdcategoryDao(); %>
<% List<Adcategory> ad = new ArrayList<Adcategory>();
ad = dao.findAll();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="style.css" rel="stylesheet" type="text/css" />
<title>Adil Onur Candanoglu</title>
</head>
<body>
	<div id="top">
		<h2>The Adverts Site</h2>
		<c:if test="${not empty user }">
		<h3>Welcome ${user.firstname}</h3>
</c:if> 

	</div>


	<div id="menu">
		<c:url value="/index.jsp" var="homelink"></c:url>
		<c:url value="/register.jsp" var="registerlink"></c:url>
		<c:url value="/login.jsp" var="loginlink"></c:url>
		<c:url value="/dologout" var="logoutlink"></c:url>
<c:url value="/postad" var="postadlink"></c:url>
		<a href="${homelink}" class="menulink">Home</a>
		<c:if test="${empty user}">

			<a href="${loginlink}" class="menulink">Login</a>
		</c:if>	
		<c:if test="${empty user}" >
		<a
			href="${registerlink}" class=registerlink>Register</a>
			
		</c:if>
		<c:if test="${not empty user}">
			<a href="${logoutlink}" class="menulink">Logout</a>
		</c:if>
		<c:if test="${not empty user}">
		<a
			href="${postadlink}" class=postadlink>Post Ad</a>
			</c:if>
	</div>
<div id="center">
			<div id="centerleft"><h2>Adverts </h2> 
			
			<table>
			
			 
			
			
			<% for(Adcategory a : ad){ %>
			<c:url value="/adverts" var="advertlink">
	<c:param name="adsid" value="<%=String.valueOf(a.getId())%>"/>
	
	</c:url>
			<tr>
			<td>
			
			<a href="${advertlink}"><%=a.getCategory_name()%>
			
			</a>
			</td>
			</tr>
			<%} %>
			
			
			
			
			</table>
			
			
			
			</div>
			<div id="centerright">
	
	