package day55;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Durability {

    // Q1. Commit a Deposit and Verify Persistence
    public void commitDeposit() throws ClassNotFoundException, SQLException {

        String UPDATE_SQL = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";
        String SELECT_SQL = "SELECT balance FROM accounts WHERE account_id = ?";

        try (Connection con = ConnectionEx.getConnection();
             Scanner sc = new Scanner(System.in)) {

            con.setAutoCommit(false);

            System.out.println("Enter account id:");
            int id = sc.nextInt();

            try (PreparedStatement selectPstm = con.prepareStatement(SELECT_SQL)) {

                selectPstm.setInt(1, id);

                try (ResultSet rs = selectPstm.executeQuery()) {

                    if (!rs.next()) {
                        System.out.println("Account not found.");
                        con.rollback();
                        return;
                    }

                    double currentBalance = rs.getDouble("balance");

                    System.out.println("Current Balance: " + currentBalance);

                    System.out.println("Enter deposit amount:");
                    double amount = sc.nextDouble();

                    if (amount <= 0) {
                        System.out.println("Invalid deposit amount.");
                        con.rollback();
                        return;
                    }

                    try (PreparedStatement updatePstm = con.prepareStatement(UPDATE_SQL)) {

                        updatePstm.setDouble(1, amount);
                        updatePstm.setInt(2, id);

                        int rows = updatePstm.executeUpdate();

                        if (rows == 1) {

                            con.commit();

                            System.out.println("Deposit committed successfully.");
                            System.out.println("New Balance: "
                                    + (currentBalance + amount));
                        } else {

                            con.rollback();

                            System.out.println("Deposit failed.");
                        }
                    }
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }


    // Q2. Commit a Withdrawal and Verify Persistence
    public void commitWithdrawal() throws ClassNotFoundException, SQLException {

        String SELECT_SQL = "SELECT balance FROM accounts WHERE account_id = ?";
        String UPDATE_SQL = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";

        try (Connection con = ConnectionEx.getConnection();
             Scanner sc = new Scanner(System.in)) {

            con.setAutoCommit(false);

            System.out.println("Enter account id:");
            int id = sc.nextInt();

            double currentBalance;

            try (PreparedStatement selectPstm = con.prepareStatement(SELECT_SQL)) {

                selectPstm.setInt(1, id);

                try (ResultSet rs = selectPstm.executeQuery()) {

                    if (!rs.next()) {
                        System.out.println("Account not found.");
                        con.rollback();
                        return;
                    }

                    currentBalance = rs.getDouble("balance");
                }
            }

            System.out.println("Current Balance: " + currentBalance);

            System.out.println("Enter withdrawal amount:");
            double amount = sc.nextDouble();

            if (amount <= 0) {
                System.out.println("Invalid withdrawal amount.");
                con.rollback();
                return;
            }

            if (amount > currentBalance) {
                System.out.println("Insufficient balance.");
                con.rollback();
                return;
            }

            try (PreparedStatement updatePstm = con.prepareStatement(UPDATE_SQL)) {

                updatePstm.setDouble(1, amount);
                updatePstm.setInt(2, id);

                int rows = updatePstm.executeUpdate();

                if (rows == 1) {

                    con.commit();

                    System.out.println("Withdrawal committed successfully.");
                    System.out.println("Remaining Balance: "
                            + (currentBalance - amount));
                } else {

                    con.rollback();

                    System.out.println("Withdrawal failed.");
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }


    // Q3. Commit Transfer Between Two Accounts
    public void commitTransfer() throws ClassNotFoundException, SQLException {

        String SELECT_SQL = "SELECT balance FROM accounts WHERE account_id = ?";
        String DEBIT_SQL = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";
        String CREDIT_SQL = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

        try (Connection con = ConnectionEx.getConnection();
             Scanner sc = new Scanner(System.in)) {

            con.setAutoCommit(false);

            System.out.println("Enter source account id:");
            int sourceId = sc.nextInt();

            System.out.println("Enter destination account id:");
            int destinationId = sc.nextInt();

            if (sourceId == destinationId) {
                System.out.println("Source and destination cannot be same.");
                con.rollback();
                return;
            }

            double sourceBalance;

            try (PreparedStatement sourcePstm = con.prepareStatement(SELECT_SQL)) {

                sourcePstm.setInt(1, sourceId);

                try (ResultSet rs = sourcePstm.executeQuery()) {

                    if (!rs.next()) {
                        System.out.println("Source account not found.");
                        con.rollback();
                        return;
                    }

                    sourceBalance = rs.getDouble("balance");
                }
            }

            System.out.println("Source Account Balance: " + sourceBalance);

            try (PreparedStatement destinationPstm = con.prepareStatement(SELECT_SQL)) {

                destinationPstm.setInt(1, destinationId);

                try (ResultSet rs = destinationPstm.executeQuery()) {

                    if (!rs.next()) {
                        System.out.println("Destination account not found.");
                        con.rollback();
                        return;
                    }
                }
            }

            System.out.println("Enter transfer amount:");
            double amount = sc.nextDouble();

            if (amount <= 0) {
                System.out.println("Invalid transfer amount.");
                con.rollback();
                return;
            }

            if (amount > sourceBalance) {
                System.out.println("Insufficient balance.");
                con.rollback();
                return;
            }

            try (PreparedStatement debitPstm = con.prepareStatement(DEBIT_SQL);
                 PreparedStatement creditPstm = con.prepareStatement(CREDIT_SQL)) {

                debitPstm.setDouble(1, amount);
                debitPstm.setInt(2, sourceId);

                creditPstm.setDouble(1, amount);
                creditPstm.setInt(2, destinationId);

                int debitRows = debitPstm.executeUpdate();
                int creditRows = creditPstm.executeUpdate();

                if (debitRows == 1 && creditRows == 1) {

                    con.commit();

                    System.out.println("Transfer committed successfully.");
                    System.out.println("Transferred Amount: " + amount);
                } else {

                    con.rollback();

                    System.out.println("Transfer failed.");
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }


    // Q4. Verify Committed Data Using a New Connection
    public void verifyCommittedData() throws ClassNotFoundException, SQLException {

        String SELECT_SQL = "SELECT account_holder, balance FROM accounts WHERE account_id = ?";

        try (Connection con = ConnectionEx.getConnection();
             Scanner sc = new Scanner(System.in)) {

            System.out.println("Enter account id:");
            int id = sc.nextInt();

            try (PreparedStatement pstm = con.prepareStatement(SELECT_SQL)) {

                pstm.setInt(1, id);

                try (ResultSet rs = pstm.executeQuery()) {

                    if (rs.next()) {

                        System.out.println("Account Holder: "
                                + rs.getString("account_holder"));

                        System.out.println("Current Balance: "
                                + rs.getDouble("balance"));

                        System.out.println("Committed data is available.");
                    } else {

                        System.out.println("Account not found.");
                    }
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }


    // Q5. Demonstrate Rollback Does Not Persist Changes
    public void rollbackDoesNotPersist() throws ClassNotFoundException, SQLException {

        String SELECT_SQL = "SELECT balance FROM accounts WHERE account_id = ?";
        String UPDATE_SQL = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

        try (Connection con = ConnectionEx.getConnection();
             Scanner sc = new Scanner(System.in)) {

            con.setAutoCommit(false);

            System.out.println("Enter account id:");
            int id = sc.nextInt();

            double currentBalance;

            try (PreparedStatement selectPstm = con.prepareStatement(SELECT_SQL)) {

                selectPstm.setInt(1, id);

                try (ResultSet rs = selectPstm.executeQuery()) {

                    if (!rs.next()) {
                        System.out.println("Account not found.");
                        con.rollback();
                        return;
                    }

                    currentBalance = rs.getDouble("balance");
                }
            }

            System.out.println("Current Balance: " + currentBalance);

            System.out.println("Enter deposit amount:");
            double amount = sc.nextDouble();

            if (amount <= 0) {
                System.out.println("Invalid amount.");
                con.rollback();
                return;
            }

            try (PreparedStatement updatePstm = con.prepareStatement(UPDATE_SQL)) {

                updatePstm.setDouble(1, amount);
                updatePstm.setInt(2, id);

                updatePstm.executeUpdate();

                System.out.println("Temporary Balance: "
                        + (currentBalance + amount));

                System.out.println("Rolling back transaction...");

                con.rollback();

                System.out.println("Rollback completed.");
                System.out.println("Original Balance remains: "
                        + currentBalance);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}