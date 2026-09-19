package day56;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Question5 {

    private static final String BALANCE_QUERY =
            "SELECT balance FROM accounts WHERE account_id = ?";

    private static final String TRANSFER_QUERY =
            "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

    public static void completeTransactionAndVerify() throws SQLException, ClassNotFoundException {

        int accountId;
        double amount;

        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("Enter account ID: ");
            accountId = sc.nextInt();

            System.out.println("Enter deposit amount: ");
            amount = sc.nextDouble();
        }

        if (amount <= 0) {
            System.out.println("Invalid deposit amount!");
            return;
        }

        try (Connection con = ConnectionEx.getConnection();
             PreparedStatement stmt = con.prepareStatement(TRANSFER_QUERY)) {

            con.setAutoCommit(false);

            stmt.setDouble(1, amount);
            stmt.setInt(2, accountId);

            int rows = stmt.executeUpdate();

            if (rows != 1) {

                con.rollback();

                System.out.println("Transaction failed and rolled back.");

                return;
            }

            con.commit();

            System.out.println("Transaction committed successfully.");
        }

        try (Connection con = ConnectionEx.getConnection();
             PreparedStatement stmt = con.prepareStatement(BALANCE_QUERY)) {

            stmt.setInt(1, accountId);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {

                    double balance = rs.getDouble("balance");

                    System.out.println("Verified Balance: " + balance);

                } else {

                    System.out.println("Account not found during verification.");
                }
            }
        }
    }
}