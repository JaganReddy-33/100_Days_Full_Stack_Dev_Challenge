package day54;

public class BasicArrayPrograms {

    public static void basicCalculations() {

        int[] numbers = {10, 20, 30, 40, 50};

        int sum = 0;
        int max = numbers[0];
        int min = numbers[0];

        for (int number : numbers) {
            sum += number;

            if (number > max) {
                max = number;
            }

            if (number < min) {
                min = number;
            }
        }

        double average = (double) sum / numbers.length;

        System.out.println("Array: " + java.util.Arrays.toString(numbers));
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
    }

    public static void countElements() {

        int[] numbers = {10, 15, 20, -5, 0, 25, -10, 20, 30, 20};

        int evenCount = 0;
        int oddCount = 0;
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;
        int particularCount = 0;

        int target = 20;

        for (int number : numbers) {

            if (number % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }

            if (number > 0) {
                positiveCount++;
            } else if (number < 0) {
                negativeCount++;
            } else {
                zeroCount++;
            }

            if (number == target) {
                particularCount++;
            }
        }

        System.out.println("Array: " + java.util.Arrays.toString(numbers));
        System.out.println("Even Count: " + evenCount);
        System.out.println("Odd Count: " + oddCount);
        System.out.println("Positive Count: " + positiveCount);
        System.out.println("Negative Count: " + negativeCount);
        System.out.println("Zero Count: " + zeroCount);
        System.out.println("Count of " + target + ": " + particularCount);
    }

    public static void searchElements() {

        int[] numbers = {12, 25, 8, 42, 19, 30};

        int target = 42;
        boolean found = false;

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] == target) {
                System.out.println("Element " + target + " found at index: " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Element " + target + " not found");
        }

        int secondTarget = 100;
        boolean secondFound = false;

        for (int number : numbers) {

            if (number == secondTarget) {
                secondFound = true;
                break;
            }
        }

        if (secondFound) {
            System.out.println("Element " + secondTarget + " found");
        } else {
            System.out.println("Element " + secondTarget + " not found");
        }
    }

    public static void reverseArray() {

        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("Original Array: " + java.util.Arrays.toString(numbers));

        System.out.print("Reverse Order: ");

        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }

        System.out.println();

        int[] reversed = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            reversed[i] = numbers[numbers.length - 1 - i];
        }

        System.out.println("Reversed Array: " + java.util.Arrays.toString(reversed));
    }

    public static void copyArray() {

        int[] original = {10, 20, 30, 40, 50};

        int[] copied = new int[original.length];

        for (int i = 0; i < original.length; i++) {
            copied[i] = original[i];
        }

        System.out.println("Original Array: " + java.util.Arrays.toString(original));
        System.out.println("Copied Array: " + java.util.Arrays.toString(copied));

        copied[0] = 100;

        System.out.println("After modifying copied array:");
        System.out.println("Original Array: " + java.util.Arrays.toString(original));
        System.out.println("Copied Array: " + java.util.Arrays.toString(copied));
    }

    public static void printArrayInformation() {

        int[] numbers = {5, 10, 15, 20, 25};

        System.out.println("Array Elements:");

        for (int number : numbers) {
            System.out.print(number + " ");
        }

        System.out.println();
        System.out.println("Number of Elements: " + numbers.length);
        System.out.println("First Element: " + numbers[0]);
        System.out.println("Last Element: " + numbers[numbers.length - 1]);
    }
}