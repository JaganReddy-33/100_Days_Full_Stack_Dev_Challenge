package day56;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Question7 {

    private static final String UPDATE_BALANCE =
            "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

    public static void exceptionRollbackTransaction() throws SQLException, ClassNotFoundException {

        try (Connection con = ConnectionEx.getConnection();
             PreparedStatement stmt = con.prepareStatement(UPDATE_BALANCE);
             Scanner sc = new Scanner(System.in)) {

            con.setAutoCommit(false);

            System.out.println("Enter account ID: ");
            int accountId = sc.nextInt();

            System.out.println("Enter deposit amount: ");
            double amount = sc.nextDouble();

            if (amount <= 0) {
                System.out.println("Invalid amount!");
                con.rollback();
                return;
            }

            stmt.setDouble(1, amount);
            stmt.setInt(2, accountId);

            int firstOperation = stmt.executeUpdate();

            if (firstOperation != 1) {
                con.rollback();
                System.out.println("First operation failed.");
                return;
            }

            System.out.println("First operation completed.");

            try {
                stmt.setDouble(1, amount);
                stmt.setInt(2, 999);

                int secondOperation = stmt.executeUpdate();

                if (secondOperation != 1) {
                    throw new SQLException("Second operation failed.");
                }

                con.commit();

                System.out.println("Transaction committed successfully.");

            } catch (SQLException e) {

                con.rollback();

                System.out.println("Exception occurred.");
                System.out.println("Entire transaction rolled back.");
                System.out.println("Reason: " + e.getMessage());
            }
        }
    }
}