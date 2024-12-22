package in.sp.backend;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;




public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	String name = request.getParameter("name");
	
	String email = request.getParameter("email");
	
	long number = Long.parseLong(request.getParameter("number"));
	
	Person p = new Person(name, email, number);
	
	
	
	PersonDAO pd = new PersonDAO();
	try {
		boolean register = pd.addPerson(p);
		if (register) 
		{
			response.sendRedirect("success.html");
		}
		else 
		{
          PrintWriter out = response.getWriter();
          out.print("<h1> Error while Registering </h1> ");
		}
		
	} catch (ClassNotFoundException | SQLException e) {
		PrintWriter out = response.getWriter();
        out.print("<h1> Error while Registering </h1> ");
	}
	
	
	
	
		
		
	}

}
