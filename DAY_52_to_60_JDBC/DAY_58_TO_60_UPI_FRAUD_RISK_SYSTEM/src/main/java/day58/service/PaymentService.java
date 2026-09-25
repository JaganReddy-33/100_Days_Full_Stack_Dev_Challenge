
package day58.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

import day58.ConnectionEx;
import day58.dao.AccountDAO;
import day58.dao.TransactionDAO;
import day58.model.Account;
import day58.model.PaymentResult;
import day58.model.RiskAssessment;
import day58.model.Transaction;

public class PaymentService {

	private final AccountDAO accountDAO;
	private final TransactionDAO transactionDAO;
	private final RiskService riskService;

	public PaymentService(AccountDAO accountDAO, TransactionDAO transactionDAO, RiskService riskService) {

		this.accountDAO = accountDAO;
		this.transactionDAO = transactionDAO;
		this.riskService = riskService;
	}

	public PaymentResult processPayment(
            int senderAccountId,
            BigDecimal amount,
            String recipientUpiId,
            String idempotencyKey) throws SQLException {

        Connection con = ConnectionEx.getConnection();

        con.setAutoCommit(false);

        con.setTransactionIsolation(
                Connection.TRANSACTION_READ_COMMITTED
        );

        try {

            if (amount == null ||
                    amount.compareTo(BigDecimal.ZERO) <= 0) {

                con.rollback();

                return new PaymentResult(
                        false,
                        0,
                        "UNKNOWN",
                        "BLOCK"
                );
            }

            if (recipientUpiId == null ||
                    recipientUpiId.trim().isEmpty()) {

                con.rollback();

                return new PaymentResult(
                        false,
                        0,
                        "UNKNOWN",
                        "BLOCK"
                );
            }

            if (idempotencyKey == null ||
                    idempotencyKey.trim().isEmpty()) {

                con.rollback();

                return new PaymentResult(
                        false,
                        0,
                        "UNKNOWN",
                        "BLOCK"
                );
            }

            Transaction existingTransaction =
                    transactionDAO.findTransactionByIdempotencyKey(
                            con,
                            idempotencyKey
                    );

            if (existingTransaction != null) {

                con.rollback();

                return new PaymentResult(
                        "SUCCESS".equalsIgnoreCase(
                                existingTransaction.getTransactionStatus()
                        ),
                        existingTransaction.getRiskScore(),
                        "UNKNOWN",
                        "EXISTING_TRANSACTION"
                );
            }

            Account sender =
                    accountDAO.findAccountById(
                            con,
                            senderAccountId
                    );

            if (sender == null) {

                con.rollback();

                return new PaymentResult(
                        false,
                        0,
                        "UNKNOWN",
                        "BLOCK"
                );
            }

            Account receiver =
                    accountDAO.findAccountByUpiId(
                            con,
                            recipientUpiId
                    );

            if (receiver == null) {

                con.rollback();

                return new PaymentResult(
                        false,
                        0,
                        "UNKNOWN",
                        "BLOCK"
                );
            }

            if (sender.getAccountId() ==
                    receiver.getAccountId()) {

                con.rollback();

                return new PaymentResult(
                        false,
                        0,
                        "UNKNOWN",
                        "BLOCK"
                );
            }

            if (sender.getAccountId() <
                    receiver.getAccountId()) {

                sender =
                        accountDAO.findAccountByIdForUpdate(
                                con,
                                sender.getAccountId()
                        );

                receiver =
                        accountDAO.findAccountByUpiIdForUpdate(
                                con,
                                receiver.getUpiId()
                        );

            } else {

                receiver =
                        accountDAO.findAccountByUpiIdForUpdate(
                                con,
                                receiver.getUpiId()
                        );

                sender =
                        accountDAO.findAccountByIdForUpdate(
                                con,
                                sender.getAccountId()
                        );
            }

            if (!"ACTIVE".equalsIgnoreCase(
                    sender.getAccountStatus())) {

                con.rollback();

                return new PaymentResult(
                        false,
                        0,
                        "UNKNOWN",
                        "BLOCK"
                );
            }

            if (!"ACTIVE".equalsIgnoreCase(
                    receiver.getAccountStatus())) {

                con.rollback();

                return new PaymentResult(
                        false,
                        0,
                        "UNKNOWN",
                        "BLOCK"
                );
            }

            if (sender.getBalance().compareTo(amount) < 0) {

                con.rollback();

                return new PaymentResult(
                        false,
                        0,
                        "UNKNOWN",
                        "BLOCK"
                );
            }

            RiskAssessment riskAssessment =
                    riskService.evaluate(
                            con,
                            sender,
                            receiver,
                            amount
                    );

            if ("BLOCK".equalsIgnoreCase(
                    riskAssessment.getDecision())) {

                con.rollback();

                return new PaymentResult(
                        false,
                        riskAssessment.getRiskScore(),
                        riskAssessment.getRiskLevel(),
                        riskAssessment.getDecision()
                );
            }

            String transactionReference =
                    UUID.randomUUID().toString();

            Transaction transaction =
                    new Transaction();

            transaction.setAccountId(
                    senderAccountId
            );

            transaction.setTransactionReference(
                    transactionReference
            );

            transaction.setIdempotencyKey(
                    idempotencyKey
            );

            transaction.setTransactionType(
                    "UPI_PAYMENT"
            );

            transaction.setAmount(
                    amount
            );

            transaction.setRecipientUpiId(
                    recipientUpiId
            );

            transaction.setTransactionStatus(
                    "PENDING"
            );

            transaction.setRiskScore(
                    riskAssessment.getRiskScore()
            );

            boolean debited =
                    accountDAO.updateBalance(
                            con,
                            senderAccountId,
                            amount,
                            "DEBIT"
                    );

            if (!debited) {

                con.rollback();

                return new PaymentResult(
                        false,
                        riskAssessment.getRiskScore(),
                        riskAssessment.getRiskLevel(),
                        riskAssessment.getDecision()
                );
            }

            boolean credited =
                    accountDAO.updateBalance(
                            con,
                            receiver.getAccountId(),
                            amount,
                            "CREDIT"
                    );

            if (!credited) {

                con.rollback();

                return new PaymentResult(
                        false,
                        riskAssessment.getRiskScore(),
                        riskAssessment.getRiskLevel(),
                        riskAssessment.getDecision()
                );
            }

            boolean transactionCreated =
                    transactionDAO.createTransaction(
                            con,
                            transaction
                    );

            if (!transactionCreated) {

                con.rollback();

                return new PaymentResult(
                        false,
                        riskAssessment.getRiskScore(),
                        riskAssessment.getRiskLevel(),
                        riskAssessment.getDecision()
                );
            }

            boolean statusUpdated =
                    transactionDAO.updateTransactionStatus(
                            con,
                            transaction.getTransactionId(),
                            "SUCCESS"
                    );

            if (!statusUpdated) {

                con.rollback();

                return new PaymentResult(
                        false,
                        riskAssessment.getRiskScore(),
                        riskAssessment.getRiskLevel(),
                        riskAssessment.getDecision()
                );
            }

            con.commit();

            return new PaymentResult(
                    true,
                    riskAssessment.getRiskScore(),
                    riskAssessment.getRiskLevel(),
                    riskAssessment.getDecision()
            );

        } catch (SQLException e) {

            con.rollback();

            throw e;

        } finally {

            con.close();
        }
    }
}
