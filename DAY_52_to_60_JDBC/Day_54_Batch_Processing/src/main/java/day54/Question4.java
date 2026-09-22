package day54;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Question4 {
    private static final String SQL = "DELETE FROM employees WHERE employee_id = ?";

    public static void runQuestion4() {
    	
        try (Connection con = ConnectionEx.getConnection();
             PreparedStatement stmt = con.prepareStatement(SQL);
             Scanner sc = new Scanner(System.in)) {

            System.out.println("How many employees do you want to delete?");
            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 1; i <= n; i++) {
                System.out.println("Enter "+(i==1 ? i+"st" : i==2 ? i+"nd" : i==3 ? i+"rd" : i+"th")+" Employee ID to delete: ");
                int id = sc.nextInt();
                sc.nextLine();

                stmt.setInt(1, id);
                stmt.addBatch();
            }

            int[] result = stmt.executeBatch();
            int totalDeleted = 0;
            for (int count : result) {
                if (count >= 0) {
                    totalDeleted += count;
                } else if (count == PreparedStatement.SUCCESS_NO_INFO) {
                    totalDeleted++;
                }
            }

            System.out.println("Batch execution complete. Total rows deleted: " + totalDeleted);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
