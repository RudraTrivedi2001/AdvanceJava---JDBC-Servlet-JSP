package dac;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

public class ViewCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<Product> cart = (ArrayList<Product>) session.getAttribute("cart"); // Retrieve cart as Product objects
        ArrayList<Product> cartItems = new ArrayList<>();

        if (cart != null) {
            cartItems.addAll(cart); // Add all products from the cart to cartItems
        }
        
        request.setAttribute("cartItems", cartItems);
        RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
        rd.forward(request, response);
    }
}