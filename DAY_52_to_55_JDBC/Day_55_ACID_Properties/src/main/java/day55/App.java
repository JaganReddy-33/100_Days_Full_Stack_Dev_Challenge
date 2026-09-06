package day55;

public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException{
    	
    	Atomicity atomicity = new Atomicity();

    	atomicity.deductAndCommit();
    	atomicity.addAndCommit();
    	atomicity.transactionWithRollback();
    	atomicity.transferJaganToLohith();
    	atomicity.failedTransfer();
    	atomicity.multipleOperationsTransaction();
    	atomicity.transferWithAccountCheck();
    	atomicity.completeAtomicTransaction();
        
    }
}
