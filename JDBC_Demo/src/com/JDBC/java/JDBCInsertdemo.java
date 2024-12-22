package com.JDBC.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// This class demonstrates inserting data into a MySQL database using JDBC
public class JDBCInsertdemo {

    // JDBC programs are always written inside a method, typically the main method
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

        // Step 3: Prepare the SQL INSERT query
        // The table 'employee' should already exist in the 'company' database with columns: empID, empName, empSal
        String insertQuery = "INSERT INTO employee(empID, empName, empSal) VALUES (?, ?, ?)";
        // The '?' placeholders will be replaced with actual values later

        // Step 4: Create a PreparedStatement object to send the query
        PreparedStatement ps = con.prepareStatement(insertQuery);

        // Step 5: Provide values for the placeholders in the query
        String name = "John Doe";  // Name of the employee
        int id = 21;               // Unique employee ID
        float empsal = 93000;      // Employee's salary

        ps.setInt(1, id);          // Sets the 1st placeholder to 'id'
        ps.setString(2, name);     // Sets the 2nd placeholder to 'name'
        ps.setFloat(3, empsal);    // Sets the 3rd placeholder to 'empsal'

        // Step 6: Execute the query
        // executeUpdate() is used for INSERT, UPDATE, DELETE queries as they modify the database
        int rowsInserted = ps.executeUpdate();

        // Step 7: Check if data was inserted successfully
        if (rowsInserted > 0) {
            System.out.println("Data Inserted Successfully"); // Success message
        } else {
            System.out.println("Problem occurred while inserting data"); // Failure message
        }

        // Step 8: Close resources to release database connections
        ps.close();   // Close the PreparedStatement object
        con.close();  // Close the Connection object
    }
}
