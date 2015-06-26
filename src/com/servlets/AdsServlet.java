package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.naming.Context;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdDao;
import com.dao.AdcategoryDao;
import com.model.Ad;
import com.model.Adcategory;


@WebServlet("/adverts")
public class AdsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdDao dao = new AdDao();
		
		 int id = Integer.valueOf(request.getParameter("adsid"));
		
		List<Ad> listads = dao.findById(id);
		AdcategoryDao ado2 = new AdcategoryDao();
		List<Adcategory> category = ado2.findById(id);
		request.setAttribute("listads", listads);
		request.setAttribute("category", category);
		request.getRequestDispatcher("ads.jsp").forward(request, response);
		
		
		
		
		
	}
	
	
}
