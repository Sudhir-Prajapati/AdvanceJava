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
		ResultSet rs = (ResultSet) request.getAttribute("rs");
	%>

	<h2>List Product</h2>
		
		<table border="1">
			<tr>
				<th>ProductName</th>
				<th>Categoty</th>
				<th>Price</th>
				<th>Qty</th>
			</tr>
		
		<%
			while(rs.next())
			{
				String pname = rs.getString("productName");
				String category = rs.getString("category");
				Integer price = rs.getInt("price");
				Integer qty = rs.getInt("qty");
				
				out.print("<tr>");
				
				out.print("<td>"+pname+"</td>");
				out.print("<td>"+category+"</td>");
				out.print("<td>"+price+"</td>");
				out.print("<td>"+qty+"</td>");
				
				out.print("</tr>");
					
			}
		%>
	
	</table>

</body>
</html>