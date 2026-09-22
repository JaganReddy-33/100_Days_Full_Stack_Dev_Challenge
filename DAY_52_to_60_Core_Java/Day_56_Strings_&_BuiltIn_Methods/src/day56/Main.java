package day56;

public class Main {
	public static void main(String[] args) {
		
		 StringBasics_01 stringBasics = new StringBasics_01();
		 stringBasics.declarationAndInitialization();
	     stringBasics.stringLiteralsAndNew();
	     stringBasics.indexingAndLength();
	     stringBasics.stringVsCharacterArray();
	     stringBasics.stringImmutability();
	     stringBasics.stringPoolConcept();
		
	     
	     StringMethods_02 stringMethods = new StringMethods_02();
	     stringMethods.caseConversion();
	     stringMethods.whitespaceMethods();
	     stringMethods.substringMethods();
	     stringMethods.checkingMethods();
	     stringMethods.emptyBlankConcat();
	     
	     
	     StringComparision_03 stringComparison = new StringComparision_03();
	     stringComparison.equalsComparison();
	     stringComparison.compareToComparison();
	     stringComparison.doubleEqualsVsEquals();
	     stringComparison.stringPoolComparison();

		
	     StringSearching_04 stringSearching = new StringSearching_04();
	     stringSearching.indexSearching();
	     stringSearching.substringSearching();
	     stringSearching.prefixAndSuffixSearching();
	     stringSearching.characterSearching();
	     stringSearching.substringPositionSearching();
	     
	     
	     StringModification_05 stringModification = new StringModification_05();
	     stringModification.replaceCharactersAndStrings();
	     stringModification.replaceAllExamples();
	     stringModification.removeCharactersAndSpaces();
	     stringModification.substringModification();
	     stringModification.concatModification();
	     stringModification.immutableModification();

		
		StringConversion_06 conversion = new StringConversion_06();
		conversion.stringToCharacterArray();
		conversion.characterArrayToString();
		conversion.stringToCharacter();
		conversion.stringToNumericValues();
		conversion.numericValuesToString();
		conversion.conversionAndModification();

		
		StringWithLoops_07 stringWithLoops = new StringWithLoops_07();
		stringWithLoops.traversalUsingForLoop();
		stringWithLoops.traversalUsingWhileLoop();
		stringWithLoops.countCharacters();
		stringWithLoops.countUpperCaseAndLowerCase();
		stringWithLoops.printCharactersWithIndex();
		stringWithLoops.printCharactersUsingForEachLoop();
		
		
		StringPrograms_08 basicStringPrograms = new StringPrograms_08();
		basicStringPrograms.reverseString();
		basicStringPrograms.checkPalindrome();
		basicStringPrograms.countVowelsAndConsonants();
		basicStringPrograms.countDigitsAndSpecialCharacters();
		basicStringPrograms.countWordsAndSpaces();
		basicStringPrograms.findLongestAndShortestWord();
		basicStringPrograms.replaceCharacter();
		basicStringPrograms.removeSpaces();
		
		
		StringProblemSolving_09 stringProblemSolving = new StringProblemSolving_09();
		stringProblemSolving.characterFrequency();
		stringProblemSolving.findDuplicateCharacters();
		stringProblemSolving.removeDuplicateCharacters();
		stringProblemSolving.firstNonRepeatingCharacter();
		stringProblemSolving.firstRepeatingCharacter();
		stringProblemSolving.reverseEachWord();
		stringProblemSolving.reverseWordOrder();
		stringProblemSolving.checkAnagram();
		stringProblemSolving.countSubstringOccurrences();
		stringProblemSolving.checkOnlyDigits();
	     
	}
}
