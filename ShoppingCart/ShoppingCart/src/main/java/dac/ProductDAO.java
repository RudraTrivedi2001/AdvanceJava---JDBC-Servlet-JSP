package dac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {
    public ArrayList<Product> getproduct() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletjdbc", "root", "Abhishek@25");

        String query = "SELECT * FROM products";
        PreparedStatement pmt = con.prepareStatement(query);
        ResultSet rs = pmt.executeQuery();
        
        ArrayList<Product> al = new ArrayList<>();
        while (rs.next()) {
            Product p = new Product();
            p.setId(rs.getInt(1));
            p.setName(rs.getString(2));
            p.setPrice(rs.getDouble(3));
            p.setImageUrl(rs.getString(4));  // Fetch image URL from the database
            al.add(p);
        }
        return al;
    }
}
