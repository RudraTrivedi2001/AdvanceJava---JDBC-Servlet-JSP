<%@ page import="java.util.ArrayList" %>
<%@ page import="dac.Product" %>

<!DOCTYPE html>
<html>
<head>
    <title>Shopping Cart</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        .cart-item {
            display: flex;
            align-items: center;
            border-bottom: 1px solid #ddd;
            padding: 15px 0;
        }
        .cart-item img {
            width: 100px;
            height: 100px;
            object-fit: cover;
            margin-right: 15px;
        }
        .cart-container {
            max-width: 900px;
            margin: auto;
        }
    </style>
</head>
<body class="container mt-5">
    <div class="cart-container">
        <h1 class="text-center mb-4">Your Cart</h1>

        <%
            ArrayList<Product> cartItems = (ArrayList<Product>) session.getAttribute("cart");
            double total = 0.0;
            
            if (cartItems != null && !cartItems.isEmpty()) {
        %>

        <div class="list-group">
            <%
                for (Product product : cartItems) {
                    total += product.getPrice();
            %>
            <div class="cart-item list-group-item">
                <img src="<%= product.getImageUrl() != null ? product.getImageUrl() : "images/default-product.jpg" %>" 
                     alt="<%= product.getName() %>">
                <div>
                    <h5><%= product.getName() %></h5>
                    <p>Price: Rs. <%= product.getPrice() %></p>
                </div>
            </div>
            <% } %>
        </div>

        <div class="text-end mt-4">
            <h4>Total: Rs. <%= total %></h4>
        </div>

        <div class="text-center mt-4">
            <a href="checkout" class="btn btn-primary btn-lg">Proceed to Checkout</a>
            <a href="<%= request.getContextPath() %>/Index.jsp" class="btn btn-secondary btn-lg">Continue Shopping</a>
        </div>

        <%
            } else {
        %>
        <p class="text-center text-danger mt-5">Your cart is empty.</p>
        <div class="text-center">
            <a href="<%= request.getContextPath() %>/Index.jsp" class="btn btn-outline-primary">Return to Home</a>
        </div>
        <%
            }
        %>
    </div>
</body>
</html>
