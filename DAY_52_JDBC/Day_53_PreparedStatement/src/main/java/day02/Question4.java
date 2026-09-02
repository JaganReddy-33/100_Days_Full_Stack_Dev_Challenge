package day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Question4 {
	
	private static final String SQL = "DELETE FROM `employees` WHERE employee_id = ?";

	public static void runQuestion4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("--- Deleting your data from Database ---");
		System.out.println();
		
		System.out.println("Enter your Employee ID for Delete data: ");
		int id = sc.nextInt();
		
		
		try(Connection con = ConnectionEx.getConnection();
				PreparedStatement stmt = con.prepareStatement(SQL)){
			
			stmt.setInt(1, id);
			
			int i = stmt.executeUpdate();
			System.out.println(i+ " Rows Effected!");
			System.out.println("Deleted your Data Successfully");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
