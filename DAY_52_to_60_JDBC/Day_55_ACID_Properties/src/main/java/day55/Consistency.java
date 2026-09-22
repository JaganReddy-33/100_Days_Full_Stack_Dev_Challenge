package day55;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Consistency {

    // Q1. Prevent Negative Balance
    public void preventNegativeBalance() throws ClassNotFoundException, SQLException {

        String SELECT_SQL = "SELECT balance FROM accounts WHERE account_id = ?";
        String UPDATE_SQL = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";

        try (Connection con = ConnectionEx.getConnection();
             Scanner sc = new Scanner(System.in)) {

            con.setAutoCommit(false);

            System.out.println("Enter your account id:");
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

                    System.out.println("Enter your withdrawal amount:");
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
                            System.out.println("Withdrawal successful.");
                            System.out.println("Remaining Balance: " + (currentBalance - amount));
                        } else {
                            con.rollback();
                            System.out.println("Withdrawal failed.");
                        }
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Q2. Prevent Transfer When Source Account Has Insufficient Balance
    public void validateTransferBalance() throws ClassNotFoundException, SQLException {

        String SELECT_SQL = "SELECT balance FROM accounts WHERE account_id = ?";

        try (Connection con = ConnectionEx.getConnection();
             Scanner sc = new Scanner(System.in)) {

            con.setAutoCommit(false);

            System.out.println("Enter source account id:");
            int sourceId = sc.nextInt();

            try (PreparedStatement selectPstm = con.prepareStatement(SELECT_SQL)) {

                selectPstm.setInt(1, sourceId);

                try (ResultSet rs = selectPstm.executeQuery()) {

                    if (!rs.next()) {
                        System.out.println("Source account not found.");
                        con.rollback();
                        return;
                    }

                    double sourceBalance = rs.getDouble("balance");

                    System.out.println("Source Account Balance: " + sourceBalance);

                    System.out.println("Enter destination account id:");
                    int destinationId = sc.nextInt();

                    System.out.println("Enter transfer amount:");
                    double amount = sc.nextDouble();

                    if (amount <= 0) {
                        System.out.println("Invalid transfer amount.");
                        con.rollback();
                        return;
                    }

                    if (sourceId == destinationId) {
                        System.out.println("Source and destination accounts cannot be same.");
                        con.rollback();
                        return;
                    }

                    if (amount > sourceBalance) {
                        System.out.println("Insufficient balance for transfer.");
                        con.rollback();
                        return;
                    }

                    System.out.println("Transfer validation successful.");
                    System.out.println("Amount can be transferred safely.");

                    con.rollback();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Q3. Prevent Transfer To Non-Existing Account
    public void validateDestinationAccount() throws ClassNotFoundException, SQLException {

        String SELECT_SQL = "SELECT account_id, balance FROM accounts WHERE account_id = ?";
        String UPDATE_SOURCE_SQL = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";
        String UPDATE_DESTINATION_SQL = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

        try (Connection con = ConnectionEx.getConnection();
             Scanner sc = new Scanner(System.in)) {

            con.setAutoCommit(false);

            System.out.println("Enter source account id:");
            int sourceId = sc.nextInt();

            System.out.println("Enter destination account id:");
            int destinationId = sc.nextInt();

            System.out.println("Enter transfer amount:");
            double amount = sc.nextDouble();

            if (amount <= 0) {
                System.out.println("Invalid transfer amount.");
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

            if (sourceId == destinationId) {
                System.out.println("Source and destination accounts cannot be same.");
                con.rollback();
                return;
            }

            if (amount > sourceBalance) {
                System.out.println("Insufficient source account balance.");
                con.rollback();
                return;
            }

            try (PreparedStatement sourceUpdate = con.prepareStatement(UPDATE_SOURCE_SQL);
                 PreparedStatement destinationUpdate = con.prepareStatement(UPDATE_DESTINATION_SQL)) {

                sourceUpdate.setDouble(1, amount);
                sourceUpdate.setInt(2, sourceId);

                destinationUpdate.setDouble(1, amount);
                destinationUpdate.setInt(2, destinationId);

                int sourceRows = sourceUpdate.executeUpdate();
                int destinationRows = destinationUpdate.executeUpdate();

                if (sourceRows == 1 && destinationRows == 1) {
                    con.commit();
                    System.out.println("Transfer successful.");
                } else {
                    con.rollback();
                    System.out.println("Transfer failed.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Q4. Validate Deposit Amount
    public void validateDeposit() throws ClassNotFoundException, SQLException {

        String SELECT_SQL = "SELECT balance FROM accounts WHERE account_id = ?";
        String UPDATE_SQL = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

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
                        System.out.println("Deposit amount must be greater than 0.");
                        con.rollback();
                        return;
                    }

                    try (PreparedStatement updatePstm = con.prepareStatement(UPDATE_SQL)) {

                        updatePstm.setDouble(1, amount);
                        updatePstm.setInt(2, id);

                        int rows = updatePstm.executeUpdate();

                        if (rows == 1) {
                            con.commit();
                            System.out.println("Deposit successful.");
                            System.out.println("New Balance: " + (currentBalance + amount));
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


    // Q5. Complete Validated Money Transfer
    public void validatedTransfer() throws ClassNotFoundException, SQLException {

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
                System.out.println("Source and destination accounts cannot be same.");
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
                System.out.println("Transfer amount must be greater than 0.");
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

                    System.out.println("Transfer successful.");
                    System.out.println("Transferred Amount: " + amount);
                    System.out.println("Remaining Source Balance: " + (sourceBalance - amount));
                } else {
                    con.rollback();
                    System.out.println("Transfer failed.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}