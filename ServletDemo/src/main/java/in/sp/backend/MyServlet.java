
package in.sp.backend;

// Importing required Java libraries for I/O and servlet functionality.
import java.io.IOException;
import java.io.PrintWriter;

// Importing servlet-specific classes from the Jakarta Servlet API.
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Declaring a servlet class that extends HttpServlet.
// HttpServlet provides methods for handling HTTP requests (e.g., GET, POST).
public class MyServlet extends HttpServlet {

    // Overriding the doGet() method to handle HTTP GET requests.
    // This method is invoked automatically when a GET request is made to the servlet.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        // Getting the PrintWriter object to send a response back to the client.
        PrintWriter out = resp.getWriter();

        // Writing a simple response to the client.
        // This content will be displayed in the browser or HTTP client.
        out.print("I am inside the doGet method");

        // This will display in console
        System.out.println("I am inside the doGet method");
    }
}
