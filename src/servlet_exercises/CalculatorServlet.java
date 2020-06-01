package servlet_exercises;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try (PrintWriter out = response.getWriter()) {
			
			int num1 = Integer.parseInt(request.getParameter("x")); 
			int num2 = Integer.parseInt(request.getParameter("y")); 
			
			String operation = request.getParameter("operation");
			
			int result = 0;
			
			if (operation.equals("add")) {
				result = num1 + num2;
				out.print((num1) + " + " + (num2) + " = " + result);
			}
			
			else if(operation.equals("multiply")) {
				result = num1 * num2;
				out.print((num1) + " * " +(num2) + " = " + result);
			}
			
		}	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
