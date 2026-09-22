package day56;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Question3 {

    private static final String BALANCE_QUERY =
            "SELECT balance FROM accounts WHERE account_id = ?";

    private static final String DEBIT_QUERY =
            "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";

    private static final String CREDIT_QUERY =
            "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

    public static void bankTransfer() throws SQLException, ClassNotFoundException {

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

            double senderBalance;

            try (PreparedStatement balanceStmt = con.prepareStatement(BALANCE_QUERY)) {

                balanceStmt.setInt(1, senderId);

                try (ResultSet rs = balanceStmt.executeQuery()) {

                    if (!rs.next()) {
                        System.out.println("Sender account not found!");
                        con.rollback();
                        return;
                    }

                    senderBalance = rs.getDouble("balance");
                }
            }

            if (amount > senderBalance) {
                System.out.println("Insufficient balance!");
                con.rollback();
                return;
            }

            try (PreparedStatement receiverStmt = con.prepareStatement(BALANCE_QUERY)) {

                receiverStmt.setInt(1, receiverId);

                try (ResultSet rs = receiverStmt.executeQuery()) {

                    if (!rs.next()) {
                        System.out.println("Receiver account not found!");
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
                    System.out.println("Debit failed!");
                    return;
                }

                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, receiverId);

                int creditRows = creditStmt.executeUpdate();

                if (creditRows != 1) {
                    con.rollback();
                    System.out.println("Credit failed!");
                    return;
                }

                con.commit();

                System.out.println("Transfer successful!");
                System.out.println("Transferred Amount: " + amount);
                System.out.println("Remaining Sender Balance: " + (senderBalance - amount));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}