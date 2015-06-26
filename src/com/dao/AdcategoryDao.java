package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Ad;
import com.model.Adcategory;

public class AdcategoryDao {

	public static List<Adcategory> findAll()
	{
		 List<Adcategory> adcategories = new ArrayList<Adcategory>();
		 
		 Connection conn = null;
		 
		 
		
		 try {
			 conn = DatabaseManager.getConnection();
			 String query = "select * from adcategory";
			PreparedStatement psmt = conn.prepareStatement(query);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next())
			{
				Adcategory adcategory = new Adcategory();
				
				adcategory.setId(rs.getInt("id"));
				adcategory.setCategory_name(rs.getString("category_name"));
				adcategories.add(adcategory);
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
		
		return adcategories;
		
	}
	
	public List<Adcategory> findById(int adid)
	{
		List<Adcategory> ads = new ArrayList<Adcategory>();
		Connection conn = DatabaseManager.getConnection();
		
		try {
			
			String query = "select * from adcategory where id=?";
			PreparedStatement psmt = conn.prepareStatement(query);
			
			psmt.setInt(1, adid);
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				Adcategory ad = new Adcategory();
				ad.setCategory_name(rs.getString("category_name"));
				ad.setId(rs.getInt("id"));
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
