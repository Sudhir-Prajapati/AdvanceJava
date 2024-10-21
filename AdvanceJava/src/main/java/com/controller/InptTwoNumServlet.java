package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InptTwoNumServlet extends HttpServlet
{
	public void serveic(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		String no1 = request.getParameter("no1");
		String no2 = request.getParameter("no2");
		Boolean isError = false;
		String mes = "";
		if (no1==null || no1.trim().length() == 0)
		{
			isError = true;
			mes = "Please Enter NO1.";
		}
		if (no2==null||no2.trim().length() == 0)
		{
			isError = true;
			mes += "Please Enter NO2";
		}
		
		if (isError)
		{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print(mes);
		}
		else
		{
			Integer number1 = Integer.parseInt(no1);
			Integer number2 = Integer.parseInt(no2);
			
			if (number1>number2)
			{
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print(number1+">"+number2);
			} 
			else 
			{
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print(number2+">"+number1);
			}
		}
	}
}