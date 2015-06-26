package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdDao;
import com.dao.UserDao;
import com.model.User;


@WebServlet("/register")
public class SaveRegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	    UserDao dao = new UserDao();
	    User user = dao.save(firstname, lastname, email, username, password);
		
	    if(user==null)
	    {
	    	request.setAttribute("errmessage", "Username Exists");
			request.getRequestDispatcher("register.jsp").forward(request, response);
	    	
	    }else{
	    	
	    	response.sendRedirect("login.jsp");
	    	
	    }
		
		
		
	}

}
