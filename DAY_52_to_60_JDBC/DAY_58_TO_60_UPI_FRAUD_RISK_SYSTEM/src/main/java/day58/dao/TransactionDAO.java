package day58.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import day58.model.Transaction;
import day58.model.TransactionSummary;

public interface TransactionDAO {

	boolean createTransaction(Connection con, Transaction transaction) throws SQLException;

	Transaction findTransactionById(int transactionId) throws SQLException;

	Transaction findTransactionByReference(String transactionReference) throws SQLException;

	Transaction findTransactionByIdempotencyKey(String idempotencyKey) throws SQLException;

	Transaction findTransactionByIdempotencyKey(Connection con, String idempotencyKey) throws SQLException;

	List<Transaction> findTransactionsByAccount(int accountId) throws SQLException;

	List<Transaction> findAllTransactions() throws SQLException;

	boolean updateTransactionStatus(Connection con, int transactionId, String status) throws SQLException;

	boolean updateRiskScore(int transactionId, int riskScore) throws SQLException;

	List<Transaction> findTransactionsByDateRange(Timestamp startTime, Timestamp endTime) throws SQLException;

	TransactionSummary getTransactionSummary(Timestamp startTime, Timestamp endTime) throws SQLException;

	List<Transaction> findHighRiskTransactions(int minimumRiskScore) throws SQLException;

}
