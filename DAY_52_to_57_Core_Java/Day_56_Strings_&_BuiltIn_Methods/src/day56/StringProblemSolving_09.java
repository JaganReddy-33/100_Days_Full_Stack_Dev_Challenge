package day56;

public class StringProblemSolving_09 {

    public void characterFrequency() {
        String text = "programming";

        for (int i = 0; i < text.length(); i++) {

            char current = text.charAt(i);

            boolean alreadyCounted = false;

            for (int j = 0; j < i; j++) {

                if (text.charAt(j) == current) {
                    alreadyCounted = true;
                    break;
                }
            }

            if (!alreadyCounted) {

                int count = 0;

                for (int j = 0; j < text.length(); j++) {

                    if (text.charAt(j) == current) {
                        count++;
                    }
                }

                System.out.println(current + " : " + count);
            }
        }
    }

    public void findDuplicateCharacters() {
        String text = "programming";

        for (int i = 0; i < text.length(); i++) {

            char current = text.charAt(i);

            boolean alreadyPrinted = false;

            for (int j = 0; j < i; j++) {

                if (text.charAt(j) == current) {
                    alreadyPrinted = true;
                    break;
                }
            }

            if (alreadyPrinted) {
                continue;
            }

            int count = 0;

            for (int j = 0; j < text.length(); j++) {

                if (text.charAt(j) == current) {
                    count++;
                }
            }

            if (count > 1) {
                System.out.println(current);
            }
        }
    }

    public void removeDuplicateCharacters() {
        String text = "programming";

        String result = "";

        for (int i = 0; i < text.length(); i++) {

            char current = text.charAt(i);

            if (result.indexOf(current) == -1) {
                result = result + current;
            }
        }

        System.out.println(result);
    }

    public void firstNonRepeatingCharacter() {
        String text = "swiss";

        for (int i = 0; i < text.length(); i++) {

            char current = text.charAt(i);

            int count = 0;

            for (int j = 0; j < text.length(); j++) {

                if (text.charAt(j) == current) {
                    count++;
                }
            }

            if (count == 1) {
                System.out.println("First non-repeating character: " + current);
                return;
            }
        }

        System.out.println("No non-repeating character found.");
    }

    public void firstRepeatingCharacter() {
        String text = "programming";

        for (int i = 0; i < text.length(); i++) {

            char current = text.charAt(i);

            for (int j = i + 1; j < text.length(); j++) {

                if (current == text.charAt(j)) {
                    System.out.println("First repeating character: " + current);
                    return;
                }
            }
        }

        System.out.println("No repeating character found.");
    }

    public void reverseEachWord() {
        String text = "Java is easy";

        String[] words = text.split(" ");

        for (String word : words) {

            String reversed = "";

            for (int i = word.length() - 1; i >= 0; i--) {
                reversed = reversed + word.charAt(i);
            }

            System.out.print(reversed + " ");
        }

        System.out.println();
    }

    public void reverseWordOrder() {
        String text = "Java is easy";

        String[] words = text.split(" ");

        for (int i = words.length - 1; i >= 0; i--) {
            System.out.print(words[i] + " ");
        }

        System.out.println();
    }

    public void checkAnagram() {
        String text1 = "listen";
        String text2 = "silent";

        if (text1.length() != text2.length()) {
            System.out.println("Not Anagram");
            return;
        }

        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();

        java.util.Arrays.sort(arr1);
        java.util.Arrays.sort(arr2);

        if (java.util.Arrays.equals(arr1, arr2)) {
            System.out.println("Anagram");
        } else {
            System.out.println("Not Anagram");
        }
    }

    public void countSubstringOccurrences() {
        String text = "Java Java Java";
        String target = "Java";

        int count = 0;
        int index = 0;

        while ((index = text.indexOf(target, index)) != -1) {

            count++;

            index = index + target.length();
        }

        System.out.println("Occurrences: " + count);
    }

    public void checkOnlyDigits() {
        String text = "123456";

        boolean onlyDigits = true;

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (ch < '0' || ch > '9') {
                onlyDigits = false;
                break;
            }
        }

        System.out.println(onlyDigits);
    }
}