package day60.compiletime;


class Calculator {
	
	public void add(int a, int b) {
		int res = a + b;
		System.out.println("Two Integer Sum: " + res);
	}
	
	public void add(int a, int b, int c) {
		int res = a + b + c;
		System.out.println("Three Integers Sum: " + res);
	}
	
	public void add(double a, double b) {
		double res = a + b;
		System.out.println("Two Double values Sum: " + res);
	}
}



public class MethodOverloadingEx_01 {
	
	public static void main(String[] args) {
		
		Calculator cal = new Calculator();
		cal.add(10, 2);
		cal.add(20.2, 9.8);
		cal.add(2, 4, 5);
	}
}
