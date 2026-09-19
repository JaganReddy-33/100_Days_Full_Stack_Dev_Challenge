package day57;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PaymentTransaction {
	
	private static final String BALANCE_QUERY = "SELECT balance FROM accounts WHERE account_id = ?";
	private static final String DEDUCT_QUERY = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";
	private static final String INSERT_PAYMENT = "INSERT INTO payments "
	        + "(account_id, amount, payment_method, payment_status) "
	        + "VALUES (?, ?, ?, ?)";
	
	
	public static void makePayment() throws ClassNotFoundException, SQLException {
		
		try(Connection con = ConnectionEx.getConnection();
			Scanner sc = new Scanner(System.in)){
			
			con.setAutoCommit(false);
			
			System.out.println("Enter Account ID: ");
			int id = sc.nextInt();
			
			double balance; 
			
			try(PreparedStatement selectStmt = con.prepareStatement(BALANCE_QUERY)){
				
				selectStmt.setInt(1, id);
				
				try(ResultSet rs = selectStmt.executeQuery()){
					
					if(rs.next()) {
						balance = rs.getDouble("balance");
						System.out.println("User Account exist!");
						System.out.println("User Account balance: " + balance);
					} else {
						con.rollback();
						System.out.println("Account not found!");
						return;
					}
				}
			}
			
			System.out.println("Enter payment amount: ");
			double amount = sc.nextDouble();
			
			sc.nextLine();
			
			System.out.println("Enter Payment Method: ");
			String paymentMethod = sc.nextLine();
			
			if(amount <= 0) {
				System.out.println("Invalid payment amount!");
				con.rollback();
				return;
			}
			
			if(amount > balance) {
				System.out.println("Insufficient Balance!");
				con.rollback();
				return;
			}
			
			
			try(PreparedStatement deductStmt = con.prepareStatement(DEDUCT_QUERY);
				PreparedStatement insertStmt = con.prepareStatement(INSERT_PAYMENT)){
				
				deductStmt.setDouble(1, amount);
				deductStmt.setInt(2, id);
				
				int deductRows = deductStmt.executeUpdate();
				
				if(deductRows != 1) {
					con.rollback();
					System.out.println("Payment Deduction failed!");
					return;
				}
				System.out.println("Payment Deduction Successful!");
				
				insertStmt.setInt(1, id);
				insertStmt.setDouble(2, amount);
				insertStmt.setString(3, paymentMethod);
				insertStmt.setString(4, "SUCCESS");
				
				int insertRows = insertStmt.executeUpdate();
				if(insertRows != 1) {
					con.rollback();
					System.out.println("Insertion Payment Record fail!");
					return;
				}
				System.out.println("Insertion Payment Record Successful!");
				con.commit();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
