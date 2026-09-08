package day53;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Question5 {

    private static final String SQL =
            "SELECT employee_id, first_name, last_name, " +
            "department_id, salary, city, experience_years " +
            "FROM employees " +
            "WHERE employee_id = ?";

    public static void runQuestion5() {

        try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Employee ID:");
			int id = sc.nextInt();

			try ( Connection con = ConnectionEx.getConnection();
					PreparedStatement stmt = con.prepareStatement(SQL) ) {
				
				stmt.setInt(1, id);

			    try (ResultSet res = stmt.executeQuery()) {

			        if (res.next()) {
			            Employee employee = new Employee( res.getInt("employee_id"), res.getString("first_name"), res.getString("last_name"), res.getInt("department_id"),
			            		res.getDouble("salary"), res.getString("city"), res.getInt("experience_years"));

			            System.out.println(employee);
			        } else {
			            System.out.println("No Employee Found with ID: " + id);
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