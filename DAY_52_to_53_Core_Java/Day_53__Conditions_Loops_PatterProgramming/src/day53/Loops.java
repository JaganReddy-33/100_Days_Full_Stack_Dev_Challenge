package day53;

public class Loops {

	public static void forLoopExamples() {

		System.out.println("FOR LOOP - Print numbers from 1 to 10");
		for (int i = 1; i <= 10; i++) {
			System.out.println("Number = " + i);
		}

		System.out.println("-------------------------------------");

		
		System.out.println("FOR LOOP - Print even numbers from 1 to 10");
		for (int i = 2; i <= 10; i += 2) {
			System.out.println("Even Number = " + i);
		}

		System.out.println("-------------------------------------");

		
		System.out.println("FOR LOOP - Print odd numbers from 1 to 10");
		for (int i = 1; i <= 10; i += 2) {
			System.out.println("Odd Number = " + i);
		}

		System.out.println("-------------------------------------");

		
		System.out.println("FOR LOOP - Print numbers from 10 to 1");
		for (int i = 10; i >= 1; i--) {
			System.out.println("Number = " + i);
		}

		System.out.println("-------------------------------------");

		
		System.out.println("FOR LOOP - Sum of numbers from 1 to 10");
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.println("Sum = " + sum);

		System.out.println("-------------------------------------");

		
		System.out.println("FOR LOOP - Multiplication table of 5");
		for (int i = 1; i <= 10; i++) {
			System.out.println("5 x " + i + " = " + (5 * i));
		}

		System.out.println("-------------------------------------");

		
		System.out.println("FOR LOOP - Print squares from 1 to 5");
		for (int i = 1; i <= 5; i++) {
			System.out.println("Square of " + i + " = " + (i * i));
		}
		System.out.println("-------------------------------------");

	}

	

	public static void whileLoopExamples() {

		System.out.println("WHILE LOOP - Print numbers from 1 to 10");
		int i = 1;
		while (i <= 10) {
			System.out.println("Number = " + i);
			i++;
		}

		System.out.println("-------------------------------------");

		
		System.out.println("WHILE LOOP - Print even numbers from 1 to 10");
		i = 2;
		while (i <= 10) {
			System.out.println("Even Number = " + i);
			i += 2;
		}

		System.out.println("-------------------------------------");

		
		System.out.println("WHILE LOOP - Print odd numbers from 1 to 10");
		i = 1;
		while (i <= 10) {
			System.out.println("Odd Number = " + i);
			i += 2;
		}

		System.out.println("-------------------------------------");

		
		System.out.println("WHILE LOOP - Print numbers from 10 to 1");
		i = 10;
		while (i >= 1) {
			System.out.println("Number = " + i);
			i--;
		}

		System.out.println("-------------------------------------");

		
		System.out.println("WHILE LOOP - Sum of numbers from 1 to 10");
		i = 1;
		int sum = 0;
		while (i <= 10) {
			sum += i;
			i++;
		}
		System.out.println("Sum = " + sum);

		System.out.println("-------------------------------------");

		
		System.out.println("WHILE LOOP - Multiplication table of 5");
		i = 1;
		while (i <= 10) {
			System.out.println("5 x " + i + " = " + (5 * i));
			i++;
		}

		System.out.println("-------------------------------------");

		
		System.out.println("WHILE LOOP - Print squares from 1 to 5");
		i = 1;
		while (i <= 5) {
			System.out.println("Square of " + i + " = " + (i * i));
			i++;
		}
		System.out.println("-------------------------------------");

	}


	public static void doWhileLoopExamples() {

		System.out.println("DO-WHILE LOOP - Print numbers from 1 to 10");
		int i = 1;
		do {
			System.out.println("Number = " + i);
			i++;
		} while (i <= 10);

		System.out.println("-------------------------------------");

		
		System.out.println("DO-WHILE LOOP - Print even numbers from 2 to 10");
		i = 2;
		do {
			System.out.println("Even Number = " + i);
			i += 2;
		} while (i <= 10);

		System.out.println("-------------------------------------");

		
		System.out.println("DO-WHILE LOOP - Print odd numbers from 1 to 10");
		i = 1;
		do {
			System.out.println("Odd Number = " + i);
			i += 2;
		} while (i <= 10);

		System.out.println("-------------------------------------");

		
		System.out.println("DO-WHILE LOOP - Print numbers from 10 to 1");
		i = 10;
		do {
			System.out.println("Number = " + i);
			i--;
		} while (i >= 1);

		System.out.println("-------------------------------------");

		
		System.out.println("DO-WHILE LOOP - Sum of numbers from 1 to 10");
		i = 1;
		int sum = 0;
		do {
			sum += i;
			i++;
		} while (i <= 10);
		System.out.println("Sum = " + sum);

		System.out.println("-------------------------------------");

		
		System.out.println("DO-WHILE LOOP - Multiplication table of 5");
		i = 1;
		do {
			System.out.println("5 x " + i + " = " + (5 * i));
			i++;
		} while (i <= 10);

		System.out.println("-------------------------------------");

		
		System.out.println("DO-WHILE LOOP - Executes at least once");
		i = 10;
		do {
			System.out.println("Number = " + i);
			i++;
		} while (i < 5);
		System.out.println("-------------------------------------");

	}


