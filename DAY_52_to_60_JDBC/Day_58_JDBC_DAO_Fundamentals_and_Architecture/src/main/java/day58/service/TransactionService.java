package day58.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import day58.ConnectionEx;
import day58.dao.TransactionDAO;
import day58.daoimpl.TransactionDAOImpl;
import day58.model.Account;
import day58.model.Transaction;

public class TransactionService {

    private TransactionDAO transactionDAO;
    private AccountService accountService;

    public TransactionService() {
        transactionDAO = new TransactionDAOImpl();
        accountService = new AccountService();
    }

    public boolean createTransaction(Transaction transaction)
            throws SQLException {

        if (transaction == null) {
            return false;
        }

        if (transaction.getAccountId() <= 0) {
            return false;
        }

        if (transaction.getTransactionReference() == null ||
                transaction.getTransactionReference().trim().isEmpty()) {
            return false;
        }

        if (transaction.getIdempotencyKey() == null ||
                transaction.getIdempotencyKey().trim().isEmpty()) {
            return false;
        }

        if (transaction.getTransactionType() == null ||
                transaction.getTransactionType().trim().isEmpty()) {
            return false;
        }

        if (transaction.getAmount() == null ||
                transaction.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }

        if (transaction.getRecipientUpiId() == null ||
                transaction.getRecipientUpiId().trim().isEmpty()) {
            return false;
        }

        Account account =
                accountService.findAccountById(
                        transaction.getAccountId()
                );

        if (account == null) {
            return false;
        }

        if (!"ACTIVE".equalsIgnoreCase(
                account.getAccountStatus())) {
            return false;
        }

        if (transaction.getTransactionStatus() == null ||
                transaction.getTransactionStatus().trim().isEmpty()) {

            transaction.setTransactionStatus("PENDING");
        }

        if (transaction.getRiskScore() < 0 ||
                transaction.getRiskScore() > 100) {
            return false;
        }

        Connection con = ConnectionEx.getConnection();

        try {
            return transactionDAO.createTransaction(
                    con,
                    transaction
            );
        } finally {
            con.close();
        }
    }

    public Transaction findTransactionById(
            int transactionId) throws SQLException {

        if (transactionId <= 0) {
            return null;
        }

        return transactionDAO.findTransactionById(
                transactionId
        );
    }

    public Transaction findTransactionByReference(
            String transactionReference) throws SQLException {

        if (transactionReference == null ||
                transactionReference.trim().isEmpty()) {
            return null;
        }

        return transactionDAO.findTransactionByReference(
                transactionReference
        );
    }

    public Transaction findTransactionByIdempotencyKey(
            String idempotencyKey) throws SQLException {

        if (idempotencyKey == null ||
                idempotencyKey.trim().isEmpty()) {
            return null;
        }

        return transactionDAO.findTransactionByIdempotencyKey(
                idempotencyKey
        );
    }

    public List<Transaction> findTransactionsByAccount(
            int accountId) throws SQLException {

        if (accountId <= 0) {
            return new ArrayList<>();
        }

        return transactionDAO.findTransactionsByAccount(
                accountId
        );
    }

    public List<Transaction> findAllTransactions()
            throws SQLException {

        return transactionDAO.findAllTransactions();
    }

    public boolean updateTransactionStatus(
            int transactionId,
            String status) throws SQLException {

        if (transactionId <= 0) {
            return false;
        }

        if (status == null ||
                status.trim().isEmpty()) {
            return false;
        }

        status = status.trim().toUpperCase();

        if (!status.equals("PENDING") &&
                !status.equals("SUCCESS") &&
                !status.equals("FAILED") &&
                !status.equals("CANCELLED")) {
            return false;
        }

        Connection con = ConnectionEx.getConnection();

        try {
            return transactionDAO.updateTransactionStatus(
                    con,
                    transactionId,
                    status
            );
        } finally {
            con.close();
        }
    }

    public boolean updateRiskScore(
            int transactionId,
            int riskScore) throws SQLException {

        if (transactionId <= 0) {
            return false;
        }

        if (riskScore < 0 ||
                riskScore > 100) {
            return false;
        }

        return transactionDAO.updateRiskScore(
                transactionId,
                riskScore
        );
    }
}