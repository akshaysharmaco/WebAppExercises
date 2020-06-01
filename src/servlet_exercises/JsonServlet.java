package servlet_exercises;

import com.google.gson.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class JsonServlet
 */
@WebServlet("/jsontest")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		PrintWriter out = response.getWriter();
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
	
			List<Student> studentList = new ArrayList<Student>();
			
			studentList.add(new Student(50, "Akshay", " Sharma", " Peltokylantie 3 ", 00740, " HELSINKI"));
			
			Gson gson = new Gson();
			String json = gson.toJson(studentList);
			out.print(json);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
