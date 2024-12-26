package dac;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        HttpSession session = request.getSession();
        
        ArrayList<Product> cart = (ArrayList<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        
        // Fetch product from session (product list)
        ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("prod");
        
        for (Product p : products) {
            if (p.getId() == productId) {
                cart.add(p);
                System.out.println("Product added to cart: " + p.getName() + " | Image URL: " + p.getImageUrl());
                break;
            }
        }
        
        session.setAttribute("cart", cart);
        response.sendRedirect("viewCart");
    }
}
