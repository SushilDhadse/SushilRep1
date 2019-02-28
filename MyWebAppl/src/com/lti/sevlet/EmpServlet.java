package com.lti.sevlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/emp.xls")
public class EmpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("application/vnd.ms-excel");
		PrintWriter out=response.getWriter();
		
		out.println("EMPNO\tNAME\tSALARY");
		out.println("1001\tAKSHAY\t1000");
		out.println("1002\tSUSHIL\t2000");
		out.println("1003\tRAM\t3000");
		out.println("1004\tCRYBABY\t0000");
	}

}
