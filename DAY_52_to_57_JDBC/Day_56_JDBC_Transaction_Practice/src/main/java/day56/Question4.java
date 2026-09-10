package day56;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Question4 {

    private static final String BALANCE_QUERY =
            "SELECT balance FROM accounts WHERE account_id = ?";

    private static final String DEBIT_QUERY =
            "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";

    private static final String CREDIT_QUERY =
            "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

    public static void rollbackOnBusinessFailure() throws SQLException, ClassNotFoundException {

        try (Connection con = ConnectionEx.getConnection();
             Scanner sc = new Scanner(System.in)) {

            con.setAutoCommit(false);

            System.out.println("Enter sender account ID: ");
            int senderId = sc.nextInt();

            System.out.println("Enter receiver account ID: ");
            int receiverId = sc.nextInt();

            System.out.println("Enter amount: ");
            double amount = sc.nextDouble();

            if (amount <= 0) {
                System.out.println("Amount must be greater than zero.");
                con.rollback();
                return;
            }

            double balance;

            try (PreparedStatement stmt = con.prepareStatement(BALANCE_QUERY)) {

                stmt.setInt(1, senderId);

                try (ResultSet rs = stmt.executeQuery()) {

                    if (!rs.next()) {
                        System.out.println("Sender account does not exist.");
                        con.rollback();
                        return;
                    }

                    balance = rs.getDouble("balance");
                }
            }

            if (amount > balance) {
                System.out.println("Insufficient balance.");
                con.rollback();
                return;
            }

            try (PreparedStatement stmt = con.prepareStatement(BALANCE_QUERY)) {

                stmt.setInt(1, receiverId);

                try (ResultSet rs = stmt.executeQuery()) {

                    if (!rs.next()) {
                        System.out.println("Receiver account does not exist.");
                        con.rollback();
                        return;
                    }
                }
            }

            try (PreparedStatement debitStmt = con.prepareStatement(DEBIT_QUERY);
                 PreparedStatement creditStmt = con.prepareStatement(CREDIT_QUERY)) {

                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, senderId);

                int debitRows = debitStmt.executeUpdate();

                if (debitRows != 1) {
                    con.rollback();
                    System.out.println("Debit failed. Transaction rolled back.");
                    return;
                }

                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, receiverId);

                int creditRows = creditStmt.executeUpdate();

                if (creditRows != 1) {
                    con.rollback();
                    System.out.println("Credit failed. Transaction rolled back.");
                    return;
                }

                con.commit();

                System.out.println("Transaction completed successfully.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}