package day57;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Scanner;

public class SavepointBasics {

    private static final String UPDATED_QUERY =
            "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

    public static void savepointExample() throws ClassNotFoundException, SQLException {

        try (Connection con = ConnectionEx.getConnection();
             PreparedStatement stmt = con.prepareStatement(UPDATED_QUERY);
             Scanner sc = new Scanner(System.in)) {

            con.setAutoCommit(false);

            System.out.println("Enter account ID: ");
            int id = sc.nextInt();

            System.out.println("Enter first deposit amount: ");
            double amount1 = sc.nextDouble();

            if (amount1 <= 0) {
                System.out.println("Invalid first deposit amount!");
                con.rollback();
                return;
            }

            stmt.setDouble(1, amount1);
            stmt.setInt(2, id);

            int rows1 = stmt.executeUpdate();

            if (rows1 != 1) {
                con.rollback();
                System.out.println("First deposit failed.");
                return;
            }

            System.out.println(rows1 + " Row affected!");
            System.out.println("First deposit executed successfully.");

            Savepoint sp1 = con.setSavepoint("AFTER_FIRST_DEPOSIT");

            System.out.println("Savepoint created after first deposit.");

            try {

                System.out.println("Enter second deposit amount: ");
                double amount2 = sc.nextDouble();

                if (amount2 <= 0) {
                    con.rollback(sp1);
                    con.commit();
                    System.out.println("Invalid second deposit amount.");
                    System.out.println("Rolled back to savepoint.");
                    return;
                }

                stmt.setDouble(1, amount2);
                stmt.setInt(2, id);

                int rows2 = stmt.executeUpdate();

                if (rows2 != 1) {
                    throw new SQLException("Second deposit failed.");
                }

                con.commit();

                System.out.println("Second deposit executed successfully.");
                System.out.println("Both deposits committed to the database!");

            } catch (SQLException e) {

                con.rollback(sp1);
                con.commit();

                System.out.println("Second deposit failed.");
                System.out.println("Rolled back to savepoint.");
                System.out.println("First deposit remains committed.");

            }
        }
    }
}