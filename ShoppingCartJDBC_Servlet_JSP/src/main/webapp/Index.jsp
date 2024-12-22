<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ page import="java.util.ArrayList" %>
<%@ page import="in.sp.backend.Product" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product List</title>
</head>
<body>
    <h2>Available Products</h2>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        <%
            // Retrieve the list of products passed by ProductListServlet
            ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("prod");
            if (products != null) {
                for (Product product : products) {
        %>
        <tr>
            <td><%= product.getName() %></td>
            <td><%= product.getPrice() %></td>
            <td>
                <form action="addToCart" method="post">
                    <input type="hidden" name="productId" value="<%= product.getId() %>">
                    <button type="submit">Add to Cart</button>
                </form>
            </td>
        </tr>
        <% 
                }
            } else { 
        %>
        <tr>
            <td colspan="3">No products available.</td>
        </tr>
        <% } %>
    </table>
    <br>
    <a href="viewCart">View Cart</a>
</body>
</html>