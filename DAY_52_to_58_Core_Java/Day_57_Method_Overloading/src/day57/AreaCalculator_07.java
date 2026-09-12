package day57;

public class AreaCalculator_07 {

    public void area(int side) {

        int area = side * side;

        System.out.println("Area of Square: " + area);
    }

    public void area(int length, int width) {

        int area = length * width;

        System.out.println("Area of Rectangle: " + area);
    }

    public void area(double radius) {

        double area = Math.PI * radius * radius;

        System.out.println("Area of Circle: " + area);
    }

    public void area(double base, double height) {

        double area = 0.5 * base * height;

        System.out.println("Area of Triangle: " + area);
    }

    public void area(float radius, String unit) {

        double area = Math.PI * radius * radius;

        System.out.println("Area of Circle: " + area + " " + unit);
    }

    public void area(int length, int width, String shape) {

        int area = length * width;

        System.out.println("Area of " + shape + ": " + area);
    }

    public void area(double length, double width, String shape) {

        double area = length * width;

        System.out.println("Area of " + shape + ": " + area);
    }

    public void area(int base, int height, boolean triangle) {

        double area = 0.5 * base * height;

        System.out.println("Area of Triangle: " + area);
    }

    public void area(double side1, double side2, double side3) {

        double semiPerimeter = (side1 + side2 + side3) / 2;

        double area = Math.sqrt(
                semiPerimeter
                * (semiPerimeter - side1)
                * (semiPerimeter - side2)
                * (semiPerimeter - side3)
        );

        System.out.println("Area of Triangle using Heron's Formula: " + area);
    }

    public void area(double radius, String unit, boolean circle) {

        double area = Math.PI * radius * radius;

        System.out.println("Area of Circle: " + area + " " + unit);
    }
}