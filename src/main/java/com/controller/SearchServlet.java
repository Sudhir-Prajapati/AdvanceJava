package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchServlet")

public class SearchServlet extends HttpServlet
{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String ProductCat =request.getParameter("ProductCategory");
		

		try
		{
			String driverClassName = "com.mysql.cj.jdbc.Driver";
			String dbUrl = "jdbc:mysql://localhost:3306/adjava";
			String dbUserName = "root";
			String dbPassword = "root";
			
			
			Class.forName(driverClassName);
			
			Connection con = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
			
			PreparedStatement pstmt = con.prepareStatement("select * from product where category = ?");
			
			pstmt.setString(1, ProductCat);
			ResultSet rs = pstmt.executeQuery();
			
			request.setAttribute("rs", rs);
			request.getRequestDispatcher("ProductInformation.jsp").forward(request, response);
			
		}
		catch (ClassNotFoundException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}
}
