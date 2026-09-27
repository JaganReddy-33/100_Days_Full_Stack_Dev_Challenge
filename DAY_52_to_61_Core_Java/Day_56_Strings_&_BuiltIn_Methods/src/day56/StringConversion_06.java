package day56;

public class StringConversion_06 {

    public void stringToCharacterArray() {
        String text = "Java";

        char[] characters = text.toCharArray();

        for (char ch : characters) {
            System.out.println(ch);
        }
    }

    public void characterArrayToString() {
        char[] characters = {'J', 'a', 'v', 'a'};

        String text1 = new String(characters);
        String text2 = String.valueOf(characters);

        System.out.println(text1);
        System.out.println(text2);
    }

    public void stringToCharacter() {
        String text = "Java";

        char firstCharacter = text.charAt(0);
        char lastCharacter = text.charAt(text.length() - 1);

        System.out.println(firstCharacter);
        System.out.println(lastCharacter);
    }

    public void stringToNumericValues() {
        String number1 = "100";
        String number2 = "25.50";

        int value1 = Integer.parseInt(number1);
        double value2 = Double.parseDouble(number2);

        System.out.println(value1);
        System.out.println(value2);
        System.out.println(value1 + 50);
        System.out.println(value2 + 10.5);
    }

    public void numericValuesToString() {
        int number1 = 100;
        double number2 = 25.50;

        String text1 = String.valueOf(number1);
        String text2 = String.valueOf(number2);

        System.out.println(text1);
        System.out.println(text2);
        System.out.println(text1 + 50);
        System.out.println(text2 + " Java");
    }

    public void conversionAndModification() {
        String text = "java";

        char[] characters = text.toCharArray();

        characters[0] = 'J';

        String result = new String(characters);

        System.out.println(result);
    }
}