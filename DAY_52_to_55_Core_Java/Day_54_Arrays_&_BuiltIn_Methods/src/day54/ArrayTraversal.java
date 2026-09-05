package day54;

public class ArrayTraversal {

	public static void traverseUsingForLoop() {

		System.out.println("ARRAY TRAVERSAL USING FOR LOOP");

		int[] numbers = {10, 20, 30, 40, 50};

		for (int i = 0; i < numbers.length; i++) {
			System.out.println("Index " + i + " = " + numbers[i]);
		}

		System.out.println();

		System.out.println("Reverse traversal:");

		for (int i = numbers.length - 1; i >= 0; i--) {
			System.out.println("Index " + i + " = " + numbers[i]);
		}

		System.out.println();

		System.out.println("Even elements:");

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] % 2 == 0) {
				System.out.println("Even = " + numbers[i]);
			}
		}

		System.out.println();

		System.out.println("Elements greater than 25:");

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > 25) {
				System.out.println("Number = " + numbers[i]);
			}
		}
	}


	public static void traverseUsingWhileLoop() {

		System.out.println("ARRAY TRAVERSAL USING WHILE LOOP");

		int[] numbers = {15, 25, 35, 45, 55};

		int i = 0;

		while (i < numbers.length) {
			System.out.println("Index " + i + " = " + numbers[i]);
			i++;
		}

		System.out.println();

		System.out.println("Reverse traversal:");

		i = numbers.length - 1;

		while (i >= 0) {
			System.out.println("Index " + i + " = " + numbers[i]);
			i--;
		}

		System.out.println();

		System.out.println("Odd elements:");

		i = 0;

		while (i < numbers.length) {
			if (numbers[i] % 2 != 0) {
				System.out.println("Odd = " + numbers[i]);
			}
			i++;
		}

		System.out.println();

		System.out.println("Elements greater than 30:");

		i = 0;

		while (i < numbers.length) {
			if (numbers[i] > 30) {
				System.out.println("Number = " + numbers[i]);
			}
			i++;
		}
	}


	public static void traverseUsingForEach() {

		System.out.println("ARRAY TRAVERSAL USING FOR-EACH LOOP");

		int[] numbers = {10, 20, 30, 40, 50};

		for (int number : numbers) {
			System.out.println("Number = " + number);
		}

		System.out.println();

		System.out.println("Even elements:");

		for (int number : numbers) {
			if (number % 2 == 0) {
				System.out.println("Even = " + number);
			}
		}

		System.out.println();

		System.out.println("Elements greater than 25:");

		for (int number : numbers) {
			if (number > 25) {
				System.out.println("Number = " + number);
			}
		}
	}


	public static void traverseStringArray() {

		System.out.println("STRING ARRAY TRAVERSAL");

		String[] names = {"Jagan", "Rahul", "Arun", "Kiran", "Vijay"};

		System.out.println("Using for loop:");

		for (int i = 0; i < names.length; i++) {
			System.out.println("Index " + i + " = " + names[i]);
		}

		System.out.println();

		System.out.println("Using for-each loop:");

		for (String name : names) {
			System.out.println("Name = " + name);
		}
	}


	public static void traverseAndUpdateArray() {

		System.out.println("ARRAY TRAVERSAL AND UPDATE");

		int[] numbers = {10, 20, 30, 40, 50};

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = numbers[i] + 5;
		}

		System.out.println("Updated array:");

		for (int number : numbers) {
			System.out.println("Number = " + number);
		}
	}
}