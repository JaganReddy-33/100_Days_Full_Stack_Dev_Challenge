package day58.dao;

import java.sql.SQLException;
import java.util.List;

import day58.model.Transaction;

public interface TransactionDAO {
	
	boolean createTransaction(Transaction transaction) throws SQLException;
	
	Transaction findTransactionById(int transactionId) throws SQLException;
	
	Transaction findTransactionByReference(String transactionReference) throws SQLException;
	
	List<Transaction> findTransactionsByAccount(int accountId) throws SQLException;
	
	List<Transaction> findAllTransactions() throws SQLException;
	
	boolean updateTransactionStatus(int transactionId, String status) throws SQLException;
	
	boolean updateRiskScore(int transactionId, int riskScore) throws SQLException;
}
