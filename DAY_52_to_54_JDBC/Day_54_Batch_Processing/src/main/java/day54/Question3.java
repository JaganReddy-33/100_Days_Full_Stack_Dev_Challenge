package day54;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Question3 {
	private static final String SQL = "UPDATE employees SET salary = salary + ? "
			+ "WHERE employee_id = ? ";
	public static void runQuestion3() {
		
		try(Connection con = ConnectionEx.getConnection();
				PreparedStatement stmt = con.prepareStatement(SQL);
				Scanner sc = new Scanner(System.in);){
			
			System.out.println("How many Employees Salaries you want to Update? ");
			int n = sc.nextInt();
			sc.nextLine();
			
			for(int i=1; i<=n; i++) {
				System.out.println("Enter employee "+ i + " Details below ---");
				
				System.out.println("Enter Employee ID: ");
				int id = sc.nextInt();
				
				System.out.println("Enter Employee bonus Salary: ");
				Double salary = sc.nextDouble();
				sc.nextLine();
				
				stmt.setDouble(1, salary);
				stmt.setInt(2, id);
				
				stmt.addBatch();
			}
			
			int[] result = stmt.executeBatch();
			
			int totalCount = 0;
			for(int count : result) {
				if(count >= 0) {
					totalCount += count;
				}
			}
			System.out.println(totalCount + " rows affected!");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

