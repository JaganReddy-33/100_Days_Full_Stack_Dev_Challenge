package day54;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Question2 {
	
    private static final String SQL = "INSERT INTO employees (employee_id, "
    		+ "first_name, last_name, gender, age, email, phone, "
    		+ "department_id, salary, joining_date, city, "
    		+ "experience_years) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public static void runQuestion2() {
		try(Connection con = ConnectionEx.getConnection();
				PreparedStatement stmt = con.prepareStatement(SQL);
				Scanner sc = new Scanner(System.in)){
			
			System.out.println("How many employees do you want to add?");
			int n =sc.nextInt();
			sc.nextLine();
			
			
			for(int i=0; i<n; i++) {
                System.out.println("\n--- Entering details for Employee "+(i+1) +" ---");
				
				System.out.println("Enter Employee_Id");
				int id = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter Employee FirstName");
				String firstName = sc.nextLine();
				
				System.out.println("Enter Employee lastName");
				String lastName = sc.nextLine();
				
				System.out.println("Enter Gender");
				String gender = sc.nextLine();
				
				System.out.println("Enter age");
				int age = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter email");
				String email = sc.nextLine();
				
				System.out.println("Enter phone number");
				String phone = sc.nextLine();
				
				System.out.println("Enter Department ID");
				int dept = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter Salary");
				Double salary = sc.nextDouble();
				sc.nextLine();
				
				System.out.println("Enter Joining Data (YYYY-MM-DD");
				String date = sc.nextLine();
				java.sql.Date joiningDate = java.sql.Date.valueOf(date);
				
				System.out.println("Enter City: ");
				String city = sc.nextLine();

				System.out.println("Enter Experience Years: ");
				int expYears = sc.nextInt();
				sc.nextLine(); 
				
				stmt.setInt(1, id);
	            stmt.setString(2, firstName);
	            stmt.setString(3, lastName);
	            stmt.setString(4, gender);
	            stmt.setInt(5, age);
	            stmt.setString(6, email);
	            stmt.setString(7, phone);
	            stmt.setInt(8, dept);
	            stmt.setDouble(9, salary);
	            stmt.setDate(10, joiningDate);
	            stmt.setString(11, city);
	            stmt.setInt(12, expYears);
	            
	            stmt.addBatch();
			}
			
			int[] result = stmt.executeBatch();
			int totalCount = 0;
			for(int count : result) {
				if(count >= 0) {
					totalCount += count;
				}
			}
			System.out.println("Batch execution completed! "+totalCount+" rows affected!");
			
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

