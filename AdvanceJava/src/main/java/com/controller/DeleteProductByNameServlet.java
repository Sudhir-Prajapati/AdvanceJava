package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteProductByNameServlet")
public class DeleteProductByNameServlet extends HttpServlet
{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			String productName = request.getParameter("productName");
			String DriverName = "com.mysql.cj.jdbc.Driver";
			String dbUrl = "jdbc:mysql://localhost:3306/adjava";
			String dbUsername = "root";
			String dbPassword = "root";
			
			Class.forName(DriverName);
			
			Connection con =  DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			
			PreparedStatement pstmt =  con.prepareStatement("delete from product where productName = ?");
			
			pstmt.setString(1,productName);
			
			pstmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("ListProductServlet").forward(request, response);
	}
}
