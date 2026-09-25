package day58.daoimpl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import day58.dao.RiskDAO;
import day58.model.RiskProfile;

public class RiskDAOImpl implements RiskDAO {

	@Override
	public RiskProfile getRiskProfile(Connection con, int accountId, String recipientUpiId) throws SQLException {

		RiskProfile profile = new RiskProfile();

		String recentTransactionsSql = "SELECT COUNT(*) " + "FROM transactions " + "WHERE account_id = ? "
				+ "AND transaction_time >= NOW() - INTERVAL 10 MINUTE";

		try (PreparedStatement statement = con.prepareStatement(recentTransactionsSql)) {

			statement.setInt(1, accountId);

			try (ResultSet resultSet = statement.executeQuery()) {

				if (resultSet.next()) {
					profile.setRecentTransactionCount(resultSet.getInt(1));
				}
			}
		}

		String recentAmountSql = "SELECT COALESCE(SUM(amount), 0) " + "FROM transactions " + "WHERE account_id = ? "
				+ "AND transaction_status = 'SUCCESS' " + "AND transaction_time >= NOW() - INTERVAL 24 HOUR";

		try (PreparedStatement statement = con.prepareStatement(recentAmountSql)) {

			statement.setInt(1, accountId);

			try (ResultSet resultSet = statement.executeQuery()) {

				if (resultSet.next()) {
					BigDecimal amount = resultSet.getBigDecimal(1);

					profile.setRecentTransactionAmount(amount == null ? BigDecimal.ZERO : amount);
				}
			}
		}

		String failedTransactionsSql = "SELECT COUNT(*) " + "FROM transactions " + "WHERE account_id = ? "
				+ "AND transaction_status = 'FAILED' " + "AND transaction_time >= NOW() - INTERVAL 24 HOUR";

		try (PreparedStatement statement = con.prepareStatement(failedTransactionsSql)) {

			statement.setInt(1, accountId);

			try (ResultSet resultSet = statement.executeQuery()) {

				if (resultSet.next()) {
					profile.setRecentFailedTransactionCount(resultSet.getInt(1));
				}
			}
		}

		String recipientSql = "SELECT COUNT(*) " + "FROM transactions " + "WHERE account_id = ? "
				+ "AND recipient_upi_id = ? " + "AND transaction_status = 'SUCCESS'";

		try (PreparedStatement statement = con.prepareStatement(recipientSql)) {

			statement.setInt(1, accountId);
			statement.setString(2, recipientUpiId);

			try (ResultSet resultSet = statement.executeQuery()) {

				if (resultSet.next()) {
					profile.setRecipientTransactionCount(resultSet.getInt(1));
				}
			}
		}

		String highRiskSql = "SELECT COUNT(*) " + "FROM transactions " + "WHERE account_id = ? "
				+ "AND risk_score >= 70 " + "AND transaction_time >= NOW() - INTERVAL 30 DAY";

		try (PreparedStatement statement = con.prepareStatement(highRiskSql)) {

			statement.setInt(1, accountId);

			try (ResultSet resultSet = statement.executeQuery()) {

				if (resultSet.next()) {
					profile.setHighRiskTransactionCount(resultSet.getInt(1));
				}
			}
		}

		return profile;

	}
}
