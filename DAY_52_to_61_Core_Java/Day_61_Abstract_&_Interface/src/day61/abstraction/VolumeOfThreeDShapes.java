package day61.abstraction;

import java.util.Scanner;

abstract class ThreeDShape {
    float volume;

    abstract void acceptInput(Scanner scanner);
    abstract void calcVolume();

    void displayVolume(String shapeName) {
        System.out.printf("Volume of %s: %.2f\n", shapeName, volume);
    }
}

class Cube extends ThreeDShape {
    float side;

    @Override
    void acceptInput(Scanner scanner) {
        side = scanner.nextFloat();
    }

    @Override
    void calcVolume() {
        volume = side * side * side;
    }
}

class Cylinder extends ThreeDShape {
    float radius;
    float height;

    @Override
    void acceptInput(Scanner scanner) {
        radius = scanner.nextFloat();
        height = scanner.nextFloat();
    }

    @Override
    void calcVolume() {
        volume = (float) (Math.PI * radius * radius * height);
    }
}

class Sphere extends ThreeDShape {
    float radius;

    @Override
    void acceptInput(Scanner scanner) {
        radius = scanner.nextFloat();
    }

    @Override
    void calcVolume() {
        volume = (float) ((4.0 / 3.0) * Math.PI * Math.pow(radius, 3));
    }
}

public class VolumeOfThreeDShapes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String shapeName = scanner.next();
        ThreeDShape shape = null;

        if (shapeName.equalsIgnoreCase("Cube")) {
            shape = new Cube();
            
        } else if (shapeName.equalsIgnoreCase("Cylinder")) {
            shape = new Cylinder();
        } else if (shapeName.equalsIgnoreCase("Sphere")) {
            shape = new Sphere();
        }

        if (shape != null) {
            shape.acceptInput(scanner);
            shape.calcVolume();
            shape.displayVolume(shapeName);
        }
    }
}