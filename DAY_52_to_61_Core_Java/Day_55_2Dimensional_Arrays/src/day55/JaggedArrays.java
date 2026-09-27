package day55;

public class JaggedArrays {

    public void createAndInitialize() {

        int[][] numbers = new int[3][];

        numbers[0] = new int[]{10, 20};
        numbers[1] = new int[]{30, 40, 50};
        numbers[2] = new int[]{60, 70, 80, 90};

        for (int i = 0; i < numbers.length; i++) {

            for (int j = 0; j < numbers[i].length; j++) {

                System.out.print(numbers[i][j] + " ");
            }

            System.out.println();
        }
    }

    public void differentRowSizes() {

        int[][] matrix = {
                {10, 20},
                {30, 40, 50},
                {60, 70, 80, 90}
        };

        for (int i = 0; i < matrix.length; i++) {

            System.out.println("Row " + i + " length: " + matrix[i].length);
        }
    }

    public void sumOfJaggedArray() {

        int[][] matrix = {
                {10, 20},
                {30, 40, 50},
                {60, 70, 80, 90}
        };

        int sum = 0;

        for (int[] row : matrix) {

            for (int value : row) {

                sum += value;
            }
        }

        System.out.println("Sum: " + sum);
    }

    public void rowWiseSum() {

        int[][] matrix = {
                {10, 20},
                {30, 40, 50},
                {60, 70, 80, 90}
        };

        for (int i = 0; i < matrix.length; i++) {

            int sum = 0;

            for (int value : matrix[i]) {

                sum += value;
            }

            System.out.println("Row " + i + " Sum: " + sum);
        }

    }

    public void searchElement() {

        int[][] matrix = {
                {10, 20},
                {30, 40, 50},
                {60, 70, 80, 90}
        };

        int target = 70;

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == target) {

                    System.out.println(
                            "Found at row " + i + ", column " + j
                    );

                    return;
                }
            }
        }

        System.out.println("Element not found");
    }
}