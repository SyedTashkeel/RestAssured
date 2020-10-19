package DBPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class ConnectMySQL {

	@Test
	public void testDB() throws ClassNotFoundException, SQLException{
		
		//Remember Driver: com.mysql.jdbc.Driver
		
		Class.forName("com.mysql.jdbc.Driver");
		
		System.out.println("MySQL JDBC Driver Loaded");
		
		//Remember Connection URL: jdbc:mysql://hostname:port/databaseName","userName","password"
		
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/SeleniumDB","root","ZAZ#123");
		
		System.out.println("Connected to MySQL DB");
		
		Statement smt= con.createStatement();
		
		ResultSet rs= smt.executeQuery("select * from SeleniumUsers");
		
		System.out.println("DB record shows:FName:LName:Email");
		
		while (rs.next()) {
			
			String fName = rs.getString("fName");
			String lName = rs.getString("lName");
			String email = rs.getString("email");
			
			System.out.println("DB record shows:"+fName+":"+lName+":"+email);
			
		}
	}
}
