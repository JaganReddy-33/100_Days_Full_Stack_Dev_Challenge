package day58;

import java.util.Scanner;

import day58.constructors.ConstructorBasics_01;
import day58.constructors.ConstructorChaining_04;
import day58.constructors.ConstructorOverloading_03;
import day58.constructors.ConstructorRules_05;
import day58.constructors.ParameterizedConstructor_02;
import day58.constructors.RealWorldConstructorDesign_07;
import day58.constructors.ThisWithConstructors_06;

import day58.encapsulation.EncapsulationBasics_01;
import day58.encapsulation.EncapsulationProblems_04;
import day58.encapsulation.EncapsulationValidation_03;
import day58.encapsulation.GetterSetter_02;

import day58.staticconcepts.InstanceVsStatic_05;
import day58.staticconcepts.InitializationBlocks_11;
import day58.staticconcepts.ObjectInitializationOrder_10;
import day58.staticconcepts.RealWorldTransactionModel_12;
import day58.staticconcepts.StaticConstants_07;
import day58.staticconcepts.StaticInitialization_04;
import day58.staticconcepts.StaticMistakes_09;
import day58.staticconcepts.StaticPaymentConfig_02;
import day58.staticconcepts.StaticTransactionCounter_01;
import day58.staticconcepts.StaticTransactionUtility_03;
import day58.staticconcepts.StaticWithConstructors_06;
import day58.staticconcepts.UtilityClassDesign_08;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EncapsulationBasics_01 emp = new EncapsulationBasics_01();
        System.out.print("Enter Employee ID: ");
        emp.setEmpId(sc.nextInt());
        sc.nextLine();
        System.out.print("Enter Employee Name: ");
        emp.setName(sc.nextLine());
        System.out.print("Enter Employee Salary: ");
        emp.setSalary(sc.nextDouble());
        emp.display();

        GetterSetter_02 acc = new GetterSetter_02();
        System.out.print("\nEnter User Account Number: ");
        acc.setAccNumber(sc.nextLong());
        sc.nextLine();
        System.out.print("Enter User Account Name: ");
        acc.setAccName(sc.nextLine());
        System.out.print("Enter User Balance: ");
        acc.setBalance(sc.nextDouble());
        acc.displayAccountDetails();

        EncapsulationValidation_03 student = new EncapsulationValidation_03();
        System.out.print("\nEnter Student ID: ");
        student.setStudentId(sc.nextInt());
        sc.nextLine();
        System.out.print("Enter Student Name: ");
        student.setStudentName(sc.nextLine());
        System.out.print("Enter Marks (0 - 100): ");
        student.setMarks(sc.nextDouble());
        student.displayStudentDetails();

        EncapsulationProblems_04 account = new EncapsulationProblems_04();
        System.out.print("\nEnter Account Number: ");
        account.setAccountNumber(sc.nextLong());
        sc.nextLine();
        System.out.print("Enter Account Name: ");
        account.setAccountHolder(sc.nextLine());
        System.out.print("Enter Deposit Amount: ");
        account.deposit(sc.nextDouble());
        System.out.print("Enter Withdrawal Amount: ");
        account.withdraw(sc.nextDouble());
        System.out.println("Current Balance: ₹" + account.getBalance());
        account.displayAccountDetails();

        ConstructorBasics_01 empConstructor = new ConstructorBasics_01();
        empConstructor.displayEmployeeDetails();

        System.out.print("\nEnter Employee ID: ");
        int empId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Employee Name: ");
        String empName = sc.nextLine();
        System.out.print("Enter Employee Salary: ");
        double salary = sc.nextDouble();
        ParameterizedConstructor_02 parameterizedEmployee =
                new ParameterizedConstructor_02(empId, empName, salary);
        parameterizedEmployee.displayEmployeeDetails();

        System.out.println("\n--- Creating Employee with Default Constructor ---");
        ConstructorOverloading_03 employee1 = new ConstructorOverloading_03();
        employee1.displayEmployeeDetails();

        System.out.println("\n--- Creating Employee with ID Only ---");
        System.out.print("Enter Employee ID: ");
        int idOnly = sc.nextInt();
        sc.nextLine();
        ConstructorOverloading_03 employee2 =
                new ConstructorOverloading_03(idOnly);
        employee2.displayEmployeeDetails();

        System.out.println("\n--- Creating Employee with Full Details ---");
        System.out.print("Enter Employee ID: ");
        int fullId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Employee Name: ");
        String fullName = sc.nextLine();
        System.out.print("Enter Employee Salary: ");
        double fullSalary = sc.nextDouble();
        ConstructorOverloading_03 employee3 =
                new ConstructorOverloading_03(fullId, fullName, fullSalary);
        employee3.displayEmployeeDetails();

        sc.nextLine();
        System.out.print("\nEnter Order ID: ");
        String orderId = sc.nextLine();
        System.out.print("Enter Restaurant Name: ");
        String restaurant = sc.nextLine();
        System.out.print("Enter Delivery Type (STANDARD/EXPRESS): ");
        String deliveryType = sc.nextLine();
        System.out.print("Enter Base Delivery Fee: ");
        double deliveryFee = sc.nextDouble();
        ConstructorChaining_04 order =
                new ConstructorChaining_04(orderId, restaurant, deliveryType, deliveryFee);
        order.displayOrder();

        sc.nextLine();
        System.out.print("\nEnter Request ID: ");
        String requestId = sc.nextLine();
        System.out.print("Enter API Endpoint: ");
        String endpoint = sc.nextLine();
        System.out.print("Enter HTTP Method: ");
        String method = sc.nextLine();
        System.out.print("Enter Timeout in Seconds: ");
        int timeout = sc.nextInt();
        ConstructorRules_05 request =
                new ConstructorRules_05(requestId, endpoint, method, timeout);
        request.displayRequest();

        sc.nextLine();
        System.out.print("\nEnter Transaction ID: ");
        String transactionId = sc.nextLine();
        System.out.print("Enter Sender UPI ID: ");
        String senderUpi = sc.nextLine();
        System.out.print("Enter Receiver UPI ID: ");
        String receiverUpi = sc.nextLine();
        System.out.print("Enter Transaction Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Payment Method: ");
        String paymentMethod = sc.nextLine();
        ThisWithConstructors_06 transaction =
                new ThisWithConstructors_06(
                        transactionId,
                        senderUpi,
                        receiverUpi,
                        amount,
                        paymentMethod
                );
        transaction.displayTransaction();

        System.out.print("\nEnter Application ID: ");
        String applicationId = sc.nextLine();
        System.out.print("Enter Candidate Name: ");
        String candidateName = sc.nextLine();
        System.out.print("Enter Company Name: ");
        String companyName = sc.nextLine();
        System.out.print("Enter Job Role: ");
        String role = sc.nextLine();
        System.out.print("Enter Application Source: ");
        String applicationSource = sc.nextLine();
        RealWorldConstructorDesign_07 application =
                new RealWorldConstructorDesign_07(
                        applicationId,
                        candidateName,
                        companyName,
                        role,
                        applicationSource
                );
        application.displayApplication();
        System.out.print("\nEnter Updated Status: ");
        String status = sc.nextLine();
        application.updateStatus(status);
        application.displayApplication();

        StaticTransactionCounter_01 transaction1 = new StaticTransactionCounter_01();
        transaction1.setTransactionDetails(1001, 5000);
        transaction1.incrementTransactionCount();
        StaticTransactionCounter_01 transaction2 = new StaticTransactionCounter_01();
        transaction2.setTransactionDetails(1002, 2500);
        transaction2.incrementTransactionCount();
        StaticTransactionCounter_01 transaction3 = new StaticTransactionCounter_01();
        transaction3.setTransactionDetails(1003, 7500);
        transaction3.incrementTransactionCount();
        System.out.println(transaction1.getTransactionDetails());
        System.out.println(transaction2.getTransactionDetails());
        System.out.println(transaction3.getTransactionDetails());
        System.out.println("Total Transactions: " +
                StaticTransactionCounter_01.getTotalTransactions());

        StaticPaymentConfig_02.setPaymentLimits(100000.00, 20, 1.00);
        System.out.println("\nMinimum Transaction: ₹" +
                StaticPaymentConfig_02.getMinTransactionAmount());
        System.out.println("Maximum Transaction: ₹" +
                StaticPaymentConfig_02.getMaxTransactionAmount());
        System.out.println("Maximum Daily Transactions: " +
                StaticPaymentConfig_02.getMaxDailyTransactionCount());
        System.out.println("₹5000 Allowed: " +
                StaticPaymentConfig_02.isAmountWithinLimit(5000));
        System.out.println("₹150000 Allowed: " +
                StaticPaymentConfig_02.isAmountWithinLimit(150000));

        System.out.println("\nValid Amount: " +
                StaticTransactionUtility_03.isValidAmount(5000));
        System.out.println("Transaction Fee: ₹" +
                StaticTransactionUtility_03.calculateTransactionFee(5000));
        System.out.println("Normalized Payment Method: " +
                StaticTransactionUtility_03.normalizePaymentMethod("  upi  "));
        System.out.println("UPI Supported: " +
                StaticTransactionUtility_03.isSupportedPaymentMethod("UPI"));
        System.out.println("CASH Supported: " +
                StaticTransactionUtility_03.isSupportedPaymentMethod("CASH"));

        System.out.println("\nSystem Name: " +
                StaticInitialization_04.getSystemName());
        System.out.println("Risk Threshold: " +
                StaticInitialization_04.getRiskThreshold());
        System.out.println("Fraud Detection Enabled: " +
                StaticInitialization_04.isFraudDetectionEnabled());
        System.out.println("Risk Score 85: " +
                StaticInitialization_04.isHighRisk(85));
        System.out.println("Risk Score 45: " +
                StaticInitialization_04.isHighRisk(45));

        InstanceVsStatic_05 payment1 = new InstanceVsStatic_05();
        payment1.setPaymentDetails(1001, 500, "UPI", "SUCCESS");
        payment1.registerPayment();
        InstanceVsStatic_05 payment2 = new InstanceVsStatic_05();
        payment2.setPaymentDetails(1002, 2000, "CARD", "PENDING");
        payment2.registerPayment();
        InstanceVsStatic_05 payment3 = new InstanceVsStatic_05();
        payment3.setPaymentDetails(1003, 750, "UPI", "SUCCESS");
        payment3.registerPayment();
        System.out.println("\n" + payment1.getPaymentDetails());
        System.out.println(payment2.getPaymentDetails());
        System.out.println(payment3.getPaymentDetails());
        payment2.updateStatus("SUCCESS");
        System.out.println("\n" + payment2.getPaymentDetails());
        System.out.println("Total Payments: " +
                InstanceVsStatic_05.getTotalPayments());

        StaticWithConstructors_06 payment4 =
                new StaticWithConstructors_06(2001, 1500, "UPI");
        StaticWithConstructors_06 payment5 =
                new StaticWithConstructors_06(2002, 3500, "CARD");
        StaticWithConstructors_06 payment6 =
                new StaticWithConstructors_06(2003, 750, "WALLET");
        System.out.println("\n" + payment4.getPaymentDetails());
        System.out.println(payment5.getPaymentDetails());
        System.out.println(payment6.getPaymentDetails());
        System.out.println("Total Payments Created: " +
                StaticWithConstructors_06.getTotalPayments());

        System.out.println("\nAccount Active: " +
                StaticConstants_07.ACCOUNT_ACTIVE);
        System.out.println("Transaction Success: " +
                StaticConstants_07.TRANSACTION_SUCCESS);
        System.out.println("Valid Account Status: " +
                StaticConstants_07.isValidAccountStatus("ACTIVE"));
        System.out.println("Invalid Account Status: " +
                StaticConstants_07.isValidAccountStatus("CLOSED"));
        System.out.println("Valid Transaction Status: " +
                StaticConstants_07.isValidTransactionStatus("SUCCESS"));
        System.out.println("Invalid Transaction Status: " +
                StaticConstants_07.isValidTransactionStatus("PROCESSING"));
        System.out.println("Default Account Status: " +
                StaticConstants_07.getDefaultAccountStatus());
        System.out.println("Default Transaction Status: " +
                StaticConstants_07.getDefaultTransactionStatus());

        System.out.println("\nValid Transaction Amount: " +
                UtilityClassDesign_08.isValidTransactionAmount(5000));
        System.out.println("Invalid Transaction Amount: " +
                UtilityClassDesign_08.isValidTransactionAmount(-500));
        System.out.println("Valid Risk Score: " +
                UtilityClassDesign_08.isValidRiskScore(85));
        System.out.println("Risk Level 85: " +
                UtilityClassDesign_08.determineRiskLevel(85));
        System.out.println("Risk Level 60: " +
                UtilityClassDesign_08.determineRiskLevel(60));
        System.out.println("Risk Level 25: " +
                UtilityClassDesign_08.determineRiskLevel(25));
        System.out.println("Normalized Payment Method: " +
                UtilityClassDesign_08.normalizePaymentMethod("  upi  "));
        System.out.println("CARD Supported: " +
                UtilityClassDesign_08.isSupportedPaymentMethod("CARD"));
        System.out.println("CASH Supported: " +
                UtilityClassDesign_08.isSupportedPaymentMethod("CASH"));

        StaticMistakes_09 account1 =
                new StaticMistakes_09(101, "Jagan", 10000);
        StaticMistakes_09 account2 =
                new StaticMistakes_09(102, "Rahul", 15000);
        account1.deposit(2000);
        System.out.println("\n" + account1.getAccountDetails());
        System.out.println(account2.getAccountDetails());
        System.out.println("Account 1 Balance: ₹" +
                account1.getBalance());
        System.out.println("Account 2 Balance: ₹" +
                account2.getBalance());
        System.out.println("Total Accounts: " +
                StaticMistakes_09.getAccountCount());
        System.out.println("Valid Account ID: " +
                StaticMistakes_09.isValidAccountId(101));
        System.out.println("Valid Deposit Amount: " +
                StaticMistakes_09.isValidDepositAmount(5000));

        System.out.println("\nApplication Started");
        ObjectInitializationOrder_10.showSystemName();
        System.out.println("\nCreating First Object...");
        ObjectInitializationOrder_10 riskEngine1 =
                new ObjectInitializationOrder_10();
        riskEngine1.showTransactionType();
        System.out.println("\nCreating Second Object...");
        ObjectInitializationOrder_10 riskEngine2 =
                new ObjectInitializationOrder_10();
        riskEngine2.showTransactionType();

        
        
        System.out.println("\nApplication Started");
        System.out.println(InitializationBlocks_11.getSystemName());
        System.out.println("\nCreating Transaction 1");
        InitializationBlocks_11 initializationTransaction1 =
                new InitializationBlocks_11(5001, "UPI");
        System.out.println(
                initializationTransaction1.getTransactionDetails()
        );
        System.out.println("\nCreating Transaction 2");
        InitializationBlocks_11 initializationTransaction2 =
                new InitializationBlocks_11(5002, "CARD");
        System.out.println(
                initializationTransaction2.getTransactionDetails()
        );

        
        
        RealWorldTransactionModel_12 realTransaction1 =
                new RealWorldTransactionModel_12(
                        7001,
                        "jagan@upi",
                        "merchant@upi",
                        2500
                );
        RealWorldTransactionModel_12 realTransaction2 =
                new RealWorldTransactionModel_12(
                        7002,
                        "jagan@upi",
                        "food@upi",
                        850
                );
        RealWorldTransactionModel_12 realTransaction3 =
                new RealWorldTransactionModel_12(
                        7003,
                        "jagan@upi",
                        "invalid@upi",
                        -500
                );
        realTransaction1.markSuccessful();
        realTransaction2.markSuccessful();
        realTransaction3.markFailed();
        System.out.println("\n" + realTransaction1.getTransactionDetails());
        System.out.println(realTransaction2.getTransactionDetails());
        System.out.println(realTransaction3.getTransactionDetails());
        System.out.println("Total Transactions: " +
                RealWorldTransactionModel_12.getTotalTransactions());
        System.out.println("Valid Status: " +
                RealWorldTransactionModel_12.isValidStatus(
                        RealWorldTransactionModel_12.SUCCESS
                ));
        System.out.println("Invalid Status: " +
                RealWorldTransactionModel_12.isValidStatus("PROCESSING"));

        sc.close();
    }
}