package day54;

public class ArrayProblemSolving {

    public static void findSecondLargestAndSmallest() {

        int[] numbers = {10, 5, 20, 8, 15, 20, 3};

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int number : numbers) {

            if (number > largest) {
                secondLargest = largest;
                largest = number;
            } else if (number > secondLargest && number != largest) {
                secondLargest = number;
            }

            if (number < smallest) {
                secondSmallest = smallest;
                smallest = number;
            } else if (number < secondSmallest && number != smallest) {
                secondSmallest = number;
            }
        }

        System.out.println("Array: " + java.util.Arrays.toString(numbers));
        System.out.println("Largest: " + largest);
        System.out.println("Second Largest: " + secondLargest);
        System.out.println("Smallest: " + smallest);
        System.out.println("Second Smallest: " + secondSmallest);
    }

    public static void findDuplicatesAndFrequency() {

        int[] numbers = {10, 20, 10, 30, 20, 40, 10, 30};

        System.out.println("Array: " + java.util.Arrays.toString(numbers));

        System.out.println("Duplicate Elements:");

        for (int i = 0; i < numbers.length; i++) {

            boolean alreadyChecked = false;

            for (int k = 0; k < i; k++) {
                if (numbers[k] == numbers[i]) {
                    alreadyChecked = true;
                    break;
                }
            }

            if (alreadyChecked) {
                continue;
            }

            int count = 0;

            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    count++;
                }
            }

            if (count > 1) {
                System.out.println(numbers[i] + " -> " + count + " times");
            }
        }

        System.out.println("Frequency of All Elements:");

        for (int i = 0; i < numbers.length; i++) {

            boolean alreadyChecked = false;

            for (int k = 0; k < i; k++) {
                if (numbers[k] == numbers[i]) {
                    alreadyChecked = true;
                    break;
                }
            }

            if (alreadyChecked) {
                continue;
            }

            int count = 0;

            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    count++;
                }
            }

            System.out.println(numbers[i] + " -> " + count);
        }
    }

    public static void removeDuplicates() {

        int[] numbers = {10, 20, 10, 30, 20, 40, 30};

        int[] unique = new int[numbers.length];
        int uniqueCount = 0;

        for (int i = 0; i < numbers.length; i++) {

            boolean exists = false;

            for (int j = 0; j < uniqueCount; j++) {

                if (numbers[i] == unique[j]) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                unique[uniqueCount] = numbers[i];
                uniqueCount++;
            }
        }

        System.out.println("Original Array: " + java.util.Arrays.toString(numbers));

        System.out.print("Array Without Duplicates: ");

        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(unique[i] + " ");
        }

        System.out.println();
    }

    public static void findMissingNumber() {

        int[] numbers = {1, 2, 3, 5, 6};

        int n = 6;

        int expectedSum = n * (n + 1) / 2;

        int actualSum = 0;

        for (int number : numbers) {
            actualSum += number;
        }

        int missingNumber = expectedSum - actualSum;

        System.out.println("Array: " + java.util.Arrays.toString(numbers));
        System.out.println("Missing Number: " + missingNumber);
    }

    public static void findCommonElementsAndMerge() {

        int[] first = {10, 20, 30, 40, 50};
        int[] second = {30, 40, 50, 60, 70};

        System.out.println("First Array: " + java.util.Arrays.toString(first));
        System.out.println("Second Array: " + java.util.Arrays.toString(second));

        System.out.print("Common Elements: ");

        for (int i = 0; i < first.length; i++) {

            boolean found = false;

            for (int j = 0; j < second.length; j++) {

                if (first[i] == second[j]) {
                    found = true;
                    break;
                }
            }

            if (found) {
                System.out.print(first[i] + " ");
            }
        }

        System.out.println();

        int[] merged = new int[first.length + second.length];

        for (int i = 0; i < first.length; i++) {
            merged[i] = first[i];
        }

        for (int i = 0; i < second.length; i++) {
            merged[first.length + i] = second[i];
        }

        System.out.println("Merged Array: " + java.util.Arrays.toString(merged));
    }

    public static void separateEvenOddAndMoveZeros() {

        int[] numbers = {10, 0, 15, 20, 0, 25, 30, 0, 35};

        int[] evenOdd = new int[numbers.length];

        int index = 0;

        for (int number : numbers) {

            if (number % 2 == 0 && number != 0) {
                evenOdd[index++] = number;
            }
        }

        for (int number : numbers) {

            if (number % 2 != 0) {
                evenOdd[index++] = number;
            }
        }

        System.out.println("Original Array: " + java.util.Arrays.toString(numbers));

        System.out.print("Even Elements Followed By Odd Elements: ");

        for (int i = 0; i < index; i++) {
            System.out.print(evenOdd[i] + " ");
        }

        System.out.println();

        int[] moveZeros = {0, 10, 0, 20, 30, 0, 40};

        int position = 0;

        for (int number : moveZeros) {

            if (number != 0) {
                moveZeros[position] = number;
                position++;
            }
        }

        while (position < moveZeros.length) {
            moveZeros[position] = 0;
            position++;
        }

        System.out.println("After Moving Zeros: " + java.util.Arrays.toString(moveZeros));
    }

    public static void compareArrays() {

        int[] first = {10, 20, 30, 40};
        int[] second = {10, 20, 30, 40};
        int[] third = {10, 20, 35, 40};

        boolean firstSecondEqual = true;
        boolean firstThirdEqual = true;

        if (first.length != second.length) {
            firstSecondEqual = false;
        } else {
            for (int i = 0; i < first.length; i++) {
                if (first[i] != second[i]) {
                    firstSecondEqual = false;
                    break;
                }
            }
        }

        if (first.length != third.length) {
            firstThirdEqual = false;
        } else {
            for (int i = 0; i < first.length; i++) {
                if (first[i] != third[i]) {
                    firstThirdEqual = false;
                    break;
                }
            }
        }

        System.out.println("First Array: " + java.util.Arrays.toString(first));
        System.out.println("Second Array: " + java.util.Arrays.toString(second));
        System.out.println("Third Array: " + java.util.Arrays.toString(third));

        System.out.println("First and Second Equal: " + firstSecondEqual);
        System.out.println("First and Third Equal: " + firstThirdEqual);
    }
}