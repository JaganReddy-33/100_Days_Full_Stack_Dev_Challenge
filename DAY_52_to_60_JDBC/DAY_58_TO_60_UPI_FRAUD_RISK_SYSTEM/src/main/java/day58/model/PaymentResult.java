
package day58.model;

public class PaymentResult {

    private boolean success;
    private int riskScore;
    private String riskLevel;
    private String decision;

    public PaymentResult() {
    }

    public PaymentResult(boolean success, int riskScore, String riskLevel, String decision) {
        this.success = success;
        this.riskScore = riskScore;
        this.riskLevel = riskLevel;
        this.decision = decision;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    @Override
    public String toString() {
        return "PaymentResult{" +
                "success=" + success +
                ", riskScore=" + riskScore +
                ", riskLevel='" + riskLevel + '\'' +
                ", decision='" + decision + '\'' +
                '}';
    }
}
