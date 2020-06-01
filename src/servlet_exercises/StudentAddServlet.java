package servlet_exercises;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import data_access.StudentDAO;
import model.Student;

/**
 * Servlet implementation class StudentAddServlet
 */
@WebServlet("/addStudent")
public class StudentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("application/json"); 
		response.setCharacterEncoding("UTF-8");
		
		
		StudentDAO studentDAO = new StudentDAO();
		
		String idText = request.getParameter("id");
		String firstNameText = request.getParameter("firstname");
		String lastNameText = request.getParameter("lastname");
		String streetaddressText = request.getParameter("street");
		
		String postcodeText = request.getParameter("postcode");
		String postofficeText = request.getParameter("postoffice");
		
		int studentId = -1;
		int postcode = -1;
		
		if (idText != null) {
			try {
				studentId = Integer.parseInt(idText);
			} catch (Exception ex) { }
		}
		
		if (postcodeText != null) {
			try {
				postcode = Integer.parseInt(postcodeText);
			} catch (Exception ex) { }
		}
		
		Student newStudent = new Student(studentId, firstNameText, lastNameText, streetaddressText, postcode, postofficeText);

		int returnInt = studentDAO.insertStudent(newStudent);
		String message = " ";
		
		
		if(returnInt == 0) {
			message = ("Student data added!");
		} else if(returnInt == 1) {
			message = ("Cannot add the student "+ studentId + " The id is already existed....");
		} else if(returnInt == -1) {
			message = ("The database is temporarily unavailable. Please try again later...");
		}
		
		
		Gson gson = new Gson();
		String json = gson.toJson(newStudent);
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
