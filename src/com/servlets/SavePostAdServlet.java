package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdDao;
import com.model.User;


@WebServlet("/savepostad")
public class SavePostAdServlet extends HttpServlet {
	
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String header = request.getParameter("header");
		String details = request.getParameter("details");
		int category = Integer.valueOf(request.getParameter("selectedcategory"));
		User user = (User) request.getSession().getAttribute("user");
		int userid= user.getId();
		
	
	
		new AdDao().save(header, details, category, userid);
		response.sendRedirect("index.jsp");
	}

}
