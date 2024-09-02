<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Search</h2>
		
		<form action="SearchServlet" method="post">
			Enter Product Category : <input type="text" name="ProductCategory" /> <br>
			<input type="submit" value="Search"/>
		</form>
		
</body>
</html>