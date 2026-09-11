package day57;

public class StringUtility_09 {

    public void process(String text) {

        System.out.println("Original String: " + text);
        System.out.println("Length: " + text.length());
    }

    public void process(String text, String suffix) {

        System.out.println("Result: " + text.concat(suffix));
    }

    public void process(String text, char character) {

        int count = 0;

        for (int i = 0; i < text.length(); i++) {

            if (text.charAt(i) == character) {
                count++;
            }
        }

        System.out.println("Character '" + character + "' Count: " + count);
    }

    public void process(String text, int position) {

        if (position >= 0 && position < text.length()) {
            System.out.println("Character at position " + position + ": "
                    + text.charAt(position));
        } else {
            System.out.println("Invalid position");
        }
    }

    public void process(String text, boolean reverse) {

        if (reverse) {

            String result = "";

            for (int i = text.length() - 1; i >= 0; i--) {
                result += text.charAt(i);
            }

            System.out.println("Reversed String: " + result);

        } else {

            System.out.println("Original String: " + text);
        }
    }

    public void process(String firstName, String lastName, String separator) {

        String fullName = firstName + separator + lastName;

        System.out.println("Full Name: " + fullName);
    }

    public void process(String text, int start, int end) {

        if (start >= 0 && end <= text.length() && start <= end) {
            System.out.println("Substring: " + text.substring(start, end));
        } else {
            System.out.println("Invalid range");
        }
    }

    public void process(String text, char oldChar, char newChar) {

        String result = text.replace(oldChar, newChar);

        System.out.println("Modified String: " + result);
    }

    public void process(String text, String target, String replacement, boolean replaceAll) {

        String result;

        if (replaceAll) {
            result = text.replace(target, replacement);
        } else {
            result = text.replaceFirst(target, replacement);
        }

        System.out.println("Modified String: " + result);
    }
}