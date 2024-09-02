<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%	String FirstNameError =(String)request.getAttribute("FirstNameError");
	String EmailError = (String)request.getAttribute("EmailError");
	String PasswordError = (String)request.getAttribute("PasswordError");
	String birthyearError = (String)request.getAttribute("birthyearError");
	
	String FirstNameValue= (String)request.getAttribute("FirstNameValue");
	String EmailValue = (String)request.getAttribute("EmailValue");
	String PasswordValue = (String)request.getAttribute("PasswordValue");
	String BirthyearValue = (String)request.getAttribute("BirthyearValue");
	%>
	<form action="EmployeeRegistrationServlet" method="post">
	
		FirstName : <input type="text" name="firstname" value="<%= FirstNameValue==null?"":FirstNameValue %>" /> 
		<%= FirstNameError==null?"":FirstNameError %><br>
		Email : <input type="email"  name="email" value="<%= EmailValue==null?"":EmailValue %>" />
		<%=EmailError==null?"":EmailError %><br>
		Password : <input type="password" name="pass" value="<%= PasswordValue==null?"":PasswordValue %>" />
		<%=PasswordError==null?"":PasswordError %><br>
		BirthYear : <input type="number" name="birthyear" value="<%= BirthyearValue==null?"":BirthyearValue %>" />
		<%=birthyearError==null?"":birthyearError%><br>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>