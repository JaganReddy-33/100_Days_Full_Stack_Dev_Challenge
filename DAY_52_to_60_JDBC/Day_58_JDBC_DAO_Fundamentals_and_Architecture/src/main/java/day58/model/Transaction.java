package day58.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Transaction {
	private int transactionId;
	private int accountId;
	private String transactionReference;
	private String transactionType;
	private BigDecimal amount;
	private String recipientUpiId;
	private String transactionStatus;
	private int riskScore;
	private Timestamp transactionTime;
	
	
	public Transaction() {
		
	}
	
	public Transaction(int transactionId, int accountId,String transactionReference, 
			String transactionType, BigDecimal amount, String recipientUpiId, 
			String transactionStatus, int riskScore, Timestamp transactionTime) {
		
		this.setTransactionId(transactionId);
		this.setAccountId(accountId);
		this.setTransactionReference(transactionReference);
		this.setTransactionType(transactionType);
		this.setAmount(amount);
		this.setRecipientUpiId(recipientUpiId);
		this.setTransactionStatus(transactionStatus);
		this.setRiskScore(riskScore);
		this.setTransactionTime(transactionTime);
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getTransactionReference() {
		return transactionReference;
	}

	public void setTransactionReference(String transactionReference) {
		this.transactionReference = transactionReference;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getRecipientUpiId() {
		return recipientUpiId;
	}

	public void setRecipientUpiId(String recipientUpiId) {
		this.recipientUpiId = recipientUpiId;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public int getRiskScore() {
		return riskScore;
	}

	public void setRiskScore(int riskScore) {
		this.riskScore = riskScore;
	}

	public Timestamp getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(Timestamp transactionTime) {
		this.transactionTime = transactionTime;
	}
	
	@Override
    public String toString() {
        return "Transaction [" +
                "transactionId=" + transactionId +
                ", accountId=" + accountId +
                ", transactionReference='" + transactionReference + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", amount=" + amount +
                ", recipientUpiId='" + recipientUpiId + '\'' +
                ", transactionStatus='" + transactionStatus + '\'' +
                ", riskScore=" + riskScore +
                ", transactionTime=" + transactionTime +
                ']';
    }
}
