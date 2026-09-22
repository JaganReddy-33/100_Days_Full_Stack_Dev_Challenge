package day58.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

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
    	
    	if(accountId <= 0) {
    		return null;
    	}
    	
		return accountDAO.findAccountById(accountId);
    	
    }
    
    public Account findAccountByUpiId(String upiId) throws SQLException {
    	
    	if(upiId == null || upiId.trim().isEmpty()) {
    		return null;
    	}
    	
		return accountDAO.findAccountByUpiId(upiId.trim());
    	
    }
    
    public List<Account> findAllActiveAccounts() throws SQLException{
    	
    	return accountDAO.findAllActiveAccounts();
    }
    
    public boolean updateBalance(int accountId, BigDecimal amount, String operation) throws SQLException {
    	
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
    	
		return accountDAO.updateBalance(accountId, amount, normalizedOperation);
    	
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