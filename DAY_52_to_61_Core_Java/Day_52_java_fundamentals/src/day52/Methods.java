package day52;

public class Methods {
	
	
	public static void printGreeting() {
		System.out.println("Hello, Welcome back to 100 day's Full Stack Challeng Mr. JMR");
	}
	
	public static int addNumbers(int a, int b) {
		int c = a + b;
		return c;
	}
	
	public static int subtraction(int a, int b) {
		return b-a;
	}
	
	public static int mulNumbers(int a, int b) {
		int res = a*b;
		return res;
	}
	
	public static void printSquarePattern(int n) {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static int printMaxNumber(int a, int b) {
		if(a > b) {
			return a;
		} else {
			return b;
		}
	}
	
	public static int squareOfNumber(int n) {
		return n*n;
	}
	
	public static int cubeOfNumber(int n) {
		return n*n*n;
	}
	
	public static void runProgran4() {
		int a = 10;
		int b = 15;
		int n = 5;
		
		printGreeting();
		
		int res = addNumbers(a, b);
		System.out.println("Two Numbers sum: "+res);
		
		int sub = subtraction(a, b);
		System.out.println("Subtrction of two numbers: "+sub);
		
		int mul = mulNumbers(a, b);
		System.out.println("Multification of Two numbers: "+mul);
		
		printSquarePattern(n);
		
		System.out.println(printMaxNumber(a, b));
		
		System.out.println(squareOfNumber(n));
		
		System.out.println(cubeOfNumber(n));
		
	}
}
