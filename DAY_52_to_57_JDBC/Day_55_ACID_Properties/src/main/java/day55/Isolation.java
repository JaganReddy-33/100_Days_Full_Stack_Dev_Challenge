package day55;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Isolation {

    // Q1. Demonstrate READ_COMMITTED
    public void readCommittedExample() throws ClassNotFoundException, SQLException {

        String SELECT_SQL = "SELECT balance FROM accounts WHERE account_id = ?";
        String UPDATE_SQL = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";

        try (Connection con1 = ConnectionEx.getConnection();
             Connection con2 = ConnectionEx.getConnection()) {

            con1.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            con2.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);	

            con1.setAutoCommit(false);
            con2.setAutoCommit(false);

            try (PreparedStatement pstm1 = con1.prepareStatement(SELECT_SQL);
                 PreparedStatement pstm2 = con2.prepareStatement(UPDATE_SQL)) {

                pstm1.setInt(1, 1);

                try (ResultSet rs = pstm1.executeQuery()) {

                    if (rs.next()) {
                        System.out.println("Transaction A Initial Balance: "
                                + rs.getDouble("balance"));
                    }
                }

                pstm2.setDouble(1, 1000);
                pstm2.setInt(2, 1);
                pstm2.executeUpdate();

                System.out.println("Transaction B updated balance but has NOT committed.");

                pstm1.setInt(1, 1);

                try (ResultSet rs = pstm1.executeQuery()) {

                    if (rs.next()) {
                        System.out.println("Transaction A sees Balance: "
                                + rs.getDouble("balance"));
                    }
                }

                con2.commit();

                System.out.println("Transaction B committed.");

                pstm1.setInt(1, 1);

                try (ResultSet rs = pstm1.executeQuery()) {

                    if (rs.next()) {
                        System.out.println("Transaction A now sees Balance: "
                                + rs.getDouble("balance"));
                    }
                }

                con1.commit();
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }


    // Q2. Demonstrate REPEATABLE_READ
    public void repeatableReadExample() throws ClassNotFoundException, SQLException {

        String SELECT_SQL = "SELECT balance FROM accounts WHERE account_id = ?";
        String UPDATE_SQL = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";

        try (Connection con1 = ConnectionEx.getConnection();
             Connection con2 = ConnectionEx.getConnection()) {

            con1.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            con2.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

            con1.setAutoCommit(false);
            con2.setAutoCommit(false);

            try (PreparedStatement pstm1 = con1.prepareStatement(SELECT_SQL);
                 PreparedStatement pstm2 = con2.prepareStatement(UPDATE_SQL)) {

                pstm1.setInt(1, 1);

                try (ResultSet rs = pstm1.executeQuery()) {

                    if (rs.next()) {
                        System.out.println("Transaction A First Read: "
                                + rs.getDouble("balance"));
                    }
                }

                pstm2.setDouble(1, 500);
                pstm2.setInt(2, 1);
                pstm2.executeUpdate();

                con2.commit();

                System.out.println("Transaction B committed an update.");

                pstm1.setInt(1, 1);

                try (ResultSet rs = pstm1.executeQuery()) {

                    if (rs.next()) {
                        System.out.println("Transaction A Second Read: "
                                + rs.getDouble("balance"));
                    }
                }

                con1.commit();
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }


    // Q3. Demonstrate SERIALIZABLE
    public void serializableExample() throws ClassNotFoundException, SQLException {

        String SELECT_SQL = "SELECT balance FROM accounts WHERE account_id = ?";
        String UPDATE_SQL = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

        try (Connection con1 = ConnectionEx.getConnection();
             Connection con2 = ConnectionEx.getConnection()) {

            con1.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            con2.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            con1.setAutoCommit(false);
            con2.setAutoCommit(false);

            try (PreparedStatement pstm1 = con1.prepareStatement(SELECT_SQL);
                 PreparedStatement pstm2 = con2.prepareStatement(UPDATE_SQL)) {

                pstm1.setInt(1, 1);

                try (ResultSet rs = pstm1.executeQuery()) {

                    if (rs.next()) {
                        System.out.println("Transaction A Balance: "
                                + rs.getDouble("balance"));
                    }
                }

                System.out.println("Transaction A is holding the transaction.");

                pstm2.setDouble(1, 500);
                pstm2.setInt(2, 1);

                try {
                    pstm2.executeUpdate();
                    con2.commit();

                    System.out.println("Transaction B completed.");
                } catch (SQLException e) {

                    con2.rollback();

                    System.out.println("Transaction B could not complete immediately.");
                    System.out.println("Reason: " + e.getMessage());
                }

                con1.commit();
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }


    // Q4. Display Current Transaction Isolation Level
    public void displayIsolationLevel() throws ClassNotFoundException, SQLException {

        try (Connection con = ConnectionEx.getConnection()) {

            int level = con.getTransactionIsolation();

            System.out.println("Current Isolation Level:");

            switch (level) {

                case Connection.TRANSACTION_READ_UNCOMMITTED:
                    System.out.println("READ_UNCOMMITTED");
                    break;

                case Connection.TRANSACTION_READ_COMMITTED:
                    System.out.println("READ_COMMITTED");
                    break;

                case Connection.TRANSACTION_REPEATABLE_READ:
                    System.out.println("REPEATABLE_READ");
                    break;

                case Connection.TRANSACTION_SERIALIZABLE:
                    System.out.println("SERIALIZABLE");
                    break;

                default:
                    System.out.println("Unknown Isolation Level");
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }


    // Q5. Change Transaction Isolation Level
    public void changeIsolationLevel() throws ClassNotFoundException, SQLException {

        try (Connection con = ConnectionEx.getConnection()) {

            System.out.println("Default Isolation Level:");

            int defaultLevel = con.getTransactionIsolation();

            switch (defaultLevel) {

                case Connection.TRANSACTION_READ_UNCOMMITTED:
                    System.out.println("READ_UNCOMMITTED");
                    break;

                case Connection.TRANSACTION_READ_COMMITTED:
                    System.out.println("READ_COMMITTED");
                    break;

                case Connection.TRANSACTION_REPEATABLE_READ:
                    System.out.println("REPEATABLE_READ");
                    break;

                case Connection.TRANSACTION_SERIALIZABLE:
                    System.out.println("SERIALIZABLE");
                    break;
            }

            con.setTransactionIsolation(
                    Connection.TRANSACTION_READ_COMMITTED);

            System.out.println("Isolation level changed to READ_COMMITTED.");

            int newLevel = con.getTransactionIsolation();

            System.out.println("Current Isolation Level: "
                    + (newLevel == Connection.TRANSACTION_READ_COMMITTED
                    ? "READ_COMMITTED"
                    : "Other"));
        }
    }
}