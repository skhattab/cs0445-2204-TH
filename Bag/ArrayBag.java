public class ArrayBag<T> implements BagInterface<T> {
  private static final int DEFAULT_CAPACITY = 10;
  private T[] bag;
  private int size;

  public ArrayBag(){
    this(DEFAULT_CAPACITY);
  }

  public ArrayBag(int initialCapacity){
    @SuppressWarnings("unchecked")
    T[] temp = (T[]) new Object[initialCapacity];
    bag = temp;
    size = 0;
  }
  /** Adds an item to the bag if possible
    * @param item the item to be added
    * @return true if adding was sucessful, or false otherwise
    */
  public boolean add(T item) {
    return false;
  }

  /** Removes an aribtrary instance of a given item from the bag.
    * @param item the item to be removed
    * @return the removed item, or null if item is not in the bag
    */
  public T remove(T item){
    return null;
  }

  public int size(){
    return 0;
  }

  public boolean isEmpty(){
    return false;
  }

  public boolean isFull() {
    return false;
  }

  public int getFrequencyOf(T item) {
    return 0;
  }

  public void clear(){

  }



}
