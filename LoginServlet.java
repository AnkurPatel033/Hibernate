package com.xwokrz.loginapp.component;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xwokrz.loginapp.connection.DBConnection;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 3L;

	Connection con = null;
	Statement stms = null;

	RequestDispatcher rd = null;

	public LoginServlet() {
		System.out.println("Created /t:" + this.getClass().getSimpleName());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("pass");

		System.out.println("email:" + email + "password:" + password);

		try {
			con = DBConnection.getConnection();

			stms = con.createStatement();
			 ResultSet rs;
			 int res = 0;
			PreparedStatement st = con.prepareStatement("select count(email) from register_tbl where email= ? and password=? ");
			st.setString(1, email);
			st.setString(2, password);
			ResultSet k;
			rs.next();
			 st.getResultSet();
			 k = st.executeQuery();
			
			 while(rs!=null) {
				
				res =  rs.getInt(1);
			 }
			System.out.println("Record Found:" + k);
			if (res == 1) {
				System.out.println("Sucessfully Login...");
				System.out.println("email:" + email + "password:" + password);
				rd = request.getRequestDispatcher("Home.jsp");

			} else {
				System.out.println("Credentials are wrongs...");
				rd = request.getRequestDispatcher("Login.jsp");
			}

			rd.forward(request, response);

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

}
