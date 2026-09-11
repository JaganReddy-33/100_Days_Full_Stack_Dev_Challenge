package day57;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Scanner;

public class AccountTransaction {

    private static final String BALANCE_QUERY = "SELECT balance FROM accounts WHERE account_id = ?";

    private static final String DEBIT_QUERY = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";

    private static final String CREDIT_QUERY = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

    public static void transferWithSavepoint() throws ClassNotFoundException, SQLException {

        try (Connection con = ConnectionEx.getConnection();
             Scanner sc = new Scanner(System.in)) {

            con.setAutoCommit(false);

            System.out.println("Enter sender account ID: ");
            int senderId = sc.nextInt();

            System.out.println("Enter receiver account ID: ");
            int receiverId = sc.nextInt();

            System.out.println("Enter transfer amount: ");
            double amount = sc.nextDouble();

            if (senderId == receiverId) {
                System.out.println("Sender and receiver cannot be the same account.");
                con.rollback();
                return;
            }

            if (amount <= 0) {
                System.out.println("Invalid transfer amount.");
                con.rollback();
                return;
            }

            double senderBalance;

            try (PreparedStatement balanceStmt = con.prepareStatement(BALANCE_QUERY)) {

                balanceStmt.setInt(1, senderId);

                try (ResultSet rs = balanceStmt.executeQuery()) {

                    if (!rs.next()) {
                        System.out.println("Sender account not found.");
                        con.rollback();
                        return;
                    }

                    senderBalance = rs.getDouble("balance");
                }
            }

            System.out.println("Sender Balance: " + senderBalance);

            try (PreparedStatement balanceStmt = con.prepareStatement(BALANCE_QUERY)) {

                balanceStmt.setInt(1, receiverId);

                try (ResultSet rs = balanceStmt.executeQuery()) {

                    if (!rs.next()) {
                        System.out.println("Receiver account not found.");
                        con.rollback();
                        return;
                    }
                }
            }

            if (amount > senderBalance) {
                System.out.println("Insufficient sender balance.");
                con.rollback();
                return;
            }

            try (PreparedStatement debitStmt = con.prepareStatement(DEBIT_QUERY)) {

                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, senderId);

                int rows = debitStmt.executeUpdate();

                if (rows != 1) {
                    con.rollback();
                    System.out.println("Sender debit failed.");
                    return;
                }
            }

            System.out.println("Sender account debited successfully.");

            Savepoint savepoint = con.setSavepoint("AFTER_DEBIT");

            System.out.println("Savepoint created after debit.");

            try (PreparedStatement creditStmt = con.prepareStatement(CREDIT_QUERY)) {

                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, receiverId);

                int rows = creditStmt.executeUpdate();

                if (rows != 1) {
                    throw new SQLException("Receiver credit failed.");
                }

                System.out.println("Receiver account credited successfully.");

                con.commit();

                System.out.println("Transfer committed successfully.");
                System.out.println("Transferred Amount: " + amount);
                System.out.println("Remaining Sender Balance: "
                        + (senderBalance - amount));

            } catch (SQLException e) {

                con.rollback(savepoint);

                System.out.println("Receiver credit failed.");
                System.out.println("Rolled back to savepoint.");

                con.rollback();

                System.out.println("Entire transfer rolled back.");
            }
        }
    }
}