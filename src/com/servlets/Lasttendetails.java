package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.dao.AdDao;
import com.dao.UserDao;
import com.dao.User_AdDao;
import com.model.Ad;
import com.model.User;
import com.model.User_ad;


@WebServlet("/lasttendetails")
public class Lasttendetails extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int lastid  = Integer.valueOf(request.getParameter("lastid"));
		

		AdDao dao = new AdDao();
		List<Ad> ad = dao.findByNormalId(lastid);
		UserDao dao2= new UserDao();
		List<User> user= null;
		for (Ad ad2 : ad) {
			user = dao2.findById(ad2.getUser_id());
			
		}
		

		User_AdDao userdao = new User_AdDao();
		int count = userdao.findAll(lastid);
		
	
		request.setAttribute("ad", ad);
		request.setAttribute("userdetail", user);
		request.setAttribute("count", count);
		request.setAttribute("lastid", lastid);
		request.getRequestDispatcher("lasttenads.jsp").forward(request, response);
		
		
	}

}
