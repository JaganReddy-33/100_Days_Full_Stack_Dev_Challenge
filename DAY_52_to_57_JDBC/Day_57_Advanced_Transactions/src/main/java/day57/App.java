package day57;

import java.sql.SQLException;

public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException{
        
    	SavepointBasics.savepointExample();
    	MultipleSavepoints.multipleSavepointExample();
    	PartialRollback.partialRollbackExample();
    	TransactionValidation.validatedTransfer();
    	InsertUpdateTransaction.depositWithTransactionHistory();
    }
}
