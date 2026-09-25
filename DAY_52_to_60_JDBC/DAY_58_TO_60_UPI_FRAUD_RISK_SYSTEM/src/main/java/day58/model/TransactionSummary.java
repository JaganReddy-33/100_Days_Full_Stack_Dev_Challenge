package day58.model;

import java.math.BigDecimal;

public class TransactionSummary {

    private long totalTransactions;
    private long successfulTransactions;
    private long failedTransactions;
    private long pendingTransactions;

    private BigDecimal totalAmount;
    private BigDecimal successfulAmount;
    private BigDecimal averageAmount;

    private long lowRiskTransactions;
    private long mediumRiskTransactions;
    private long highRiskTransactions;

    public TransactionSummary() {
    }

    public long getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(long totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public long getSuccessfulTransactions() {
        return successfulTransactions;
    }

    public void setSuccessfulTransactions(long successfulTransactions) {
        this.successfulTransactions = successfulTransactions;
    }

    public long getFailedTransactions() {
        return failedTransactions;
    }

    public void setFailedTransactions(long failedTransactions) {
        this.failedTransactions = failedTransactions;
    }

    public long getPendingTransactions() {
        return pendingTransactions;
    }

    public void setPendingTransactions(long pendingTransactions) {
        this.pendingTransactions = pendingTransactions;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getSuccessfulAmount() {
        return successfulAmount;
    }

    public void setSuccessfulAmount(BigDecimal successfulAmount) {
        this.successfulAmount = successfulAmount;
    }

    public BigDecimal getAverageAmount() {
        return averageAmount;
    }

    public void setAverageAmount(BigDecimal averageAmount) {
        this.averageAmount = averageAmount;
    }

    public long getLowRiskTransactions() {
        return lowRiskTransactions;
    }

    public void setLowRiskTransactions(long lowRiskTransactions) {
        this.lowRiskTransactions = lowRiskTransactions;
    }

    public long getMediumRiskTransactions() {
        return mediumRiskTransactions;
    }

    public void setMediumRiskTransactions(long mediumRiskTransactions) {
        this.mediumRiskTransactions = mediumRiskTransactions;
    }

    public long getHighRiskTransactions() {
        return highRiskTransactions;
    }

    public void setHighRiskTransactions(long highRiskTransactions) {
        this.highRiskTransactions = highRiskTransactions;
    }

    @Override
    public String toString() {
        return "TransactionSummary{" +
                "totalTransactions=" + totalTransactions +
                ", successfulTransactions=" + successfulTransactions +
                ", failedTransactions=" + failedTransactions +
                ", pendingTransactions=" + pendingTransactions +
                ", totalAmount=" + totalAmount +
                ", successfulAmount=" + successfulAmount +
                ", averageAmount=" + averageAmount +
                ", lowRiskTransactions=" + lowRiskTransactions +
                ", mediumRiskTransactions=" + mediumRiskTransactions +
                ", highRiskTransactions=" + highRiskTransactions +
                '}';
    }
}