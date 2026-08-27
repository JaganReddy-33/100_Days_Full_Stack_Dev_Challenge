package day52;

import java.util.Scanner;

public class DataTypes {
	public static void runProgram2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Byte value: ");
		byte a = sc.nextByte();
		System.out.println("Here is Byte value: "+a);
		
		System.out.println("Enter Short value: ");
		short b = sc.nextShort();
		System.out.println("Here is Short value: "+b);
		
		System.out.println("Enter Int value: ");
		int c = sc.nextInt();
		System.out.println("Here is Int value: "+c);
		
		System.out.println("Enter Long value: ");
		 long d = sc.nextLong();
		System.out.println("Here is Long value: "+d);
		
		
		System.out.println("Enter Float value: ");
		float e = sc.nextFloat();
		System.out.println("Here is Float value: "+e);
		
		System.out.println("Enter Double value: ");
		 double f = sc.nextDouble();
		System.out.println("Here is Double value: "+f);
		
		System.out.println("Enter Character here: ");
		 char ch = sc.next().charAt(0);
		System.out.println("Here is your's Character: "+ch);
		
		
		
	}
}
