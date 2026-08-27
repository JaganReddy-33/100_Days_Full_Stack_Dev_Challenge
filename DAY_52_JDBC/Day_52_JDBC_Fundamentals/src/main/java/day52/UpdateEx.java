package day52;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateEx {

    
    private static final String SQL = "UPDATE employees " +
            "SET salary = salary + 5000 " +
            "WHERE employee_id = 101";

    public static void main(String[] args) throws SQLException {

        Connection con = null;
        Statement stmt = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DBConnection.getConnection();
            stmt = con.createStatement();
            int rows = stmt.executeUpdate(SQL);
            System.out.println(rows + " row updated!");
            
            
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