package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/SaveProductFilter")
public class SaveProductFilter implements Filter	
{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException 
	{
		System.out.println("saveProductfilter.init");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		System.out.println("saveProductfilter.dofilter");
		
//		String ProductName = request.getParameter("ProductName");
////		Integer Price = Integer.parseInt(request.getParameter("Price"));
//		String Price = request.getParameter("Price");
//		String Category = request.getParameter("Category");
////		Integer Qty = Integer.parseInt(request.getParameter("Qty"));
//		String Qty = request.getParameter("Qty");
//		
//		
//		boolean iserror = false;
//		String ragProductName = "[a-zA-Z]+";
//		String ragPrice = "[0-9]+";
//		
//		if(ProductName== null || ProductName.trim().length() == 0) 
//		{
//			iserror = true;
//			request.setAttribute("ProductNameError","Please Enter valid FirstName");
//		}
//		if(Price== null || Price.trim().length() == 0 || Price.matches(ragPrice) == false )
//		{
//			iserror = true;
//			request.setAttribute("PriceError","Please Enter valid Price");
//		}
//		if(Category== null || Category.trim().length() == 0 || Category.matches(ragProductName) == false)
//		{
//			iserror = true;
//			request.setAttribute("CategoryError","Please Enter valid Category");
//		}
//		if(Qty== null || Qty.trim().length() == 0 || Qty.matches(ragPrice) == false )
//		{
//			iserror = true;
//			request.setAttribute("QtyError","Please Enter valid Qty");
//		}
//		
//		
//		if (iserror == true)
//		{
//			request.getRequestDispatcher("InputProduct.jsp").forward(request, response);
//		} 
//		else
//		{
//			chain.doFilter(request, response);
//		}
		
	}
	
	@Override
	public void destroy()
	{
		System.out.println("saveProductfilter.destroy");
	}
		
}
