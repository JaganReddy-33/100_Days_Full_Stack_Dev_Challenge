package day54;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Question6 {
    private static final String SQL = "UPDATE employees "
    		+ "SET salary = salary + ? "
    		+ "WHERE department_id = ?";
    
    public static void runQuestion6() {
    	
        try (Connection con = ConnectionEx.getConnection();
             PreparedStatement stmt = con.prepareStatement(SQL);
             Scanner sc = new Scanner(System.in)) {
        	
            System.out.println("How many department salary updates do you want to add?");
            int n = sc.nextInt();
            
            for (int i = 1; i <= n; i++) {
                System.out.println("\n--- Department " + i + " ---");
                System.out.println();
                
                System.out.print("Enter Department ID: ");
                int dept = sc.nextInt();
                
                System.out.print("Enter Bonus Amount: ");
                double bonus = sc.nextDouble();
                
                stmt.setDouble(1, bonus);
                stmt.setInt(2, dept);
                
                stmt.addBatch();
            }
            
            int[] result = stmt.executeBatch();
            
            int totalCount = 0;
            for (int count : result) {
                if (count >= 0) {
                    totalCount += count;
                }
            }
            
            System.out.println("\nBatch execution completed!");
            System.out.println(totalCount + " rows updated!");
            
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
