package com.cdac.java;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Welcome extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = (String) request.getAttribute("username");
        
        
        
        if (name != null) {
        	
        	response.setContentType("text/html");
        	PrintWriter out = response.getWriter();
            out.print("<h1>Welcome user " + name + "</h1>");
        	RequestDispatcher dispatcher = request.getRequestDispatcher("Welcome.html");
        
        	dispatcher.include(request, response);
           
            
            
            
            
            
        } else {
        	
        	RequestDispatcher dispatcher = request.getRequestDispatcher("error.html");
        	
            dispatcher.include(request, response);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.print("<h2> You have Typed wrong password or Username </h2>");
        }
    }
}
