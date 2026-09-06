package day52;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteEx {

    
    private static final String SQL = "DELETE FROM employees " +
            "WHERE employee_id = 106";

    public static void main(String[] args) throws SQLException {

        Connection con = null;
        Statement stmt = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DBConnection.getConnection();
            stmt = con.createStatement();
            int rows = stmt.executeUpdate(SQL);
            System.out.println(rows + " row deleted!");
            
            
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