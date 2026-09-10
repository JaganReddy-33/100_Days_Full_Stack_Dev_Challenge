package day55;

public class Main {
	public static void main(String[] args) {
		
//		2D- Arrays basics
		TwoArrayBasics basics = new TwoArrayBasics();

		basics.declarationAndInitialization();
		basics.accessingAndUpdating();
		basics.rowAndColumnLength();
		basics.defaultValues();
		basics.firstAndLastElements();
		
		
//		Diff Type of traversing arrays 
		TwoDArrayTraversal traversal = new TwoDArrayTraversal();

		traversal.nestedForLoop();
		traversal.nestedWhileLoop();
		traversal.enhancedForLoop();
		traversal.rowWiseTraversal();
		traversal.columnWiseTraversal();
		
		
//		Basics Matrix Programs
		BasicMatrixPrograms basic = new BasicMatrixPrograms();

		basic.printMatrix();
		basic.totalSum();
		basic.rowWiseSum();
		basic.columnWiseSum();
		basic.maxAndMin();
		basic.searchElement();
		basic.evenOddCount();
		basic.countOccurrences();
		
		
//		Some arithmetic operations
		MatrixOperations operations = new MatrixOperations();

		operations.addition();
		operations.subtraction();
		operations.multiplication();
		operations.transpose();
		operations.compareMatrices();
		
		
//		2D -Array problems
		MatrixProblemSolving problems = new MatrixProblemSolving();

		problems.mainDiagonal();
		problems.secondaryDiagonal();
		problems.diagonalSums();
		problems.diagonalDifference();
		problems.identityMatrix();
		problems.symmetricMatrix();
		problems.upperTriangular();
		problems.lowerTriangular();
		
		
//		Jagged-Arrays
		JaggedArrays jagged = new JaggedArrays();

		jagged.createAndInitialize();
		jagged.differentRowSizes();
		jagged.sumOfJaggedArray();
		jagged.rowWiseSum();
		jagged.searchElement();
		
		
		
		
	}
}
