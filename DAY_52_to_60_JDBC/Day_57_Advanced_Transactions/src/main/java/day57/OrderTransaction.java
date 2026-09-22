package day57;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class OrderTransaction {
	
	private static final String SELECT_QUERY = "SELECT balance FROM accounts WHERE account_id = ? "; 
	private static final String DEDUCT_BALANCE = "UPDATE accounts SET balance = balance - ? WHERE account_id = ? ";
	private static final String INSERT_QUERY = "INSERT INTO orders "
			+ "(account_id, product_name, amount, order_status) "
			+ "VALUES (?, ?, ?, ?) ";
	
	public static void placeOrder() throws ClassNotFoundException, SQLException {
		
		try(Connection con = ConnectionEx.getConnection();
			Scanner sc = new Scanner(System.in)){
		
			con.setAutoCommit(false);
			
			System.out.println("Enter account ID: ");
			int id = sc.nextInt();
			
			double balance;
			
			try(PreparedStatement selectStmt = con.prepareStatement(SELECT_QUERY)){
				selectStmt.setInt(1, id);
				
				try(ResultSet rs = selectStmt.executeQuery()){
					if(rs.next()) {
						balance = rs.getDouble("balance");
						System.out.println("Account exists!");
						System.out.println("Current Balance: " + balance);
					} else {
						System.out.println("Account not found!");
						con.rollback();
						return;
					}
				}
			}
			
			sc.nextLine();
			System.out.println("Enter Product Name: ");
			String pName = sc.nextLine();
			
			System.out.println("Enter Product amount: ");
			double amount = sc.nextDouble();
			
			if(amount <= 0) {
				System.out.println("Invalid product amount!");
				con.rollback();
				return;
			}
			
			if(amount > balance) {
				System.out.println("Insufficient balance!");
				con.rollback();
				return;
			}
			
			
			try(PreparedStatement insertStmt = con.prepareStatement(INSERT_QUERY);
				PreparedStatement deductStmt = con.prepareStatement(DEDUCT_BALANCE)){
				
				deductStmt.setDouble(1, amount);
				deductStmt.setInt(2, id);
				
				int deductRows = deductStmt.executeUpdate();
				
				if(deductRows != 1) {
					con.rollback();
					System.out.println("Balance deduction failed!");
					return;
				}
				
				System.out.println("Balanced deducted successfully!");
				
				insertStmt.setInt(1, id);
				insertStmt.setString(2, pName);
				insertStmt.setDouble(3, amount);
				insertStmt.setString(4, "SUCCESS");
				
				int insertRows = insertStmt.executeUpdate();
				
				if(insertRows != 1) {
					con.rollback();
					System.out.println("Order creation failed!");
					return;
				}
				System.out.println("Order created successfully!");
				
				con.commit();
				
				System.out.println("Transaction committed successfully.");
                System.out.println("Product: " + pName);
                System.out.println("Order Amount: " + amount);
                System.out.println("Order Status: SUCCESS");
                System.out.println("Remaining Balance: "
                        + (balance - amount));
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
