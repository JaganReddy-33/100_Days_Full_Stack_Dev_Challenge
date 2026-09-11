package day57;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExceptionTransaction {

    private static final String DEBIT_QUERY =
            "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";

    private static final String CREDIT_QUERY =
            "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

    public static void handleTransactionException()
            throws ClassNotFoundException, SQLException {

        try (Connection con = ConnectionEx.getConnection();
             Scanner sc = new Scanner(System.in)) {

            con.setAutoCommit(false);

            System.out.println("Enter account ID: ");
            int accountId = sc.nextInt();

            System.out.println("Enter debit amount: ");
            double debitAmount = sc.nextDouble();

            if (debitAmount <= 0) {
                System.out.println("Invalid debit amount.");
                con.rollback();
                return;
            }

            try (PreparedStatement debitStmt =
                         con.prepareStatement(DEBIT_QUERY)) {

                debitStmt.setDouble(1, debitAmount);
                debitStmt.setInt(2, accountId);

                int rows = debitStmt.executeUpdate();

                if (rows != 1) {
                    throw new SQLException("Debit operation failed.");
                }

                System.out.println("Debit operation successful.");
            }

            System.out.println("Transaction is still active.");

            System.out.println("Enter account ID for credit operation: ");
            int creditAccountId = sc.nextInt();

            System.out.println("Enter credit amount: ");
            double creditAmount = sc.nextDouble();

            try (PreparedStatement creditStmt =
                         con.prepareStatement(CREDIT_QUERY)) {

                creditStmt.setDouble(1, creditAmount);
                creditStmt.setInt(2, creditAccountId);

                int rows = creditStmt.executeUpdate();

                if (rows != 1) {
                    throw new SQLException("Credit operation failed.");
                }

                System.out.println("Credit operation successful.");
            }

            con.commit();

            System.out.println("Transaction committed successfully.");

        } catch (SQLException e) {

            System.out.println("Exception occurred during transaction.");
            System.out.println("Transaction rolled back.");
            e.printStackTrace();
        }
    }
}