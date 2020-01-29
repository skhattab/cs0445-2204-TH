/** A partial implementation of the ReallyLongInt class.
 * @author Sherif Khattab (Adapted from Dr. John Ramirez's Spring 2017 CS 0445 Assignment 2 code)
 * You need to complete the implementation of the remaining methods.  Also, for this class
 *  to work, you must complete the implementation of the ArrayDS class. See additional comments below.
 */

public class ReallyLongInt extends ArrayDS<Integer> implements Comparable<ReallyLongInt>
{
	// Instance variables are inherited.  You may not add any new instance variables
	private static final Integer[] DIGITS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

	private ReallyLongInt(int size) {

		super(DIGITS);
		for (int i = 0; i < size; i++) {
			append(0);
		}
	}

	/**
	 * @param s a string representing the integer (e.g., "123456") with no leading
	 * zeros except for the special case "0".
	 * Note that we are adding the digits here to the END. This results in the
	 * MOST significant digit first. It is assumed that String s is a valid representation of an
	 * unsigned integer with no leading zeros.
	 * @throws NumberFormatException if s contains a non-digit
	 */
	public ReallyLongInt(String s)
	{
		super(DIGITS);
		char c;
		Integer digit;
		// Iterate through the String, getting each character and converting it into
		// an int.  Then add at the end.  Note that
		// the append() method (from ArrayDS) adds at the end.
		for (int i = 0; i < s.length(); i++)
		{
			c = s.charAt(i);
			if (('0' <= c) && (c <= '9'))
			{
				digit = c - '0';
				append(digit);
			}
			else
				throw new NumberFormatException("Illegal digit " + c);
		}
	}



	/** Simple call to super to copy the items from the argument ReallyLongInt into a new one.
	 * @param rightOp the object to copy
	 */
	public ReallyLongInt(ReallyLongInt rightOp)
	{
		super(rightOp);
	}

	// You must implement the methods below.  See the descriptions in the
	// assignment sheet

	public ReallyLongInt add(ReallyLongInt rightOp) {
		return null;
	}


	/** Remove leading zeros.
	 *
	 */
	private void removeZeros() 	{

	}

	public ReallyLongInt subtract(ReallyLongInt rightOp){
		return null;
	}

	public ReallyLongInt subtract(ReallyLongInt first, ReallyLongInt second){
		return null;
	}

	public int compareTo(ReallyLongInt rOp){
		return 0;
	}

	public boolean equals(Object rightOp){
		return false;
	}

	public ReallyLongInt multTenToThe(int num){
		return null;
	}

	public ReallyLongInt divTenToThe(int num){
		return null;
	}
}
