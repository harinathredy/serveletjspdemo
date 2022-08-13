<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Valid Product</title>
</head>
<body>
<%= session.getAttribute("name") %> has been added with product ID: <%= session.getAttribute("id") %> and the price: <%= session.getAttribute("price") %>
</body>
</html>