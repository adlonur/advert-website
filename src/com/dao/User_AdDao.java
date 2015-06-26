package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.User;
import com.model.User_ad;

public class User_AdDao {

	public int findAll(int ad_id)
	{
		
		Connection conn = null;
		int count = 0;
		conn = DatabaseManager.getConnection();
		
		String query = "select * from user_ad where ad_id=?";
		
		try {
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setInt(1,ad_id);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next())
			{
				count++;
				
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
		
		return count;
		
		
	}
	
	
		public  User_ad like(int ad_id,int user_id)
		{
			User_ad user = new User_ad();
			String quary = "select * from user_ad where ad_id=? and user_id=?";
			Connection conn = DatabaseManager.getConnection();
			try {
				PreparedStatement psmt = conn.prepareStatement(quary);
				psmt.setInt(1, ad_id);
				psmt.setInt(2, user_id);
				ResultSet rs = psmt.executeQuery();
				if(rs.next())
				{
					
					
						user= null;
					
				}else{
					
					
					String query2 = "insert into user_ad(ad_id,user_id) values(?,?)";
					PreparedStatement psmt2 = conn.prepareStatement(query2);
					psmt2.setInt(1, ad_id);
					psmt2.setInt(2, user_id);
					
					psmt2.executeUpdate();
					
					
					user.setAd_id(ad_id);
					user.setUser_id(user_id);
					
					
					
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
	
}
