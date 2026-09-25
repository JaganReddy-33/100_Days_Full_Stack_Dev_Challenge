
package day58;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import day58.daoimpl.AccountDAOImpl;
import day58.daoimpl.RiskDAOImpl;
import day58.daoimpl.TransactionDAOImpl;
import day58.model.Account;
import day58.model.PaymentResult;
import day58.model.Transaction;
import day58.model.TransactionSummary;
import day58.service.AccountService;
import day58.service.PaymentService;
import day58.service.ReportingService;
import day58.service.RiskService;
import day58.service.TransactionService;

public class App {

	private static Scanner scanner = new Scanner(System.in);

	private static AccountService accountService = new AccountService();

	private static TransactionService transactionService = new TransactionService();

	private static ReportingService reportingService = new ReportingService();

	private static PaymentService paymentService = new PaymentService(new AccountDAOImpl(), new TransactionDAOImpl(),
			new RiskService(new RiskDAOImpl()));

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

				case 4:
					findAllActiveAccounts();
					break;

				case 5:
					updateBalance();
					break;

				case 6:
					updateAccountStatus();
					break;

				case 7:
					createTransaction();
					break;

				case 8:
					findTransactionById();
					break;

				case 9:
					findTransactionByReference();
					break;

				case 10:
					findTransactionsByAccount();
					break;

				case 11:
					findAllTransactions();
					break;

				case 12:
					updateTransactionStatus();
					break;

				case 13:
					makeUpiPayment();
					break;

				case 14:
					showAccountTransactionHistory();
					break;

				case 15:
					showDateRangeTransactionHistory();
					break;

				case 16:
					showTransactionSummary();
					break;

