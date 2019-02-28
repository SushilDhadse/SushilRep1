package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CurrencyConverter
 */
@WebServlet("/Currency.Converter")
public class CurrencyConverter extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CurrencyConverter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String from=request.getParameter("fromCurrency");
		String to=request.getParameter("toCurrency");
		double amount=Double.parseDouble(request.getParameter("amount"));
		double result=0;
		if(from.equals("USD")&&to.equals("INR"))
			result=amount*72.72;
		else if(from.equals("INR")&&to.equals("USD"))
			result=amount/71.71;
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
		out.println("<h1>Result of conversion:"+result+"</h1>");
		out.println("</body></html>");
	
	}

}
