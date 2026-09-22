package day57;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Scanner;

public class MultipleSavepoints {

    private static final String UPDATE_QUERY =
            "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

    public static void multipleSavepointExample() throws ClassNotFoundException, SQLException {

        try (Connection con = ConnectionEx.getConnection();
             PreparedStatement stmt = con.prepareStatement(UPDATE_QUERY);
             Scanner sc = new Scanner(System.in)) {

            con.setAutoCommit(false);

            System.out.println("Enter account ID: ");
            int id = sc.nextInt();

            System.out.println("Enter first deposit amount: ");
            double amount1 = sc.nextDouble();

            if (amount1 <= 0) {
                System.out.println("Invalid first deposit amount!");
                con.rollback();
                return;
            }

            stmt.setDouble(1, amount1);
            stmt.setInt(2, id);

            int rows1 = stmt.executeUpdate();

            if (rows1 != 1) {
                con.rollback();
                System.out.println("First deposit failed.");
                return;
            }

            System.out.println("First deposit successful.");

            Savepoint sp1 = con.setSavepoint("AFTER_FIRST_DEPOSIT");

            System.out.println("Savepoint 1 created.");

            try {

                System.out.println("Enter second deposit amount: ");
                double amount2 = sc.nextDouble();

                if (amount2 <= 0) {
                    throw new SQLException("Invalid second deposit amount.");
                }

                stmt.setDouble(1, amount2);
                stmt.setInt(2, id);

                int rows2 = stmt.executeUpdate();

                if (rows2 != 1) {
                    throw new SQLException("Second deposit failed.");
                }

                System.out.println("Second deposit successful.");

                Savepoint sp2 = con.setSavepoint("AFTER_SECOND_DEPOSIT");

                System.out.println("Savepoint 2 created.");

                try {

                    System.out.println("Enter third deposit amount: ");
                    double amount3 = sc.nextDouble();

                    if (amount3 <= 0) {
                        throw new SQLException("Invalid third deposit amount.");
                    }

                    stmt.setDouble(1, amount3);
                    stmt.setInt(2, id);

                    int rows3 = stmt.executeUpdate();

                    if (rows3 != 1) {
                        throw new SQLException("Third deposit failed.");
                    }

                    System.out.println("Third deposit successful.");

                } catch (SQLException e) {

                    con.rollback(sp2);

                    System.out.println("Third deposit failed.");
                    System.out.println("Rolled back to Savepoint 2.");
                }

            } catch (SQLException e) {

                con.rollback(sp1);

                System.out.println("Second deposit failed.");
                System.out.println("Rolled back to Savepoint 1.");
            }

            con.commit();

            System.out.println("Transaction committed successfully.");
        }
    }
}