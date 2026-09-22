package day59.problems;

import java.util.Scanner;

class Vehicle {
	private String brand;
	private String model;
	
	public Vehicle(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getInfo() {
		return "Brand: " + brand + " Model: "+model;
	}
}

class Car extends Vehicle {
	private int seats;
	
	public Car(String brand, String model, int seats) {
		super(brand, model);
		this.seats = seats;
	}
	
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	@Override
	public String getInfo() {
		return super.getInfo() + ", Seats: "+seats;
	}
}

class Bike extends Vehicle {
	private String type;
	
	public Bike(String brand, String model, String type) {
		super(brand, model);
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String getInfo() {
		return super.getInfo() + ", Type: " + type;
	}
}

public class VehicleInformationSystem {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String type = sc.nextLine().trim();
		String detailsLine = sc.nextLine().trim();
		
		String[] arr = detailsLine.split(",");
		String brand = arr[0];
		String model = arr[1];
		
		if(type.equalsIgnoreCase("Car")) {
			int seats = Integer.parseInt(arr[2]);
			Car car = new Car(brand, model, seats);
			System.out.println("Vehicle Info: " + car.getInfo());
		} else if(type.equalsIgnoreCase("Bike")) {
			String Type = arr[2];
			Bike bike = new Bike(brand, model, Type);
			System.out.println("Vehicle Info: " + bike.getInfo());
		}
				
	}

}
