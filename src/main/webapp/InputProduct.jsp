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
		String ProductNameError = (String)request.getAttribute("ProductNameError");
		String PriceError = (String)request.getAttribute("PriceError");
		String CategoryError = (String)request.getAttribute("CategoryError");
		String QtyError = (String)request.getAttribute("QtyError");
	%>
	<h2>Add New Product</h2>
	<form action="SaveProductServlet" method="post">
		Product Name : <input type="text" name="ProductName"/> <%=ProductNameError==null?"":ProductNameError%> <br><br>
		Price : <input type="text" name="Price"/> <%=PriceError==null?"":PriceError%> <br><br>
		Category : <input type="text" name="Category"/> <%=CategoryError==null?"":CategoryError%> <br><br>
		Qty : <input type="text" name="Qty"/>  <%=QtyError==null?"":QtyError%> <br><br>
		
		<input type="submit" value="Save Product"/>
	</form>
</body>
</html>