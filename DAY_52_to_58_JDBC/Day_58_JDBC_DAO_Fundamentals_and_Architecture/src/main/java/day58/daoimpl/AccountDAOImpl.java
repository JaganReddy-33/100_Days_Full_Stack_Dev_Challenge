package day58.daoimpl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import day58.ConnectionEx;
import day58.dao.AccountDAO;
import day58.model.Account;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public boolean createAccount(Account account) throws SQLException {
		
		String sql = "INSERT INTO accounts (user_name, upi_id, account_number, balance, account_status) "
	               + "VALUES (?, ?, ?, ?, ?)";

	    try (Connection con = ConnectionEx.getConnection();
	         PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

	        statement.setString(1, account.getUserName());
	        statement.setString(2, account.getUpiId());
	        statement.setString(3, account.getAccountNumber());
	        statement.setBigDecimal(4, account.getBalance());
	        statement.setString(5, account.getAccountStatus());

	        int rowsAffected = statement.executeUpdate();
	        
	        if (rowsAffected == 0) {
	            return false;
	        }

	        try (ResultSet resultSet = statement.getGeneratedKeys()) {

	            if (resultSet.next()) {
	                int generatedId = resultSet.getInt(1);
	                account.setAccountId(generatedId);
	                return true;
	            }
	        }

	        return false;
	    }
	}

	@Override
	public Account findAccountById(int accountId) throws SQLException {

		String sql = "SELECT * FROM accounts WHERE account_id = ? ";
		
		try(Connection con = ConnectionEx.getConnection();
				PreparedStatement statement = con.prepareStatement(sql)){
			
			statement.setInt(1, accountId);
			
			try(ResultSet res = statement.executeQuery()){
				
				if(res.next()) {
					int id = res.getInt("account_id");
	                String userName = res.getString("user_name");
	                String upiId = res.getString("upi_id");
	                String accNum = res.getString("account_number");
	                BigDecimal balance = res.getBigDecimal("balance");
	                String status = res.getString("account_status");
	                Timestamp createdAt = res.getTimestamp("created_at");
	                
	                return new Account(id, userName, upiId, accNum, balance, status, createdAt);
				}
			}
		}
		return null;
	}

	@Override
	public Account findAccountByUpiId(String upiId) throws SQLException {
		
		String sql = "SELECT * FROM accounts WHERE upi_id = ? ";
		
		try(Connection con = ConnectionEx.getConnection();
				PreparedStatement statement = con.prepareStatement(sql)){
			
			statement.setString(1, upiId);
			
			try(ResultSet res = statement.executeQuery()){
				
				if(res.next()) {
					int id = res.getInt("account_id");
	                String userName = res.getString("user_name");
	                String upi_Id = res.getString("upi_id");
	                String accNum = res.getString("account_number");
	                BigDecimal balance = res.getBigDecimal("balance");
	                String status = res.getString("account_status");
	                Timestamp createdAt = res.getTimestamp("created_at");
	                
	                return new Account(id, userName, upi_Id, accNum, balance, status, createdAt);
				}
			}
		}
		return null;
	}
	

	@Override
	public List<Account> findAllActiveAccounts() throws SQLException {
		
		List<Account> accounts = new ArrayList<>();
		
		String sql = "SELECT * FROM accounts WHERE account_status = 'ACTIVE' ";
		
		try(Connection con = ConnectionEx.getConnection();
				PreparedStatement statement = con.prepareStatement(sql)){
			
			try(ResultSet resultSet = statement.executeQuery()){
				while(resultSet.next()) {
					int id = resultSet.getInt("account_id");
	                String userName = resultSet.getString("user_name");
	                String upi_Id = resultSet.getString("upi_id");
	                String accNum = resultSet.getString("account_number");
	                BigDecimal balance = resultSet.getBigDecimal("balance");
	                String status = resultSet.getString("account_status");
	                Timestamp createdAt = resultSet.getTimestamp("created_at");
	                
	                Account account = new Account(id, userName, upi_Id, accNum, balance, status, createdAt);
	                accounts.add(account);
				}
			}
		}
		return accounts;
	}

	@Override
	public boolean updateBalance(int accountId, BigDecimal amount, String operation) throws SQLException {
		
		if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
	        return false;
	    }

	    if (operation == null) {
	        return false;
	    }

	    String sql;
		
	    if (operation.equalsIgnoreCase("CREDIT")) {

	        sql = "UPDATE accounts "
	            + "SET balance = balance + ? "
	            + "WHERE account_id = ? "
	            + "AND account_status = 'ACTIVE'";

	    } else if (operation.equalsIgnoreCase("DEBIT")) {

	        sql = "UPDATE accounts "
	            + "SET balance = balance - ? "
	            + "WHERE account_id = ? "
	            + "AND account_status = 'ACTIVE' "
	            + "AND balance >= ?";

	    } else {

	        return false;
	    }
	    
	    try (Connection con = ConnectionEx.getConnection();
	    		PreparedStatement statement = con.prepareStatement(sql)) {
	    	
	    	statement.setBigDecimal(1, amount);
	    	statement.setInt(2, accountId);

	        if (operation.equalsIgnoreCase("DEBIT")) {
	            statement.setBigDecimal(3, amount);
	        }

	        int rowsAffected = statement.executeUpdate();

	        return rowsAffected > 0;
	    }
	}

	@Override
	public boolean updateAccountStatus(int accountId, String status) throws SQLException {
		
		if (status == null || status.trim().isEmpty()) {
	        return false;
	    }
		
		String normalizedStatus = status.trim().toUpperCase();

	    if (!normalizedStatus.equals("ACTIVE")
	            && !normalizedStatus.equals("SUSPENDED")
	            && !normalizedStatus.equals("BLOCKED")) {
	        return false;
	    }
	    
	    String sql = "UPDATE accounts "
	               + "SET account_status = ? "
	               + "WHERE account_id = ?";

	    try (Connection con = ConnectionEx.getConnection();
	         PreparedStatement statement = con.prepareStatement(sql)) {

	        statement.setString(1, normalizedStatus);
	        statement.setInt(2, accountId);

	        int rowsAffected = statement.executeUpdate();

	        return rowsAffected > 0;
	    }
	}

}