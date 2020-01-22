public class LinkedBag<T> implements BagInterface<T>{


  /** Adds an item to the bag if possible
    * @param item the item to be added
    * @return true if adding was sucessful, or false otherwise
    */
  public boolean add(T item){
    return false;
  }

  /** Removes an aribtrary instance of a given item from the bag.
    * @param item the item to be removed
    * @return the removed item, or null if item is not in the bag
    */
  public T remove(T item){
    return null;
  }

  /** Removes an arbitrary item from the Bag
    * @return the removed item, or null if the bag is empty
    */
  public T remove(){
    return null;
  }

  public int size(){
    return 0;
  }

  public boolean isEmpty(){
    return false;
  }

  public boolean isFull(){
    return false;
  }

  public int getFrequencyOf(T item){
    return 0;
  }

  public boolean contains(T item){
    return false;
  }

  public void clear(){

  }

  public T[] toArray(){
    return null;
  }

  public BagInterface<T> intersection(BagInterface<T> anotherBag){
    return null;
  }

  public BagInterface<T> union(BagInterface<T> anotherBag){
    return null;
  }

  public BagInterface<T> difference(BagInterface<T> another){
    return null;
  }

}
