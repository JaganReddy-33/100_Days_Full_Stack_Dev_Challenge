package day56;

public class StringModification_05 {

    public void replaceCharactersAndStrings() {
        String text = "Java Programming";

        System.out.println(text.replace('a', 'o'));
        System.out.println(text.replace("Java", "Python"));
        System.out.println(text.replace("Programming", "Development"));
    }

    public void replaceAllExamples() {
        String text = "Java123Programming456";

        System.out.println(text.replaceAll("[0-9]", ""));
        System.out.println(text.replaceAll("[a-z]", ""));
        System.out.println(text.replaceAll("\\s", ""));
    }

    public void removeCharactersAndSpaces() {
        String text = "Java Programming Language";

        System.out.println(text.replace(" ", ""));
        System.out.println(text.replace("a", ""));
        System.out.println(text.replace("Java ", ""));
    }

    public void substringModification() {
        String firstName = "Jagan";
        String lastName = "Reddy";

        String result = firstName.substring(0, 1)
                + lastName.substring(0, 1)
                + firstName.substring(1)
                + lastName.substring(1);

        System.out.println(result);
    }

    public void concatModification() {
        String firstName = "Jagan";
        String lastName = "Reddy";

        String fullName = firstName.concat(" ").concat(lastName);

        System.out.println(fullName);
    }

    public void immutableModification() {
        String text = "Java";

        text.replace("Java", "Python");

        System.out.println(text);

        text = text.replace("Java", "Python");

        System.out.println(text);
    }
}