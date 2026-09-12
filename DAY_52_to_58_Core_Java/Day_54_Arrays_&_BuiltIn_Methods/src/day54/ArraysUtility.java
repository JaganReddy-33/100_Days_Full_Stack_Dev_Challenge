package day54;

import java.util.Arrays;

public class ArraysUtility {

    public static void displayAndCompareArrays() {

        int[] numbers = {10, 20, 30, 40, 50};
        int[] sameNumbers = {10, 20, 30, 40, 50};
        int[] differentNumbers = {10, 20, 35, 40, 50};

        System.out.println("Numbers: " + Arrays.toString(numbers));
        System.out.println("Same Numbers: " + Arrays.toString(sameNumbers));
        System.out.println("Different Numbers: " + Arrays.toString(differentNumbers));

        System.out.println("numbers equals sameNumbers: "
                + Arrays.equals(numbers, sameNumbers));

        System.out.println("numbers equals differentNumbers: "
                + Arrays.equals(numbers, differentNumbers));
    }

    public static void sortAndSearchArray() {

        int[] numbers = {50, 10, 40, 20, 30};

        System.out.println("Before Sorting: " + Arrays.toString(numbers));

        Arrays.sort(numbers);

        System.out.println("After Sorting: " + Arrays.toString(numbers));

        int target = 30;

        int index = Arrays.binarySearch(numbers, target);

        System.out.println("Searching for: " + target);
        System.out.println("Index: " + index);

        int missingTarget = 100;

        int missingIndex = Arrays.binarySearch(numbers, missingTarget);

        System.out.println("Searching for: " + missingTarget);
        System.out.println("Result: " + missingIndex);
    }

    public static void copyArrays() {

        int[] numbers = {10, 20, 30, 40, 50};

        int[] fullCopy = Arrays.copyOf(numbers, numbers.length);

        int[] extendedCopy = Arrays.copyOf(numbers, 8);

        int[] shortenedCopy = Arrays.copyOf(numbers, 3);

        int[] rangeCopy = Arrays.copyOfRange(numbers, 1, 4);

        System.out.println("Original: " + Arrays.toString(numbers));
        System.out.println("Full Copy: " + Arrays.toString(fullCopy));
        System.out.println("Extended Copy: " + Arrays.toString(extendedCopy));
        System.out.println("Shortened Copy: " + Arrays.toString(shortenedCopy));
        System.out.println("Range Copy: " + Arrays.toString(rangeCopy));
    }

    public static void fillArrays() {

        int[] numbers = new int[5];

        Arrays.fill(numbers, 100);

        System.out.println("Entire Array Filled: " + Arrays.toString(numbers));

        int[] values = {10, 20, 30, 40, 50, 60};

        Arrays.fill(values, 1, 4, 99);

        System.out.println("Range Filled: " + Arrays.toString(values));
    }

    public static void utilityWorkflow() {

        int[] numbers = {45, 12, 78, 23, 9, 56};

        System.out.println("Original Array: " + Arrays.toString(numbers));

        Arrays.sort(numbers);

        System.out.println("Sorted Array: " + Arrays.toString(numbers));

        int[] firstThree = Arrays.copyOf(numbers, 3);

        System.out.println("First Three Elements: "
                + Arrays.toString(firstThree));

        int searchValue = 45;

        int index = Arrays.binarySearch(numbers, searchValue);

        System.out.println("Value " + searchValue + " found at index: " + index);

        int[] expected = {9, 12, 23};

        System.out.println("First Three Match Expected: "
                + Arrays.equals(firstThree, expected));
    }
}