package day56;

public class StringBasics_01 {

    public void declarationAndInitialization() {
        String name;
        name = "Jagan";

        String city = "Bangalore";
        String language = "Java";

        System.out.println(name);
        System.out.println(city);
        System.out.println(language);
    }

    public void stringLiteralsAndNew() {
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");
        String s4 = new String("Java");

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
    }

    public void indexingAndLength() {
        String text = "Java Programming";

        System.out.println(text.length());
        System.out.println(text.charAt(0));
        System.out.println(text.charAt(5));
        System.out.println(text.charAt(text.length() - 1));

        System.out.println(text.indexOf("P"));
    }

    public void stringVsCharacterArray() {
        String text = "Java";

        char[] characters = {'J', 'a', 'v', 'a'};

        System.out.println(text);
        System.out.println(characters[0]);
        System.out.println(characters[1]);
        System.out.println(characters[2]);
        System.out.println(characters[3]);
    }

    public void stringImmutability() {
        String text = "Java";

        text.concat(" Programming");

        System.out.println(text);

        text = text.concat(" Programming");

        System.out.println(text);
    }

    public void stringPoolConcept() {
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));
    }
}