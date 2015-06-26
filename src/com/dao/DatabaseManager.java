package com.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatabaseManager {

	public static Connection getConnection()
	{
		Connection conn = null;
		
		try {
			InitialContext cont = new InitialContext();
			DataSource ds = (DataSource) cont.lookup("java:/comp/env/jdbc/adsdb");
			conn = ds.getConnection();
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return conn;
		
	}
	
	
	
	
	
}
