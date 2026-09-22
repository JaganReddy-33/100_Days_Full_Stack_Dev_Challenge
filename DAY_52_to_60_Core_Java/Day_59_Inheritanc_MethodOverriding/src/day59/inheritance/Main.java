package day59.inheritance;

public class Main {
    public static void main(String[] args) {

//    	BasicInheritance_01 paymentAccount = new BasicInheritance_01();
//        paymentAccount.setAccountType("UPI Account");
//        paymentAccount.showAccountType();
//        paymentAccount.processPayment();
        
    	
//    	SingleInheritance_02 account = new SingleInheritance_02();
//    	account.setAccountDetails("Acc1008", "ACTIVE");
//    	account.setUpiId("jagan@upi");
//    	account.showAccountDetails();
//    	account.processingPayment();
        
    	
//    	MultilevelInheritance_03 account = new MultilevelInheritance_03();
//    	account.setAccountNumber("ACC1009");
//    	account.setAccountStatus("ACTIVE");
//    	account.setUpiId("jagan@upi");
//    	account.showAccountNumber();
//    	account.showAccountStatus();
//    	account.processUpiPayment();
    	
    	
//    	UPIAccount upiAccount = new UPIAccount();
//    	upiAccount.setAccountDetails("ACC1010", "ACTIVE");
//    	upiAccount.setUpiId("jagan@upi");
//    	upiAccount.showAccountDetails();
//    	upiAccount.processingUpiPayment();
//
//    	HierarchicalInheritance_04 cardAccount = new HierarchicalInheritance_04();
//    	cardAccount.setAccountDetails("ACC1011", "ACTIVE");
//    	cardAccount.setCardNumber("CARD1011");
//    	cardAccount.showAccountDetails();
//    	cardAccount.processCardPayment();
    	
    	
    	
//    	InheritanceWithConstructors_05 account = new InheritanceWithConstructors_05( "ACC1012", "ACTIVE", "jagan@upi");
//    	account.showAccountDetails();
//    	account.showUpiDetails();
    	
    	
    	InheritanceRealWorld_06 account = new InheritanceRealWorld_06(1013, "ACTIVE", "jagan@upi", 85);
    	account.showAccountDetails();
    	account.showUpiDetails();
    	account.showRiskDetails();
    	System.out.println("High Risk: " + account.isHighRisk());
    	
    	
    }
}