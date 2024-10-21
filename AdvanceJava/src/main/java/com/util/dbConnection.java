package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection
{
	public static void main(String[] args)
	{
		String dbUrl = "jdbc:mysql://localhost:3306/AdJava";
		String dbUsername = "root";
		String dbPassword = "root";
		
		
		try 
		{	
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			
			System.out.println("connection = > "+ connection);
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
