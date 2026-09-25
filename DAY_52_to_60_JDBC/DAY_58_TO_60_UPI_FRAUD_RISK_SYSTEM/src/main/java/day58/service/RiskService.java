package day58.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

import day58.dao.RiskDAO;
import day58.model.Account;
import day58.model.RiskAssessment;
import day58.model.RiskProfile;

public class RiskService {

	private final RiskDAO riskDAO;

	public RiskService(RiskDAO riskDAO) {
		this.riskDAO = riskDAO;
	}

	public RiskAssessment evaluate(Connection con, Account sender, Account receiver, BigDecimal amount)
			throws SQLException {

		RiskProfile profile = riskDAO.getRiskProfile(con, sender.getAccountId(), receiver.getUpiId());

		RiskAssessment assessment = new RiskAssessment();

		int amountRisk = calculateAmountRisk(amount);

		int balanceImpactRisk = calculateBalanceImpactRisk(sender.getBalance(), amount);

		int velocityRisk = calculateVelocityRisk(profile.getRecentTransactionCount());

		int volumeRisk = calculateVolumeRisk(profile.getRecentTransactionAmount());

		int failedTransactionRisk = calculateFailedTransactionRisk(profile.getRecentFailedTransactionCount());

		int recipientRisk = calculateRecipientRisk(profile.getRecipientTransactionCount());

		int historyRisk = calculateHistoryRisk(profile.getHighRiskTransactionCount());

		int finalScore = amountRisk + balanceImpactRisk + velocityRisk + volumeRisk + failedTransactionRisk
				+ recipientRisk + historyRisk;

		finalScore = Math.min(finalScore, 100);

		String riskLevel = determineRiskLevel(finalScore);

		String decision = determineDecision(riskLevel);

		assessment.setAmountRisk(amountRisk);
		assessment.setBalanceImpactRisk(balanceImpactRisk);
		assessment.setVelocityRisk(velocityRisk);
		assessment.setVolumeRisk(volumeRisk);
		assessment.setFailedTransactionRisk(failedTransactionRisk);
		assessment.setRecipientRisk(recipientRisk);
		assessment.setHistoryRisk(historyRisk);

		assessment.setRiskScore(finalScore);
		assessment.setRiskLevel(riskLevel);
		assessment.setDecision(decision);

		return assessment;
	}

	private int calculateAmountRisk(BigDecimal amount) {

		if (amount == null) {
			return 30;
		}

		if (amount.compareTo(new BigDecimal("1000")) <= 0) {
			return 0;
		}

		if (amount.compareTo(new BigDecimal("5000")) <= 0) {
			return 5;
		}

		if (amount.compareTo(new BigDecimal("10000")) <= 0) {
			return 10;
		}

		if (amount.compareTo(new BigDecimal("25000")) <= 0) {
			return 20;
		}

		if (amount.compareTo(new BigDecimal("50000")) <= 0) {
			return 25;
		}

		if (amount.compareTo(new BigDecimal("100000")) <= 0) {
			return 30;
		}

		return 35;
	}

	private int calculateBalanceImpactRisk(BigDecimal balance, BigDecimal amount) {

		if (balance == null || amount == null || balance.compareTo(BigDecimal.ZERO) <= 0) {

			return 25;
		}

		BigDecimal percentage = amount.multiply(new BigDecimal("100")).divide(balance, 2,
				java.math.RoundingMode.HALF_UP);

		if (percentage.compareTo(new BigDecimal("10")) <= 0) {
			return 0;
		}

		if (percentage.compareTo(new BigDecimal("25")) <= 0) {
			return 5;
		}

		if (percentage.compareTo(new BigDecimal("50")) <= 0) {
			return 10;
		}

		if (percentage.compareTo(new BigDecimal("75")) <= 0) {
			return 15;
		}

		return 20;
	}

	private int calculateVelocityRisk(int recentTransactionCount) {

		if (recentTransactionCount <= 1) {
			return 0;
		}

		if (recentTransactionCount <= 3) {
			return 5;
		}

		if (recentTransactionCount <= 5) {
			return 10;
		}

		if (recentTransactionCount <= 8) {
			return 15;
		}

		return 20;
	}

	private int calculateVolumeRisk(BigDecimal recentTransactionAmount) {

		if (recentTransactionAmount == null) {
			return 0;
		}

		if (recentTransactionAmount.compareTo(new BigDecimal("5000")) <= 0) {

			return 0;
		}

		if (recentTransactionAmount.compareTo(new BigDecimal("25000")) <= 0) {

			return 5;
		}

		if (recentTransactionAmount.compareTo(new BigDecimal("50000")) <= 0) {

			return 10;
		}

		if (recentTransactionAmount.compareTo(new BigDecimal("100000")) <= 0) {

			return 15;
		}

		return 20;
	}

	private int calculateFailedTransactionRisk(int failedTransactionCount) {

		if (failedTransactionCount == 0) {
			return 0;
		}

		if (failedTransactionCount <= 2) {
			return 5;
		}

		if (failedTransactionCount <= 4) {
			return 10;
		}

		if (failedTransactionCount <= 7) {
			return 15;
		}

		return 20;
	}

	private int calculateRecipientRisk(int recipientTransactionCount) {

		if (recipientTransactionCount >= 5) {
			return 0;
		}

		if (recipientTransactionCount >= 2) {
			return 5;
		}

		if (recipientTransactionCount == 1) {
			return 10;
		}

		return 15;
	}

	private int calculateHistoryRisk(int highRiskTransactionCount) {

		if (highRiskTransactionCount == 0) {
			return 0;
		}

		if (highRiskTransactionCount <= 2) {
			return 5;
		}

		if (highRiskTransactionCount <= 4) {
			return 10;
		}

		return 15;
	}

	private String determineRiskLevel(int score) {

		if (score < 30) {
			return "LOW";
		}

		if (score < 70) {
			return "MEDIUM";
		}

		return "HIGH";
	}

	private String determineDecision(String riskLevel) {

		if ("LOW".equals(riskLevel)) {
			return "ALLOW";
		}

		if ("MEDIUM".equals(riskLevel)) {
			return "REVIEW";
		}

		return "BLOCK";
	}
}