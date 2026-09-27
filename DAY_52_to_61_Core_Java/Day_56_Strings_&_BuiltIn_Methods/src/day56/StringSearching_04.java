package day56;

public class StringSearching_04 {

    public void indexSearching() {
        String text = "Java Programming";

        System.out.println(text.indexOf('a'));
        System.out.println(text.indexOf("Programming"));
        System.out.println(text.indexOf('a', 2));
        System.out.println(text.lastIndexOf('a'));
    }

    public void substringSearching() {
        String text = "Java is a programming language";

        System.out.println(text.contains("programming"));
        System.out.println(text.contains("Python"));
        System.out.println(text.indexOf("Java"));
        System.out.println(text.indexOf("language"));
    }

    public void prefixAndSuffixSearching() {
        String text = "Java Programming";

        System.out.println(text.startsWith("Java"));
        System.out.println(text.startsWith("Programming"));
        System.out.println(text.endsWith("Programming"));
        System.out.println(text.endsWith("Java"));
    }

    public void characterSearching() {
        String text = "programming";

        System.out.println(text.indexOf('g'));
        System.out.println(text.lastIndexOf('g'));
        System.out.println(text.indexOf('z'));
    }

    public void substringPositionSearching() {
        String text = "Java Java Java";

        System.out.println(text.indexOf("Java"));
        System.out.println(text.indexOf("Java", 1));
        System.out.println(text.indexOf("Java", 6));
        System.out.println(text.lastIndexOf("Java"));
    }
}