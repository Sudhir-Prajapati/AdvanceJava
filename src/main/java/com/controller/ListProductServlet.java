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

@WebServlet("/ListProductServlet")
public class ListProductServlet extends HttpServlet
{

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try 
		{
			String DriverClassName = "com.mysql.cj.jdbc.Driver";
			String dbUrl = "jdbc:mysql://localhost:3306/adjava";
			String dbUsername = "root";
			String dbPassword = "root";
			
			Class.forName(DriverClassName);
			
			Connection con = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			
			PreparedStatement pstmt = con.prepareStatement("select * from product");
			
			ResultSet rs = pstmt.executeQuery();
		
			request.setAttribute("rs", rs);
			
			request.getRequestDispatcher("ListProduct.jsp").forward(request, response);
		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
