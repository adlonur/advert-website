package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Ad;


public class AdDao {

	public List<Ad> findAll()
	{
		List<Ad> ads = new ArrayList<Ad>();
		
		Connection conn = null;
		
		conn = DatabaseManager.getConnection();
		String query = "SELECT * FROM ad ORDER BY id DESC LIMIT 10";
		
		try {
			PreparedStatement psmt = conn.prepareStatement(query);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next())
			{
				Ad ad = new Ad();
				ad.setId(rs.getInt("id"));
				ad.setHeader(rs.getString("header"));
				ad.setAdcategory_id(rs.getInt("adcategory_id"));
				ad.setUser_id(rs.getInt("user_id"));
				
				ads.add(ad);
				
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
		return ads;
	}
	
	public void save(String header,String details,int adcategory,int user_id)
	{
		Connection conn = null;
		
		
		try {
			conn = DatabaseManager.getConnection();
			String query = "insert into ad (header,details,adcategory_id,user_id) values(?,?,?,?)";
			
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setString(1, header);
			psmt.setString(2, details);
			psmt.setInt(3, adcategory);
			psmt.setInt(4, user_id);
			psmt.executeUpdate();
			
			
			
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
		
	}
	public List<Ad> findById(int adid)
	{
		List<Ad> ads = new ArrayList<Ad>();
		Connection conn = DatabaseManager.getConnection();
		
		try {
			
			String query = "select * from ad where adcategory_id=?";
			PreparedStatement psmt = conn.prepareStatement(query);
			
			psmt.setInt(1, adid);
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				Ad ad = new Ad();
				ad.setId(rs.getInt("id"));
				ad.setHeader(rs.getString("header"));
				ad.setDetails(rs.getString("details"));
				ad.setAdcategory_id(rs.getInt("adcategory_id"));
				ad.setUser_id(rs.getInt("user_id"));
				ads.add(ad);
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
		
		
		return ads;
		
	}
	
	public List<Ad> findByNormalId(int id)
	{
		List<Ad> ads = new ArrayList<Ad>();
		Connection conn = DatabaseManager.getConnection();
		
		try {
			
			String query = "select * from ad where id=?";
			PreparedStatement psmt = conn.prepareStatement(query);
			
			psmt.setInt(1, id);
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				Ad ad = new Ad();
				ad.setId(rs.getInt("id"));
				ad.setHeader(rs.getString("header"));
				ad.setDetails(rs.getString("details"));
				ad.setAdcategory_id(rs.getInt("adcategory_id"));
				ad.setUser_id(rs.getInt("user_id"));
				ads.add(ad);
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
		
		
		return ads;
		
	}
	
}
