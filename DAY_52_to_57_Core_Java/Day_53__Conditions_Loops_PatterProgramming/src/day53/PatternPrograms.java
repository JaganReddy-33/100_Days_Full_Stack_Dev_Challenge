package day53;

public class PatternPrograms {

	public static void starSquarePattern() {
		System.out.println("STAR SQUARE PATTERN");

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}


	public static void rightTrianglePattern() {
		System.out.println("RIGHT TRIANGLE PATTERN");

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}


	public static void invertedRightTrianglePattern() {
		System.out.println("INVERTED RIGHT TRIANGLE PATTERN");

		for (int i = 5; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}


	public static void numberTrianglePattern() {
		System.out.println("NUMBER TRIANGLE PATTERN");

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}


	public static void repeatedNumberTrianglePattern() {
		System.out.println("REPEATED NUMBER TRIANGLE PATTERN");

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}


	public static void invertedNumberTrianglePattern() {
		System.out.println("INVERTED NUMBER TRIANGLE PATTERN");

		for (int i = 5; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}


	public static void increasingNumberPattern() {
		System.out.println("INCREASING NUMBER PATTERN");

		int number = 1;

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(number + " ");
				number++;
			}
			System.out.println();
		}
	}


	public static void alphabetTrianglePattern() {
		System.out.println("ALPHABET TRIANGLE PATTERN");

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print((char) (64 + j) + " ");
			}
			System.out.println();
		}
	}


	public static void repeatedAlphabetTrianglePattern() {
		System.out.println("REPEATED ALPHABET TRIANGLE PATTERN");

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print((char) (64 + i) + " ");
			}
			System.out.println();
		}
	}


	public static void pyramidStarPattern() {
		System.out.println("PYRAMID STAR PATTERN");

		for (int i = 1; i <= 5; i++) {

			for (int j = 1; j <= 5 - i; j++) {
				System.out.print("  ");
			}

			for (int j = 1; j <= 2 * i - 1; j++) {
				System.out.print("* ");
			}

			System.out.println();
		}
	}


	public static void invertedPyramidPattern() {
		System.out.println("INVERTED PYRAMID PATTERN");

		for (int i = 5; i >= 1; i--) {

			for (int j = 1; j <= 5 - i; j++) {
				System.out.print("  ");
			}

			for (int j = 1; j <= 2 * i - 1; j++) {
				System.out.print("* ");
			}

			System.out.println();
		}
	}


	public static void diamondPattern() {
		System.out.println("DIAMOND STAR PATTERN");

		for (int i = 1; i <= 5; i++) {

			for (int j = 1; j <= 5 - i; j++) {
				System.out.print("  ");
			}

			for (int j = 1; j <= 2 * i - 1; j++) {
				System.out.print("* ");
			}

			System.out.println();
		}

		for (int i = 4; i >= 1; i--) {

			for (int j = 1; j <= 5 - i; j++) {
				System.out.print("  ");
			}

			for (int j = 1; j <= 2 * i - 1; j++) {
				System.out.print("* ");
			}

			System.out.println();
		}
	}
}