				case 17:
					showHighRiskTransactions();
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
		System.out.println("4. Find All Active Accounts");
		System.out.println("5. Update Account Balance");
		System.out.println("6. Update Account Status");
		System.out.println("7. Create Transaction");
		System.out.println("8. Find Transaction By ID");
		System.out.println("9. Find Transaction By Reference");
		System.out.println("10. Find Transactions By Account");
		System.out.println("11. Find All Transactions");
		System.out.println("12. Update Transaction Status");
		System.out.println("13. Make UPI Payment");
		System.out.println("14. Account Transaction History");
		System.out.println("15. Date-Range Transaction History");
		System.out.println("16. Transaction Summary");
		System.out.println("17. High-Risk Transaction Report");
		System.out.println("0. Exit");
		System.out.println("=================================");
		System.out.print("Enter your choice: ");
	}

	private static void createAccount() throws SQLException {

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

		boolean result = accountService.createAccount(account);

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

		System.out.println("=================================");
		System.out.println("       FIND ACCOUNT BY ID");
		System.out.println("=================================");

		System.out.print("Enter account ID: ");

		int accountId = scanner.nextInt();
		scanner.nextLine();

		Account foundAccount = accountService.findAccountById(accountId);

		if (foundAccount != null) {

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

		Account foundAccount = accountService.findAccountByUpiId(upiId);

		if (foundAccount != null) {

			System.out.println("Account found successfully!");

			System.out.println("Account Details:");
			System.out.println(foundAccount);

		} else {

			System.out.println("Account not found!");
		}
	}

	private static void findAllActiveAccounts() throws SQLException {

		List<Account> accounts = accountService.findAllActiveAccounts();

		if (accounts.isEmpty()) {

			System.out.println("No active accounts found!");

		} else {

			System.out.println("=================================");
			System.out.println("       ACTIVE ACCOUNTS");
			System.out.println("=================================");

			for (Account account : accounts) {
				System.out.println(account);
			}
		}
	}

	private static void updateBalance() throws SQLException {

		System.out.println("=================================");
		System.out.println("       UPDATE ACCOUNT BALANCE");
		System.out.println("=================================");

		System.out.print("Enter account ID: ");

		int accountId = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Enter amount: ");

		BigDecimal amount = scanner.nextBigDecimal();

		scanner.nextLine();

		System.out.print("Enter operation (CREDIT/DEBIT): ");

		String operation = scanner.nextLine();

		boolean result = accountService.updateBalance(accountId, amount, operation);

		if (result) {

			System.out.println("Balance updated successfully!");

			Account updatedAccount = accountService.findAccountById(accountId);

			if (updatedAccount != null) {

				System.out.println("Updated Account Details:");

				System.out.println(updatedAccount);
			}

		} else {

			System.out.println("Balance update failed!");

			if (operation.equalsIgnoreCase("DEBIT")) {

				System.out.println(
						"Possible reasons: insufficient balance, " + "inactive account, or invalid account ID.");

			} else {

				System.out.println("Please check the account ID, amount, and operation.");
			}
		}
	}

	private static void updateAccountStatus() throws SQLException {

		System.out.println("=================================");
		System.out.println("       UPDATE ACCOUNT STATUS");
		System.out.println("=================================");

		System.out.print("Enter account ID: ");

		int accountId = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Enter new status (ACTIVE/SUSPENDED/BLOCKED): ");

		String status = scanner.nextLine();

		boolean result = accountService.updateAccountStatus(accountId, status);

		if (result) {

			System.out.println("Account status updated successfully!");

			Account updatedAccount = accountService.findAccountById(accountId);

			if (updatedAccount != null) {

				System.out.println("Updated Account Details:");

				System.out.println(updatedAccount);
			}

		} else {

			System.out.println("Account status update failed!");

			System.out.println("Check the account ID or provide a valid status.");
		}
	}

	public static void createTransaction() throws SQLException {

		System.out.println("=================================");
		System.out.println("       CREATE TRANSACTION");
		System.out.println("=================================");

		System.out.print("Enter account ID: ");

		int accountId = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Enter transaction reference: ");

		String transactionReference = scanner.nextLine();

		System.out.print("Enter transaction type: ");

		String transactionType = scanner.nextLine();

		System.out.print("Enter transaction amount: ");

		BigDecimal amount = scanner.nextBigDecimal();

		scanner.nextLine();

		System.out.print("Enter recipient UPI ID: ");

		String recipientUpiId = scanner.nextLine();

		System.out.print("Enter transaction status " + "(PENDING/SUCCESS/FAILED/CANCELLED): ");

		String transactionStatus = scanner.nextLine();

		System.out.print("Enter risk score (0-100): ");

		int riskScore = scanner.nextInt();

		scanner.nextLine();

		Transaction transaction = new Transaction();

		transaction.setAccountId(accountId);

		transaction.setTransactionReference(transactionReference);

		transaction.setTransactionType(transactionType);

		transaction.setAmount(amount);

		transaction.setRecipientUpiId(recipientUpiId);

		transaction.setTransactionStatus(transactionStatus);

		transaction.setRiskScore(riskScore);

		boolean result = transactionService.createTransaction(transaction);

		if (result) {

			System.out.println("Transaction created successfully!");

			System.out.println("Generated Transaction ID: " + transaction.getTransactionId());

			System.out.println("Transaction Details: ");

			System.out.println(transaction);

		} else {

			System.out.println("Transaction creation failed!");

			System.out.println("Check account status, input values, " + "or transaction details.");
		}
	}

	private static void findTransactionById() throws SQLException {

		System.out.println("=================================");
		System.out.println("       FIND TRANSACTION BY ID");
		System.out.println("=================================");

		System.out.print("Enter transaction ID: ");

		int transactionId = scanner.nextInt();

		scanner.nextLine();

		Transaction transaction = transactionService.findTransactionById(transactionId);

		if (transaction != null) {

			System.out.println("Transaction found successfully!");

			System.out.println("Transaction Details:");

			System.out.println(transaction);

		} else {

			System.out.println();
			System.out.println("Transaction not found!");
		}
	}

	private static void findTransactionByReference() throws SQLException {

		System.out.println("=================================");
		System.out.println("    FIND TRANSACTION BY REFERENCE");
		System.out.println("=================================");

		System.out.print("Enter transaction reference: ");

		String transactionReference = scanner.nextLine();

		Transaction transaction = transactionService.findTransactionByReference(transactionReference);

		if (transaction != null) {

			System.out.println("Transaction found successfully!");

			System.out.println("Transaction Details:");

			System.out.println(transaction);

		} else {

			System.out.println("Transaction not found!");
		}
	}

	private static void findTransactionsByAccount() throws SQLException {

		System.out.println("=================================");
		System.out.println("   TRANSACTIONS BY ACCOUNT");
		System.out.println("=================================");

		System.out.print("Enter account ID: ");

		int accountId = scanner.nextInt();

		scanner.nextLine();

		List<Transaction> transactions = transactionService.findTransactionsByAccount(accountId);

		if (transactions.isEmpty()) {

			System.out.println("No transactions found for this account.");

		} else {

			System.out.println("Transactions found: " + transactions.size());

			System.out.println("---------------------------------");

			for (Transaction transaction : transactions) {

				System.out.println(transaction);
			}
		}
	}

	private static void findAllTransactions() throws SQLException {

		System.out.println("=================================");
		System.out.println("       ALL TRANSACTIONS");
		System.out.println("=================================");

		List<Transaction> transactions = transactionService.findAllTransactions();

		if (transactions.isEmpty()) {

			System.out.println("No transactions found.");

		} else {

			System.out.println("Total Transactions: " + transactions.size());

			System.out.println("---------------------------------");

			for (Transaction transaction : transactions) {

				System.out.println(transaction);
			}
		}
	}

	private static void updateTransactionStatus() throws SQLException {

		System.out.println("=================================");
		System.out.println("    UPDATE TRANSACTION STATUS");
		System.out.println("=================================");

		System.out.print("Enter transaction ID: ");

		int transactionId = scanner.nextInt();

		scanner.nextLine();

		System.out.print("Enter new status " + "(PENDING/SUCCESS/FAILED/CANCELLED): ");

		String status = scanner.nextLine();

		boolean result = transactionService.updateTransactionStatus(transactionId, status);

		if (result) {

			System.out.println("Transaction status updated successfully!");

			Transaction transaction = transactionService.findTransactionById(transactionId);

			if (transaction != null) {

				System.out.println("Updated Transaction Details:");

				System.out.println(transaction);
			}

		} else {

			System.out.println("Transaction status update failed!");

			System.out.println("Check the transaction ID or provide a valid status.");
		}
	}

	private static void makeUpiPayment() throws SQLException {

		System.out.println("=================================");
		System.out.println("          MAKE UPI PAYMENT");
		System.out.println("=================================");

		System.out.print("Enter sender account ID: ");

		int senderAccountId = scanner.nextInt();

		scanner.nextLine();

		System.out.print("Enter payment amount: ");

		BigDecimal amount = scanner.nextBigDecimal();

		scanner.nextLine();

		System.out.print("Enter recipient UPI ID: ");

		String recipientUpiId = scanner.nextLine();

		System.out.print("Enter idempotency key: ");

		String idempotencyKey = scanner.nextLine();

		PaymentResult result = paymentService.processPayment(senderAccountId, amount, recipientUpiId, idempotencyKey);

		System.out.println("=================================");

		System.out.println("          RISK ASSESSMENT");

		System.out.println("=================================");

		System.out.println("Risk Score : " + result.getRiskScore());

		System.out.println("Risk Level : " + result.getRiskLevel());

		System.out.println("Decision   : " + result.getDecision());

		System.out.println();

		if (result.isSuccess()) {

			System.out.println("=================================");

			System.out.println("        PAYMENT SUCCESSFUL");

			System.out.println("=================================");

			System.out.println("UPI Payment Successful!");

		} else {

			System.out.println("=================================");

			System.out.println("          PAYMENT FAILED");

			System.out.println("=================================");

			System.out.println("UPI Payment Failed!");

			if ("BLOCK".equalsIgnoreCase(result.getDecision())) {

				System.out.println("Payment blocked by risk engine.");
			}
		}
	}

	private static void showAccountTransactionHistory() throws SQLException {

		System.out.println();
		System.out.println("=================================");
		System.out.println("     ACCOUNT TRANSACTION HISTORY");
		System.out.println("=================================");

		System.out.print("Enter account ID: ");

		int accountId = scanner.nextInt();

		scanner.nextLine();

		List<Transaction> transactions = reportingService.getAccountTransactionHistory(accountId);

		System.out.println();

		if (transactions.isEmpty()) {

			System.out.println("No transaction history found.");

		} else {

			System.out.println("Transactions Found: " + transactions.size());

			System.out.println("---------------------------------");

			for (Transaction transaction : transactions) {

				System.out.println(transaction);
			}
		}
	}

	private static void showDateRangeTransactionHistory() throws SQLException {

		System.out.println();
		System.out.println("=================================");
		System.out.println("    DATE-RANGE TRANSACTION HISTORY");
		System.out.println("=================================");

		System.out.println("Format: yyyy-MM-dd HH:mm:ss");

		System.out.print("Enter start date/time: ");

		String startInput = scanner.nextLine();

		System.out.print("Enter end date/time: ");

		String endInput = scanner.nextLine();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		LocalDateTime startDateTime = LocalDateTime.parse(startInput, formatter);

		LocalDateTime endDateTime = LocalDateTime.parse(endInput, formatter);

		Timestamp startTime = Timestamp.valueOf(startDateTime);

		Timestamp endTime = Timestamp.valueOf(endDateTime);

		List<Transaction> transactions = reportingService.getTransactionsByDateRange(startTime, endTime);

		System.out.println();

		System.out.println("From : " + startTime);

		System.out.println("To   : " + endTime);

		System.out.println("---------------------------------");

		if (transactions.isEmpty()) {

			System.out.println("No transactions found in this date range.");

		} else {

			System.out.println("Transactions Found: " + transactions.size());

			System.out.println("---------------------------------");

			for (Transaction transaction : transactions) {

				System.out.println(transaction);
			}
		}
	}

	private static void showTransactionSummary() throws SQLException {

		System.out.println();
		System.out.println("=================================");
		System.out.println("        TRANSACTION SUMMARY");
		System.out.println("=================================");

		System.out.println("Format: yyyy-MM-dd HH:mm:ss");

		System.out.print("Enter start date/time: ");

		String startInput = scanner.nextLine();

		System.out.print("Enter end date/time: ");

		String endInput = scanner.nextLine();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		LocalDateTime startDateTime = LocalDateTime.parse(startInput, formatter);

		LocalDateTime endDateTime = LocalDateTime.parse(endInput, formatter);

		Timestamp startTime = Timestamp.valueOf(startDateTime);

		Timestamp endTime = Timestamp.valueOf(endDateTime);

		TransactionSummary summary = reportingService.getTransactionSummary(startTime, endTime);

		System.out.println();

		System.out.println("=================================");

		System.out.println("        TRANSACTION SUMMARY");

		System.out.println("=================================");

		System.out.println("From                : " + startTime);

		System.out.println("To                  : " + endTime);

		System.out.println("---------------------------------");

		System.out.println("Total Transactions  : " + summary.getTotalTransactions());

		System.out.println("Successful          : " + summary.getSuccessfulTransactions());

		System.out.println("Failed              : " + summary.getFailedTransactions());

		System.out.println("Pending             : " + summary.getPendingTransactions());

		System.out.println("---------------------------------");

		System.out.println("Total Amount        : ₹" + summary.getTotalAmount());

		System.out.println("Successful Amount   : ₹" + summary.getSuccessfulAmount());

		System.out.println("Average Amount      : ₹" + summary.getAverageAmount());

		System.out.println("---------------------------------");

		System.out.println("Low Risk            : " + summary.getLowRiskTransactions());

		System.out.println("Medium Risk         : " + summary.getMediumRiskTransactions());

		System.out.println("High Risk           : " + summary.getHighRiskTransactions());

		System.out.println("=================================");
	}

	private static void showHighRiskTransactions() throws SQLException {

		System.out.println();
		System.out.println("=================================");
		System.out.println("       HIGH-RISK TRANSACTIONS");
		System.out.println("=================================");

		System.out.print("Enter minimum risk score (default 70): ");

		String input = scanner.nextLine();

		int minimumRiskScore;

		if (input.isBlank()) {

			minimumRiskScore = 70;

		} else {

			minimumRiskScore = Integer.parseInt(input);
		}

		List<Transaction> transactions = reportingService.getHighRiskTransactions(minimumRiskScore);

		System.out.println();

		System.out.println("Minimum Risk Score: " + minimumRiskScore);

		System.out.println("---------------------------------");

		if (transactions.isEmpty()) {

			System.out.println("No high-risk transactions found.");

		} else {

			System.out.println("High-Risk Transactions: " + transactions.size());

			System.out.println("---------------------------------");

			for (Transaction transaction : transactions) {

				System.out.println("Transaction ID : " + transaction.getTransactionId());

				System.out.println("Account ID     : " + transaction.getAccountId());

				System.out.println("Reference      : " + transaction.getTransactionReference());

				System.out.println("Amount         : ₹" + transaction.getAmount());

				System.out.println("Recipient      : " + transaction.getRecipientUpiId());

				System.out.println("Status         : " + transaction.getTransactionStatus());

				System.out.println("Risk Score     : " + transaction.getRiskScore());

				System.out.println("Transaction Time: " + transaction.getTransactionTime());

				System.out.println("---------------------------------");
			}
		}
	}
}
