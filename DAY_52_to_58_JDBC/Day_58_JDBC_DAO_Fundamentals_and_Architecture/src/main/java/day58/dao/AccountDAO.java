package day58.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import day58.model.Account;

public interface AccountDAO {

    boolean createAccount(Account account) throws SQLException;

    Account findAccountById(int accountId) throws SQLException;

    Account findAccountByUpiId(String upiId) throws SQLException;

    List<Account> findAllActiveAccounts() throws SQLException;

    boolean updateBalance(int accountId, BigDecimal balance) throws SQLException;

    boolean updateAccountStatus(int accountId, String status) throws SQLException;
}