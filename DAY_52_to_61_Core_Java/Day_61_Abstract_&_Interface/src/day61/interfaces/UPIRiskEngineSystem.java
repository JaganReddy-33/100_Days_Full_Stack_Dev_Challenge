package day61.interfaces;

import java.util.Scanner;

interface RiskEngine {

    int calculateRiskScore(double amount, double balance);

    String makeDecision(int riskScore);
}

class RuleBasedRiskEngine implements RiskEngine {

    public int calculateRiskScore(double amount, double balance) {

        int score = 0;

        if (amount > 50000) {
            score += 40;
        }

        if (amount > balance * 0.7) {
            score += 30;
        }

        if (amount > 100000) {
            score += 30;
        }

        return Math.min(score, 100);
    }

    public String makeDecision(int riskScore) {

        if (riskScore < 30) {
            return "ALLOW";
        }

        if (riskScore < 70) {
            return "REVIEW";
        }

        return "BLOCK";
    }
}

class MachineLearningRiskEngine implements RiskEngine {

    public int calculateRiskScore(double amount, double balance) {

        int score = 20;

        if (amount > balance * 0.5) {
            score += 25;
        }

        if (amount > 100000) {
            score += 35;
        }

        return Math.min(score, 100);
    }

    public String makeDecision(int riskScore) {

        if (riskScore < 30) {
            return "ALLOW";
        }

        if (riskScore < 70) {
            return "REVIEW";
        }

        return "BLOCK";
    }
}

class ManualReviewEngine implements RiskEngine {

    public int calculateRiskScore(double amount, double balance) {

        if (amount > balance * 0.5) {
            return 70;
        }

        return 40;
    }

    public String makeDecision(int riskScore) {

        if (riskScore >= 70) {
            return "BLOCK";
        }

        return "REVIEW";
    }
}

public class UPIRiskEngineSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter transaction amount: ");
        double amount = sc.nextDouble();

        System.out.print("Enter account balance: ");
        double balance = sc.nextDouble();

        System.out.println("1. Rule-Based Risk Engine");
        System.out.println("2. Machine Learning Risk Engine");
        System.out.println("3. Manual Review Engine");

        System.out.print("Choose risk engine: ");
        int choice = sc.nextInt();

        RiskEngine riskEngine;

        if (choice == 1) {
            riskEngine = new RuleBasedRiskEngine();
        } else if (choice == 2) {
            riskEngine = new MachineLearningRiskEngine();
        } else if (choice == 3) {
            riskEngine = new ManualReviewEngine();
        } else {
            System.out.println("Invalid risk engine");
            sc.close();
            return;
        }

        int riskScore = riskEngine.calculateRiskScore(amount, balance);

        String decision = riskEngine.makeDecision(riskScore);

        System.out.println("Risk Score: " + riskScore);
        System.out.println("Decision: " + decision);

        sc.close();
    }
}