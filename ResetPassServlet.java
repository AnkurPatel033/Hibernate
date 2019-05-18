package com.xwokrz.loginapp.component;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xwokrz.loginapp.connection.DBConnection;


@WebServlet("/ResetPassServlet")
public class ResetPassServlet extends HttpServlet {
	private static final long serialVersionUID = 5L;
       
    public ResetPassServlet() {
    	System.out.println("Created /t:"+this.getClass().getSimpleName());
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("remail");
		String oldpass=request.getParameter("curpass");
		String newpass=request.getParameter("rnewpass");
		RequestDispatcher rd = null;
		Connection con=null;
		
		System.out.println("Email:"+email+"Old Pass:"+oldpass+"New Pass:"+newpass);
		try {
		con=DBConnection.getConnection();
		
		PreparedStatement st=con.prepareStatement("update register_tbl set password=? where email=? and password=?");
		st.setString(1,newpass);
		st.setString(2,email);
		st.setString(3,oldpass);
		
		int i=st.executeUpdate();
		if(i!=0)
		{
			System.out.println("Sucessfully Update password..");

			rd=request.getRequestDispatcher("Login.jsp");
		}
		
		}
		catch (Exception e) {
			System.out.println("Error:"+e.getMessage());
			
		}
		
		rd.forward(request, response);
		
		
	}

}
