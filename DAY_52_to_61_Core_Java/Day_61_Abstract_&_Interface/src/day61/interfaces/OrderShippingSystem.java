package day61.interfaces;

import java.util.Scanner;

interface ShippingService {

    double calculateShippingCost(double weight);

    void shipOrder(String orderId);

    void trackOrder(String orderId);
}

class StandardShipping implements ShippingService {

    public double calculateShippingCost(double weight) {
        return weight * 40;
    }

    public void shipOrder(String orderId) {
        System.out.println("Order " + orderId + " shipped using Standard Shipping");
    }

    public void trackOrder(String orderId) {
        System.out.println("Tracking Standard shipment for " + orderId);
    }
}

class ExpressShipping implements ShippingService {

    public double calculateShippingCost(double weight) {
        return weight * 80;
    }

    public void shipOrder(String orderId) {
        System.out.println("Order " + orderId + " shipped using Express Shipping");
    }

    public void trackOrder(String orderId) {
        System.out.println("Tracking Express shipment for " + orderId);
    }
}

class SameDayShipping implements ShippingService {

    public double calculateShippingCost(double weight) {
        return weight * 120;
    }

    public void shipOrder(String orderId) {
        System.out.println("Order " + orderId + " shipped using Same-Day Shipping");
    }

    public void trackOrder(String orderId) {
        System.out.println("Tracking Same-Day shipment for " + orderId);
    }
}

public class OrderShippingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter order ID: ");
        String orderId = sc.nextLine();

        System.out.print("Enter package weight: ");
        double weight = sc.nextDouble();

        System.out.println("1. Standard Shipping");
        System.out.println("2. Express Shipping");
        System.out.println("3. Same-Day Shipping");

        System.out.print("Choose shipping method: ");
        int choice = sc.nextInt();

        ShippingService shippingService;

        if (choice == 1) {
            shippingService = new StandardShipping();
        } else if (choice == 2) {
            shippingService = new ExpressShipping();
        } else if (choice == 3) {
            shippingService = new SameDayShipping();
        } else {
            System.out.println("Invalid shipping method");
            sc.close();
            return;
        }

        double cost = shippingService.calculateShippingCost(weight);

        System.out.println("Shipping Cost: ₹" + cost);

        shippingService.shipOrder(orderId);
        shippingService.trackOrder(orderId);

        sc.close();
    }
}
