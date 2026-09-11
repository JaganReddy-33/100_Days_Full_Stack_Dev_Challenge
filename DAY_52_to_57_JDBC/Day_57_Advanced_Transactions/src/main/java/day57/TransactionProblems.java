package day57;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TransactionProblems {

    private static final String BALANCE_QUERY =
            "SELECT balance FROM accounts WHERE account_id = ?";

    private static final String UPDATE_BALANCE =
            "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

    private static final String WITHDRAW_QUERY =
            "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";

    public static void safeDeposit()
            throws ClassNotFoundException, SQLException {

        try (Connection con = ConnectionEx.getConnection();
             Scanner sc = new Scanner(System.in)) {

            con.setAutoCommit(false);

            System.out.println("Enter account ID: ");
            int accountId = sc.nextInt();

            System.out.println("Enter deposit amount: ");
            double amount = sc.nextDouble();

            if (amount <= 0) {
                System.out.println("Invalid deposit amount.");
                con.rollback();
                return;
            }

            try (PreparedStatement stmt =
                         con.prepareStatement(UPDATE_BALANCE)) {

                stmt.setDouble(1, amount);
                stmt.setInt(2, accountId);

                int rows = stmt.executeUpdate();

                if (rows != 1) {
                    throw new SQLException("Deposit failed.");
                }
            }

            con.commit();

            System.out.println("Deposit committed successfully.");
            System.out.println("Deposited Amount: " + amount);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public static void safeWithdrawal()
            throws ClassNotFoundException, SQLException {

        try (Connection con = ConnectionEx.getConnection();
             Scanner sc = new Scanner(System.in)) {

            con.setAutoCommit(false);

            System.out.println("Enter account ID: ");
            int accountId = sc.nextInt();

            double balance;

            try (PreparedStatement stmt =
                         con.prepareStatement(BALANCE_QUERY)) {

                stmt.setInt(1, accountId);

                try (ResultSet rs = stmt.executeQuery()) {

                    if (!rs.next()) {
                        System.out.println("Account not found.");
                        con.rollback();
                        return;
                    }

                    balance = rs.getDouble("balance");
                }
            }

            System.out.println("Current Balance: " + balance);

            System.out.println("Enter withdrawal amount: ");
            double amount = sc.nextDouble();

            if (amount <= 0) {
                System.out.println("Invalid withdrawal amount.");
                con.rollback();
                return;
            }

            if (amount > balance) {
                System.out.println("Insufficient balance.");
                con.rollback();
                return;
            }

            try (PreparedStatement stmt =
                         con.prepareStatement(WITHDRAW_QUERY)) {

                stmt.setDouble(1, amount);
                stmt.setInt(2, accountId);

                int rows = stmt.executeUpdate();

                if (rows != 1) {
                    throw new SQLException("Withdrawal failed.");
                }
            }

            con.commit();

            System.out.println("Withdrawal committed successfully.");
            System.out.println("Remaining Balance: "
                    + (balance - amount));

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public static void failedTransaction()
            throws ClassNotFoundException, SQLException {

        try (Connection con = ConnectionEx.getConnection();
             Scanner sc = new Scanner(System.in)) {

            con.setAutoCommit(false);

            System.out.println("Enter account ID: ");
            int accountId = sc.nextInt();

            System.out.println("Enter deposit amount: ");
            double amount = sc.nextDouble();

            if (amount <= 0) {
                System.out.println("Invalid amount.");
                con.rollback();
                return;
            }

            try (PreparedStatement stmt =
                         con.prepareStatement(UPDATE_BALANCE)) {

                stmt.setDouble(1, amount);
                stmt.setInt(2, accountId);

                int rows = stmt.executeUpdate();

                if (rows != 1) {
                    throw new SQLException("Account update failed.");
                }
            }

            System.out.println("First operation completed.");

            throw new SQLException(
                    "Simulated failure after balance update."
            );

        } catch (SQLException e) {

            System.out.println("Transaction failed.");
            System.out.println("Rollback required.");
            e.printStackTrace();
        }
    }

    public static void multipleUpdates()
            throws ClassNotFoundException, SQLException {

        try (Connection con = ConnectionEx.getConnection();
             Scanner sc = new Scanner(System.in)) {

            con.setAutoCommit(false);

            System.out.println("Enter first account ID: ");
            int firstId = sc.nextInt();

            System.out.println("Enter second account ID: ");
            int secondId = sc.nextInt();

            System.out.println("Enter amount: ");
            double amount = sc.nextDouble();

            if (amount <= 0) {
                System.out.println("Invalid amount.");
                con.rollback();
                return;
            }

            try (PreparedStatement stmt =
                         con.prepareStatement(UPDATE_BALANCE)) {

                stmt.setDouble(1, amount);
                stmt.setInt(2, firstId);

                int firstRows = stmt.executeUpdate();

                if (firstRows != 1) {
                    throw new SQLException("First account update failed.");
                }

                stmt.setDouble(1, amount);
                stmt.setInt(2, secondId);

                int secondRows = stmt.executeUpdate();

                if (secondRows != 1) {
                    throw new SQLException("Second account update failed.");
                }
            }

            con.commit();

            System.out.println("Both account updates committed.");

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public static void transactionWithRollback()
            throws ClassNotFoundException, SQLException {

        try (Connection con = ConnectionEx.getConnection();
             Scanner sc = new Scanner(System.in)) {

            con.setAutoCommit(false);

            System.out.println("Enter account ID: ");
            int accountId = sc.nextInt();

            System.out.println("Enter amount: ");
            double amount = sc.nextDouble();

            if (amount <= 0) {
                System.out.println("Invalid amount.");
                con.rollback();
                return;
            }

            try (PreparedStatement stmt =
                         con.prepareStatement(UPDATE_BALANCE)) {

                stmt.setDouble(1, amount);
                stmt.setInt(2, accountId);

                int rows = stmt.executeUpdate();

                if (rows != 1) {
                    throw new SQLException("Update failed.");
                }
            }

            System.out.println("Balance updated inside transaction.");

            con.rollback();

            System.out.println("Rollback executed.");
            System.out.println("Balance update was not committed.");

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}