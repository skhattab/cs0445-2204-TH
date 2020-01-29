
/** Driver program for the first part of Assignment 1
 * @author Sherif Khattab (Adapted  from Dr. John Ramirez's Spring 2017 CS 0445 Assignment 1 code)
 *
 * This program must work as is with your ArrayDS<T> class.
 * Look carefully at all of the method calls so that
 *  you create your ArrayDS<T> methods correctly.  For example,
 *  note the constructor calls and the toString() method call.
 *  The output should be identical to the sample output.
 *  This will be verified by running the diff program (fc on Windows) between
 *  the provided A1Out.txt and the output of running this driver using your
 *  ArrayDS<T> implementation. The diff program shouldn't
 *  give any differences.
 */
public class Assig1A
{
	private static final int SIZE = 5;
	private static final int SIZE2 = 10;
	private static final int LARGE_SIZE = 100000;
	private static final Integer[] DIGITS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	private static final Character[] LETTERS = {' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	public static void main(String [] args)
	{
		// Testing constructors and SequenceInterface<T> interface


		ArrayDS<Integer> s1 = new ArrayDS<>(DIGITS);

		// Testing append
		for (int i = 0; i < SIZE; i++)
		{
			Integer newItem = 2 * i;
			s1.append(newItem);
			System.out.println(newItem + " appended to sequence");
		}

		System.out.println(s1);
		//Testing clear
		s1.clear();
		int sz = s1.size();
		System.out.println(sz + " item(s) in the sequence.");

		// Testing prefix
		for (int i = 0; i < SIZE; i++)
		{
			Integer newItem = 2 * i;
			s1.prefix(newItem);
			System.out.println(newItem + " prefixed to sequence");
		}

		System.out.println(s1);

		ArrayDS<Integer> s2 = new ArrayDS<>(s1);
		System.out.println(s2);

		SequenceInterface<Integer> theS = new ArrayDS<>(DIGITS);

		for (int i = 0; i < SIZE; i++)
		{
			Integer newItem = 2 * i;
			theS.append(newItem);
			System.out.println(newItem + " added to sequence");
		}

		System.out.println(theS);

		// Testing deleteHead
		while (!(theS.isEmpty()))
		{
			Integer oldItem = theS.deleteHead();
			System.out.println(oldItem + " retrieved from sequence");
		}
		try {
			Integer noItem = theS.deleteHead();
		} catch (EmptySequenceException e) {
			System.out.println("Nothing in the sequence");
		}

		// Testing deleteTail
		while (!(s1.isEmpty()))
		{
			Integer oldItem = s1.deleteTail();
			System.out.println(oldItem + " retrieved from sequence");
		}
		try {
			Integer noItem = s1.deleteTail();
		} catch (EmptySequenceException e) {
			System.out.println("Nothing in the sequence");
		}

		// Testing array management
		String[] alphabet = new String[SIZE2];
		for(int i=0; i<SIZE2; i++){
			alphabet[i] = new String("Item " + i);
		}
		SequenceInterface<String> theS2 = new ArrayDS<>(alphabet);

		int count = 0;
		String theItem = new String("Item " + count);
		System.out.println("Adding " + theItem);
		theS2.prefix(theItem);
		for (int i = 0; i < 8; i++)
		{
			count++;
			theItem = new String("Item " + count);
			System.out.println("Adding " + theItem);
			theS2.prefix(theItem);
			theItem = theS2.deleteHead();
			System.out.println("Removing " + theItem);
		}
		sz = theS2.size();
		System.out.println(sz + " item(s) in the sequence.");


		//Testing itemAt, firstOccurrenceOf, getFrequencyOf, indexInAlphabet,
		//nextIndex, prevIndex, predecessor()
		SequenceInterface<Character> sentence = new ArrayDS<>(LETTERS);
		String s = "data structures are fun";
		for(Character c : s.toCharArray()){
			sentence.append(c);
		}
		System.out.println(sentence);

		int index = 10;
		char c = 's';
		System.out.println("The index of " + c + " in the alphabet is: " + sentence.indexInAlphabet(c));

		System.out.println("Character at index " + index + " is " + sentence.itemAt(index));
		System.out.println("First occurrence of " + c + " is at position " +
											  sentence.firstOccurrenceOf(c));
		System.out.println("The letter following the occurrence of " + c + " at position "
		                   + sentence.firstOccurrenceOf(c) + " is " + LETTERS[sentence.nextIndex(c, sentence.firstOccurrenceOf(c))]);
		c = 't';
		System.out.println("The letter preceding the occurrence of " + c + " at position "
									 		                   + sentence.firstOccurrenceOf(c) + " is " + LETTERS[sentence.prevIndex(c, sentence.firstOccurrenceOf(c))]);
		char char1 = 'r';
		char char2 = 'u';
		System.out.println("The letter " + char1 + " is a predecessor of " + char2 + ": " + sentence.predecessor(char1, char2));
	  char1 = 'r';
		char2 = 't';
		System.out.println("The letter " + char1 + " is a predecessor of " + char2 + ": " + sentence.predecessor(char1, char2));


		SequenceInterface<Character> word = new ArrayDS<>(LETTERS);
		String w = "tures aref";
		for(Character c2 : w.toCharArray()){
			word.append(c2);
		}
		System.out.println(sentence + " has a subsequence of " + w + ": " + sentence.hasSubsequence(word));

		w = "fun";
		word.clear();
		for(Character c3 : w.toCharArray()){
			word.append(c3);
		}
		System.out.println(sentence + " has a subsequence of " + word + ": " + sentence.hasSubsequence(word));

		// This code will test the toString() method and the Reorder
		// interface.
		System.out.println("\nAbout to test Reorder methods");
		ArrayDS<Integer> newDS = new ArrayDS<>(DIGITS);
		for (int i = 0; i < 8; i++)
		{
			System.out.println("Prefixing " + i);
			newDS.prefix(i);
		}
		System.out.println(newDS);
		System.out.println("Reversing");
		newDS.reverse();
		System.out.println(newDS);
		System.out.println("Removing 3 items then appending 1");
		newDS.deleteTail();
		newDS.deleteTail();
		newDS.deleteTail();
		newDS.append(8);
		System.out.println(newDS);
		System.out.println("Reversing");
		newDS.reverse();
		System.out.println(newDS);
		System.out.println("Rotating right");
		newDS.rotateRight();
		System.out.println(newDS);
		System.out.println("Rotating left twice");
		newDS.rotateLeft();
		newDS.rotateLeft();
		System.out.println(newDS);

		//Testing with really large sequences
		SequenceInterface<Integer> largeNumber = new ArrayDS<>(DIGITS);
		for(int i=0; i<LARGE_SIZE; i++){
			largeNumber.append(9);
		}
		//System.out.println(largeNumber);
		System.out.println("The size of the sequence is " + largeNumber.size());
}
}
