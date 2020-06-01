package data_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Student;

public class StudentDAO {
		
	public StudentDAO() {
		// In Tomcat 8 environment, the JDBC driver must be explicitly loaded as below
		try {
			Class.forName(ConnectionParameters.jdbcDriver);
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}
	}

	/**
	 * Open a new database connection
	 * 
	 * @throws SQLException
	 */
	private Connection openConnection() throws SQLException {
		return DriverManager.getConnection(ConnectionParameters.connectionString, ConnectionParameters.username,
				ConnectionParameters.password);
	}

	/**
	 * Retrieve all students from the database
	 * 
	 * @return List<Student>
	 * @throws SQLException
	 */
	public List<Student> getAllStudents() {
		
		List<Student> studentList = new ArrayList<Student>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		

		try {
			connection = openConnection();

			String sqlText = "SELECT id, firstname, lastname, streetaddress, postcode, postoffice FROM Student ORDER BY lastname";

			preparedStatement = connection.prepareStatement(sqlText);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String streetaddress = resultSet.getString("streetaddress");
				String postoffice = resultSet.getString("postoffice");
				int postcode = resultSet.getInt("postcode");
				int id = resultSet.getInt("id");

				studentList.add(new Student(id, firstname, lastname, streetaddress, postcode, postoffice));
			}

		} catch (SQLException sqle) {
			System.out.println("\n[ERROR] StudentDAO: getAllStudents() failed. " + sqle.getMessage() + "\n");
			studentList = null;

		} finally {
			DbUtils.closeQuietly(resultSet, preparedStatement, connection);
		}

		return studentList;
	
	}
	
	
	public String getAllStudentsJSON() {
		
		List<Student> studentList = new ArrayList<Student>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		

		try {
			connection = openConnection();

			String sqlText = "SELECT id, firstname, lastname, streetaddress, postcode, postoffice FROM Student ORDER BY lastname";

			preparedStatement = connection.prepareStatement(sqlText);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String streetaddress = resultSet.getString("streetaddress");
				String postoffice = resultSet.getString("postoffice");
				int postcode = resultSet.getInt("postcode");
				int id = resultSet.getInt("id");

				studentList.add(new Student(id, firstname, lastname, streetaddress, postcode, postoffice));
			}

		} catch (SQLException sqle) {
			System.out.println("\n[ERROR] StudentDAO: getAllStudents() failed. " + sqle.getMessage() + "\n");
			studentList = null;

		} finally {
			DbUtils.closeQuietly(resultSet, preparedStatement, connection);
		}

		return getAllStudentsJSON();
		
	}
	
	
	/**
	 * Retrieve all students from the given id from the database
	 * 
	 * @param givenid - the id to be used as the filter in the query
	 * @return List<Student>
	 * @throws SQLException
	 */
	public List<Student> getStudentByID(int studentID) {
		
		List<Student> studentList = new ArrayList<Student>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		

		try {
			connection = openConnection();

			String sqlText = "SELECT id, firstname, lastname, streetaddress, postcode, postoffice FROM Student WHERE id = ? ORDER BY lastname";

			preparedStatement = connection.prepareStatement(sqlText);
			preparedStatement.setInt(1, studentID);

			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String streetaddress = resultSet.getString("streetaddress");
				String postoffice = resultSet.getString("postoffice");
				int postcode = resultSet.getInt("postcode");
				int id = resultSet.getInt("id");

				studentList.add(new Student(id, firstname, lastname, streetaddress, postcode, postoffice));
			}

		} catch (SQLException sqle) {
			System.out.println("[ERROR] StudentDAO: getStudentByID() failed. " + sqle.getMessage() + "\n");
			studentList = null;

		} finally {
			DbUtils.closeQuietly(resultSet, preparedStatement, connection);
		}

		return studentList;
	}
	
	
	public int insertStudent(Student student) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = openConnection();

			String sqlText = "INSERT INTO Student (id, firstname, lastname, streetaddress, postcode, postoffice) VALUES (?, ?, ?, ?, ?, ?)";
			
			preparedStatement = connection.prepareStatement(sqlText);
			
			
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getFirstname());
			preparedStatement.setString(3, student.getLastname());
			preparedStatement.setString(4, student.getStreetaddress());
			preparedStatement.setInt(5, student.getPostcode());
			preparedStatement.setString(6, student.getPostoffice());

			preparedStatement.executeUpdate();
			
			return 0;
	

		} catch (SQLException sqle) {
				if (sqle.getErrorCode() == ConnectionParameters.PK_VIOLATION_ERROR) {
					return 1;
			} else {	
					return -1;
			}
		} finally {
			DbUtils.closeQuietly(preparedStatement, connection);
		}
		
	}
	
	
	public Student deleteStudent(int studentId) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		

		try {
			connection = openConnection();

			String sqlText = "DELETE FROM Student WHERE id = ?";
			
			preparedStatement = connection.prepareStatement(sqlText);
			
			
			preparedStatement.setInt(1, studentId);

			resultSet = preparedStatement.executeQuery();
			
	

		} catch (SQLException sqle) {
			System.out.println("\n[ERROR] Database error. " + sqle.getMessage());
		} finally {
			DbUtils.closeQuietly(resultSet, preparedStatement, connection);
		}
		return null;
		

	}
	
}
	
	
	
