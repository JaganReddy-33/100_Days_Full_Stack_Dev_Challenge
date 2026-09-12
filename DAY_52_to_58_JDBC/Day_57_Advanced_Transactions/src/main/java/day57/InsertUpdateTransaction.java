package day57;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertUpdateTransaction {

    private static final String UPDATE_ACCOUNT =
            "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

    private static final String INSERT_HISTORY =
            "INSERT INTO transaction_history "
            + "(account_id, transaction_type, amount, transaction_status) "
            + "VALUES (?, ?, ?, ?)";

    public static void depositWithTransactionHistory() throws ClassNotFoundException, SQLException {

        try (Connection con = ConnectionEx.getConnection();
             Scanner sc = new Scanner(System.in)) {

            con.setAutoCommit(false);

            System.out.println("Enter account ID: ");
            int accountId = sc.nextInt();

            System.out.println("Enter deposit amount: ");
            double amount = sc.nextDouble();

            if (amount <= 0) {
                System.out.println("Invalid deposit amount!");
                con.rollback();
                return;
            }

            try (PreparedStatement updateStmt = con.prepareStatement(UPDATE_ACCOUNT);
                 PreparedStatement insertStmt = con.prepareStatement(INSERT_HISTORY)) {

                updateStmt.setDouble(1, amount);
                updateStmt.setInt(2, accountId);

                int updateRows = updateStmt.executeUpdate();

                if (updateRows != 1) {
                    throw new SQLException("Account update failed.");
                }

                System.out.println("Account balance updated successfully.");

                insertStmt.setInt(1, accountId);
                insertStmt.setString(2, "DEPOSIT");
                insertStmt.setDouble(3, amount);
                insertStmt.setString(4, "SUCCESS");

                int insertRows = insertStmt.executeUpdate();

                if (insertRows != 1) {
                    throw new SQLException("Transaction history insertion failed.");
                }

                System.out.println("Transaction history inserted successfully.");

                con.commit();

                System.out.println("Transaction committed successfully.");
                System.out.println("Deposit Amount: " + amount);

            } catch (SQLException e) {

                con.rollback();

                System.out.println("Transaction failed.");
                System.out.println("Account update and history insertion rolled back.");
                System.out.println("Reason: " + e.getMessage());
            }
        }
    }
}