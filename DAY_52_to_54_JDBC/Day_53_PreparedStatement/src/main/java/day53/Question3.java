package day53;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class Question3 {
	
	private static final String SQL = "UPDATE `employees` SET city = ? , phone = ? WHERE employee_id = ? ";
	
	public static void runQuestion3() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("---- Updating your details ----");
			System.out.println();
			
			System.out.println("Enter your updated city: ");
			String city = sc.nextLine();
			
			System.out.println("Enter your updated phone: ");
			String phone = sc.nextLine();
			
			System.out.println("Enter your employee ID: ");
			int id = sc.nextInt();
			
			Employee emp = new Employee(city, phone, id);
			
			try(Connection con = ConnectionEx.getConnection();
					PreparedStatement stmt = con.prepareStatement(SQL)){
				
				stmt.setString(1, emp.getCity());
				stmt.setString(2, emp.getPhone());
				stmt.setInt(3, emp.getEmployeeId());
				
				int i = stmt.executeUpdate();
				System.out.println(i+ " Rows affected!");
				System.out.println("Updated Successfully!");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
