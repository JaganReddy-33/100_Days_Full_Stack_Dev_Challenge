package day60.problems;

import java.util.Scanner;

class RiskEvaluator {

    protected double transactionAmount;

    public RiskEvaluator(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public int calculateRiskScore() {
        return 0;
    }

    public String getRiskLevel() {
        return "UNKNOWN";
    }

    public void evaluateRisk() {
        System.out.println("Risk Level: " + getRiskLevel());
        System.out.println("Risk Score: " + calculateRiskScore());
    }
}

class LowRiskEvaluator extends RiskEvaluator {

    public LowRiskEvaluator(double transactionAmount) {
        super(transactionAmount);
    }

    @Override
    public int calculateRiskScore() {
        return 20;
    }

    @Override
    public String getRiskLevel() {
        return "LOW";
    }
}

class MediumRiskEvaluator extends RiskEvaluator {

    public MediumRiskEvaluator(double transactionAmount) {
        super(transactionAmount);
    }

    @Override
    public int calculateRiskScore() {
        return 60;
    }

    @Override
    public String getRiskLevel() {
        return "MEDIUM";
    }
}

class HighRiskEvaluator extends RiskEvaluator {

    public HighRiskEvaluator(double transactionAmount) {
        super(transactionAmount);
    }

    @Override
    public int calculateRiskScore() {
        return 90;
    }

    @Override
    public String getRiskLevel() {
        return "HIGH";
    }
}

public class FraudRiskEvaluation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Transaction Amount:");
        double amount = sc.nextDouble();

        System.out.println("Select Risk Evaluation Type:");
        System.out.println("1. Low Risk");
        System.out.println("2. Medium Risk");
        System.out.println("3. High Risk");

        int choice = sc.nextInt();

        RiskEvaluator evaluator;

        if (choice == 1) {
            evaluator = new LowRiskEvaluator(amount);
        } else if (choice == 2) {
            evaluator = new MediumRiskEvaluator(amount);
        } else if (choice == 3) {
            evaluator = new HighRiskEvaluator(amount);
        } else {
            System.out.println("Invalid Risk Type!");
            sc.close();
            return;
        }

        evaluator.evaluateRisk();
    }
}