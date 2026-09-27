package day61.abstraction;

import java.util.Scanner;

abstract class Animal {
	abstract void sound();
	
}

class Lion extends Animal {
	
	@Override
	public void sound() {
		System.out.println("Roar...");
	}
}

class Tiger extends Animal {
	
	@Override
	public void sound() {
		System.out.println("Growl...");
	}
}

public class AnimalSounds {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Animal Name here...");
		String str = sc.nextLine();
		
		Animal a = null;
		
		if(str.equalsIgnoreCase("Lion")) {
			a = new Lion();
		} else if(str.equalsIgnoreCase("Tiger")) {
			a = new Tiger();
		} else {
		    System.out.println("Invalid animal name!");
		    return;
		}
		
		a.sound();
		
	}

}
