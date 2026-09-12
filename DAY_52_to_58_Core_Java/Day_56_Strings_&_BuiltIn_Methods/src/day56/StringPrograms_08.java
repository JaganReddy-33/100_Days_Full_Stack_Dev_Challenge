package day56;

public class StringPrograms_08 {

    public void reverseString() {
        String text = "Java";

        String reversed = "";

        for (int i = text.length() - 1; i >= 0; i--) {
            reversed = reversed + text.charAt(i);
        }

        System.out.println("Original: " + text);
        System.out.println("Reversed: " + reversed);
    }

    public void checkPalindrome() {
        String text = "madam";

        String reversed = "";

        for (int i = text.length() - 1; i >= 0; i--) {
            reversed = reversed + text.charAt(i);
        }

        if (text.equals(reversed)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }

    public void countVowelsAndConsonants() {
        String text = "Java Programming";

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                    || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {

                vowels++;

            } else if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {

                consonants++;
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    public void countDigitsAndSpecialCharacters() {
        String text = "Java@123#";

        int digits = 0;
        int specialCharacters = 0;

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (ch >= '0' && ch <= '9') {
                digits++;
            } else if (!((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'))) {
                specialCharacters++;
            }
        }

        System.out.println("Digits: " + digits);
        System.out.println("Special Characters: " + specialCharacters);
    }

    public void countWordsAndSpaces() {
        String text = "Java is easy to learn";

        String[] words = text.split(" ");

        int spaces = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                spaces++;
            }
        }

        System.out.println("Words: " + words.length);
        System.out.println("Spaces: " + spaces);
    }

    public void findLongestAndShortestWord() {
        String text = "Java programming is interesting";

        String[] words = text.split(" ");

        String longest = words[0];
        String shortest = words[0];

        for (String word : words) {

            if (word.length() > longest.length()) {
                longest = word;
            }

            if (word.length() < shortest.length()) {
                shortest = word;
            }
        }

        System.out.println("Longest Word: " + longest);
        System.out.println("Shortest Word: " + shortest);
    }

    public void replaceCharacter() {
        String text = "Java Programming";

        char oldCharacter = 'a';
        char newCharacter = 'o';

        String result = text.replace(oldCharacter, newCharacter);

        System.out.println("Original: " + text);
        System.out.println("Modified: " + result);
    }

    public void removeSpaces() {
        String text = "Java Programming Language";

        String result = "";

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (ch != ' ') {
                result = result + ch;
            }
        }

        System.out.println(result);
    }
}