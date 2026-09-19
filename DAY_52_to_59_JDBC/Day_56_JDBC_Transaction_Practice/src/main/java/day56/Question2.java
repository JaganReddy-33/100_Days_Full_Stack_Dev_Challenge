package day56;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Question2 {

    private static final String DEBIT_QUERY =
            "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";

    private static final String CREDIT_QUERY =
            "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

    public static void multipleOperationsTransaction() throws SQLException, ClassNotFoundException {

        try (Connection con = ConnectionEx.getConnection();
             PreparedStatement debitStmt = con.prepareStatement(DEBIT_QUERY);
             PreparedStatement creditStmt = con.prepareStatement(CREDIT_QUERY);
             Scanner sc = new Scanner(System.in)) {

            con.setAutoCommit(false);

            System.out.println("Enter source account ID: ");
            int sourceId = sc.nextInt();

            System.out.println("Enter destination account ID: ");
            int destinationId = sc.nextInt();

            System.out.println("Enter amount: ");
            double amount = sc.nextDouble();

            if (amount <= 0) {
                System.out.println("Invalid amount!");
                con.rollback();
                return;
            }

            debitStmt.setDouble(1, amount);
            debitStmt.setInt(2, sourceId);

            int debitRows = debitStmt.executeUpdate();

            if (debitRows != 1) {
                con.rollback();
                System.out.println("Debit operation failed!");
                return;
            }

            creditStmt.setDouble(1, amount);
            creditStmt.setInt(2, destinationId);

            int creditRows = creditStmt.executeUpdate();

            if (creditRows != 1) {
                con.rollback();
                System.out.println("Credit operation failed!");
                return;
            }

            con.commit();

            System.out.println("Transaction committed successfully!");
            System.out.println("Amount transferred: " + amount);

        } catch (SQLException e) {
            throw e;
        }
    }
}