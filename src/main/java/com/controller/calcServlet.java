package com.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcServlet")
public class calcServlet extends HttpServlet
{
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		
		String no1 = request.getParameter("n1");
		String no2 = request.getParameter("no2");
		String operation = request.getParameter("Operation");
		
		boolean isError = false;
		String mess = "";
		
		if (no1 == null || no1.trim().length() == 0 )
		{
			isError = true;
			mess = "Please Enter Name1.";
		}		
		if (no2 == null || no2.trim().length()==0)
		{
			isError = true;
			mess = mess+ "Please Enter Number2";
		}
		
		
		if (operation == null)
		{
			isError = true;
			mess += "please Select Any one Operation.";
		}
		
		
		if (isError)
		{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print(mess);	
		}
		else
		{
			Integer x = Integer.parseInt(no1);
			Integer y = Integer.parseInt(no2);
			Integer ans = 0;
			
			
			if (operation.equals("+"))
			{
				ans = x+y;
			}
			else if (operation.equals("-")) 
			{
				ans = x-y;
			}
			else if (operation.equals("mul"))
			{
				ans = x*y;
			}
			else if (operation.equals("/"))
			{
				ans = x/y;
			}
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
		}
	}

	void display(){

	}
}
