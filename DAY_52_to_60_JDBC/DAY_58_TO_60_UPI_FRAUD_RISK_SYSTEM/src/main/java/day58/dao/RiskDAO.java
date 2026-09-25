package day58.dao;

import java.sql.Connection;
import java.sql.SQLException;

import day58.model.RiskProfile;

public interface RiskDAO {
	
	RiskProfile getRiskProfile(Connection con, int accountId, String recipientUpiId) throws SQLException;
}
