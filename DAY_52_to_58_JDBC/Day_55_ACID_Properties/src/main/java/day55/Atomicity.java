package day55;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Atomicity {

    // Q1. Deduct money from one account and commit the transaction
    public void deductAndCommit() throws ClassNotFoundException {

        String sql = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";

        try (Connection connection = ConnectionEx.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            connection.setAutoCommit(false);

            statement.setDouble(1, 500);
            statement.setInt(2, 1);

            statement.executeUpdate();

            connection.commit();

            System.out.println("Money deducted and transaction committed");

        } catch (SQLException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
    }

    // Q2. Add money to an account and commit the transaction
    public void addAndCommit() throws ClassNotFoundException {

        String sql = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

        try (Connection connection = ConnectionEx.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            connection.setAutoCommit(false);

            statement.setDouble(1, 1000);
            statement.setInt(2, 2);

            statement.executeUpdate();

            connection.commit();

            System.out.println("Money added and transaction committed");

        } catch (SQLException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
    }

    // Q3. Perform two operations and rollback if any operation fails
    public void transactionWithRollback() throws ClassNotFoundException {

        String debitSql = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";
        String creditSql = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

        try (Connection connection = ConnectionEx.getConnection();
             PreparedStatement debit = connection.prepareStatement(debitSql);
             PreparedStatement credit = connection.prepareStatement(creditSql)) {

            connection.setAutoCommit(false);

            try {

                debit.setDouble(1, 1000);
                debit.setInt(2, 1);
                debit.executeUpdate();

                credit.setDouble(1, 1000);
                credit.setInt(2, 2);
                credit.executeUpdate();

                connection.commit();

                System.out.println("Transaction successful");

            } catch (SQLException e) {

                connection.rollback();

                System.out.println("Transaction rolled back");
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    // Q4. Transfer money from Jagan to Lohith
    public void transferJaganToLohith() throws ClassNotFoundException {

        String debitSql = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";
        String creditSql = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

        try (Connection connection = ConnectionEx.getConnection();
             PreparedStatement debit = connection.prepareStatement(debitSql);
             PreparedStatement credit = connection.prepareStatement(creditSql)) {

            connection.setAutoCommit(false);

            try {

                debit.setDouble(1, 1000);
                debit.setInt(2, 1);
                debit.executeUpdate();

                credit.setDouble(1, 1000);
                credit.setInt(2, 2);
                credit.executeUpdate();

                connection.commit();

                System.out.println("₹1000 transferred from Jagan to Lohith");

            } catch (SQLException e) {

                connection.rollback();

                System.out.println("Transfer failed. Transaction rolled back");
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    // Q5. Transfer money from Lohith to AJay and force a failure
    public void failedTransfer() throws ClassNotFoundException {

        String debitSql = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";
        String creditSql = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

        try (Connection connection = ConnectionEx.getConnection();
             PreparedStatement debit = connection.prepareStatement(debitSql);
             PreparedStatement credit = connection.prepareStatement(creditSql)) {

            connection.setAutoCommit(false);

            try {

                debit.setDouble(1, 500);
                debit.setInt(2, 2);
                debit.executeUpdate();

                credit.setDouble(1, 500);
                credit.setInt(2, 999);
                credit.executeUpdate();

                connection.commit();

            } catch (SQLException e) {

                connection.rollback();

                System.out.println("Transfer failed");
                System.out.println("All changes rolled back");
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    // Q6. Transfer money from AJay to Kiran using three operations
    public void multipleOperationsTransaction() throws ClassNotFoundException {

        String sql = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

        String debitSql = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";

        try (Connection connection = ConnectionEx.getConnection();
             PreparedStatement debit = connection.prepareStatement(debitSql);
             PreparedStatement credit = connection.prepareStatement(sql)) {

            connection.setAutoCommit(false);

            try {

                debit.setDouble(1, 1500);
                debit.setInt(2, 3);
                debit.executeUpdate();

                credit.setDouble(1, 1500);
                credit.setInt(2, 4);
                credit.executeUpdate();

                credit.setDouble(1, 100);
                credit.setInt(2, 5);
                credit.executeUpdate();

                connection.commit();

                System.out.println("All operations committed");

            } catch (SQLException e) {

                connection.rollback();

                System.out.println("One operation failed");
                System.out.println("All operations rolled back");
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    // Q7. Check whether an account exists before transferring money
    public void transferWithAccountCheck() throws ClassNotFoundException {

        String checkSql = "SELECT account_id FROM accounts WHERE account_id = ?";
        String debitSql = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";
        String creditSql = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

        try (Connection connection = ConnectionEx.getConnection();
             PreparedStatement check = connection.prepareStatement(checkSql);
             PreparedStatement debit = connection.prepareStatement(debitSql);
             PreparedStatement credit = connection.prepareStatement(creditSql)) {

            connection.setAutoCommit(false);

            try {

                check.setInt(1, 5);

                ResultSet result = check.executeQuery();

                if (!result.next()) {
                    throw new SQLException("Destination account does not exist");
                }

                debit.setDouble(1, 700);
                debit.setInt(2, 1);
                debit.executeUpdate();

                credit.setDouble(1, 700);
                credit.setInt(2, 5);
                credit.executeUpdate();

                connection.commit();

                System.out.println("Transfer successful");

            } catch (SQLException e) {

                connection.rollback();

                System.out.println("Transfer failed");
                System.out.println("Transaction rolled back");
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    // Q8. Demonstrate atomicity with three account updates
    public void completeAtomicTransaction() throws ClassNotFoundException {

        String sql = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

        try (Connection connection = ConnectionEx.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            connection.setAutoCommit(false);

            try {

                statement.setDouble(1, 500);
                statement.setInt(2, 1);
                statement.executeUpdate();

                statement.setDouble(1, 750);
                statement.setInt(2, 2);
                statement.executeUpdate();

                statement.setDouble(1, 1000);
                statement.setInt(2, 3);
                statement.executeUpdate();

                connection.commit();

                System.out.println("All three operations committed");

            } catch (SQLException e) {

                connection.rollback();

                System.out.println("Transaction failed");
                System.out.println("All three operations rolled back");
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}