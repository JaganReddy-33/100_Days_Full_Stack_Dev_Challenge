package day57;

public class MaxValue_08 {

    public void max(int a, int b) {

        int max = a > b ? a : b;

        System.out.println("Maximum of two integers: " + max);
    }

    public void max(double a, double b) {

        double max = a > b ? a : b;

        System.out.println("Maximum of two doubles: " + max);
    }

    public void max(int a, int b, int c) {

        int max = a;

        if (b > max) {
            max = b;
        }

        if (c > max) {
            max = c;
        }

        System.out.println("Maximum of three integers: " + max);
    }

    public void max(double a, double b, double c) {

        double max = a;

        if (b > max) {
            max = b;
        }

        if (c > max) {
            max = c;
        }

        System.out.println("Maximum of three doubles: " + max);
    }

    public void max(int a, double b) {

        double max = a > b ? a : b;

        System.out.println("Maximum of int and double: " + max);
    }

    public void max(double a, int b) {

        double max = a > b ? a : b;

        System.out.println("Maximum of double and int: " + max);
    }

    public void max(float a, float b) {

        float max = a > b ? a : b;

        System.out.println("Maximum of two floats: " + max);
    }

    public void max(long a, long b) {

        long max = a > b ? a : b;

        System.out.println("Maximum of two long values: " + max);
    }

    public void max(String a, String b) {

        String max = a.compareTo(b) > 0 ? a : b;

        System.out.println("Greater String: " + max);
    }

    public void max(int a, int b, String message) {

        int max = a > b ? a : b;

        System.out.println(message + ": " + max);
    }
}