package day61.abstraction;

import java.util.Scanner;

abstract class Animals { 
	
	abstract void eat();
	abstract void sleep();
	
}

class Lion1 extends Animals {
	
	@Override
	public void eat() {
		System.out.println("Lion is eating meat.");
	}
	
	@Override
	public void sleep() {
		System.out.println("Lion sleeps in its den for 8 hours.");
	}
}

class Tiger1 extends Animals {
	
	@Override
	public void eat() {
		System.out.println("Tiger is eating meat.");
	}
	
	@Override
	public void sleep() {
		System.out.println("Tiger sleeps under a tree fro 7 hours.");
	}
}

class Deer extends Animals {
	
	@Override
	public void eat() {
		System.out.println("Deer is eating grass.");
	}
	
	@Override
	public void sleep() {
		System.out.println("Deer sleeps in the forest for 6 hours.");
	}
}


public class AnimalsBehaviours {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter animal name here..");
		String name = sc.nextLine();
		
		Animals a = null;
		
		if(name.equalsIgnoreCase("Lion")) {
			a = new Lion1();
		} else if(name.equalsIgnoreCase("Tiger")) {
			a = new Tiger1();
		} else if(name.equalsIgnoreCase("Deer")) {
			a = new Deer();
		} else {
			System.out.println("Wrong animal name!");
			return;
		}
		
		a.eat();
		a.sleep();

	}

}
