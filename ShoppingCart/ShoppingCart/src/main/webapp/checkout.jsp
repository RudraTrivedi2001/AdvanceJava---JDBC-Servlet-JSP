<!DOCTYPE html>
<html>
<head>
    <title>Checkout Success</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5 text-center">
    <h1 class="text-success">Thank You for Your Order!</h1>
    <p>Your order has been placed successfully.</p>
    <a href="<%= request.getContextPath() %>/Index.jsp" class="btn btn-primary mt-4">Return to Store</a>
</body>
</html>
