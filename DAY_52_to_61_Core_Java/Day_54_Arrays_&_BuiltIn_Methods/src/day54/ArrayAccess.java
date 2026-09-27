package day54;

public class ArrayAccess {

	public static void readArrayElements() {

		System.out.println("READING ARRAY ELEMENTS...");

		int[] marks = {85, 90, 78, 92, 88};

		System.out.println("Index 0 = " + marks[0]);
		System.out.println("Index 1 = " + marks[1]);
		System.out.println("Index 2 = " + marks[2]);
		System.out.println("Index 3 = " + marks[3]);
		System.out.println("Index 4 = " + marks[4]);

		System.out.println("First mark = " + marks[0]);
		System.out.println("Third mark = " + marks[2]);
		System.out.println("Last mark = " + marks[marks.length - 1]);
	}


	public static void updateArrayElements() {

		System.out.println("UPDATING ARRAY ELEMENTS");

		int[] marks = {70, 75, 80, 85, 90};

		System.out.println("Before update:");
		System.out.println("Index 0 = " + marks[0]);
		System.out.println("Index 2 = " + marks[2]);
		System.out.println("Index 4 = " + marks[4]);

		marks[0] = 72;
		marks[2] = 82;
		marks[4] = 95;

		System.out.println("After update:");
		System.out.println("Index 0 = " + marks[0]);
		System.out.println("Index 2 = " + marks[2]);
		System.out.println("Index 4 = " + marks[4]);
	}


	public static void accessFirstLastElements() {

		System.out.println("ACCESSING FIRST AND LAST ELEMENTS");

		String[] employees = {"Jagan", "Rahul", "Arun", "Kiran", "Vijay"};

		int firstIndex = 0;
		int lastIndex = employees.length - 1;

		System.out.println("First index = " + firstIndex);
		System.out.println("First employee = " + employees[firstIndex]);

		System.out.println("Last index = " + lastIndex);
		System.out.println("Last employee = " + employees[lastIndex]);

		System.out.println("Array length = " + employees.length);
	}


	public static void accessUsingIndex() {

		System.out.println("ACCESSING ELEMENTS USING INDEX");

		int[] numbers = {100, 200, 300, 400, 500, 600};

		int index1 = 1;
		int index2 = 3;
		int index3 = 5;

		System.out.println("Element at index " + index1 + " = " + numbers[index1]);
		System.out.println("Element at index " + index2 + " = " + numbers[index2]);
		System.out.println("Element at index " + index3 + " = " + numbers[index3]);

		System.out.println("Element at middle index = " + numbers[numbers.length / 2]);
		System.out.println("Element at last index = " + numbers[numbers.length - 1]);
	}


	public static void handleInvalidIndex() {

		System.out.println("ARRAY INDEX OUT OF BOUNDS EXCEPTION");

		int[] numbers = {10, 20, 30, 40, 50};

		System.out.println("Valid index 0 = " + numbers[0]);
		System.out.println("Valid index 4 = " + numbers[4]);

		try {
			System.out.println("Invalid index 5 = " + numbers[5]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid index detected");
			System.out.println("Message = " + e.getMessage());
		}

		try {
			System.out.println("Invalid negative index = " + numbers[-1]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Negative index detected");
			System.out.println("Message = " + e.getMessage());
		}
	}


	public static void accessDifferentArrayTypes() {

		System.out.println("ACCESSING DIFFERENT ARRAY TYPES");

		int[] ages = {21, 22, 23};
		double[] salaries = {25000.50, 35000.75, 45000.25};
		char[] grades = {'A', 'B', 'C'};
		String[] names = {"Jagan", "Rahul", "Arun"};
		boolean[] results = {true, false, true};

		System.out.println("Integer array = " + ages[1]);
		System.out.println("Double array = " + salaries[1]);
		System.out.println("Character array = " + grades[1]);
		System.out.println("String array = " + names[1]);
		System.out.println("Boolean array = " + results[1]);
	}
}