package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Ad;
import com.model.User;

public class UserDao {

	public User login(String username,String password)
	{
		User user = null;
		String quary = "select * from user where username=? and password=?";
		Connection conn = DatabaseManager.getConnection();
		
		

		try {
			PreparedStatement psmt = conn.prepareStatement(quary);
			psmt.setString(1, username);
			psmt.setString(2, password);
			ResultSet rs = psmt.executeQuery();
			if(rs.next())
			{
				user = new User(rs.getInt("id"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("email"),rs.getString("username"),rs.getString("password"));
		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return user;
		
	}
	//yeni kullanici kaydetme
	public  User save(String firstname,String lastname,String email,String username,String password)
	{
		User user = new User();
		String quary = "select * from user where username=?";
		Connection conn = DatabaseManager.getConnection();
		try {
			PreparedStatement psmt = conn.prepareStatement(quary);
			psmt.setString(1, username);
			ResultSet rs = psmt.executeQuery();
			if(rs.next())
			{
				
				
					user= null;
				
			}else{
				
				
				String query2 = "insert into user (firstname,lastname,email,username,password) values(?,?,?,?,?)";
				PreparedStatement psmt2 = conn.prepareStatement(query2);
				psmt2.setString(1, firstname);
				psmt2.setString(2, lastname);
				psmt2.setString(3, email);
				psmt2.setString(4, username);
				psmt2.setString(5, password);
				psmt2.executeUpdate();
				
				
				user.setFirstname(firstname);
				user.setLastname(lastname);
				user.setEmail(email);
				user.setUsername(username);
				user.setPassword(password);
				
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return user;
	}
	
	
	public List<User> findById(int id)
	{
		List<User> users = new ArrayList<User>();
		Connection conn = DatabaseManager.getConnection();
		
		try {
			
			String query = "select * from user where id=?";
			PreparedStatement psmt = conn.prepareStatement(query);
			
			psmt.setInt(1, id);
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				users.add(user);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		return users;
		
	}
	
}
