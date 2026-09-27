package day61.abstraction;

import java.util.Scanner;

abstract class Bird {
	abstract void fly();
	abstract void makeSound();
	
}

class Eagle extends Bird {
	
	@Override
	public void fly() {
		System.out.println("Eagle is soaring at great heights.");
	}
	
	@Override
	public void makeSound() {
		System.out.println("Eagle makes a sharp, piercing sounds.");
	}
}

class Hawk extends Bird {
	
	@Override
	public void fly() {
		System.out.println("Hawk is flying swiftly over the plains.");
	}
	
	@Override
	public void makeSound() {
		System.out.println("Hawk makes a screening sounds.");
	}
}




public class BirdsBehavious {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Bird name here..");
		String name = sc.nextLine();
		
		Bird b = null;
		
		if(name.equalsIgnoreCase("Eagle")) {
			b = new Eagle();
		} else if(name.equalsIgnoreCase("Hawk")) {
			b = new Hawk();
		} else {
			System.out.println("Invalid bird name!");
			return;
		}
		
		b.fly();
		b.makeSound();
		
		
		

	}

}
