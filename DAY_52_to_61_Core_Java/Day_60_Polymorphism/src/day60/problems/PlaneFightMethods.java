package day60.problems;

import java.util.Scanner;

class Plane {
	public void fly() {
		
	}
}

class CargoPlane extends Plane {
	
	@Override
	public void fly() {
		System.out.println("Cargo Plane is flying at low heights.");
	}
}

class PassengerPlane extends Plane {
	
	@Override
	public void fly() {
		System.out.println("Passenger Plane is flying at medium heights.");
	}
}

class FighterPlane extends Plane {
	
	@Override
	public void fly() {
		System.out.println("FighterPlane is flying at great heights.");
	}
}

public class PlaneFightMethods {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String type = sc.nextLine().trim();
		
		Plane plane = null;
		
		if(type.equalsIgnoreCase("CargoPlane")) {
			plane = new CargoPlane();
			
		} else if(type.equalsIgnoreCase("PassengerPlane")) {
			plane = new PassengerPlane();
			
		} else if(type.equalsIgnoreCase("FighterPlane")) {
			plane = new FighterPlane();
			
		}
		
		plane.fly();
		
	}

}
