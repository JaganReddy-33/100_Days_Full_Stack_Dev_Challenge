package day56;

public class StringMethods_02 {

    public void caseConversion() {
        String text = "Java Programming";

        System.out.println(text.toUpperCase());
        System.out.println(text.toLowerCase());
    }

    public void whitespaceMethods() {
        String text1 = "   Java Programming   ";
        String text2 = "   Java Programming   ";

        System.out.println(text1.trim());
        System.out.println(text2.strip());
    }

    public void substringMethods() {
        String text = "Java Programming";

        System.out.println(text.substring(5));
        System.out.println(text.substring(0, 4));
        System.out.println(text.substring(5, 16));
    }

    public void checkingMethods() {
        String text = "Java Programming";

        System.out.println(text.contains("Java"));
        System.out.println(text.contains("Python"));
        System.out.println(text.startsWith("Java"));
        System.out.println(text.endsWith("Programming"));
    }

    public void emptyBlankConcat() {
        String empty = "";
        String blank = "   ";
        String firstName = "Jagan";
        String lastName = "Reddy";

        System.out.println(empty.isEmpty());
        System.out.println(blank.isBlank());
        System.out.println(firstName.concat(" ").concat(lastName));
    }
}