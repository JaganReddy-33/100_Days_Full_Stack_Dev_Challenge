package day60.runtime;

class Payment {
	
	public void processPayment() {
		System.out.println("Processing payment... ");
	}
}

class UPIPayment extends Payment {
	
	@Override
	public void processPayment() {
		System.out.println("UPI Payment | processing payment through UPi");
	}
}

class CardPayment extends Payment {
	
	@Override
	public void processPayment() {
		System.out.println("Card payment | Processing payment through Card");
	}
}


public class RuntimePolymorphismEx_01 {
	
	public static void main(String[] args) {
		
		Payment py;
		
		py = new UPIPayment();
		py.processPayment();
		
		 py = new CardPayment();
		py.processPayment();
	}
}
