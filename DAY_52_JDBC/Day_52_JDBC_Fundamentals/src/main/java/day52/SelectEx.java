package day52;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectEx {

    
    private static final String SQL = "SELECT * FROM employees ";

    public static void main(String[] args) throws SQLException {

        Connection con = null;
        Statement stmt = null;
        ResultSet result = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DBConnection.getConnection();
            stmt = con.createStatement();
            result = stmt.executeQuery(SQL);
            
            while(result.next()) {
            	System.out.println(
                        result.getInt("employee_id") +
                        " | " +
                        result.getString("first_name") +
                        " | " +
                        result.getString("last_name") +
                        " | " +
                        result.getDouble("salary")
                );
            }
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	if(result != null) {
        		result.close();
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