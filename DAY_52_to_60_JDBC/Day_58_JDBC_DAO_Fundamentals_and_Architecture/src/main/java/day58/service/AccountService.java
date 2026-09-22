package day58.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import day58.ConnectionEx;
import day58.dao.AccountDAO;
import day58.daoimpl.AccountDAOImpl;
import day58.model.Account;

public class AccountService {

    private AccountDAO accountDAO;

    public AccountService() {
        accountDAO = new AccountDAOImpl();
    }

    public boolean createAccount(Account account) throws SQLException {

        if (account == null) {
            return false;
        }

        if (account.getUserName() == null
                || account.getUserName().trim().isEmpty()) {
            return false;
        }

        if (account.getUpiId() == null
                || account.getUpiId().trim().isEmpty()) {
            return false;
        }

        if (account.getAccountNumber() == null
                || account.getAccountNumber().trim().isEmpty()) {
            return false;
        }

        if (account.getBalance() == null
                || account.getBalance().compareTo(BigDecimal.ZERO) < 0) {
            return false;
        }

        account.setAccountStatus("ACTIVE");

        return accountDAO.createAccount(account);
    }
    
    
    public Account findAccountById(int accountId) throws SQLException {
    	Connection con = ConnectionEx.getConnection();
    	
    	if(accountId <= 0) {
    		return null;
    	}
    	
    	try {
    		return accountDAO.findAccountById(con, accountId);
    	} finally {
    		con.close();
    	}
    	
    }
    
    public Account findAccountByUpiId(String upiId) throws SQLException {
    	
    	Connection con = ConnectionEx.getConnection();
    	
    	if(upiId == null || upiId.trim().isEmpty()) {
    		return null;
    	}
    	
    	try {
            return accountDAO.findAccountByUpiId(con, upiId);
            
        } finally {
            con.close();
        }
    	
    }
    
    public List<Account> findAllActiveAccounts() throws SQLException{
    	
    	return accountDAO.findAllActiveAccounts();
    }
    
    public boolean updateBalance(int accountId, BigDecimal amount, String operation) throws SQLException {
    	
    	Connection con = ConnectionEx.getConnection();
    	
    	if(accountId <= 0) {
    		return false;
    	}
    	
    	if(amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
    		return false;
    	}
    	
    	if(operation == null || operation.trim().isEmpty()) {
    		return false;
    	}
    	
    	String normalizedOperation = operation.trim().toUpperCase();
    	
    	if(!normalizedOperation.equals("CREDIT") && !normalizedOperation.equals("DEBIT")) {
    		return false;
    	}
    	
		try {
			return accountDAO.updateBalance(con, accountId, amount, normalizedOperation);
		} finally {
			con.close();
		}
    	
    }
    
    
    public boolean updateAccountStatus(int accountId, String status) throws SQLException {

        if (accountId <= 0) {
            return false;
        }

        if (status == null || status.trim().isEmpty()) {
            return false;
        }

        String normalizedStatus = status.trim().toUpperCase();

        if (!normalizedStatus.equals("ACTIVE")
                && !normalizedStatus.equals("SUSPENDED")
                && !normalizedStatus.equals("BLOCKED")) {
            return false;
        }

        return accountDAO.updateAccountStatus(accountId, normalizedStatus);
    }
}