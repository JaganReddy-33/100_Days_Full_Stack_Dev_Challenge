package day60.problems;

import java.util.*;


class Vehicle {
  public void startEngine() {
    System.out.println("Vehicle Engine Started.");
  }

  public void stopEngine() {
    System.out.println("Vehicle Engine Stopped.");
  }
}

class Car extends Vehicle {
  @Override
  public void startEngine() {
    System.out.println("Car Engine Started.");
  }

  @Override
  public void stopEngine() {
    System.out.println("Car Engine Stopped.");
  }
}

class Motorcycle extends Vehicle {
  @Override
  public void startEngine() {
    System.out.println("Motorcycle Engine Started.");
  }

  @Override
  public void stopEngine() {
    System.out.println("Motorcycle Engine Stopped.");
  }
}

public class VehicleMethods {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    String vehicleType = scanner.nextLine().trim();

    Vehicle vehicle = null;

    if (vehicleType.equalsIgnoreCase("Car")) {
      vehicle = new Car();
    } else if (vehicleType.equalsIgnoreCase("Motorcycle")) {
      vehicle = new Motorcycle();
    }
      
    vehicle.startEngine();
    vehicle.stopEngine();
  }
}