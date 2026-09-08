package day56;

public class StringComparision_03 {

    public void equalsComparison() {
        String s1 = "Java";
        String s2 = "Java";
        String s3 = "java";

        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s1.equalsIgnoreCase(s3));
    }

    public void compareToComparison() {
        String s1 = "Apple";
        String s2 = "Banana";
        String s3 = "Apple";
        String s4 = "apple";

        System.out.println(s1.compareTo(s2));
        System.out.println(s2.compareTo(s1));
        System.out.println(s1.compareTo(s3));
        System.out.println(s1.compareToIgnoreCase(s4));
    }

    public void doubleEqualsVsEquals() {
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));
    }

    public void stringPoolComparison() {
        String s1 = "Hello";
        String s2 = "Hello";

        String s3 = new String("Hello");
        String s4 = new String("Hello");

        System.out.println(s1 == s2);
        System.out.println(s3 == s4);
        System.out.println(s1.equals(s2));
        System.out.println(s3.equals(s4));
    }
}