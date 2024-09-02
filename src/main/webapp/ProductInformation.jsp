<%@page import="java.sql.ResultSet"%>
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
		ResultSet rs = (ResultSet)request.getAttribute("rs");
	%>
	
	
	<table>
		<tr>
			<th>ProductName</th>
			<th>Categoty</th>
			<th>Price</th>
			<th>Qty</th>
		</tr>
		
		<%
			while(rs.next())
			{
				String Pname = rs.getString("productName");
				String category = rs.getString("category");
				Integer price = rs.getInt("price");
				Integer qty = rs.getInt("qty");
				
				out.print("<tr>");
					out.print("<td>"+Pname+"</td>");
					out.print("<td>"+category+"</td>");
					out.print("<td>"+price+"</td>");
					out.print("<td>"+qty+"</td>");
				out.print("</tr>");
			}
		%>
	</table>
</body>
</html>