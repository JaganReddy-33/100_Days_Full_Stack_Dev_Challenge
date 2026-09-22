package day60.problems;

import java.util.Scanner;

class Sports {
	public void play() {
		
	}
}

class Football extends Sports {
	
	@Override
	public void play() {
		System.out.println("Playing football on the ground..");
	}
}

class Basketball extends Sports {
	
	@Override
	public void play() {
		System.out.println("Playing basketball on the Court..");
	}
}

class Rubgy extends Sports {
	
	@Override
	public void play() {
		System.out.println("Playing rubgy on the pitch...");
	}
}


public class SportsClasses {
	
	public static void main(String[] args ) {
		Scanner sc = new Scanner(System.in);
		
		String type = sc.nextLine().trim();
		
		Sports s = null;
		
		if(type.equalsIgnoreCase("Football")) {
			s = new Football();
		} else if(type.equalsIgnoreCase("Basketball")) {
			s = new Basketball();
		} else if(type.equalsIgnoreCase("Rubgy")) {
			s = new Rubgy();
		} else {
			System.out.println("Invalid Sports type");
			return;
		}
		
		s.play();
	}
}
