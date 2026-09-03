package day53;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Question8 {
    
	private static final String SQL = "SELECT project_id, project_name, employee_id, start_date, end_date, budget FROM projects WHERE employee_id = ?";
    
	public static void runQuestion8() {
        try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter employee ID: ");
			int empId = sc.nextInt();
			
			try (Connection con = ConnectionEx.getConnection();
			     PreparedStatement stmt = con.prepareStatement(SQL)) {
				
			    stmt.setInt(1, empId);
			    
			    try (ResultSet result = stmt.executeQuery()) {
			        boolean dataFound = false;
			        while (result.next()) {
			            dataFound = true;
			            Project project = new Project(
			                    result.getInt("project_id"),
			                    result.getString("project_name"),
			                    result.getInt("employee_id"),
			                    result.getDate("start_date"),
			                    result.getDate("end_date"),
			                    result.getDouble("budget")
			            );
			            System.out.println(project);
			        }
			        if (!dataFound) {
			            System.out.println("No projects found for Employee ID: " + empId);
			        }
			    }
			    
			} catch (SQLException e) {
			    e.printStackTrace();
			} catch (ClassNotFoundException e) {
			    e.printStackTrace();
			}
		}
    }
}