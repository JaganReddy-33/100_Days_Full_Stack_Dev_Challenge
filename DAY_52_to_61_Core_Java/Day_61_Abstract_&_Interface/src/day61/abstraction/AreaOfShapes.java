package day61.abstraction;

import java.util.Scanner;

abstract class Shape {
    private float area;

    abstract void acceptInput(Scanner sc);
    abstract void calcArea();

    public float getArea() {
        return area;
    }

    protected void setArea(float area) {
        this.area = area;
    }
}

class Square extends Shape {
    private float side;

    @Override
    void acceptInput(Scanner sc) {
        this.side = sc.nextFloat();
    }

    @Override
    void calcArea() {
        setArea(side * side);
    }
}

class Rectangle extends Shape {
    private float length;
    private float breadth;

    @Override
    void acceptInput(Scanner sc) {
        this.length = sc.nextFloat();
        this.breadth = sc.nextFloat();
    }

    @Override
    void calcArea() {
        setArea(length * breadth);
    }
}

class Circle extends Shape {
    private float radius;

    @Override
    void acceptInput(Scanner sc) {
        this.radius = sc.nextFloat();
    }

    @Override
    void calcArea() {
        setArea((float) (Math.PI * radius * radius));
    }
}

public class AreaOfShapes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String shapeType = sc.next();

        Shape shape = null;
        
        if (shapeType.equalsIgnoreCase("Square")) {
        	shape = new Square();
        } else if (shapeType.equalsIgnoreCase("Rectangle")) {
        	shape = new Rectangle();
        } else if (shapeType.equalsIgnoreCase("Circle")) {
        	shape = new Circle();
        }
        
        if (shape != null) {
            shape.acceptInput(sc);
            shape.calcArea();
            System.out.printf("Area of %s: %.2f%n", shapeType, shape.getArea());
        } else {
            System.out.println("Invalid shape type: " + shapeType);
        }

        sc.close();
    }
}