package day60.problems;

import java.util.Scanner;

class Animal {
	
	public void sound() {
		
	}
}

class Bird extends Animal {
	
	@Override
	public void sound() {
		System.out.println("Chirp..Chirp");
	}
}

class Cat extends Animal {
	
	@Override
	public void sound() {
		System.out.println("Meow..Meow..");
	}
}


public class AnimalSoundMethod {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String type = sc.nextLine().trim();
		
		Animal a = null;
		
		if(type.equalsIgnoreCase("Bird")) {
			a = new Bird();
		} else if(type.equalsIgnoreCase("Cat")) {
			a = new Cat();
		} else {
			System.out.println("Unknown animal type");
			return;
		}
		
		a.sound();
		
	}
}
