package day57;

public class OrderOverloading_04 {

    public void processOrder(String productName, int quantity) {
        double price = 50000;
        double total = price * quantity;

        System.out.println("Product: " + productName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Order Value: ₹" + total);
    }

    public void processOrder(int quantity, String productName) {
        double price = 50000;
        double total = price * quantity;

        System.out.println("Product: " + productName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Order Value: ₹" + total);
    }

    public void processOrder(String productName, double price) {
        System.out.println("Product: " + productName);
        System.out.println("Product Price: ₹" + price);
    }

    public void processOrder(double price, String productName) {
        System.out.println("Product: " + productName);
        System.out.println("Product Price: ₹" + price);
    }

    public void employeeDetails(String name, int employeeId) {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + employeeId);
    }

    public void employeeDetails(int employeeId, String name) {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + name);
    }

    public void paymentDetails(String paymentMethod, double amount) {
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Payment Amount: ₹" + amount);
    }

    public void paymentDetails(double amount, String paymentMethod) {
        System.out.println("Payment Amount: ₹" + amount);
        System.out.println("Payment Method: " + paymentMethod);
    }

    public void productDetails(String productName, int quantity, double price) {
        double total = quantity * price;

        System.out.println("Product: " + productName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: ₹" + price);
        System.out.println("Total: ₹" + total);
    }

    public void productDetails(int quantity, String productName, double price) {
        double total = quantity * price;

        System.out.println("Quantity: " + quantity);
        System.out.println("Product: " + productName);
        System.out.println("Price: ₹" + price);
        System.out.println("Total: ₹" + total);
    }

    public void bookTicket(String passengerName, int seatNumber) {
        System.out.println("Passenger: " + passengerName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Ticket booked successfully.");
    }

    public void bookTicket(int seatNumber, String passengerName) {
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Passenger: " + passengerName);
        System.out.println("Ticket booked successfully.");
    }

    public void deliveryDetails(String address, int pincode) {
        System.out.println("Delivery Address: " + address);
        System.out.println("Pincode: " + pincode);
    }

    public void deliveryDetails(int pincode, String address) {
        System.out.println("Pincode: " + pincode);
        System.out.println("Delivery Address: " + address);
    }
}