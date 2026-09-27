package day55;

public class TwoDArrayTraversal {

    public void nestedForLoop() {

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

    public void nestedWhileLoop() {

        int[][] matrix = {
                {10, 20, 30},
                {40, 50, 60}
        };

        int i = 0;

        while (i < matrix.length) {

            int j = 0;

            while (j < matrix[i].length) {

                System.out.print(matrix[i][j] + " ");
                j++;
            }

            System.out.println();
            i++;
        }
    }

    public void enhancedForLoop() {

        int[][] matrix = {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90}
        };

        for (int[] row : matrix) {

            for (int value : row) {

                System.out.print(value + " ");
            }

            System.out.println();
        }
    }

    public void rowWiseTraversal() {

        int[][] matrix = {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90}
        };

        for (int i = 0; i < matrix.length; i++) {

            System.out.print("Row " + i + ": ");

            for (int j = 0; j < matrix[i].length; j++) {

                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }

    public void columnWiseTraversal() {

        int[][] matrix = {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90}
        };

        for (int j = 0; j < matrix[0].length; j++) {

            System.out.print("Column " + j + ": ");

            for (int i = 0; i < matrix.length; i++) {

                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }
}