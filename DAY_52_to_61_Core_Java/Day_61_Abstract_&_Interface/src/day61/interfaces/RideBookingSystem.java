package day61.interfaces;

import java.util.Scanner;

interface RideService {

    double calculateFare(double distance);

    void startRide(String rideId);

    void endRide(String rideId);
}

class BikeRide implements RideService {

    public double calculateFare(double distance) {
        return 20 + distance * 10;
    }

    public void startRide(String rideId) {
        System.out.println("Bike ride started: " + rideId);
    }

    public void endRide(String rideId) {
        System.out.println("Bike ride completed: " + rideId);
    }
}

class AutoRide implements RideService {

    public double calculateFare(double distance) {
        return 30 + distance * 15;
    }

    public void startRide(String rideId) {
        System.out.println("Auto ride started: " + rideId);
    }

    public void endRide(String rideId) {
        System.out.println("Auto ride completed: " + rideId);
    }
}

class CabRide implements RideService {

    public double calculateFare(double distance) {
        return 50 + distance * 20;
    }

    public void startRide(String rideId) {
        System.out.println("Cab ride started: " + rideId);
    }

    public void endRide(String rideId) {
        System.out.println("Cab ride completed: " + rideId);
    }
}

public class RideBookingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ride ID: ");
        String rideId = sc.nextLine();

        System.out.print("Enter distance in km: ");
        double distance = sc.nextDouble();

        System.out.println("1. Bike");
        System.out.println("2. Auto");
        System.out.println("3. Cab");

        System.out.print("Choose ride type: ");
        int choice = sc.nextInt();

        RideService rideService;

        if (choice == 1) {
            rideService = new BikeRide();
        } else if (choice == 2) {
            rideService = new AutoRide();
        } else if (choice == 3) {
            rideService = new CabRide();
        } else {
            System.out.println("Invalid ride type");
            sc.close();
            return;
        }

        double fare = rideService.calculateFare(distance);

        System.out.println("Estimated Fare: ₹" + fare);

        rideService.startRide(rideId);
        rideService.endRide(rideId);

        sc.close();
    }
}
