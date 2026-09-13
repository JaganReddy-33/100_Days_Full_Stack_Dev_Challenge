package day58;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

import day58.dao.AccountDAO;
import day58.daoimpl.AccountDAOImpl;
import day58.model.Account;

public class App {

    private static Scanner scanner = new Scanner(System.in);
    private static AccountDAO accountDAO = new AccountDAOImpl();

    public static void main(String[] args) {

        try {

            while (true) {

                showMenu();

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                case 1:
                    createAccount();
                    break;

                case 2:
                    findAccountById();
                    break;
                    
                case 3:
                	findAccountByUPI_Id();
                	break;

                case 0:
                    System.out.println();
                    System.out.println("Exiting application...");
                    return;

                default:
                    System.out.println();
                    System.out.println("Invalid choice! Please try again.");
                }
            }

        } catch (Exception e) {

            System.out.println("Something went wrong!");
            e.printStackTrace();

        } finally {

            scanner.close();

        }
    }

    private static void showMenu() {

        System.out.println();
        System.out.println("=================================");
        System.out.println("       UPI ACCOUNT MANAGEMENT");
        System.out.println("=================================");
        System.out.println("1. Create Account");
        System.out.println("2. Find Account By ID");
        System.out.println("3. Find Account By UPI_ID");
        System.out.println("0. Exit");
        System.out.println("=================================");
        System.out.print("Enter your choice: ");
    }

    private static void createAccount() throws SQLException {

        System.out.println();
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
    }

    private static void findAccountById() throws SQLException {

        System.out.println();
        System.out.println("=================================");
        System.out.println("       FIND ACCOUNT BY ID");
        System.out.println("=================================");

        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        scanner.nextLine();

        Account foundAccount = accountDAO.findAccountById(accountId);

        if (foundAccount != null) {

            System.out.println();
            System.out.println("Account found successfully!");
            System.out.println("Account Details:");
            System.out.println(foundAccount);

        } else {
            System.out.println("Account not found!");
        }
    }
    
    private static void findAccountByUPI_Id() throws SQLException {
    	System.out.println("=================================");
        System.out.println("       FIND ACCOUNT BY UPI_ID");
        System.out.println("=================================");
        
        System.out.println("Enter account UPI_ID: ");
        String upiId = scanner.nextLine();
        
        Account foundAccount = accountDAO.findAccountByUpiId(upiId);
        
        if(foundAccount != null) {
        	System.out.println("Account found successfully!");
            System.out.println("Account Details:");
            System.out.println(foundAccount);
        } else {
            System.out.println("Account not found!");
        }
    }
}