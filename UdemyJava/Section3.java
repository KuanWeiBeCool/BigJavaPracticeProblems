
public class Section3 {

	public Section3() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		dataType();
	} 
	
	private static void dataType() {
		// Integer, byte, short, long.
		
		int intMin = Integer.MIN_VALUE;
		int intMax = Integer.MAX_VALUE;
		System.out.println(intMin);
		System.out.println(intMax);
		
		byte byteMin = Byte.MIN_VALUE;
		byte byteMax = Byte.MAX_VALUE;
		System.out.println(byteMin);
		System.out.println(byteMax);		
		
		short shortMin = Short.MIN_VALUE;
		short shortMax = Short.MAX_VALUE;
		System.out.println(shortMin);
		System.out.println(shortMax);
		
		long longMin = Long.MIN_VALUE;
		long longMax = Long.MAX_VALUE;
		System.out.println(longMin);
		System.out.println(longMax);
		
		byte newByte = (byte) (byteMin / 2);
		short newShort = (short) (shortMin / 2);
		
		float floatMin = Float.MIN_VALUE;
		float floatMax = Float.MAX_VALUE;
		System.out.println(floatMin);
		System.out.println(floatMax);	
		
		double doubleMin = Double.MIN_VALUE;
		double doubleMax = Double.MAX_VALUE;
		System.out.println(doubleMin);
		System.out.println(doubleMax);		
		
		// Assign float and double
		
		int myInt = 5;
		float myFloat = (float) 5.25; // by default, the decimal number is double.
									  // So need to convert to float.
		// Another way
		float myFloat2 = 5.25f;
		
		// It is fine to directly assign a decimal number as double.
		double myDouble = 5.5;
		// Another way
		double myDouble2 = 5.5d;
		
		// float and double have different precision
		float myFloat3 = 5f / 3f;
		double myDouble3 = 5d / 3d;
		
		System.out.println(myFloat3);
		System.out.println(myDouble3);
		// Note: it is faster to deal with double than float. So it is always recommended
		// to use double compared to float.
		
		// Char and boolean
		char myChar = 'D'; // Note one prime, and one letter.
		char myUnicodeChar = '\u0044'; // This is the unicode for D.
		char myUnicodeChar2 = '\u00A9';
		System.out.println(myUnicodeChar);
		System.out.println(myUnicodeChar2);
		
		boolean myTrue = true;
		boolean myFalse = false;
		
		// Tenary Operator ?: a shortcut to assign one of two values to a variable depending on the condition
		// the Tenary operator gives true if the former is true, otherwise gives false.
		boolean myTenary = myTrue ? true : false; 
		// the Tenary operator gives "Yes" if the former is true, otherwise gives "No".
		String myTenary1 = myTrue ? "Yes" : "No"; 
		
		int age = 20;
		boolean isEighteenOrOver = age >= 18 ? true : false;
		System.out.println(isEighteenOrOver);
		
		// String
		String myString = "50"; // Strings in Java are immutable!
		int myInt1 = 10;
		System.out.println(myString + myInt1); // in Java, number and string can be added together
											   // however, this is very inefficient way of concat strings!
		
	}
	

}
