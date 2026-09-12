package day54;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Question1 {
	
    private static final String SQL = "INSERT INTO employees (employee_id, "
    		+ "first_name, last_name, gender, age, email, phone, department_id, "
    		+ "salary, joining_date, city, experience_years) "
    		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static void runQuestion1() {
		try(Connection con = ConnectionEx.getConnection();
				PreparedStatement stmt = con.prepareStatement(SQL)){
			
			stmt.setInt(1, 107);
            stmt.setString(2, "Robert");
            stmt.setString(3, "Wilson");
            stmt.setString(4, "Male");
            stmt.setInt(5, 29);
            stmt.setString(6, "robert.wilson@email.com");
            stmt.setString(7, "555-0106");
            stmt.setInt(8, 2);
            stmt.setDouble(9, 72000);
            stmt.setDate(10, java.sql.Date.valueOf("2025-06-15"));
            stmt.setString(11, "San Francisco");
            stmt.setInt(12, 4);
            stmt.addBatch();
            
            
            stmt.setInt(1, 108);
            stmt.setString(2, "Sophia");
            stmt.setString(3, "Taylor");
            stmt.setString(4, "Female");
            stmt.setInt(5, 31);
            stmt.setString(6, "sophia.taylor@email.com");
            stmt.setString(7, "555-0107");
            stmt.setInt(8, 3);
            stmt.setDouble(9, 78000);
            stmt.setDate(10, java.sql.Date.valueOf("2025-07-10"));
            stmt.setString(11, "Chicago");
            stmt.setInt(12, 6);
            stmt.addBatch();
			
            
            stmt.setInt(1, 109);
            stmt.setString(2, "Daniel");
            stmt.setString(3, "Thomas");
            stmt.setString(4, "Male");
            stmt.setInt(5, 27);
            stmt.setString(6, "daniel.thomas@email.com");
            stmt.setString(7, "555-0108");
            stmt.setInt(8, 5);
            stmt.setDouble(9, 68000);
            stmt.setDate(10, java.sql.Date.valueOf("2025-08-20"));
            stmt.setString(11, "Austin");
            stmt.setInt(12, 3);
            stmt.addBatch();
			
            int[] result = stmt.executeBatch();
            for(int count : result) {
            	System.out.println(count+" rows affected!");
            }
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
