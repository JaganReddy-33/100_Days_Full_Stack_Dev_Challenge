package day55;

public class MatrixOperations {

    public void addition() {

        int[][] a = {
                {1, 2},
                {3, 4}
        };

        int[][] b = {
                {5, 6},
                {7, 8}
        };

        int[][] result = new int[2][2];

        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < a[i].length; j++) {

                result[i][j] = a[i][j] + b[i][j];

                System.out.print(result[i][j] + " ");
            }

            System.out.println();
        }
    }

    public void subtraction() {

        int[][] a = {
                {10, 20},
                {30, 40}
        };

        int[][] b = {
                {1, 2},
                {3, 4}
        };

        int[][] result = new int[2][2];

        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < a[i].length; j++) {

                result[i][j] = a[i][j] - b[i][j];

                System.out.print(result[i][j] + " ");
            }

            System.out.println();
        }
    }

    public void multiplication() {

        int[][] a = {
                {1, 2},
                {3, 4}
        };

        int[][] b = {
                {5, 6},
                {7, 8}
        };

        int[][] result = new int[2][2];

        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < b[0].length; j++) {

                for (int k = 0; k < b.length; k++) {

                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        for (int i = 0; i < result.length; i++) {

            for (int j = 0; j < result[i].length; j++) {

                System.out.print(result[i][j] + " ");
            }

            System.out.println();
        }
    }

    public void transpose() {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] transpose = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                transpose[j][i] = matrix[i][j];
            }
        }

        for (int i = 0; i < transpose.length; i++) {

            for (int j = 0; j < transpose[i].length; j++) {

                System.out.print(transpose[i][j] + " ");
            }

            System.out.println();
        }
    }

    public void compareMatrices() {

        int[][] a = {
                {1, 2},
                {3, 4}
        };

        int[][] b = {
                {1, 2},
                {3, 4}
        };

        boolean equal = true;

        if (a.length != b.length || a[0].length != b[0].length) {

            equal = false;

        } else {

            for (int i = 0; i < a.length; i++) {

                for (int j = 0; j < a[i].length; j++) {

                    if (a[i][j] != b[i][j]) {

                        equal = false;
                        break;
                    }
                }
            }
        }

        System.out.println("Matrices Equal: " + equal);
    }
}