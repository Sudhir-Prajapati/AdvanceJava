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
public class EmployeeRegistrationFilter2 implements Filter
{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException 
	{
		System.out.println("EmployeeRegistrationFilter2");
		
		String firstname = request.getParameter("firstname");
//		String email = request.getParameter("email");
//		String password = request.getParameter("pass");
		String birthyear = request.getParameter("birthyear");
		
		
		
		boolean isError = false;
		String alphaRegEx = "[a-zA-Z]{2,}";
		String number = "[0-9]{4,}"; // 4--n

		
		if (firstname.matches(alphaRegEx)==false)
		{
			isError = true;
			request.setAttribute("FirstNameError","Please Enter Valid FirstName.");
		}
		if (birthyear.matches(number)==false) 
		{
			isError = true;
			request.setAttribute("birthyearError","Please Enter Valid BirthYear.");
		}
		
		
		if (isError==true)
		{
			request.getRequestDispatcher("EmployeeRegistration.jsp").forward(request, response);
		} 
		else 
		{
			chain.doFilter(request, response);
		}
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
