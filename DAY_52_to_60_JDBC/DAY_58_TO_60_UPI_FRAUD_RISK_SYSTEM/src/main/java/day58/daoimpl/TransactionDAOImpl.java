
package day58.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import day58.ConnectionEx;
import day58.dao.TransactionDAO;
import day58.model.Transaction;
import day58.model.TransactionSummary;

public class TransactionDAOImpl implements TransactionDAO {

	@Override
	public boolean createTransaction(Connection con, Transaction transaction) throws SQLException {

		String sql = "INSERT INTO transactions " + "(account_id, transaction_reference, idempotency_key, "
				+ "transaction_type, amount, recipient_upi_id, " + "transaction_status, risk_score) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

			stmt.setInt(1, transaction.getAccountId());
			stmt.setString(2, transaction.getTransactionReference());
			stmt.setString(3, transaction.getIdempotencyKey());
			stmt.setString(4, transaction.getTransactionType());
			stmt.setBigDecimal(5, transaction.getAmount());
			stmt.setString(6, transaction.getRecipientUpiId());
			stmt.setString(7, transaction.getTransactionStatus());
			stmt.setInt(8, transaction.getRiskScore());

			int rows = stmt.executeUpdate();

			if (rows > 0) {

				try (ResultSet rs = stmt.getGeneratedKeys()) {

					if (rs.next()) {
						transaction.setTransactionId(rs.getInt(1));
					}
				}

				return true;
			}
		}

