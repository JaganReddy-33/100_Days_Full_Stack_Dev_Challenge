package day57;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TransactionValidation {

    private static final String BALANCE_QUERY =
            "SELECT balance FROM accounts WHERE account_id = ?";

    private static final String DEBIT_QUERY =
            "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";

    private static final String CREDIT_QUERY =
            "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

    public static void validatedTransfer() throws ClassNotFoundException, SQLException {

        try (Connection con = ConnectionEx.getConnection();
             Scanner sc = new Scanner(System.in)) {

            con.setAutoCommit(false);

            System.out.println("Enter sender account ID: ");
            int senderId = sc.nextInt();

            System.out.println("Enter receiver account ID: ");
            int receiverId = sc.nextInt();

            System.out.println("Enter transfer amount: ");
            double amount = sc.nextDouble();

            if (amount <= 0) {
                System.out.println("Invalid transfer amount!");
                con.rollback();
                return;
            }

            if (senderId == receiverId) {
                System.out.println("Sender and receiver accounts cannot be the same.");
                con.rollback();
                return;
            }

            double senderBalance;

            try (PreparedStatement stmt = con.prepareStatement(BALANCE_QUERY)) {

                stmt.setInt(1, senderId);

                try (ResultSet rs = stmt.executeQuery()) {

                    if (!rs.next()) {
                        System.out.println("Sender account not found!");
                        con.rollback();
                        return;
                    }

                    senderBalance = rs.getDouble("balance");
                }
            }

            System.out.println("Sender Balance: " + senderBalance);

            try (PreparedStatement stmt = con.prepareStatement(BALANCE_QUERY)) {

                stmt.setInt(1, receiverId);

                try (ResultSet rs = stmt.executeQuery()) {

                    if (!rs.next()) {
                        System.out.println("Receiver account not found!");
                        con.rollback();
                        return;
                    }
                }
            }

            if (amount > senderBalance) {
                System.out.println("Insufficient sender balance!");
                con.rollback();
                return;
            }

            try (PreparedStatement debitStmt = con.prepareStatement(DEBIT_QUERY);
                 PreparedStatement creditStmt = con.prepareStatement(CREDIT_QUERY)) {

                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, senderId);

                int debitRows = debitStmt.executeUpdate();

                if (debitRows != 1) {
                    throw new SQLException("Sender debit operation failed.");
                }

                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, receiverId);

                int creditRows = creditStmt.executeUpdate();

                if (creditRows != 1) {
                    throw new SQLException("Receiver credit operation failed.");
                }

                con.commit();

                System.out.println("Transaction committed successfully.");
                System.out.println("Transferred Amount: " + amount);
                System.out.println("Remaining Sender Balance: "
                        + (senderBalance - amount));

            } catch (SQLException e) {

                con.rollback();

                System.out.println("Transaction failed.");
                System.out.println("Entire transaction rolled back.");
                System.out.println("Reason: " + e.getMessage());
            }
        }
    }
}