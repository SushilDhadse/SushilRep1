package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.service.DBInfoService;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("ename");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		DBInfoService loginservice =new DBInfoService();
		
		boolean isValid = loginservice.isValidEmp(username);
		Employee e1=loginservice.empDetails(username);
		
		HttpSession session=request.getSession();
		
	if(isValid){
		
		session.setAttribute("valid",username);
			Employee e2=loginservice.empDetails(username);
		    session.setAttribute("name",e2.getName());
			session.setAttribute("email",e2.getEmail());
		    session.setAttribute("salary",e2.getSalary());
			session.setAttribute("date",e2.getDate());
		    session.setAttribute("phone_number",e2.getPhone_number());

			response.sendRedirect("Emp.jsp");
		} else {
			
			session.setAttribute("invalid","Employee Not Found");
			response.sendRedirect("UserInput.jsp");

		}
	}

	/*@Override  //code mailed by soham on 26/2/19  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empId = Integer.parseInt(request.getParameter("empId"));
		
		EmployeeService employeeService = new EmployeeService();
		Employee emp = employeeService.getEmployeeDetails(empId);
		
		HttpSession session = request.getSession();
		session.setAttribute("employeeData", emp);
		
		response.sendRedirect("searchEmpResult.jsp");
	}*/
	
}
