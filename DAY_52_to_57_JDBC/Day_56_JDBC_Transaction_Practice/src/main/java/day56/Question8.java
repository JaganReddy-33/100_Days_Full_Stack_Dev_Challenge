package day56;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Question8 {

    private static final String BALANCE_QUERY =
            "SELECT balance FROM accounts WHERE account_id = ?";

    private static final String UPDATE_QUERY =
            "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

    public static void transactionStateVerification() throws SQLException, ClassNotFoundException {

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

        double balanceBefore;

        try (Connection con = ConnectionEx.getConnection();
             PreparedStatement balanceStmt = con.prepareStatement(BALANCE_QUERY);
             PreparedStatement updateStmt = con.prepareStatement(UPDATE_QUERY)) {

            con.setAutoCommit(false);

            balanceStmt.setInt(1, accountId);

            try (ResultSet rs = balanceStmt.executeQuery()) {

                if (!rs.next()) {
                    System.out.println("Account not found.");
                    con.rollback();
                    return;
                }

                balanceBefore = rs.getDouble("balance");
            }

            System.out.println("Balance Before Transaction: " + balanceBefore);

            updateStmt.setDouble(1, amount);
            updateStmt.setInt(2, accountId);

            int rows = updateStmt.executeUpdate();

            if (rows != 1) {
                con.rollback();
                System.out.println("Update failed.");
                return;
            }

            System.out.println("Update completed.");

            balanceStmt.setInt(1, accountId);

            try (ResultSet rs = balanceStmt.executeQuery()) {

                if (rs.next()) {
                    double balanceInsideTransaction =
                            rs.getDouble("balance");

                    System.out.println(
                            "Balance Inside Transaction: "
                                    + balanceInsideTransaction);
                }
            }

            con.commit();

            System.out.println("Transaction committed.");
        }

        try (Connection con = ConnectionEx.getConnection();
             PreparedStatement stmt = con.prepareStatement(BALANCE_QUERY)) {

            stmt.setInt(1, accountId);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {

                    double finalBalance = rs.getDouble("balance");

                    System.out.println(
                            "Balance After New Connection: "
                                    + finalBalance);

                } else {

                    System.out.println(
                            "Account not found during verification.");
                }
            }
        }
    }
}