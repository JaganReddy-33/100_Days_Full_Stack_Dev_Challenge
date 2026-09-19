package day59.overriding;

public class Main {
	
	public static void main(String[] args) {
		
//		BasicMethodOverriding_07 paymentProcessor = new BasicMethodOverriding_07();
//		paymentProcessor.processPayment();
//		paymentProcessor.validatePayment();
//		paymentProcessor.generateReceipt();
//		System.out.println(paymentProcessor.getPaymentStatus());
		
		
//		MethodOverridingRules_08 paymentService = new MethodOverridingRules_08();
//		paymentService.processPayment();
//		paymentService.validateTransaction();
//		System.out.println(paymentService.getPaymentStatus());
//		paymentService.generateReference();
		
		
		UPIPayment upiPayment = new UPIPayment();

		upiPayment.validatePayment();
		upiPayment.processPayment();
		upiPayment.checkRisk();
		System.out.println(upiPayment.getPaymentStatus());

		RealWorldMethodOverriding_09 cardPayment =
		        new RealWorldMethodOverriding_09();

		cardPayment.validatePayment();
		cardPayment.processPayment();
		cardPayment.checkRisk();
		System.out.println(cardPayment.getPaymentStatus());
		
		
	}
}
