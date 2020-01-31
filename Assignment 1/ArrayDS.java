public class ArrayDS<T> implements SequenceInterface<T>, ReorderInterface {

  private int size;
  private T[] alphabet;
  private BagInterface<Integer>[][] array;
  T firstItem, lastItem;

  public ArrayDS(T[] alphabet){
    size = 0;
    this.alphabet = alphabet;
    firstItem = null;
    lastItem = null;
    @SuppressWarnings("unchecked")
    BagInterface<Integer>[][] temp =
      (ResizableArrayBag<Integer>[][])
      new ResizableArrayBag<?>[alphabet.length][alphabet.length];
      array = temp;
  }

  public ArrayDS(ArrayDS<T> other){
    size = other.size;
    alphabet = other.alphabet;
    firstItem = other.firstItem;
    lastItem = other.lastItem;
    @SuppressWarnings("unchecked")
    BagInterface<Integer>[][] temp =
      (ResizableArrayBag<Integer>[][])
      new ResizableArrayBag<?>[alphabet.length][alphabet.length];
    array = temp;
    for(int i=0; i<alphabet.length; i++){
      for(int j=0; j<alphabet.length; j++){
        if(other.array[i][j] != null){
          array[i][j] =
            new ResizableArrayBag<Integer>(
                other.array[i][j].toArray());
        }
      }
    }
  }
  /** Add a new Object to the logical end of the SequenceInterface<T>
	 * @param item the item to be added.
	 */
	public void append(T item){

  }

	/** Add a new Object to the logical start of the SequenceInterface<T>
	 * @param item the item to be added.
	 */
	public void prefix(T item){

  }

	/** Delete the item at the logical start of the SequenceInterface<T>
	 * @return the deleted item or null if the sequence is empty
	 */
	public T deleteHead(){
    if(isEmpty()){
      throw new EmptySequenceException("Attempting to delete from an empty seuquence.");
    }
    return null;
  }

	/** Delete the item at the logical end of the SequenceInterface<T>
	 * @return the deleted item
	 * @throws EmptySequenceException if the sequence is empty
	 */
	public T deleteTail(){
    return null;
  }

	/**
	 * @return true if the SequenceInterface is empty, and false otherwise
	 * @throws EmptySequenceException if the sequence is empty
	 */
	public boolean isEmpty(){
    return size == 0;
  }

	/**
	 * @return the number of items currently in the SequenceInterface
	 */
	public int size(){
    return size;
  }

	/**
	 * @return the the logically first item in the sequence
	 */
	public T first(){
    return firstItem;
  }

	/**
	 * @return the the logically last item in the sequence
	 */
	public T last(){
    return lastItem;
  }

	/** Checks if a given sequence is a subsequence of this sequence
	 * @param another the sequence to check
	 * @return true if another is a subsequence of this sequence or false otherwise
	 */
	public boolean hasSubsequence(SequenceInterface<T> another){
    return false;
  }

	/** Check if a given item comes right before another given item in the sequence
	 * @param first an item
	 * @param second another item
	 * @return true if first comes right before second in the sequence, or false otherwise
	 */
	public boolean predecessor(T first, T second){
    return false;
  }

	/** Return the number of occurences in the sequence of a given item
	 * @param item an item
	 * @return the number of occurences in the sequence of item
	 */
	public int getFrequencyOf(T item){
    return 0;
  }

	/** Reset the SequenceInterface to empty status by reinitializing the variables
	 * appropriately
	 */
	public void clear(){

  }

	/** Return the item at a given logical position
	 * @param position the logical position starting from 0
	 * @return the item at logical position position
	 * @throws IndexOutOfBoundsException if position < 0
	                                     or position > size()-1
	 */
	public T itemAt(int position){
    return null;
  }

	/** Return an array containing the items in the sequence in their logical order
	 * @return the an array containing the items in the sequence in their logical order
	 *         or null if the sequence is empty
	 */
	public T[] toArray(){
    return null;
  }

	/** Return the logical position in the sequence of the first occurrence of a given item
	 * @param item an item
	 * @return the logical position in the sequence of the first occurrence of item
	 *         or -1 if the item doesn't exist
	 */
	public int firstOccurrenceOf(T item){
    return 0;
  }

	/** Return the index of a given item in the alphabet of the sequence
	 * @param item an item
	 * @return the index of item in the alphabet of the sequence
	 *         or -1 if the item doesn't exist
	 */
	public int indexInAlphabet(T item){
    int result = -1;
    for(int i=0; i<alphabet.length; i++){
      if(alphabet[i].equals(item)){
        result = i;
        break;
      }
    }

    return result;
  }


	/** Return the index in the alphabet of the next item in the sequence
	 * @param item an item
	 * @param position item's position
	 * @return the index in the alphabet of the item after the occurrence of item
	 *         at position
	 *         or -1 if the next item doesn't exist
	 */
	public int nextIndex(T item, int position){
    return 0;
  }


	/** Return the index in the alphabet of the previous item in the sequence
	 * @param item an item
	 * @param position item's position
	 * @return the index in the alphabet of the item before the occurrence of item
	 *         at position
	 *         or -1 if the previous item doesn't exist
	 */
	public int prevIndex(T item, int position){
    return 0;
  }

  /** Logically reverse the data in the ReorderInterface object so that the item
   * that was logically first will now be logically last and vice
   * versa.  The physical implementation of this can be done in
   * many different ways, depending upon how you actually implemented
   * your physical ArrayDS<T> class
   */
  public void reverse(){

  }

  /** Remove the logically last item and put it at the
   * front.  As with reverse(), this can be done physically in
   * different ways depending on the underlying implementation.
   */
  public void rotateRight(){

  }

  /** Remove the logically first item and put it at the
   * end.  As above, this can be done in different ways.
   */
  public void rotateLeft(){

  }
}
