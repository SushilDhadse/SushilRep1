package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.service.DBLoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.page")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("uid");
		String password = request.getParameter("pass");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		DBLoginService loginservice =new DBLoginService();
		
		boolean isValid = loginservice.isValidUser(username,password);
		
		String fname = loginservice.fName( username);
		HttpSession session=request.getSession();
		if(isValid){
		
			session.setAttribute("loggedInUser",username);
			
			session.setAttribute("loggedfname", fname);
			
			response.sendRedirect("welcome.jsp");
		} else {
			session.setAttribute("invalid","Invalid Username/Password");
			response.sendRedirect("Login.jsp");

		}
			
/*		if (username.equals("admin") && password.equals("admin")) {
			response.sendRedirect("welcome.html");
		} else {
			response.sendRedirect("Login.html");}*/

		
	}


}
