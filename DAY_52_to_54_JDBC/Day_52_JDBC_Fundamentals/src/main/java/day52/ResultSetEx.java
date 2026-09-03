package day52;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetEx {

    
    private static final String SQL = "SELECT * FROM employees ";

    public static void main(String[] args) throws SQLException {

        Connection con = null;
        Statement stmt = null;
        ResultSet res = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DBConnection.getConnection();
            stmt = con.createStatement();
            res = stmt.executeQuery(SQL);
            
            System.out.println("┌───────┬──────────┬──────────┬────────┬─────┬─────────────────────┬──────────┬─────────┬───────────┬──────────────┬───────────────┬────────────┐");
			
			System.out.printf("│ %-5s │ %-8s │ %-8s │ %-6s │ %-3s │ %-19s │ %-8s │ %-7s │ %-9s │ %-12s │ %-13s │ %-10s │%n", 
					"ID", "First", "Last", "Gender", "Age", "Email", "Phone", "Dept ID", "Salary", "Join Date", "City", "Experience");
			
			System.out.println("├───────┼──────────┼──────────┼────────┼─────┼─────────────────────┼──────────┼─────────┼───────────┼──────────────┼───────────────┼────────────┤");
			
			while(res.next()) {
				System.out.printf("│ %-5d │ %-8s │ %-8s │ %-6s │ %-3d │ %-19s │ %-8s │ %-7d │ %-9.2f │ %-12s │ %-13s │ %-10d │%n",
						res.getInt("employee_id"),
						res.getString("first_name"),
						res.getString("last_name"),
						res.getString("gender"),
						res.getInt("age"),
						res.getString("email"),
						res.getString("phone"),
						res.getInt("department_id"),
						res.getDouble("salary"),
						res.getDate("joining_date") != null ? res.getDate("joining_date").toString() : "N/A",
						res.getString("city"),
						res.getInt("experience_years")
				);
			}
			System.out.println("└───────┴──────────┴──────────┴────────┴─────┴─────────────────────┴──────────┴─────────┴───────────┴──────────────┴───────────────┴────────────┘");
			   
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	if(res != null) {
        		res.close();
        	}
        	if (stmt != null) {
        		stmt.close();
        	}
        	if (con != null) {
        		con.close();
        	} 
        }
    }
}