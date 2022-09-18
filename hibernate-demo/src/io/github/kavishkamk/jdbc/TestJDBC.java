package io.github.kavishkamk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {
	
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost/hb_student_tracker?useSSL=false&serverTimeZone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try {
			System.out.println("Connection to data connection");
			
			Connection conn = DriverManager.getConnection(url, user, pass);
			
			System.out.println("Connected Successfully");
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
	}

}
