package day56;

import java.sql.SQLException;

public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
        Question1.basicDebitTransaction();
    	Question2.multipleOperationsTransaction();
    	Question3.bankTransfer();
    	Question4.rollbackOnBusinessFailure();
    	Question5.completeTransactionAndVerify();
    }
}
