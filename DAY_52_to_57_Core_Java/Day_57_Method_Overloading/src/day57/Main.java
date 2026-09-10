package day57;

public class Main {

    public static void main(String[] args) {

        MethodOverloadingBasics_01 basics = new MethodOverloadingBasics_01();
        basics.display();
        basics.display("Lohith");
        basics.display("Ajay", 101);
        basics.showNumber(7);
        basics.showNumber(7.5);
        basics.showNumber("JMR-777");
        basics.printDetails("Jagan");
        basics.printDetails("Santhosh", 23);
        basics.printDetails("Kiran", 23, 45000.00);
        basics.calculate(10, 20);
        basics.calculate(10, 20, 30);
        basics.calculate(10.5, 20.5);
    	
    	
        ParameterOverloading_02 parameter = new ParameterOverloading_02();
        parameter.calculateSum(10, 20);
        parameter.calculateSum(10, 20, 30);
        parameter.calculateSum(10, 20, 30, 40);
        parameter.calculateSum(10.5, 20.5);
        parameter.calculateSum(10.5, 20.5, 30.5);
        parameter.calculateAverage(10, 20);
        parameter.calculateAverage(10, 20, 30);
        parameter.calculateAverage(10.5, 20.5, 30.5);
        parameter.printEmployee("Jagan");
        parameter.printEmployee("Jagan", 23);
        parameter.printEmployee("Jagan", 23, 45000.00);
        parameter.calculateSalary(30000);
        parameter.calculateSalary(30000, 5000);
        parameter.calculateSalary(30000, 5000, 10000);
        parameter.displayProduct("Laptop");
        parameter.displayProduct("Laptop", 55000);
        parameter.displayProduct("Laptop", 55000, 2);
    	
    	
    	TypeOverloading_03 typeOverloading = new TypeOverloading_03();
    	typeOverloading.calculateInterest(50000.0, 3);
    	typeOverloading.calculateInterest(50000.0, 7.5);
    	typeOverloading.calculateInterest(50000, 3);
    	typeOverloading.calculateBill(250);
    	typeOverloading.calculateBill(250.5);
    	typeOverloading.calculateDiscount(5000.0, 10);
    	typeOverloading.calculateDiscount(5000.0, 12.5);
    	typeOverloading.processPayment(5000);
    	typeOverloading.processPayment(5000.75);
    	typeOverloading.processPayment("TXN20260910JMR");
    	typeOverloading.createUser("Jagan", 23);
    	typeOverloading.createUser("Jagan", 23.5);
    	typeOverloading.searchProduct(101);
    	typeOverloading.searchProduct("Laptop");
    	typeOverloading.searchProduct(55000.0);
    	
    	
    	
    	OrderOverloading_04 order = new OrderOverloading_04();
    	order.processOrder("Laptop", 2);
    	order.processOrder(2, "Laptop");
    	order.processOrder("Smartphone", 25000.0);
    	order.processOrder(25000.0, "Smartphone");
    	order.employeeDetails("Jagan", 101);
    	order.employeeDetails(102, "Rahul");
    	order.paymentDetails("UPI", 15000.0);
    	order.paymentDetails(25000.0, "Credit Card");
    	order.productDetails("Monitor", 2, 12000.0);
    	order.productDetails(3, "Keyboard", 2500.0);
    	order.bookTicket("Jagan", 25);
    	order.bookTicket(30, "Rahul");
    	order.deliveryDetails("Bangalore", 560001);
    	order.deliveryDetails(600001, "Chennai");
    	
    	
    	StaticMethodOverloading_05.calculateTax(800000);
    	StaticMethodOverloading_05.calculateTax(800000, 12.5);
    	StaticMethodOverloading_05.calculateTax(800000, 12.5, 100000);
    	StaticMethodOverloading_05.generateInvoice("Jagan", 25000);
    	StaticMethodOverloading_05.generateInvoice(1001, 25000);
    	StaticMethodOverloading_05.generateInvoice("Jagan", 1001, 25000);
    	StaticMethodOverloading_05.calculateShipping(5);
    	StaticMethodOverloading_05.calculateShipping(5, 300);
    	StaticMethodOverloading_05.calculateShipping(5, 300, true);
    	StaticMethodOverloading_05.convertCurrency(100);
    	StaticMethodOverloading_05.convertCurrency(100, 83.5);
    	
    	
    	
    	Calculator_06 calculator = new Calculator_06();
    	
    	System.out.println("Addition: " + calculator.add(10, 20));
    	System.out.println("Addition: " + calculator.add(10.5, 20.5));
    	System.out.println("Addition: " + calculator.add(10, 20, 30));
    	System.out.println("Addition: " + calculator.add(10.5, 20.5, 30.5));

    	System.out.println("Subtraction: " + calculator.subtract(100, 40));
    	System.out.println("Subtraction: " + calculator.subtract(100.5, 40.5));

    	System.out.println("Multiplication: " + calculator.multiply(100, 5));
    	System.out.println("Multiplication: " + calculator.multiply(100.5, 5.5));
    	System.out.println("Final Price: " + calculator.multiply(1000, 3, 500));

    	System.out.println("Percentage: " + calculator.calculatePercentage(5000, 10));
    	System.out.println("Percentage: " + calculator.calculatePercentage(5000, 12));

    	System.out.println("Average: " + calculator.calculateAverage(10, 20));
    	System.out.println("Average: " + calculator.calculateAverage(10, 20, 30));
    	System.out.println("Average: " + calculator.calculateAverage(10.5, 20.5));
    	System.out.println("Average: " + calculator.calculateAverage(10.5, 20.5, 30.5));

    	System.out.println("Monthly EMI: " + calculator.calculateEMI(500000, 8.5, 60));

    	System.out.println("Discounted Price: " + calculator.calculateDiscount(10000, 10));

    	System.out.println("Discounted Price: " + calculator.calculateDiscount(10000, 12.5));

    	System.out.println("Final Price After Coupon: " + calculator.calculateDiscount(10000, 10, 500));
    	
    }
}