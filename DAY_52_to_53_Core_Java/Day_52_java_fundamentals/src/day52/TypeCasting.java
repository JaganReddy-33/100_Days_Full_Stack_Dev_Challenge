package day52;

public class TypeCasting {
	public static void runProgram3() {
		
		System.out.println("--- TypeCasting ---");
		System.out.println();
		
		System.out.println("--- Implicit casting(smaller to large datatypes ---");
		
		byte b = 10;
		short s = b;
		int i = s;
		long l = i;
		float f = l;
		double d = f;
		System.out.println("byte = "+ b);
		System.out.println("short = "+ s);
		System.out.println("int = "+ i);
		System.out.println("long = "+ l);
		System.out.println("float = "+ f);
		System.out.println("double = "+ d);
	
		
		System.out.println("byte -> short");
        byte byteValue1 = 25;
        short shortValue1 = byteValue1;
        System.out.println("byte  = " + byteValue1);
        System.out.println("short = " + shortValue1);


        System.out.println("byte -> int");
        byte byteValue2 = 50;
        int intValue1 = byteValue2;
        System.out.println("byte = " + byteValue2);
        System.out.println("int  = " + intValue1);


        System.out.println("byte -> long");
        byte byteValue3 = 75;
        long longValue1 = byteValue3;
        System.out.println("byte = " + byteValue3);
        System.out.println("long = " + longValue1);


        System.out.println("byte -> float");
        byte byteValue4 = 100;
        float floatValue1 = byteValue4;
        System.out.println("byte  = " + byteValue4);
        System.out.println("float = " + floatValue1);


        System.out.println("byte -> double");
        byte byteValue5 = 20;
        double doubleValue1 = byteValue5;
        System.out.println("byte   = " + byteValue5);
        System.out.println("double = " + doubleValue1);


        System.out.println("short -> int");
        short shortValue2 = 500;
        int intValue2 = shortValue2;
        System.out.println("short = " + shortValue2);
        System.out.println("int   = " + intValue2);


        System.out.println("short -> long");
        short shortValue3 = 1000;
        long longValue2 = shortValue3;
        System.out.println("short = " + shortValue3);
        System.out.println("long  = " + longValue2);


        System.out.println("short -> float");
        short shortValue4 = 2000;
        float floatValue2 = shortValue4;
        System.out.println("short = " + shortValue4);
        System.out.println("float = " + floatValue2);


        System.out.println("short -> double");
        short shortValue5 = 3000;
        double doubleValue2 = shortValue5;
        System.out.println("short  = " + shortValue5);
        System.out.println("double = " + doubleValue2);


        System.out.println("int -> long");
        int intValue3 = 100000;
        long longValue3 = intValue3;
        System.out.println("int  = " + intValue3);
        System.out.println("long = " + longValue3);


        System.out.println("int -> float");
        int intValue4 = 100;
        float floatValue3 = intValue4;
        System.out.println("int   = " + intValue4);
        System.out.println("float = " + floatValue3);


        System.out.println("int -> double");
        int intValue5 = 500;
        double doubleValue3 = intValue5;
        System.out.println("int    = " + intValue5);
        System.out.println("double = " + doubleValue3);


        System.out.println("long -> float");
        long longValue4 = 500000L;
        float floatValue4 = longValue4;
        System.out.println("long  = " + longValue4);
        System.out.println("float = " + floatValue4);


        System.out.println("long -> double");
        long longValue5 = 900000L;
        double doubleValue4 = longValue5;
        System.out.println("long   = " + longValue5);
        System.out.println("double = " + doubleValue4);


        System.out.println("float -> double");
        float floatValue5 = 25.5f;
        double doubleValue5 = floatValue5;
        System.out.println("float  = " + floatValue5);
        System.out.println("double = " + doubleValue5);


        System.out.println("char -> int");
        char character1 = 'A';
        int charInt = character1;
        System.out.println("char = " + character1);
        System.out.println("int  = " + charInt);


        System.out.println("char -> long");
        char character2 = 'B';
        long charLong = character2;
        System.out.println("char = " + character2);
        System.out.println("long = " + charLong);


        System.out.println("char -> float");
        char character3 = 'C';
        float charFloat = character3;
        System.out.println("char  = " + character3);
        System.out.println("float = " + charFloat);


        System.out.println("char -> double");
        char character4 = 'D';
        double charDouble = character4;
        System.out.println("char   = " + character4);
        System.out.println("double = " + charDouble);

        System.out.println();
        
//      ---------------------------------------------------------
        
        System.out.println("Explicit TypeCasting (large to small Datatype)");
        
        System.out.println("double -> float");
        double doubleValue6 = 99.99;
        float floatValue6 = (float) doubleValue6;
        System.out.println("double = " + doubleValue6);
        System.out.println("float  = " + floatValue6);


        System.out.println("double -> long");
        double doubleValue7 = 5000.75;
        long longValue6 = (long) doubleValue7;
        System.out.println("double = " + doubleValue7);
        System.out.println("long   = " + longValue6);


        System.out.println("double -> int");
        double doubleValue8 = 125.99;
        int intValue6 = (int) doubleValue8;
        System.out.println("double = " + doubleValue8);
        System.out.println("int    = " + intValue6);


        System.out.println("double -> short");
        double doubleValue9 = 1000.50;
        short shortValue6 = (short) doubleValue9;
        System.out.println("double = " + doubleValue9);
        System.out.println("short  = " + shortValue6);


        System.out.println("double -> byte");
        double doubleValue10 = 100.50;
        byte byteValue6 = (byte) doubleValue10;
        System.out.println("double = " + doubleValue10);
        System.out.println("byte   = " + byteValue6);


        System.out.println("float -> long");
        float floatValue7 = 500.75f;
        long longValue7 = (long) floatValue7;
        System.out.println("float = " + floatValue7);
        System.out.println("long  = " + longValue7);


        System.out.println("float -> int");
        float floatValue8 = 250.99f;
        int intValue7 = (int) floatValue8;
        System.out.println("float = " + floatValue8);
        System.out.println("int   = " + intValue7);


        System.out.println("float -> short");
        float floatValue9 = 300.99f;
        short shortValue7 = (short) floatValue9;
        System.out.println("float = " + floatValue9);
        System.out.println("short = " + shortValue7);


        System.out.println("float -> byte");
        float floatValue10 = 100.99f;
        byte byteValue7 = (byte) floatValue10;
        System.out.println("float = " + floatValue10);
        System.out.println("byte  = " + byteValue7);


        System.out.println("long -> int");
        long longValue8 = 100000L;
        int intValue8 = (int) longValue8;
        System.out.println("long = " + longValue8);
        System.out.println("int  = " + intValue8);


        System.out.println("long -> short");
        long longValue9 = 30000L;
        short shortValue8 = (short) longValue9;
        System.out.println("long  = " + longValue9);
        System.out.println("short = " + shortValue8);


        System.out.println("long -> byte");
        long longValue10 = 1000L;
        byte byteValue8 = (byte) longValue10;
        System.out.println("long = " + longValue10);
        System.out.println("byte = " + byteValue8);


        System.out.println("int -> short");
        int intValue9 = 30000;
        short shortValue9 = (short) intValue9;
        System.out.println("int   = " + intValue9);
        System.out.println("short = " + shortValue9);


        System.out.println("int -> byte");
        int intValue10 = 100;
        byte byteValue9 = (byte) intValue10;
        System.out.println("int  = " + intValue10);
        System.out.println("byte = " + byteValue9);


        System.out.println("int -> char");
        int intValue11 = 65;
        char character5 = (char) intValue11;
        System.out.println("int  = " + intValue11);
        System.out.println("char = " + character5);


        System.out.println("short -> byte");
        short shortValue10 = 100;
        byte byteValue10 = (byte) shortValue10;
        System.out.println("short = " + shortValue10);
        System.out.println("byte  = " + byteValue10);


        System.out.println("char -> byte");
        char character6 = 'A';
        byte byteCharacter = (byte) character6;
        System.out.println("char = " + character6);
        System.out.println("byte = " + byteCharacter);


        System.out.println("char -> short");
        char character7 = 'Z';
        short shortCharacter = (short) character7;
        System.out.println("char  = " + character7);
        System.out.println("short = " + shortCharacter);


        System.out.println("byte + byte -> int");
        byte firstByte = 10;
        byte secondByte = 20;
        int byteSum = firstByte + secondByte;
        System.out.println("first byte  = " + firstByte);
        System.out.println("second byte = " + secondByte);
        System.out.println(byteSum);


        System.out.println("byte + byte -> byte");
        byte firstByte2 = 10;
        byte secondByte2 = 20;
        byte byteSum2 = (byte) (firstByte2 + secondByte2);
        System.out.println("first byte  = " + firstByte2);
        System.out.println("second byte = " + secondByte2);
        System.out.println(byteSum2);


        System.out.println("char + char -> int");
        char firstChar = 'A';
        char secondChar = 'B';
        int charSum = firstChar + secondChar;
        System.out.println("first char  = " + firstChar);
        System.out.println("second char = " + secondChar);
        System.out.println(charSum);


        System.out.println("int + char -> int");
        int number = 10;
        char character8 = 'A';
        int intCharResult = number + character8;
        System.out.println("int    = " + number);
        System.out.println("char   = " + character8);
        System.out.println(intCharResult);


        System.out.println("char -> int -> char");
        char originalChar = 'A';
        int charNumber = originalChar;
        char convertedChar = (char) charNumber;
        System.out.println("original char  = " + originalChar);
        System.out.println("int value      = " + charNumber);
        System.out.println(convertedChar);


        System.out.println("double -> int");
        double price = 99.99;
        int priceInt = (int) price;
        System.out.println("double = " + price);
        System.out.println("int    = " + priceInt);


        System.out.println("int -> double");
        int priceInt2 = 99;
        double priceDouble = priceInt2;
        System.out.println("int    = " + priceInt2);
        System.out.println("double = " + priceDouble);


        System.out.println("int division");
        int number1 = 10;
        int number2 = 3;
        int division1 = number1 / number2;
        System.out.println("number1  = " + number1);
        System.out.println("number2  = " + number2);
        System.out.println(division1);


        System.out.println("int -> double division");
        int number3 = 10;
        int number4 = 3;
        double division2 = (double) number3 / number4;
        System.out.println("number3  = " + number3);
        System.out.println("number4  = " + number4);
        System.out.println(division2);


        System.out.println("int -> byte overflow");
        int largeInt = 130;
        byte overflowByte = (byte) largeInt;
        System.out.println("int  = " + largeInt);
        System.out.println("byte = " + overflowByte);


        System.out.println("int -> byte negative overflow");
        int negativeInt = -130;
        byte negativeByte = (byte) negativeInt;
        System.out.println("int  = " + negativeInt);
        System.out.println("byte = " + negativeByte);


        System.out.println("long -> int overflow");
        long largeLong = 2147483648L;
        int overflowInt = (int) largeLong;
        System.out.println("long = " + largeLong);
        System.out.println("int  = " + overflowInt);


        System.out.println("String -> int");
        String numberString = "100";
        int parsedInt = Integer.parseInt(numberString);
        System.out.println("String = " + numberString);
        System.out.println("int    = " + parsedInt);


        System.out.println("String -> double");
        String decimalString = "99.99";
        double parsedDouble = Double.parseDouble(decimalString);
        System.out.println("String = " + decimalString);
        System.out.println("double = " + parsedDouble);


        System.out.println("String -> float");
        String floatString = "25.5";
        float parsedFloat = Float.parseFloat(floatString);
        System.out.println("String = " + floatString);
        System.out.println("float  = " + parsedFloat);


        System.out.println("String -> long");
        String longString = "999999";
        long parsedLong = Long.parseLong(longString);
        System.out.println("String = " + longString);
        System.out.println("long   = " + parsedLong);


        System.out.println("String -> short");
        String shortString = "500";
        short parsedShort = Short.parseShort(shortString);
        System.out.println("String = " + shortString);
        System.out.println("short  = " + parsedShort);


        System.out.println("String -> byte");
        String byteString = "100";
        byte parsedByte = Byte.parseByte(byteString);
        System.out.println("String = " + byteString);
        System.out.println("byte   = " + parsedByte);


        System.out.println("String -> boolean");
        String booleanString = "true";
        boolean parsedBoolean = Boolean.parseBoolean(booleanString);
        System.out.println("String  = " + booleanString);
        System.out.println("boolean = " + parsedBoolean);


        System.out.println("int -> String");
        int age = 25;
        String ageString = String.valueOf(age);
        System.out.println("int    = " + age);
        System.out.println("String = " + ageString);


        System.out.println("double -> String");
        double salary = 45000.50;
        String salaryString = String.valueOf(salary);
        System.out.println("double = " + salary);
        System.out.println("String = " + salaryString);


        System.out.println("char -> String");
        char gender = 'M';
        String genderString = String.valueOf(gender);
        System.out.println("char   = " + gender);
        System.out.println("String = " + genderString);


        System.out.println("boolean -> String");
        boolean status = true;
        String statusString = String.valueOf(status);
        System.out.println("boolean = " + status);
        System.out.println("String  = " + statusString);


        System.out.println("int -> Integer");
        int primitiveInt = 100;
        Integer integerObject = primitiveInt;
        System.out.println("int     = " + primitiveInt);
        System.out.println("Integer = " + integerObject);


        System.out.println("Integer -> int");
        Integer integerObject2 = 200;
        int primitiveInt2 = integerObject2;
        System.out.println("Integer = " + integerObject2);
        System.out.println("int     = " + primitiveInt2);


        System.out.println("double -> Double");
        double primitiveDouble = 99.99;
        Double doubleObject = primitiveDouble;
        System.out.println("double = " + primitiveDouble);
        System.out.println("Double = " + doubleObject);


        System.out.println("Double -> int");
        Double doubleObject2 = 100.75;
        int convertedInt = doubleObject2.intValue();
        System.out.println("Double = " + doubleObject2);
        System.out.println("int    = " + convertedInt);


        System.out.println("Double -> float");
        Double doubleObject3 = 100.75;
        float convertedFloat = doubleObject3.floatValue();
        System.out.println("Double = " + doubleObject3);
        System.out.println("float  = " + convertedFloat);


        System.out.println("Double -> long");
        Double doubleObject4 = 100.75;
        long convertedLong = doubleObject4.longValue();
        System.out.println("Double = " + doubleObject4);
        System.out.println("long   = " + convertedLong);


        System.out.println("Double -> short");
        Double doubleObject5 = 100.75;
        short convertedShort = doubleObject5.shortValue();
        System.out.println("Double = " + doubleObject5);
        System.out.println("short  = " + convertedShort);


        System.out.println("Double -> byte");
        Double doubleObject6 = 100.75;
        byte convertedByte = doubleObject6.byteValue();
        System.out.println("Double = " + doubleObject6);
        System.out.println("byte   = " + convertedByte);


        System.out.println("Object -> String");
        Object object1 = "Hello Java";
        String objectString = (String) object1;
        System.out.println("Object = " + object1);
        System.out.println("String = " + objectString);


        System.out.println("Object -> Integer");
        Object object2 = Integer.valueOf(500);
        Integer objectInteger = (Integer) object2;
        System.out.println("Object  = " + object2);
        System.out.println("Integer = " + objectInteger);
 
	}
}
