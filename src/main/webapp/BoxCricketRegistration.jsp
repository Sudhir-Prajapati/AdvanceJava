<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		String StudentNameError = (String)request.getAttribute("StudentNameError"); //object
		String playerTypeError = (String)request.getAttribute("PlayerTypeError");
		
		String StudentNameValue = (String)request.getAttribute("StudentNameValue");
		String PlayerTypeValue = (String)request.getAttribute("PlayerTypeValue");
	%> 
	<form action="BoxCricketRegistrationServlet" method="post">
		Student Name : <input type="text" name="StudentName" value="<%=StudentNameValue==null?"":StudentNameValue %>"/> 
		<%= StudentNameError==null?"":StudentNameError %>
		 <br><br>
		
		PlayerType : <select name="PlayerType">	
						<option value=""> Please Select Your Skill </option>
						<option value="Batter" <%=PlayerTypeValue!=null&&PlayerTypeValue.contains("Batter")?"selected":""%> > Batter </option>
						<option value="Bowler" <%=PlayerTypeValue!=null&&PlayerTypeValue.contains("Bowler")?"selected":""%> >Bowler</option>
						<option value="AllRounder" <%=PlayerTypeValue!=null&&PlayerTypeValue.equals("AllRounder")?"selected":"" %> >All Rounder</option>
					</select>
					<%=playerTypeError==null?"":playerTypeError%>
					<br><br>
		<input type="submit" value="Register"/>
	</form>
</body>
</html>