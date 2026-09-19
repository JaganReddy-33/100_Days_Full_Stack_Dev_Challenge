package day56;

public class StringWithLoops_07 {
	
	public void traversalUsingForLoop() {
		String text = "Java";
		
		for(int i=0; i<text.length(); i++) {
			System.out.println(text.charAt(i));
		}
	}
	
	public void traversalUsingWhileLoop() {
		String text = "Programming";
		int i=0;
		while(i < text.length()) {
			System.out.println(text.charAt(i));
			i++;
		}
	}
	
	public void countCharacters() {
		String text = "Java1 Pro2gramming3";
		
		int vowels = 0;
		int consonants = 0;
		int digits = 0;
		int spaces = 0;
		
		for(int i=0; i<text.length(); i++) {
			char ch = text.charAt(i);
			
			if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U') {
				vowels++;
			} else if(ch>='0' && ch<='9') {
				digits++;
			} else if(ch == ' ') {
				spaces++;
			} else {
				consonants++;
			}
		}
		System.out.println("Vowels Count: " + vowels);
        System.out.println("Consonants Count: " + consonants);
        System.out.println("Digits Count: " + digits);
        System.out.println("Spaces Count: " + spaces);
	}
	
	public void countUpperCaseAndLowerCase() {
		String text = "Java Programming 123";
		
		int uppercase = 0;
		int lowercase = 0;
		
		for(int i=0; i<text.length(); i++) {
			char ch = text.charAt(i);
			
			if(ch >= 'A' && ch <= 'Z') {
				uppercase++;
			} else if(ch >= 'a' && ch<= 'z') {
				lowercase++;
			}
		}
		System.out.println("Uppercase Count: " + uppercase);
        System.out.println("Lowercase Count: " + lowercase);			
	}
	
	public void printCharactersWithIndex() {
		String text = "Java";
		for(int i=0; i<text.length(); i++) {
			System.out.println(i+" -> "+text.charAt(i));
		}
	}
	
	public void printCharactersUsingForEachLoop() {
		String text = "Java";
		char[] characters = text.toCharArray();
		
		for(char ch : characters) {
			System.out.println(ch);
		}
	}
}