		return false;
	}

	@Override
	public Transaction findTransactionById(int transactionId) throws SQLException {

		String sql = "SELECT transaction_id, account_id, transaction_reference, "
				+ "idempotency_key, transaction_type, amount, recipient_upi_id, "
				+ "transaction_status, risk_score, transaction_time " + "FROM transactions "
				+ "WHERE transaction_id = ?";

		try (Connection con = ConnectionEx.getConnection(); 
				PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setInt(1, transactionId);

			try (ResultSet rs = stmt.executeQuery()) {

				if (rs.next()) {

					Transaction transaction = new Transaction();

					transaction.setTransactionId(rs.getInt("transaction_id"));

					transaction.setAccountId(rs.getInt("account_id"));

					transaction.setTransactionReference(rs.getString("transaction_reference"));

					transaction.setIdempotencyKey(rs.getString("idempotency_key"));

					transaction.setTransactionType(rs.getString("transaction_type"));

					transaction.setAmount(rs.getBigDecimal("amount"));

					transaction.setRecipientUpiId(rs.getString("recipient_upi_id"));

					transaction.setTransactionStatus(rs.getString("transaction_status"));

					transaction.setRiskScore(rs.getInt("risk_score"));

					transaction.setTransactionTime(rs.getTimestamp("transaction_time"));

					return transaction;
				}
			}
		}

		return null;
	}

	@Override
	public Transaction findTransactionByReference(String transactionReference) throws SQLException {

		String sql = "SELECT transaction_id, account_id, transaction_reference, "
				+ "idempotency_key, transaction_type, amount, recipient_upi_id, "
				+ "transaction_status, risk_score, transaction_time " + "FROM transactions "
				+ "WHERE transaction_reference = ?";

		try (Connection con = ConnectionEx.getConnection(); 
				PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setString(1, transactionReference);

			try (ResultSet rs = stmt.executeQuery()) {

				if (rs.next()) {

					Transaction transaction = new Transaction();

					transaction.setTransactionId(rs.getInt("transaction_id"));

					transaction.setAccountId(rs.getInt("account_id"));

					transaction.setTransactionReference(rs.getString("transaction_reference"));

					transaction.setIdempotencyKey(rs.getString("idempotency_key"));

					transaction.setTransactionType(rs.getString("transaction_type"));

					transaction.setAmount(rs.getBigDecimal("amount"));

					transaction.setRecipientUpiId(rs.getString("recipient_upi_id"));

					transaction.setTransactionStatus(rs.getString("transaction_status"));

					transaction.setRiskScore(rs.getInt("risk_score"));

					transaction.setTransactionTime(rs.getTimestamp("transaction_time"));

					return transaction;
				}
			}
		}

		return null;
	}

	@Override
	public Transaction findTransactionByIdempotencyKey(String idempotencyKey) throws SQLException {

		String sql = "SELECT transaction_id, account_id, transaction_reference, "
				+ "idempotency_key, transaction_type, amount, recipient_upi_id, "
				+ "transaction_status, risk_score, transaction_time " + "FROM transactions "
				+ "WHERE idempotency_key = ?";

		try (Connection con = ConnectionEx.getConnection(); 
				PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setString(1, idempotencyKey);

			try (ResultSet rs = stmt.executeQuery()) {

				if (rs.next()) {

					Transaction transaction = new Transaction();

					transaction.setTransactionId(rs.getInt("transaction_id"));

					transaction.setAccountId(rs.getInt("account_id"));

					transaction.setTransactionReference(rs.getString("transaction_reference"));

					transaction.setIdempotencyKey(rs.getString("idempotency_key"));

					transaction.setTransactionType(rs.getString("transaction_type"));

					transaction.setAmount(rs.getBigDecimal("amount"));

					transaction.setRecipientUpiId(rs.getString("recipient_upi_id"));

					transaction.setTransactionStatus(rs.getString("transaction_status"));

					transaction.setRiskScore(rs.getInt("risk_score"));

					transaction.setTransactionTime(rs.getTimestamp("transaction_time"));

					return transaction;
				}
			}
		}

		return null;
	}

	@Override
	public Transaction findTransactionByIdempotencyKey(Connection con, String idempotencyKey) throws SQLException {

		String sql = "SELECT transaction_id, account_id, transaction_reference, "
				+ "idempotency_key, transaction_type, amount, recipient_upi_id, "
				+ "transaction_status, risk_score, transaction_time " + "FROM transactions "
				+ "WHERE idempotency_key = ?";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setString(1, idempotencyKey);

			try (ResultSet rs = stmt.executeQuery()) {

				if (rs.next()) {

					Transaction transaction = new Transaction();

					transaction.setTransactionId(rs.getInt("transaction_id"));

					transaction.setAccountId(rs.getInt("account_id"));

					transaction.setTransactionReference(rs.getString("transaction_reference"));

					transaction.setIdempotencyKey(rs.getString("idempotency_key"));

					transaction.setTransactionType(rs.getString("transaction_type"));

					transaction.setAmount(rs.getBigDecimal("amount"));

					transaction.setRecipientUpiId(rs.getString("recipient_upi_id"));

					transaction.setTransactionStatus(rs.getString("transaction_status"));

					transaction.setRiskScore(rs.getInt("risk_score"));

					transaction.setTransactionTime(rs.getTimestamp("transaction_time"));

					return transaction;
				}
			}
		}

		return null;
	}

	@Override
	public List<Transaction> findTransactionsByAccount(int accountId) throws SQLException {

		String sql = "SELECT transaction_id, account_id, transaction_reference, "
				+ "idempotency_key, transaction_type, amount, recipient_upi_id, "
				+ "transaction_status, risk_score, transaction_time " + "FROM transactions " + "WHERE account_id = ? "
				+ "ORDER BY transaction_time DESC";

		List<Transaction> transactions = new ArrayList<>();

		try (Connection con = ConnectionEx.getConnection(); 
				PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setInt(1, accountId);

			try (ResultSet rs = stmt.executeQuery()) {

				while (rs.next()) {

					Transaction transaction = new Transaction();

					transaction.setTransactionId(rs.getInt("transaction_id"));

					transaction.setAccountId(rs.getInt("account_id"));

					transaction.setTransactionReference(rs.getString("transaction_reference"));

					transaction.setIdempotencyKey(rs.getString("idempotency_key"));

					transaction.setTransactionType(rs.getString("transaction_type"));

					transaction.setAmount(rs.getBigDecimal("amount"));

					transaction.setRecipientUpiId(rs.getString("recipient_upi_id"));

					transaction.setTransactionStatus(rs.getString("transaction_status"));

					transaction.setRiskScore(rs.getInt("risk_score"));

					transaction.setTransactionTime(rs.getTimestamp("transaction_time"));

					transactions.add(transaction);
				}
			}
		}

		return transactions;
	}

	@Override
	public List<Transaction> findAllTransactions() throws SQLException {

		String sql = "SELECT transaction_id, account_id, transaction_reference, "
				+ "idempotency_key, transaction_type, amount, recipient_upi_id, "
				+ "transaction_status, risk_score, transaction_time " + "FROM transactions "
				+ "ORDER BY transaction_time DESC";

		List<Transaction> transactions = new ArrayList<>();

		try (Connection con = ConnectionEx.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {

				Transaction transaction = new Transaction();

				transaction.setTransactionId(rs.getInt("transaction_id"));

				transaction.setAccountId(rs.getInt("account_id"));

				transaction.setTransactionReference(rs.getString("transaction_reference"));

				transaction.setIdempotencyKey(rs.getString("idempotency_key"));

				transaction.setTransactionType(rs.getString("transaction_type"));

				transaction.setAmount(rs.getBigDecimal("amount"));

				transaction.setRecipientUpiId(rs.getString("recipient_upi_id"));

				transaction.setTransactionStatus(rs.getString("transaction_status"));

				transaction.setRiskScore(rs.getInt("risk_score"));

				transaction.setTransactionTime(rs.getTimestamp("transaction_time"));

				transactions.add(transaction);
			}
		}

		return transactions;
	}

	@Override
	public boolean updateTransactionStatus(Connection con, int transactionId, String status) throws SQLException {

		String sql = "UPDATE transactions " + "SET transaction_status = ? " + "WHERE transaction_id = ?";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setString(1, status);
			stmt.setInt(2, transactionId);

			return stmt.executeUpdate() > 0;
		}
	}

	@Override
	public boolean updateRiskScore(int transactionId, int riskScore) throws SQLException {

		String sql = "UPDATE transactions " + "SET risk_score = ? " + "WHERE transaction_id = ?";

		try (Connection con = ConnectionEx.getConnection(); 
				PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setInt(1, riskScore);
			stmt.setInt(2, transactionId);

			return stmt.executeUpdate() > 0;
		}
	}

	@Override
	public List<Transaction> findTransactionsByDateRange(Timestamp startTime, Timestamp endTime) throws SQLException {

		String sql = "SELECT transaction_id, account_id, transaction_reference, "
				+ "idempotency_key, transaction_type, amount, recipient_upi_id, "
				+ "transaction_status, risk_score, transaction_time " + "FROM transactions "
				+ "WHERE transaction_time BETWEEN ? AND ? " + "ORDER BY transaction_time DESC";

		List<Transaction> transactions = new ArrayList<>();

		try (Connection con = ConnectionEx.getConnection(); 
				PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setTimestamp(1, startTime);
			stmt.setTimestamp(2, endTime);

			try (ResultSet rs = stmt.executeQuery()) {

				while (rs.next()) {

					Transaction transaction = new Transaction();

					transaction.setTransactionId(rs.getInt("transaction_id"));

					transaction.setAccountId(rs.getInt("account_id"));

					transaction.setTransactionReference(rs.getString("transaction_reference"));

					transaction.setIdempotencyKey(rs.getString("idempotency_key"));

					transaction.setTransactionType(rs.getString("transaction_type"));

					transaction.setAmount(rs.getBigDecimal("amount"));

					transaction.setRecipientUpiId(rs.getString("recipient_upi_id"));

					transaction.setTransactionStatus(rs.getString("transaction_status"));

					transaction.setRiskScore(rs.getInt("risk_score"));

					transaction.setTransactionTime(rs.getTimestamp("transaction_time"));

					transactions.add(transaction);
				}
			}
		}

		return transactions;
	}

	@Override
	public TransactionSummary getTransactionSummary(Timestamp startTime, Timestamp endTime) throws SQLException {

		String sql = "SELECT " + "COUNT(*) AS total_transactions, "
				+ "SUM(CASE WHEN transaction_status = 'SUCCESS' THEN 1 ELSE 0 END) AS successful_transactions, "
				+ "SUM(CASE WHEN transaction_status = 'FAILED' THEN 1 ELSE 0 END) AS failed_transactions, "
				+ "SUM(CASE WHEN transaction_status = 'PENDING' THEN 1 ELSE 0 END) AS pending_transactions, "
				+ "COALESCE(SUM(amount), 0) AS total_amount, "
				+ "COALESCE(SUM(CASE WHEN transaction_status = 'SUCCESS' THEN amount ELSE 0 END), 0) AS successful_amount, "
				+ "COALESCE(AVG(amount), 0) AS average_amount, "
				+ "SUM(CASE WHEN risk_score < 30 THEN 1 ELSE 0 END) AS low_risk_transactions, "
				+ "SUM(CASE WHEN risk_score >= 30 AND risk_score < 70 THEN 1 ELSE 0 END) AS medium_risk_transactions, "
				+ "SUM(CASE WHEN risk_score >= 70 THEN 1 ELSE 0 END) AS high_risk_transactions " + "FROM transactions "
				+ "WHERE transaction_time BETWEEN ? AND ?";

		TransactionSummary summary = new TransactionSummary();

		try (Connection con = ConnectionEx.getConnection(); 
				PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setTimestamp(1, startTime);
			stmt.setTimestamp(2, endTime);

			try (ResultSet rs = stmt.executeQuery()) {

				if (rs.next()) {

					summary.setTotalTransactions(rs.getLong("total_transactions"));

					summary.setSuccessfulTransactions(rs.getLong("successful_transactions"));

					summary.setFailedTransactions(rs.getLong("failed_transactions"));

					summary.setPendingTransactions(rs.getLong("pending_transactions"));

					summary.setTotalAmount(rs.getBigDecimal("total_amount"));

					summary.setSuccessfulAmount(rs.getBigDecimal("successful_amount"));

					summary.setAverageAmount(rs.getBigDecimal("average_amount"));

					summary.setLowRiskTransactions(rs.getLong("low_risk_transactions"));

					summary.setMediumRiskTransactions(rs.getLong("medium_risk_transactions"));

					summary.setHighRiskTransactions(rs.getLong("high_risk_transactions"));
				}
			}
		}

		return summary;
	}

	@Override
	public List<Transaction> findHighRiskTransactions(int minimumRiskScore) throws SQLException {

		String sql = "SELECT transaction_id, account_id, transaction_reference, "
				+ "idempotency_key, transaction_type, amount, recipient_upi_id, "
				+ "transaction_status, risk_score, transaction_time " + "FROM transactions " + "WHERE risk_score >= ? "
				+ "ORDER BY risk_score DESC, transaction_time DESC";

		List<Transaction> transactions = new ArrayList<>();

		try (Connection con = ConnectionEx.getConnection(); 
				PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setInt(1, minimumRiskScore);

			try (ResultSet rs = stmt.executeQuery()) {

				while (rs.next()) {

					Transaction transaction = new Transaction();

					transaction.setTransactionId(rs.getInt("transaction_id"));

					transaction.setAccountId(rs.getInt("account_id"));

					transaction.setTransactionReference(rs.getString("transaction_reference"));

					transaction.setIdempotencyKey(rs.getString("idempotency_key"));

					transaction.setTransactionType(rs.getString("transaction_type"));

					transaction.setAmount(rs.getBigDecimal("amount"));

					transaction.setRecipientUpiId(rs.getString("recipient_upi_id"));

					transaction.setTransactionStatus(rs.getString("transaction_status"));

					transaction.setRiskScore(rs.getInt("risk_score"));

					transaction.setTransactionTime(rs.getTimestamp("transaction_time"));

					transactions.add(transaction);
				}
			}
		}

		return transactions;
	}
}