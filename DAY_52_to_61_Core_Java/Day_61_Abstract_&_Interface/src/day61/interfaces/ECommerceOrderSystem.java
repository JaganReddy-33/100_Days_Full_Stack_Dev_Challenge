package day61.interfaces;

import java.util.Scanner;

interface PaymentService {

    void makePayment(double amount);
}

interface NotificationService1 {

    void sendNotification(String message);
}

interface TrackingService {

    void trackOrder(String orderId);
}

class ECommerceService implements PaymentService, NotificationService1, TrackingService {

    public void makePayment(double amount) {
        System.out.println("Payment completed: ₹" + amount);
    }

    public void sendNotification(String message) {
        System.out.println("Notification sent: " + message);
    }

    public void trackOrder(String orderId) {
        System.out.println("Tracking order: " + orderId);
    }
}

public class ECommerceOrderSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter order ID: ");
        String orderId = sc.nextLine();

        System.out.print("Enter order amount: ");
        double amount = sc.nextDouble();

        ECommerceService service = new ECommerceService();

        PaymentService paymentService = service;
        NotificationService1 notificationService = service;
        TrackingService trackingService = service;

        paymentService.makePayment(amount);

        notificationService.sendNotification(
                "Order " + orderId + " payment successful"
        );

        trackingService.trackOrder(orderId);

        sc.close();
    }
}