	public static void nestedLoopExamples() {

		System.out.println("NESTED FOR LOOP - Number pairs");
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				System.out.println("Pair = (" + i + ", " + j + ")");
			}
		}

		System.out.println("-------------------------------------");

		
		System.out.println("NESTED FOR LOOP - Multiplication values");
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				System.out.println(i + " x " + j + " = " + (i * j));
			}
		}

		System.out.println("-------------------------------------");

		
		System.out.println("NESTED FOR LOOP - Matrix positions");
		for (int row = 1; row <= 2; row++) {
			for (int column = 1; column <= 3; column++) {
				System.out.println("Row = " + row + ", Column = " + column);
			}
		}

		System.out.println("-------------------------------------");

		
		System.out.println("NESTED WHILE LOOP - Number pairs");
		int i = 1;
		while (i <= 3) {
			int j = 1;
			while (j <= 3) {
				System.out.println("Pair = (" + i + ", " + j + ")");
				j++;
			}
			i++;
		}

		System.out.println("-------------------------------------");

		
		System.out.println("NESTED FOR LOOP - Small multiplication table");
		for (i = 1; i <= 3; i++) {
			for (int j = 1; j <= 5; j++) {
				System.out.println(i + " x " + j + " = " + (i * j));
			}
		}
		System.out.println("-------------------------------------");

	}


	public static void breakExamples() {

		System.out.println("BREAK - Stop when number reaches 5");
		for (int i = 1; i <= 10; i++) {
			if (i == 5) {
				break;
			}
			System.out.println("Number = " + i);
		}

		System.out.println("-------------------------------------");

		
		System.out.println("BREAK - Stop when number reaches 7");
		int i = 1;
		while (i <= 10) {
			if (i == 7) {
				break;
			}
			System.out.println("Number = " + i);
			i++;
		}

		System.out.println("-------------------------------------");

		
		System.out.println("BREAK - Stop at first even number");
		for (i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				break;
			}
			System.out.println("Odd Number = " + i);
		}

		System.out.println("-------------------------------------");

		
		System.out.println("BREAK - Stop at first multiple of 5");
		for (i = 1; i <= 20; i++) {
			if (i % 5 == 0) {
				break;
			}
			System.out.println("Number = " + i);
		}

		System.out.println("-------------------------------------");

		
		System.out.println("BREAK - Find first number divisible by 7");
		for (i = 1; i <= 20; i++) {
			if (i % 7 == 0) {
				System.out.println("First divisible number = " + i);
				break;
			}
		}
		System.out.println("-------------------------------------");

	}


	public static void continueExamples() {

		System.out.println("CONTINUE - Skip even numbers");
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				continue;
			}
			System.out.println("Odd Number = " + i);
		}

		System.out.println("-------------------------------------");

		
		System.out.println("CONTINUE - Skip odd numbers");
		for (int i = 1; i <= 10; i++) {
			if (i % 2 != 0) {
				continue;
			}
			System.out.println("Even Number = " + i);
		}

		System.out.println("-------------------------------------");

		
		System.out.println("CONTINUE - Skip number 5");
		for (int i = 1; i <= 10; i++) {
			if (i == 5) {
				continue;
			}
			System.out.println("Number = " + i);
		}

		System.out.println("-------------------------------------");

		
		System.out.println("CONTINUE - Skip multiples of 3");
		for (int i = 1; i <= 15; i++) {
			if (i % 3 == 0) {
				continue;
			}
			System.out.println("Number = " + i);
		}

		System.out.println("-------------------------------------");

		
		System.out.println("CONTINUE - Print numbers greater than 5");
		for (int i = 1; i <= 10; i++) {
			if (i <= 5) {
				continue;
			}
			System.out.println("Number = " + i);
		}
		System.out.println("-------------------------------------");

	}
}