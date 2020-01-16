public class ArrayBag<T> implements BagInterface<T> {
  private static final int DEFAULT_CAPACITY = 10;
  private static final int MAX_CAPACITY = 1000;
  final private T[] bag;
  private int size;
  private boolean initialized;

  public ArrayBag(){
    this(DEFAULT_CAPACITY);
  }

  public ArrayBag(int initialCapacity){
    checkCapacity(initialCapacity);
    @SuppressWarnings("unchecked")
    T[] temp = (T[]) new Object[initialCapacity];
    bag = temp;
    size = 0;
    initialized = true;
  }
  /** Adds an item to the bag if possible
    * @param item the item to be added
    * @return true if adding was sucessful, or false otherwise
    */
  public boolean add(T item) {
    checkIntegrity();
    boolean result = false;
    if(!isFull()){
      bag[size] = item;
      size++;
      result = true;
    }
    return result;
  }

  /** Removes an aribtrary instance of a given item from the bag.
    * @param item the item to be removed
    * @return the removed item, or null if item is not in the bag
    */
  public T remove(T item){
    checkIntegrity();
    T result = null;
    int index = indexOf(item);
    if(index != -1){
      result = bag[index];
      bag[index] = bag[size-1];
      bag[size-1] = null;
      size--;
    }
    return result;
  }

  public T remove(){
    checkIntegrity();
    T result = null;
    if(!isEmpty()){
      result = bag[size-1];
      bag[size-1]= null;
      size--;
    }
    return result;
  }


  public int size(){
    return size;
  }

  public boolean isEmpty(){
    return size == 0;
  }

  public boolean isFull() {
    return size == bag.length;
  }

  public int getFrequencyOf(T item) {
    checkIntegrity();
    int result = 0;
    for(int i=0; i<size; i++){
      if(bag[i].equals(item)){ //(bag[i] == item) <= DON'T USE
        result++;
      }
    }
    return result;
  }

  public void clear(){
    checkIntegrity();
    while(!isEmpty()){
      remove();
    }
    /*for(int i=0; i<size; i++){
      bag[i] = null;
    }
    size = 0;
    */

    /*
    @SuppressWarnings("unchecked")
    T[] temp = (T[])new Object[bag.length];
    bag = temp;
    size = 0;
    */

    //bag = null; <= DON'T DO THAT
  }

  public T[] toArray(){
    //return bag; <= DON'T DO THAT
    @SuppressWarnings("unchecked")
    T[] result = (T[]) new Object[size];
    for(int i=0; i<size; i++){
      result[i] = bag[i];
    }
    return result;
  }


  public BagInterface<T> intersection(BagInterface<T> anotherBag){
    checkIntegrity();
    int newSize = size;
    if(newSize > anotherBag.size()){
      newSize = anotherBag.size();
    }

    BagInterface<T> result = new ArrayBag<>(newSize);
    //TODO: Complete the method

    return result;
  }

  public BagInterface<T> union(BagInterface<T> anotherBag){
    checkIntegrity();

    return null;
  }

  public BagInterface<T> difference(BagInterface<T> another){
    checkIntegrity();

    return null;
  }

  private void checkCapacity(int capacity){
    if(capacity < 0 || capacity > MAX_CAPACITY){
      throw new IllegalStateException("Attempting to create an ArrayBag with an illegal capacity.");
    }
  }

  private void checkIntegrity(){
    if(!initialized){
      throw new SecurityException("Attempting to operate on an non-initialized ArrayBag.");
    }
  }

  private int indexOf(T item){
    int result = -1;
    for(int i=0; i<size; i++){
      if(bag[i].equals(item)){
        result = i;
        break;
      }
    }
    return result;
  }



}
