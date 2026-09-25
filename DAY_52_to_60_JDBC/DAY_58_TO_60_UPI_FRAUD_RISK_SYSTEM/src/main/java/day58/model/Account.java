package day58.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Account {

    private int accountId;
    private String userName;
    private String upiId;
    private String accountNumber;
    private BigDecimal balance;
    private String accountStatus;
    private Timestamp createdAt;

    public Account() {
    }

    public Account(int accountId, String userName, String upiId, String accountNumber,
                   BigDecimal balance, String accountStatus, Timestamp createdAt) {
        this.accountId = accountId;
        this.userName = userName;
        this.upiId = upiId;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountStatus = accountStatus;
        this.createdAt = createdAt;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", userName='" + userName + '\'' +
                ", upiId='" + upiId + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", accountStatus='" + accountStatus + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}