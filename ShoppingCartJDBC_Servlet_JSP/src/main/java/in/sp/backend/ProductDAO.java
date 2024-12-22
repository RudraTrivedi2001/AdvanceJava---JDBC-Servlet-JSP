package in.sp.backend;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class ProductDAO 
{

	public ArrayList<Product> getproduct() throws ClassNotFoundException, SQLException
	{
		
		 String url = "jdbc:mysql://localhost:3306/company"; 
	        String username = "root";                        
	        String password = "root"; 
		Class.forName("com.mysql.cj.jdbc.Driver");
	 	
		Connection con =DriverManager.getConnection(url, username,password);
		
		String query = " select * from product";
		PreparedStatement pmt=con.prepareStatement(query);
		ResultSet rs = pmt.executeQuery();
		ArrayList<Product> al =new ArrayList<>();
		
		while(rs.next())
		{
			Product p = new Product();
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setPrice(rs.getFloat(3));
			al.add(p);
		    
			 
		}
		return al;
		
		 
		
		
		
		
	
	}
	
	
}

