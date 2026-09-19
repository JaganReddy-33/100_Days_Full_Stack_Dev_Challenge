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
    	
    	
    	
    	AreaCalculator_07 calculator2 = new AreaCalculator_07();
    	calculator2.area(5);
    	calculator2.area(10, 20);
    	calculator2.area(7.5);
    	calculator2.area(10.0, 20.0);
    	calculator2.area(7.5f, "sq.units");
    	calculator2.area(10, 20, "Rectangle");
    	calculator2.area(10.5, 20.5, "Rectangle");
    	calculator2.area(10, 20, true);
    	calculator2.area(3.0, 4.0, 5.0);
    	calculator2.area(7.5, "sq.units", true);
    	
    	
    	MaxValue_08 maxValue = new MaxValue_08();
    	maxValue.max(10, 20);
    	maxValue.max(15.5, 12.5);
    	maxValue.max(10, 30, 20);
    	maxValue.max(12.5, 25.5, 18.5);
    	maxValue.max(10, 20.5);
    	maxValue.max(30.5, 20);
    	maxValue.max(15.5f, 25.5f);
    	maxValue.max(100L, 200L);
    	maxValue.max("Java", "Python");
    	maxValue.max(50, 80, "Maximum Value");
    	
    	
    	
    	StringUtility_09 stringUtility = new StringUtility_09();
    	stringUtility.process("Java Programming");
    	stringUtility.process("Java", " Development");
    	stringUtility.process("Programming", 'g');
    	stringUtility.process("Java Programming", 5);
    	stringUtility.process("Jagan", true);
    	stringUtility.process("Jagan", "Reddy", " ");
    	stringUtility.process("Java Programming", 5, 16);
    	stringUtility.process("Java Programming", 'a', 'o');
    	stringUtility.process("Java Java Java", "Java", "Python", true);
    	
    	
    	EmployeeUtility_10 employee = new EmployeeUtility_10();
    	employee.employeeDetails(101);
    	employee.employeeDetails(102, "Jagan");
    	employee.employeeDetails(103, "Ravi", "Development");
    	employee.employeeDetails(104, "Kiran", 55000);
    	employee.employeeDetails("Priya", "Testing", 60000);
    	employee.calculateSalary(40000);
    	employee.calculateSalary(40000, 5000);
    	employee.calculateSalary(40000, 5000, 2000);
    	employee.calculateBonus(50000, 10);
    	employee.calculateBonus(50000, 5000);
    	employee.calculateExperience(2022, 2026);
    	employee.calculateExperience(2022, 2026, "years");
    	
    	
    	OverloadingProblems_11 problems = new OverloadingProblems_11();
    	problems.display(100);
    	problems.display(99.5);
    	problems.display("Java");
    	problems.display(101, "Employee");
    	problems.display("Employee", 101);
    	problems.calculate(10, 20);
    	problems.calculate(10.5, 20.5);
    	problems.calculate(10, 20.5);
    	problems.calculate(10.5, 20);
    	problems.print("Java");
    	problems.print("Java", 3);
    	problems.print(101, "Employee ID");
    	problems.convert(100);
    	problems.convert(99.5);
    	problems.convert("Java");
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
}