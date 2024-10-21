package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.x.protobuf.MysqlxCrud.Column;

@WebServlet("/SaveProductServlet")
public class SaveProductServlet extends HttpServlet
{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		
		String ProductName = request.getParameter("ProductName");
//		Integer Price = Integer.parseInt(request.getParameter("Price"));
		String Price = request.getParameter("Price");
		String Category = request.getParameter("Category");
//		Integer Qty = Integer.parseInt(request.getParameter("Qty"));
		String Qty = request.getParameter("Qty");
		
		
		boolean iserror = false;
		String ragProductName = "[a-zA-Z]+";
		String ragPrice = "[0-9]+";
		
		if(ProductName== null || ProductName.trim().length() == 0) 
		{
			iserror = true;
			request.setAttribute("ProductNameError","Please Enter valid FirstName");
		}
		if(Price== null || Price.trim().length() == 0 || Price.matches(ragPrice) == false )
		{
			iserror = true;
			request.setAttribute("PriceError","Please Enter valid Price");
		}
		if(Category== null || Category.trim().length() == 0 || Category.matches(ragProductName) == false)
		{
			iserror = true;
			request.setAttribute("CategoryError","Please Enter valid Category");
		}
		if(Qty== null || Qty.trim().length() == 0 || Qty.matches(ragPrice) == false )
		{
			iserror = true;
			request.setAttribute("QtyError","Please Enter valid Qty");
		}
		
		
		if (iserror == true)
		{
			request.getRequestDispatcher("InputProduct.jsp").forward(request, response);
		} 
		else
		{
			String productName = ProductName;
			Integer price = Integer.parseInt(Price);
			String category = Category;
			Integer qty = Integer.parseInt(Qty);
			
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/adjava","root","root");
				
				
				PreparedStatement pstmt = con.prepareStatement("insert into product (productName,price,category,qty) values (?,?,?,?)");
				
				pstmt.setString(1, productName);
				pstmt.setInt(2, price);
				pstmt.setString(3, category);
				pstmt.setInt(4, qty);
				
				pstmt.executeUpdate();
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("ListProductServlet").forward(request, response);
		}	
	}
}