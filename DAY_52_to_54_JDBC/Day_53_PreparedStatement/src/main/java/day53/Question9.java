package day53;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Question9 {
	
	private static final String SQL = "SELECT e.employee_id, e.first_name, e.last_name, e.salary, d.department_name, d.location "
			+ "FROM employees e "
			+ "JOIN departments d "
			+ "ON e.department_id = d.department_id ";
	
	public static void runQuestion9() {
		
		try(Connection con = ConnectionEx.getConnection();
				PreparedStatement stmt = con.prepareStatement(SQL)) {
			ResultSet res = stmt.executeQuery();
			
			System.out.println("--------------------------------------------------------------------------");
			System.out.printf("| %-5s | %-12s | %-12s | %-18s | %-12s | %-12s \n", "emp_id", "first_name", "last_name", "department_name", "location", "salary");
			System.out.println("--------------------------------------------------------------------------");
			while(res.next()) {
				System.out.printf("| %-5d | %-12s | %-12s | %-18s | %-12s | %-12.2f \n",
						res.getInt("employee_id"),
						res.getString("first_name"),
						res.getString("last_name"),
						res.getString("department_name"),
						res.getString("location"),
						res.getDouble("salary")
				);
			}
			System.out.println("--------------------------------------------------------------------------");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} 
	}
}
