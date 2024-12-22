package com.JDBC.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewDatabaseData {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/company"; // 'company' is the database name
        String username = "root";                          // MySQL username
        String password = "root";                          // MySQL password

        // Step 1: Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");  // Required for older versions of Java, ensures the driver is loaded
        System.out.println("MySQL JDBC driver loaded successfully");

        // Step 2: Establish the connection to the database
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Connected to the database");

        // Step 3: Prepare the SQL SELECT query
        // The query will fetch all columns from the 'employee' table
        String selectQuery = "SELECT * FROM employee";

        // Step 4: Create a PreparedStatement object to execute the query
        PreparedStatement ps = con.prepareStatement(selectQuery);

        // Step 5: Execute the query and retrieve the results
        ResultSet rs = ps.executeQuery();

        // Display the results
        System.out.println("Employee Data:");
        while (rs.next()) {
            // Step 6: Extract data from the ResultSet
            // Get employee ID, name, and salary from the result set
            int id = rs.getInt("empID");
            String name = rs.getString("empName");
            float salary = rs.getFloat("empSal");

            // Step 7: Print the employee details
            System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
        }

        // Step 8: Close resources to release database connections
        rs.close();  // Close the ResultSet
        ps.close();  // Close the PreparedStatement
        con.close(); // Close the Connection
        System.out.println("Database connection closed");
    }
}
