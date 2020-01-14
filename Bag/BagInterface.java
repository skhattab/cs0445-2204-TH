/**
  * An interface for a bag of items
  */

public interface BagInterface<T>  {

  /** Adds an item to the bag if possible
    * @param item the item to be added
    * @return true if adding was sucessful, or false otherwise
    */
  public boolean add(T item);

  /** Removes an aribtrary instance of a given item from the bag.
    * @param item the item to be removed
    * @return the removed item, or null if item is not in the bag
    */
  public T remove(T item);

  public int size();

  public boolean isEmpty();

  public boolean isFull();

  public int getFrequencyOf(T item);

  public void clear();

}
