<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="com.model.Ad"%>
<%@page import="com.dao.AdDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <% AdDao dao = new AdDao(); %>
    <%List<Ad> daolist = new ArrayList<Ad>(); 
    daolist = dao.findAll();
    %>
    <jsp:include page="WEB-INF/view/head.jsp"/>
    
   <h2>Last 10 Ads </h2>
    <table>
 


    <%for(Ad ad : daolist){ %>
    <tr><td>
    <% String userid2 =String.valueOf(ad.getId());%>
    <c:url value="/lasttendetails" var="lasttenlink">
   		<c:param name="lastid" value="<%=userid2%>" />
   	</c:url>
   
    <a href="${lasttenlink}"><%=ad.getHeader() + "\n"  %>
    		
    </a>
    </td>
    </tr>
    <%} %>
   
    </table>
    <br/><br/>
		</div>
		<jsp:include page="WEB-INF/view/footer.jsp"/>