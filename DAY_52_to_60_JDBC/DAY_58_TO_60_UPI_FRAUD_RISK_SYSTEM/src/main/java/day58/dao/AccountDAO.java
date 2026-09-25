package day58.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import day58.model.Account;

public interface AccountDAO {

    boolean createAccount(Account account) throws SQLException;

    Account findAccountById(Connection con, int accountId) throws SQLException;

    Account findAccountByIdForUpdate(Connection con, int accountId) throws SQLException;
    
    Account findAccountByUpiId(Connection con, String upiId) throws SQLException;

    Account findAccountByUpiIdForUpdate(Connection con, String upiId) throws SQLException;
    
    List<Account> findAllActiveAccounts() throws SQLException;

    boolean updateBalance(Connection con, int accountId, BigDecimal amount, String operation) throws SQLException;

    boolean updateAccountStatus(int accountId, String status) throws SQLException;
}