package in.sp.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonDAO 

{
	
	public boolean addPerson(Person p) throws ClassNotFoundException, SQLException 
	{
		String url = "jdbc:mysql://localhost:3306/company";

	        String username = "root";                          
	        String password = "root"; 
	        
	        
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        
	        Connection con = DriverManager.getConnection(url, username, password);
	        
	        
	        String insertQuery = "Insert into person (name, email, number) values (?,?,?)";
	        PreparedStatement ps = con.prepareStatement(insertQuery);
	        
	        ps.setString(1, p.name );
	        ps.setString(2, p.email );
	        ps.setLong(3, p.number );
	        
	        int rowsaff = ps.executeUpdate();
	        ps.close();
	        con.close();
	        
	        if(rowsaff>0) {
	        	return true;
	        	
	        }else {
	        	return false;
	        }
	        
		
	}

}
