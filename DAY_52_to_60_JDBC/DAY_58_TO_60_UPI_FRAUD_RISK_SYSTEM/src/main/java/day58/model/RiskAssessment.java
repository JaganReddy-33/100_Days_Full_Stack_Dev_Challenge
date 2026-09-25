package day58.model;

public class RiskAssessment {

    private int riskScore;
    private String riskLevel;
    private String decision;

    private int amountRisk;
    private int balanceImpactRisk;
    private int velocityRisk;
    private int volumeRisk;
    private int failedTransactionRisk;
    private int recipientRisk;
    private int historyRisk;

    public RiskAssessment() {
    }

    public int getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(int riskScore) {
        this.riskScore = riskScore;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public int getAmountRisk() {
        return amountRisk;
    }

    public void setAmountRisk(int amountRisk) {
        this.amountRisk = amountRisk;
    }

    public int getBalanceImpactRisk() {
        return balanceImpactRisk;
    }

    public void setBalanceImpactRisk(int balanceImpactRisk) {
        this.balanceImpactRisk = balanceImpactRisk;
    }

    public int getVelocityRisk() {
        return velocityRisk;
    }

    public void setVelocityRisk(int velocityRisk) {
        this.velocityRisk = velocityRisk;
    }

    public int getVolumeRisk() {
        return volumeRisk;
    }

    public void setVolumeRisk(int volumeRisk) {
        this.volumeRisk = volumeRisk;
    }

    public int getFailedTransactionRisk() {
        return failedTransactionRisk;
    }

    public void setFailedTransactionRisk(int failedTransactionRisk) {
        this.failedTransactionRisk = failedTransactionRisk;
    }

    public int getRecipientRisk() {
        return recipientRisk;
    }

    public void setRecipientRisk(int recipientRisk) {
        this.recipientRisk = recipientRisk;
    }

    public int getHistoryRisk() {
        return historyRisk;
    }

    public void setHistoryRisk(int historyRisk) {
        this.historyRisk = historyRisk;
    }

    @Override
    public String toString() {
        return "RiskAssessment{" +
                "riskScore=" + riskScore +
                ", riskLevel='" + riskLevel + '\'' +
                ", decision='" + decision + '\'' +
                ", amountRisk=" + amountRisk +
                ", balanceImpactRisk=" + balanceImpactRisk +
                ", velocityRisk=" + velocityRisk +
                ", volumeRisk=" + volumeRisk +
                ", failedTransactionRisk=" + failedTransactionRisk +
                ", recipientRisk=" + recipientRisk +
                ", historyRisk=" + historyRisk +
                '}';
    }
}