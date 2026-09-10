package day52;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertEx {

    
    private static final String SQL = "INSERT INTO employees " +
            "(employee_id, first_name, last_name, gender, age, " +
            "email, phone, department_id, salary, joining_date, " +
            "city, experience_years) " +
            "VALUES " +
            "(106, 'Robert', 'Taylor', 'Male', 29, " +
            "'robert.t@email.com', '555-0106', 2, 70000.00, " +
            "'2025-05-10', 'San Francisco', 4)";

    public static void main(String[] args) throws SQLException {

        Connection con = null;
        Statement stmt = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DBConnection.getConnection();
            stmt = con.createStatement();
            int rows = stmt.executeUpdate(SQL);
            System.out.println(rows + " row inserted!");
            
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	if (stmt != null) {
        		stmt.close();
        	}
        	if (con != null) {
        		con.close();
        	} 
        }
    }
}