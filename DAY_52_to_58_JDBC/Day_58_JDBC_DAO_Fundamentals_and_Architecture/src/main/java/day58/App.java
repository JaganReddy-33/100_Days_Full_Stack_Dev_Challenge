package day58;

import java.math.BigDecimal;
import java.util.Scanner;

import day58.dao.AccountDAO;
import day58.daoimpl.AccountDAOImpl;
import day58.model.Account;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {

            System.out.println("=================================");
            System.out.println("       CREATE ACCOUNT");
            System.out.println("=================================");

            System.out.print("Enter user name: ");
            String userName = scanner.nextLine();

            System.out.print("Enter UPI ID: ");
            String upiId = scanner.nextLine();

            System.out.print("Enter account number: ");
            String accountNumber = scanner.nextLine();

            System.out.print("Enter initial balance: ");
            BigDecimal balance = scanner.nextBigDecimal();
            scanner.nextLine();

            String accountStatus = "ACTIVE";

            Account account = new Account();

            account.setUserName(userName);
            account.setUpiId(upiId);
            account.setAccountNumber(accountNumber);
            account.setBalance(balance);
            account.setAccountStatus(accountStatus);

            AccountDAO accountDAO = new AccountDAOImpl();

            boolean result = accountDAO.createAccount(account);

            if (result) {
                System.out.println();
                System.out.println("Account created successfully!");
                System.out.println("Generated Account ID: " + account.getAccountId());
                System.out.println("Account Details:");
                System.out.println(account);
            } else {
                System.out.println();
                System.out.println("Account creation failed!");
            }

        } catch (Exception e) {

            System.out.println("Something went wrong!");
            e.printStackTrace();

        } finally {

            scanner.close();
        }
    }
}