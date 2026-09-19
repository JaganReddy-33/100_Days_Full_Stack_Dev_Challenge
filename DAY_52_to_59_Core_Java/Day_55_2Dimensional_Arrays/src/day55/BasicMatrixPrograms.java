package day55;

public class BasicMatrixPrograms {

    public void printMatrix() {

        int[][] matrix = {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90}
        };

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }

    public void totalSum() {

        int[][] matrix = {
                {10, 20, 30},
                {40, 50, 60}
        };

        int sum = 0;

        for (int[] row : matrix) {

            for (int value : row) {

                sum += value;
            }
        }

        System.out.println("Total Sum: " + sum);
    }

    public void rowWiseSum() {

        int[][] matrix = {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90}
        };

        for (int i = 0; i < matrix.length; i++) {

            int sum = 0;

            for (int j = 0; j < matrix[i].length; j++) {

                sum += matrix[i][j];
            }

            System.out.println("Row " + i + " Sum: " + sum);
        }
    }

    public void columnWiseSum() {

        int[][] matrix = {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90}
        };

        for (int j = 0; j < matrix[0].length; j++) {

            int sum = 0;

            for (int i = 0; i < matrix.length; i++) {

                sum += matrix[i][j];
            }

            System.out.println("Column " + j + " Sum: " + sum);
        }
    }

    public void maxAndMin() {

        int[][] matrix = {
                {10, 80, 30},
                {40, 5, 60},
                {70, 20, 90}
        };

        int max = matrix[0][0];
        int min = matrix[0][0];

        for (int[] row : matrix) {

            for (int value : row) {

                if (value > max) {
                    max = value;
                }

                if (value < min) {
                    min = value;
                }
            }
        }

        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
    }

    public void searchElement() {

        int[][] matrix = {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90}
        };

        int target = 50;
        boolean found = false;

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == target) {

                    System.out.println("Found at row " + i + ", column " + j);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Element not found");
        }
    }

    public void evenOddCount() {

        int[][] matrix = {
                {10, 21, 30},
                {41, 50, 61},
                {70, 81, 90}
        };

        int even = 0;
        int odd = 0;

        for (int[] row : matrix) {

            for (int value : row) {

                if (value % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
        }

        System.out.println("Even Count: " + even);
        System.out.println("Odd Count: " + odd);
    }

    public void countOccurrences() {

        int[][] matrix = {
                {10, 20, 10},
                {30, 10, 40},
                {10, 50, 10}
        };

        int target = 10;
        int count = 0;

        for (int[] row : matrix) {

            for (int value : row) {

                if (value == target) {
                    count++;
                }
            }
        }

        System.out.println("Occurrences: " + count);
    }
}