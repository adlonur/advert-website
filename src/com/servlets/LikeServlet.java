package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.User_AdDao;
import com.model.User;
import com.model.User_ad;

@WebServlet("/like")
public class LikeServlet extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int like =Integer.valueOf(request.getParameter("lastid"));
		int user_id = Integer.valueOf(request.getParameter("likeid"));
	
		
		User_AdDao dao = new User_AdDao();
		User_ad user = new User_ad();
		user = dao.like(like, user_id);
		
		request.setAttribute("lastid", like);
		request.getRequestDispatcher("lasttendetails").forward(request, response);
	}
	}


