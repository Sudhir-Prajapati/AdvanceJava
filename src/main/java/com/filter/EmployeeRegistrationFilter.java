package com.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/EmployeeRegistrationServlet")
public class EmployeeRegistrationFilter implements Filter
{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("EmployeeRegistrationFilter::init()");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException 
	{
		System.out.println("EmployeeRegistrationFilter::doFilter()");
		
		
		String firstname = request.getParameter("firstname");
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		String birthyear = request.getParameter("birthyear");
		
		request.setAttribute("FirstNameValue",firstname);
		request.setAttribute("EmailValue",email);
		request.setAttribute("PasswordValue", password);
		request.setAttribute("BirthyearValue", birthyear);
		
		Boolean isError = false;
		
		if (firstname == null || firstname.trim().length() == 0)
		{
			isError = true;
			request.setAttribute("FirstNameError","Please Enter FirstName.");
		}
		if (email == null || email.trim().length() == 0)
		{
			isError = true;
			request.setAttribute("EmailError","Please Enter Email.");
		}
		if (password == null || password.trim().length() == 0)
		{
			isError = true;
			request.setAttribute("PasswordError","Please Enter Password.");
		}
		if (birthyear == null || birthyear.trim().length() == 0)
		{
			request.setAttribute("birthyearError","Please Enter BirthYear.");
		}
		
		
		if (isError==true) 
		{
			//back		
			request.getRequestDispatcher("EmployeeRegistration.jsp").forward(request, response);
		}
		else
		{
			//forward
			chain.doFilter(request, response);
		}
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("EmployeeRegistrationFilter::destroy()");
	}
}
