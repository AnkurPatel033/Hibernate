package com.xwokrz.loginapp.component;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xwokrz.loginapp.connection.DBConnection;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 4L;

	Connection con = null;
	PreparedStatement pstms = null;
	RequestDispatcher rd=null;


	public RegisterServlet() {
	
		System.out.println("Created /t:"+this.getClass().getSimpleName());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String uname = request.getParameter("username");
		String email = request.getParameter("email");
		String phno = request.getParameter("phoneno");
		String password = request.getParameter("pass");
		String address = request.getParameter("add");

		System.out.println("username:" + uname + "email:" + email + "phno:" + phno + "password:" + password + "address:"
				+ address);

		con = DBConnection.getConnection();

		try {
			pstms = con.prepareStatement("insert into register_tbl values( ?,?, ?,?,?)");
			pstms.setString(1, uname);
			pstms.setString(2, email);
			pstms.setString(3, phno);
			pstms.setString(4, password);
			pstms.setString(5, address);

			int i = pstms.executeUpdate();

			if (i != 0) {
				System.out.println("Sucessfully inserted..Record in DB");
				rd=request.getRequestDispatcher("Login.jsp");

			} else {
				System.out.println("Record is NOT inserted in DB");
				rd=request.getRequestDispatcher("Register.jsp");
			}
			
			rd.forward(request, response);

		} catch (SQLException e) {

			e.printStackTrace();

		} 

	}

}
