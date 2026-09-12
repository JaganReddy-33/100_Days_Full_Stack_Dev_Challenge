package day55;

public class TwoArrayBasics {

    public void declarationAndInitialization() {

        int[][] matrix1 = new int[2][3];

        int[][] matrix2 = {
                {10, 20, 30},
                {40, 50, 60}
        };

        System.out.println(matrix1.length);
        System.out.println(matrix2.length);
        System.out.println(matrix2[0].length);

        System.out.println(matrix2[0][0]);
        System.out.println(matrix2[1][2]);
    }

    public void accessingAndUpdating() {

        int[][] matrix = {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90}
        };

        System.out.println(matrix[0][1]);
        System.out.println(matrix[2][2]);

        matrix[0][1] = 200;
        matrix[2][2] = 900;

        System.out.println(matrix[0][1]);
        System.out.println(matrix[2][2]);
    }

    public void rowAndColumnLength() {

        int[][] matrix = {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90}
        };

        System.out.println("Rows: " + matrix.length);
        System.out.println("Columns: " + matrix[0].length);
    }

    public void defaultValues() {

        int[][] matrix = new int[2][3];

        System.out.println(matrix[0][0]);
        System.out.println(matrix[0][1]);
        System.out.println(matrix[1][2]);
    }

    public void firstAndLastElements() {

        int[][] matrix = {
                {10, 20, 30},
                {40, 50, 60}
        };

        int first = matrix[0][0];

        int last = matrix[matrix.length - 1][matrix[0].length - 1];

        System.out.println("First: " + first);
        System.out.println("Last: " + last);
    }
}