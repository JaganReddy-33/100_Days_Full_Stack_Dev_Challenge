package day53;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Question1 {
	
	private static final String SQL_INSERT = "INSERT INTO employees (employee_id, first_name, last_name, gender, age, email, "
			+ "phone, department_id, salary, joining_date, city, experience_years) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public static void runQuestion1() {
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("=== Enter Employee Details ===");
			
			System.out.println("Enter Employee ID: ");
			int id = sc.nextInt();
			sc.nextLine(); 

			System.out.println("Enter First Name: ");
			String fName = sc.nextLine();

			System.out.println("Enter Last Name: ");
			String lName = sc.nextLine();

			System.out.println("Enter Gender: ");
			String gender = sc.nextLine();

			System.out.println("Enter Age: ");
			int age = sc.nextInt();
			sc.nextLine(); 

			System.out.println("Enter Email: ");
			String email = sc.nextLine();

			System.out.println("Enter Phone: ");
			String phone = sc.nextLine();

			System.out.println("Enter Department ID: ");
			int deptId = sc.nextInt();
			sc.nextLine(); 

			System.out.println("Enter Salary: ");
			double salary = sc.nextDouble();
			sc.nextLine(); 

			System.out.println("Enter Joining Date (YYYY-MM-DD): ");
			String dateStr = sc.nextLine();
			java.sql.Date joiningDate = java.sql.Date.valueOf(dateStr);

			System.out.println("Enter City: ");
			String city = sc.nextLine();

			System.out.println("Enter Experience Years: ");
			int expYears = sc.nextInt();
			sc.nextLine(); 

			Employee emp = new Employee( id, fName, lName, gender, age, email, 
				phone, deptId, salary, joiningDate, city, expYears );

			try (Connection con = ConnectionEx.getConnection();
				 PreparedStatement stmt = con.prepareStatement(SQL_INSERT)) {

				stmt.setInt(1, emp.getEmployeeId());
				stmt.setString(2, emp.getFirstName());
				stmt.setString(3, emp.getLastName());
				stmt.setString(4, emp.getGender());
				stmt.setInt(5, emp.getAge());
				stmt.setString(6, emp.getEmail());
				stmt.setString(7, emp.getPhone());
				stmt.setInt(8, emp.getDepartmentId());
				stmt.setDouble(9, emp.getSalary());
				stmt.setDate(10, emp.getJoiningDate());
				stmt.setString(11, emp.getCity());
				stmt.setInt(12, emp.getExperienceYears());

				int rowsAffected = stmt.executeUpdate();
				System.out.println("\nRows affected: " + rowsAffected);
				System.out.println("Employee record inserted Successfully using ConnectionEx!");

			} catch (ClassNotFoundException e) {
				System.err.println("Database Driver missing! check your build path.");
				e.printStackTrace();
			} catch (SQLException e) {
				System.err.println("Database runtime insertion failed.");
				e.printStackTrace();
			}
		}
	}
}
