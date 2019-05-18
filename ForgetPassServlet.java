package com.xwokrz.loginapp.component;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForgetPassServlet
 */
@WebServlet("/ForgetPassServlet")
public class ForgetPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ForgetPassServlet() {
       System.out.println("Created /t:"+this.getClass().getSimpleName());
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		
		System.out.println("New Password is sent to your email id:"+email);
		
		RequestDispatcher rd;
		rd=request.getRequestDispatcher("Login.jsp");
		rd.forward(request, response);
	}

}
