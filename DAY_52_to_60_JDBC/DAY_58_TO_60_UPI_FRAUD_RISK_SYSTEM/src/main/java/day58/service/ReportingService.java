package day58.service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import day58.dao.TransactionDAO;
import day58.daoimpl.TransactionDAOImpl;
import day58.model.Transaction;
import day58.model.TransactionSummary;

public class ReportingService {

    private final TransactionDAO transactionDAO;

    public ReportingService() {
        this.transactionDAO = new TransactionDAOImpl();
    }

    public ReportingService(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    public List<Transaction> getAccountTransactionHistory(
            int accountId
    ) throws SQLException {

        if (accountId <= 0) {
            throw new IllegalArgumentException(
                    "Account ID must be greater than zero."
            );
        }

        return transactionDAO.findTransactionsByAccount(accountId);
    }

    public List<Transaction> getTransactionsByDateRange(
            Timestamp startTime,
            Timestamp endTime
    ) throws SQLException {

        validateDateRange(startTime, endTime);

        return transactionDAO.findTransactionsByDateRange(
                startTime,
                endTime
        );
    }

    public TransactionSummary getTransactionSummary(
            Timestamp startTime,
            Timestamp endTime
    ) throws SQLException {

        validateDateRange(startTime, endTime);

        return transactionDAO.getTransactionSummary(
                startTime,
                endTime
        );
    }

    public List<Transaction> getHighRiskTransactions()
            throws SQLException {

        return transactionDAO.findHighRiskTransactions(70);
    }

    public List<Transaction> getHighRiskTransactions(
            int minimumRiskScore
    ) throws SQLException {

        if (minimumRiskScore < 0 || minimumRiskScore > 100) {
            throw new IllegalArgumentException(
                    "Risk score must be between 0 and 100."
            );
        }

        return transactionDAO.findHighRiskTransactions(
                minimumRiskScore
        );
    }

    private void validateDateRange(
            Timestamp startTime,
            Timestamp endTime
    ) {

        if (startTime == null || endTime == null) {
            throw new IllegalArgumentException(
                    "Start time and end time are required."
            );
        }

        if (startTime.after(endTime)) {
            throw new IllegalArgumentException(
                    "Start time cannot be after end time."
            );
        }
    }
}