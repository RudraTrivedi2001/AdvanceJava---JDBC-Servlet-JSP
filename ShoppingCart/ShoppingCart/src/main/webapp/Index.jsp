<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dac.Product" %>

<%
    // Redirect to fetch products if session is empty
    if (session.getAttribute("prod") == null) {
        response.sendRedirect("ProductListServlet");
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product List - Shopping Cart</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        .product-card {
            border: 1px solid #ddd;
            border-radius: 10px;
            padding: 15px;
            margin-bottom: 20px;
            transition: box-shadow 0.3s;
        }
        .product-card:hover {
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
        }
        .product-img {
            height: 250px;
            object-fit: cover;
            border-bottom: 1px solid #ddd;
            margin-bottom: 10px;
        }
        .no-products {
            margin-top: 50px;
            text-align: center;
        }
    </style>
</head>
<body class="container mt-5">
    <h1 class="text-center mb-4">Welcome to Our Store</h1>

    <div class="row">
        <%
            ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("prod");

            if (products != null && !products.isEmpty()) {
                for (Product product : products) {
        %>
        <div class="col-md-4 col-sm-6 mb-4">
            <div class="product-card text-center">
                <img src="<%= product.getImageUrl() != null ? product.getImageUrl() : "images/default-product.jpg" %>" 
                     alt="<%= product.getName() %>" 
                     class="product-img img-fluid">
                <h5><%= product.getName() %></h5>
                <p class="text-muted">Price: Rs. <%= product.getPrice() %></p>
                <form action="addToCart" method="post">
                    <input type="hidden" name="productId" value="<%= product.getId() %>">
                    <button type="submit" class="btn btn-primary w-100">Add to Cart</button>
                </form>
            </div>
        </div>
        <% 
                }
            } else {
        %>
        <div class="no-products">
            <h3>No products available at the moment.</h3>
            <a href="clearSession.jsp" class="btn btn-outline-primary mt-3">Refresh Product List</a>
        </div>
        <% } %>
    </div>

    <div class="text-center mt-5">
        <a href="viewCart" class="btn btn-success btn-lg">View Cart</a>
    </div>
</body>
</html>
