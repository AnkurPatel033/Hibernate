package com.xwokrz.loginapp.connection;

import java.sql.*;

public class DBConnection {

	
	public static Connection getConnection() {
		
		System.out.println("Starting DB Connection Class...");
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/19thorv03", "root", "root");
             System.out.println("Connection object sent to calling method()..");
			return con;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Closing DB Connection Class...");
		return null;	
	}
}
