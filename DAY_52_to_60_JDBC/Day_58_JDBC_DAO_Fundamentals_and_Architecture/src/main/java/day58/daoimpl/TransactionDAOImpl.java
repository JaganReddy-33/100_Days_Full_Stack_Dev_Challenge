package day58.daoimpl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import day58.ConnectionEx;
import day58.dao.TransactionDAO;
import day58.model.Transaction;

public class TransactionDAOImpl implements TransactionDAO{

	@Override
	public boolean createTransaction(Connection con, Transaction transaction) throws SQLException {

	    String insertTransaction = "INSERT INTO transactions "
	            + "(account_id, transaction_reference, transaction_type, amount, "
	            + "recipient_upi_id, transaction_status, risk_score) "
	            + "VALUES (?, ?, ?, ?, ?, ?, ?)";

	    try (PreparedStatement stmt = con.prepareStatement(
	                 insertTransaction,
	                 Statement.RETURN_GENERATED_KEYS)) {

	        stmt.setInt(1, transaction.getAccountId());
	        stmt.setString(2, transaction.getTransactionReference());
	        stmt.setString(3, transaction.getTransactionType());
	        stmt.setBigDecimal(4, transaction.getAmount());
	        stmt.setString(5, transaction.getRecipientUpiId());
	        stmt.setString(6, transaction.getTransactionStatus());
	        stmt.setInt(7, transaction.getRiskScore());

	        int rowsAffected = stmt.executeUpdate();

	        if (rowsAffected == 0) {
	            return false;
	        }

	        try (ResultSet resultSet = stmt.getGeneratedKeys()) {

	            if (resultSet.next()) {
	                int generatedId = resultSet.getInt(1);
	                transaction.setTransactionId(generatedId);
	                return true;
	            }
	        }

	        return false;
	    }
	}

	@Override
	public Transaction findTransactionById(int transactionId) throws SQLException {
		
		String sql = "SELECT * FROM transactions WHERE transaction_id = ? ";
		
		try(Connection con = ConnectionEx.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)){
			
			stmt.setInt(1, transactionId);
			
			try(ResultSet resultSet = stmt.executeQuery()){
				
				if(resultSet.next()) {
					int transId = resultSet.getInt("transaction_id");
					int accountId = resultSet.getInt("account_id");
					String transRef = resultSet.getString("transaction_reference");
					String transType = resultSet.getString("transaction_type");
					BigDecimal amt = resultSet.getBigDecimal("amount");
					String recipientUpiId = resultSet.getString("recipient_upi_id");
					String transStatus = resultSet.getString("transaction_status");
					int riskScore = resultSet.getInt("risk_score");
					Timestamp transTime = resultSet.getTimestamp("transaction_time");
					
					return new Transaction(transId, accountId, transRef, transType, amt, recipientUpiId, transStatus, riskScore, transTime);
				}
			}
		}
		return null;
	}

	@Override
	public Transaction findTransactionByReference(String transactionReference) throws SQLException {
		
		String sql = " SELECT * FROM transactions WHERE transaction_reference = ? ";
		
		try(Connection con = ConnectionEx.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)){
			
			stmt.setString(1, transactionReference);
			
			try(ResultSet resultSet = stmt.executeQuery()){
				
				if(resultSet.next()) {
					int transId = resultSet.getInt("transaction_id");
					int accountId = resultSet.getInt("account_id");
					String transRef = resultSet.getString("transaction_reference");
					String transType = resultSet.getString("transaction_type");
					BigDecimal amt = resultSet.getBigDecimal("amount");
					String recipientUpiId = resultSet.getString("recipient_upi_id");
					String transStatus = resultSet.getString("transaction_status");
					int riskScore = resultSet.getInt("risk_score");
					Timestamp transTime = resultSet.getTimestamp("transaction_time");
					
					return new Transaction(transId, accountId, transRef, transType, amt, recipientUpiId, transStatus, riskScore, transTime);
				}
			}
		}
		return null;
	}

	@Override
	public List<Transaction> findTransactionsByAccount(int accountId) throws SQLException {
		
		List<Transaction> transactions = new ArrayList<>();
		
		String sql = " SELECT * FROM transactions WHERE account_id = ? ";
		
		try(Connection con = ConnectionEx.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)){
			
			stmt.setInt(1, accountId);
			
			try(ResultSet resultSet = stmt.executeQuery()){
				
				while(resultSet.next()) {
					int transId = resultSet.getInt("transaction_id");
					int accId = resultSet.getInt("account_id");
					String transRef = resultSet.getString("transaction_reference");
					String transType = resultSet.getString("transaction_type");
					BigDecimal amt = resultSet.getBigDecimal("amount");
					String recipientUpiId = resultSet.getString("recipient_upi_id");
					String transStatus = resultSet.getString("transaction_status");
					int riskScore = resultSet.getInt("risk_score");
					Timestamp transTime = resultSet.getTimestamp("transaction_time");
					
					Transaction transaction = new Transaction(transId, accId, transRef, transType, amt, recipientUpiId, transStatus, riskScore, transTime);
					transactions.add(transaction);
				}
			}
		}
		
		
		return transactions;
	}

	@Override
	public List<Transaction> findAllTransactions() throws SQLException {
		
		List<Transaction> allTransactions = new ArrayList<>();
		
		String sql = " SELECT * FROM transactions";
		
		try(Connection con = ConnectionEx.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)){
			
			try(ResultSet resultSet = stmt.executeQuery()){
				
				while(resultSet.next()) {
					int transId = resultSet.getInt("transaction_id");
					int accId = resultSet.getInt("account_id");
					String transRef = resultSet.getString("transaction_reference");
					String transType = resultSet.getString("transaction_type");
					BigDecimal amt = resultSet.getBigDecimal("amount");
					String recipientUpiId = resultSet.getString("recipient_upi_id");
					String transStatus = resultSet.getString("transaction_status");
					int riskScore = resultSet.getInt("risk_score");
					Timestamp transTime = resultSet.getTimestamp("transaction_time");
					
					Transaction transaction = new Transaction(transId, accId, transRef, transType, amt, recipientUpiId, transStatus, riskScore, transTime);
					allTransactions.add(transaction);
				}
			}
		}
		return allTransactions;
	}

	@Override
	public boolean updateTransactionStatus(Connection con, int transactionId, String status) throws SQLException {
		
		 String sql = "UPDATE transactions "
		 		+ "SET transaction_status = ? "
		 		+ "WHERE transaction_id = ?";

		    try (PreparedStatement stmt = con.prepareStatement(sql)) {

		        stmt.setString(1, status);
		        stmt.setInt(2, transactionId);

		        int rowsAffected = stmt.executeUpdate();

		        return rowsAffected > 0;
		    }
	}

	@Override
	public boolean updateRiskScore(int transactionId, int riskScore) throws SQLException {
		
		String sql = "UPDATE transactions SET risk_score = ? WHERE transaction_id = ?";

	    try (Connection con = ConnectionEx.getConnection();
	         PreparedStatement stmt = con.prepareStatement(sql)) {

	        stmt.setInt(1, riskScore);
	        stmt.setInt(2, transactionId);

	        int rowsAffected = stmt.executeUpdate();

	        return rowsAffected > 0;
	    }
	}
}
