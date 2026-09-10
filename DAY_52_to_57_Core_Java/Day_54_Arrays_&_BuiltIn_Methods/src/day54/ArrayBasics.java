package day54;

public class ArrayBasics {

	public static void arrayIntroduction() {

		System.out.println("ARRAY INTRODUCTION");

		int[] marks = {85, 90, 78, 92, 88};

		System.out.println("First mark = " + marks[0]);
		System.out.println("Second mark = " + marks[1]);
		System.out.println("Third mark = " + marks[2]);
		System.out.println("Fourth mark = " + marks[3]);
		System.out.println("Fifth mark = " + marks[4]);
	}


	public static void arrayDeclaration() {

		System.out.println("ARRAY DECLARATION");

		int[] numbers;
		double[] salaries;
		char[] characters;
		String[] names;
		boolean[] status;

		System.out.println("Integer array declared");
		System.out.println("Double array declared");
		System.out.println("Character array declared");
		System.out.println("String array declared");
		System.out.println("Boolean array declared");
	}


	public static void arrayInitializationUsingNew() {

		System.out.println("ARRAY INITIALIZATION USING NEW KEYWORD");

		int[] numbers = new int[5];

		numbers[0] = 10;
		numbers[1] = 20;
		numbers[2] = 30;
		numbers[3] = 40;
		numbers[4] = 50;

		System.out.println("Element 1 = " + numbers[0]);
		System.out.println("Element 2 = " + numbers[1]);
		System.out.println("Element 3 = " + numbers[2]);
		System.out.println("Element 4 = " + numbers[3]);
		System.out.println("Element 5 = " + numbers[4]);
	}


	public static void arrayDeclarationAndInitialization() {

		System.out.println("DECLARATION AND INITIALIZATION");

		int[] numbers = {10, 20, 30, 40, 50};

		String[] names = {"Jagan", "Rahul", "Arun", "Kiran"};

		char[] vowels = {'A', 'E', 'I', 'O', 'U'};

		double[] prices = {99.99, 149.50, 250.75};

		System.out.println("Integer array first element = " + numbers[0]);
		System.out.println("String array first element = " + names[0]);
		System.out.println("Character array first element = " + vowels[0]);
		System.out.println("Double array first element = " + prices[0]);
	}


	public static void arrayFixedSize() {

		System.out.println("ARRAY FIXED SIZE");

		int[] numbers = new int[5];

		System.out.println("Array size = " + numbers.length);

		numbers[0] = 10;
		numbers[1] = 20;
		numbers[2] = 30;
		numbers[3] = 40;
		numbers[4] = 50;

		System.out.println("Array contains " + numbers.length + " elements");
	}


	public static void arrayZeroBasedIndexing() {

		System.out.println("ZERO-BASED INDEXING");

		String[] names = {"Jagan", "Rahul", "Arun", "Kiran", "Vijay"};

		System.out.println("Index 0 = " + names[0]);
		System.out.println("Index 1 = " + names[1]);
		System.out.println("Index 2 = " + names[2]);
		System.out.println("Index 3 = " + names[3]);
		System.out.println("Index 4 = " + names[4]);

		System.out.println("First index = 0");
		System.out.println("Last index = " + (names.length - 1));
	}


	public static void arrayLength() {

		System.out.println("ARRAY LENGTH");

		int[] numbers = {10, 20, 30, 40, 50};

		String[] names = {"Jagan", "Rahul", "Arun"};

		char[] characters = {'A', 'B', 'C', 'D'};

		System.out.println("Numbers length = " + numbers.length);
		System.out.println("Names length = " + names.length);
		System.out.println("Characters length = " + characters.length);
	}


	public static void arrayDefaultValues() {

		System.out.println("ARRAY DEFAULT VALUES");

		int[] integers = new int[3];
		double[] decimals = new double[3];
		char[] characters = new char[3];
		boolean[] booleans = new boolean[3];
		String[] names = new String[3];

		System.out.println("Integer default = " + integers[0]);
		System.out.println("Double default = " + decimals[0]);
		System.out.println("Character default = " + characters[0]);
		System.out.println("Boolean default = " + booleans[0]);
		System.out.println("String default = " + names[0]);
	}


	public static void differentPrimitiveArrays() {

		System.out.println("DIFFERENT PRIMITIVE ARRAYS");

		int[] ages = {21, 22, 23, 24};

		double[] salaries = {25000.50, 35000.75, 45000.25};

		char[] grades = {'A', 'B', 'A', 'C'};

		boolean[] results = {true, true, false, true};

		System.out.println("Age = " + ages[0]);
		System.out.println("Salary = " + salaries[0]);
		System.out.println("Grade = " + grades[0]);
		System.out.println("Result = " + results[0]);
	}


	public static void stringArrayExample() {

		System.out.println("STRING ARRAY");

		String[] names = {"Jagan", "Rahul", "Arun", "Kiran", "Vijay"};

		System.out.println("Name 1 = " + names[0]);
		System.out.println("Name 2 = " + names[1]);
		System.out.println("Name 3 = " + names[2]);
		System.out.println("Name 4 = " + names[3]);
		System.out.println("Name 5 = " + names[4]);
	}


	public static void arrayUpdateExample() {

		System.out.println("ARRAY ELEMENT UPDATE");

		int[] marks = {80, 75, 90, 85, 70};

		System.out.println("Before update = " + marks[2]);

		marks[2] = 95;

		System.out.println("After update = " + marks[2]);
	}


	public static void arrayIndexExample() {

		System.out.println("ARRAY INDEX EXAMPLE");

		int[] numbers = {100, 200, 300, 400, 500};

		System.out.println("First element = " + numbers[0]);
		System.out.println("Second element = " + numbers[1]);
		System.out.println("Middle element = " + numbers[2]);
		System.out.println("Fourth element = " + numbers[3]);
		System.out.println("Last element = " + numbers[numbers.length - 1]);
	}


	public static void arrayMemoryConcept() {

		System.out.println("ARRAY MEMORY CONCEPT");

		int[] numbers = {10, 20, 30};

		System.out.println("Array reference = " + numbers);
		System.out.println("Element at index 0 = " + numbers[0]);
		System.out.println("Element at index 1 = " + numbers[1]);
		System.out.println("Element at index 2 = " + numbers[2]);

		int[] anotherReference = numbers;

		System.out.println("Same array through another reference = " + anotherReference[0]);
	}


	public static void arrayLengthWithDifferentSizes() {

		System.out.println("ARRAY LENGTH WITH DIFFERENT SIZES");

		int[] smallArray = new int[3];
		int[] mediumArray = new int[5];
		int[] largeArray = new int[10];

		System.out.println("Small array length = " + smallArray.length);
		System.out.println("Medium array length = " + mediumArray.length);
		System.out.println("Large array length = " + largeArray.length);
	}
	
}