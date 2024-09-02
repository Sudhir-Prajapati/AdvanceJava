<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2> Successfully Registration...</h2>
	<%
		String StudentName = (String)request.getAttribute("StudentName");
		String PlayerType = (String)request.getAttribute("PlayerType");
	%>
	
	Student Name is : <%=StudentName%> <br>
	Player Type is : <%=PlayerType %>
</body>
</html>