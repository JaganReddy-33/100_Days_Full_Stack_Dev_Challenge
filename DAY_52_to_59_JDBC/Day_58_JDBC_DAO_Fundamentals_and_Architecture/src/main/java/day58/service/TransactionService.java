package day58.service;

import java.sql.SQLException;
import java.util.List;

import day58.dao.TransactionDAO;
import day58.daoimpl.TransactionDAOImpl;
import day58.model.Transaction;

public class TransactionService {

    private TransactionDAO transactionDAO;

    public TransactionService() {
        transactionDAO = new TransactionDAOImpl();
    }

    public boolean createTransaction(Transaction transaction) throws SQLException {
        return transactionDAO.createTransaction(transaction);
    }

    public Transaction findTransactionById(int transactionId) throws SQLException {
        return transactionDAO.findTransactionById(transactionId);
    }

    public Transaction findTransactionByReference(String transactionReference) throws SQLException {
        return transactionDAO.findTransactionByReference(transactionReference);
    }

    public List<Transaction> findTransactionsByAccount(int accountId) throws SQLException {
        return transactionDAO.findTransactionsByAccount(accountId);
    }

    public List<Transaction> findAllTransactions() throws SQLException {
        return transactionDAO.findAllTransactions();
    }

    public boolean updateTransactionStatus(int transactionId, String status) throws SQLException {
        return transactionDAO.updateTransactionStatus(transactionId, status);
    }

    public boolean updateRiskScore(int transactionId, int riskScore) throws SQLException {
        return transactionDAO.updateRiskScore(transactionId, riskScore);
    }
}