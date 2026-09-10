package day54;

public class ArraysWithMethods {

    public static void passArrayToMethod() {

        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("Array Elements:");

        printArray(numbers);

        System.out.println();

        int sum = calculateSum(numbers);

        System.out.println("Sum: " + sum);
    }

    public static void modifyArrayThroughMethod() {

        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("Before Modification:");

        printArray(numbers);

        modifyElements(numbers);

        System.out.println();
        System.out.println("After Modification:");

        printArray(numbers);
    }

    public static void returnArrayFromMethod() {

        int[] original = {10, 20, 30, 40, 50};

        int[] reversed = reverseArray(original);

        System.out.println("Original Array:");

        printArray(original);

        System.out.println();
        System.out.println("Returned Reversed Array:");

        printArray(reversed);
    }

    public static void processMultipleArrays() {

        int[] first = {10, 20, 30};
        int[] second = {40, 50, 60};

        int firstSum = calculateSum(first);
        int secondSum = calculateSum(second);

        System.out.println("First Array:");

        printArray(first);

        System.out.println();
        System.out.println("Second Array:");

        printArray(second);

        System.out.println();
        System.out.println("First Array Sum: " + firstSum);
        System.out.println("Second Array Sum: " + secondSum);

        int[] merged = mergeArrays(first, second);

        System.out.println("Merged Array:");

        printArray(merged);
    }

    public static void reusableArrayOperations() {

        int[] numbers = {15, 8, 25, 12, 30};

        System.out.println("Array:");

        printArray(numbers);

        System.out.println();
        System.out.println("Maximum: " + findMaximum(numbers));
        System.out.println("Minimum: " + findMinimum(numbers));
        System.out.println("Average: " + calculateAverage(numbers));
        System.out.println("Search 25: " + searchElement(numbers, 25));
        System.out.println("Search 100: " + searchElement(numbers, 100));
    }

    private static void printArray(int[] numbers) {

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }

    private static int calculateSum(int[] numbers) {

        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

    private static void modifyElements(int[] numbers) {

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i] * 2;
        }
    }

    private static int[] reverseArray(int[] numbers) {

        int[] reversed = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            reversed[i] = numbers[numbers.length - 1 - i];
        }

        return reversed;
    }

    private static int[] mergeArrays(int[] first, int[] second) {

        int[] merged = new int[first.length + second.length];

        for (int i = 0; i < first.length; i++) {
            merged[i] = first[i];
        }

        for (int i = 0; i < second.length; i++) {
            merged[first.length + i] = second[i];
        }

        return merged;
    }

    private static int findMaximum(int[] numbers) {

        int maximum = numbers[0];

        for (int number : numbers) {

            if (number > maximum) {
                maximum = number;
            }
        }

        return maximum;
    }

    private static int findMinimum(int[] numbers) {

        int minimum = numbers[0];

        for (int number : numbers) {

            if (number < minimum) {
                minimum = number;
            }
        }

        return minimum;
    }

    private static double calculateAverage(int[] numbers) {

        int sum = calculateSum(numbers);

        return (double) sum / numbers.length;
    }

    private static boolean searchElement(int[] numbers, int target) {

        for (int number : numbers) {

            if (number == target) {
                return true;
            }
        }

        return false;
    }
}