package day56;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.util.Scanner;

public class Question6 {

    private static final String UPDATE_BALANCE =
            "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

    public static void savepointTransaction() throws SQLException, ClassNotFoundException {

        try (Connection con = ConnectionEx.getConnection();
             PreparedStatement stmt = con.prepareStatement(UPDATE_BALANCE);
             Scanner sc = new Scanner(System.in)) {

            con.setAutoCommit(false);

            System.out.println("Enter account ID: ");
            int accountId = sc.nextInt();

            System.out.println("Enter first deposit amount: ");
            double amount1 = sc.nextDouble();

            if (amount1 <= 0) {
                System.out.println("Invalid amount!");
                con.rollback();
                return;
            }

            stmt.setDouble(1, amount1);
            stmt.setInt(2, accountId);

            int rows1 = stmt.executeUpdate();

            if (rows1 != 1) {
                con.rollback();
                System.out.println("First operation failed!");
                return;
            }

            System.out.println("First operation completed.");

            Savepoint savepoint = con.setSavepoint("AFTER_FIRST_DEPOSIT");

            System.out.println("Savepoint created.");

            System.out.println("Enter second deposit amount: ");
            double amount2 = sc.nextDouble();

            if (amount2 <= 0) {
                System.out.println("Second amount is invalid.");
                con.rollback(savepoint);
                System.out.println("Rolled back to savepoint.");
            } else {

                stmt.setDouble(1, amount2);
                stmt.setInt(2, accountId);

                int rows2 = stmt.executeUpdate();

                if (rows2 != 1) {
                    con.rollback(savepoint);
                    System.out.println("Second operation failed.");
                    System.out.println("Rolled back to savepoint.");
                } else {
                    System.out.println("Second operation completed.");
                }
            }

            con.commit();

            System.out.println("Transaction committed successfully.");
        }
    }
}