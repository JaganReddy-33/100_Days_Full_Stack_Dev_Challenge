package day58.daoimpl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import day58.ConnectionEx;
import day58.dao.AccountDAO;
import day58.model.Account;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public boolean createAccount(Account account) throws SQLException {
		
		String sql = "INSERT INTO accounts (user_name, upi_id, account_number, balance, account_status) "
	               + "VALUES (?, ?, ?, ?, ?)";

	    try (Connection connection = ConnectionEx.getConnection();
	         PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account findAccountByUpiId(String upiId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> findAllActiveAccounts() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateBalance(int accountId, BigDecimal balance) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateAccountStatus(int accountId, String status) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}