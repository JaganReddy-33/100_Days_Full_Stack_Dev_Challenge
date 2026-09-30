package day61.interfaces;

import java.util.Scanner;

interface NotificationService {

    void sendNotification(String recipient, String message);
}

class EmailNotification implements NotificationService {

    public void sendNotification(String recipient, String message) {
        System.out.println("Email sent to: " + recipient);
        System.out.println("Message: " + message);
    }
}

class SMSNotification implements NotificationService {

    public void sendNotification(String recipient, String message) {
        System.out.println("SMS sent to: " + recipient);
        System.out.println("Message: " + message);
    }
}

class WhatsAppNotification implements NotificationService {

    public void sendNotification(String recipient, String message) {
        System.out.println("WhatsApp message sent to: " + recipient);
        System.out.println("Message: " + message);
    }
}

public class NotificationServiceSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Email");
        System.out.println("2. SMS");
        System.out.println("3. WhatsApp");

        System.out.print("Choose notification type: ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter recipient: ");
        String recipient = sc.nextLine();

        System.out.print("Enter message: ");
        String message = sc.nextLine();

        NotificationService notificationService;

        if (choice == 1) {
            notificationService = new EmailNotification();
        } else if (choice == 2) {
            notificationService = new SMSNotification();
        } else if (choice == 3) {
            notificationService = new WhatsAppNotification();
        } else {
            System.out.println("Invalid notification type");
            sc.close();
            return;
        }

        notificationService.sendNotification(recipient, message);

        sc.close();
    }
}