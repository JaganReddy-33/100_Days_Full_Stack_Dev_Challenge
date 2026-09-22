package day56;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Question1 {

    private static final String BALANCE_CHECK =
            "SELECT balance FROM accounts WHERE account_id = ?";

    private static final String DEBIT_QUERY =
            "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";

    public static void basicDebitTransaction() throws ClassNotFoundException, SQLException {

        try (Connection con = ConnectionEx.getConnection();
             PreparedStatement stmt1 = con.prepareStatement(BALANCE_CHECK);
             Scanner sc = new Scanner(System.in)) {

            con.setAutoCommit(false);

            System.out.println("Enter account ID: ");
            int id = sc.nextInt();
            stmt1.setInt(1, id);

            
            try (ResultSet res = stmt1.executeQuery()) {

                double balance;
                if (res.next()) {
                    balance = res.getDouble("balance");
                    System.out.println("Existing Balance is: " + balance);
                } else {
                    System.out.println("Account not found!");
                    con.rollback();
                    return;
                }

                System.out.println("Enter amount how much do you want to withdraw: ");
                double amount = sc.nextDouble();

                if (amount <= 0) {
                    System.out.println("Invalid withdrawal amount!");
                    con.rollback();
                    return;
                }

                if (amount > balance) {
                    System.out.println("Insufficient Balance!");
                    con.rollback();
                    return;
                }

                try (PreparedStatement stmt2 = con.prepareStatement(DEBIT_QUERY)) {

                    stmt2.setDouble(1, amount);
                    stmt2.setInt(2, id);

                    int rows = stmt2.executeUpdate();

                    if (rows == 1) {
                        con.commit();
                        System.out.println("Withdrawal successful!");
                        System.out.println("Withdrawn Amount: " + amount);
                        System.out.println("Remaining Balance: " + (balance - amount));
                    } else {
                        con.rollback();
                        System.out.println("Withdrawal failed!");
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}