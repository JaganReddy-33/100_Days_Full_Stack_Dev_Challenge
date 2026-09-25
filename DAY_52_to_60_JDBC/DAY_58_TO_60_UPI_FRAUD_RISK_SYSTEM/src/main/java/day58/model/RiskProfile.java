package day58.model;

import java.math.BigDecimal;

public class RiskProfile {

    private int recentTransactionCount;
    private BigDecimal recentTransactionAmount;
    private int recentFailedTransactionCount;
    private int recipientTransactionCount;
    private int highRiskTransactionCount;

    public RiskProfile() {
    }

    public int getRecentTransactionCount() {
        return recentTransactionCount;
    }

    public void setRecentTransactionCount(int recentTransactionCount) {
        this.recentTransactionCount = recentTransactionCount;
    }

    public BigDecimal getRecentTransactionAmount() {
        return recentTransactionAmount;
    }

    public void setRecentTransactionAmount(BigDecimal recentTransactionAmount) {
        this.recentTransactionAmount = recentTransactionAmount;
    }

    public int getRecentFailedTransactionCount() {
        return recentFailedTransactionCount;
    }

    public void setRecentFailedTransactionCount(int recentFailedTransactionCount) {
        this.recentFailedTransactionCount = recentFailedTransactionCount;
    }

    public int getRecipientTransactionCount() {
        return recipientTransactionCount;
    }

    public void setRecipientTransactionCount(int recipientTransactionCount) {
        this.recipientTransactionCount = recipientTransactionCount;
    }

    public int getHighRiskTransactionCount() {
        return highRiskTransactionCount;
    }

    public void setHighRiskTransactionCount(int highRiskTransactionCount) {
        this.highRiskTransactionCount = highRiskTransactionCount;
    }

    @Override
    public String toString() {
        return "RiskProfile{" +
                "recentTransactionCount=" + recentTransactionCount +
                ", recentTransactionAmount=" + recentTransactionAmount +
                ", recentFailedTransactionCount=" + recentFailedTransactionCount +
                ", recipientTransactionCount=" + recipientTransactionCount +
                ", highRiskTransactionCount=" + highRiskTransactionCount +
                '}';
    }
}