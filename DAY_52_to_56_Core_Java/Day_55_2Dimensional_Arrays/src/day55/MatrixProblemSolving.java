package day55;

public class MatrixProblemSolving {

    public void mainDiagonal() {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        for (int i = 0; i < matrix.length; i++) {

            System.out.print(matrix[i][i] + " ");
        }
    }

    public void secondaryDiagonal() {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int n = matrix.length;

        for (int i = 0; i < n; i++) {

            System.out.print(matrix[i][n - 1 - i] + " ");
        }
    }

    public void diagonalSums() {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int mainSum = 0;
        int secondarySum = 0;

        int n = matrix.length;

        for (int i = 0; i < n; i++) {

            mainSum += matrix[i][i];
            secondarySum += matrix[i][n - 1 - i];
        }

        System.out.println("Main Diagonal Sum: " + mainSum);
        System.out.println("Secondary Diagonal Sum: " + secondarySum);
    }

    public void diagonalDifference() {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int mainSum = 0;
        int secondarySum = 0;

        int n = matrix.length;

        for (int i = 0; i < n; i++) {

            mainSum += matrix[i][i];
            secondarySum += matrix[i][n - 1 - i];
        }

        System.out.println(Math.abs(mainSum - secondarySum));
    }

    public void identityMatrix() {

        int[][] matrix = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

        boolean identity = true;

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                if (i == j && matrix[i][j] != 1) {
                    identity = false;
                }

                if (i != j && matrix[i][j] != 0) {
                    identity = false;
                }
            }
        }

        System.out.println("Identity Matrix: " + identity);
    }

    public void symmetricMatrix() {

        int[][] matrix = {
                {1, 2, 3},
                {2, 4, 5},
                {3, 5, 6}
        };

        boolean symmetric = true;

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] != matrix[j][i]) {

                    symmetric = false;
                    break;
                }
            }
        }

        System.out.println("Symmetric Matrix: " + symmetric);
    }

    public void upperTriangular() {

        int[][] matrix = {
                {1, 2, 3},
                {0, 4, 5},
                {0, 0, 6}
        };

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                if (i <= j) {

                    System.out.print(matrix[i][j] + " ");
                } else {

                    System.out.print("0 ");
                }
            }

            System.out.println();
        }
    }

    public void lowerTriangular() {

        int[][] matrix = {
                {1, 0, 0},
                {2, 3, 0},
                {4, 5, 6}
        };

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                if (i >= j) {

                    System.out.print(matrix[i][j] + " ");
                } else {

                    System.out.print("0 ");
                }
            }

            System.out.println();
        }
    }
}