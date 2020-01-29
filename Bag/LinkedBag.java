public class LinkedBag<T> implements BagInterface<T>{

  private Node firstNode;
  private int size;

  public LinkedBag(){
    firstNode = null;
    size=0;
  }

  /** Adds an item to the bag if possible
    * @param item the item to be added
    * @return true if adding was sucessful, or false otherwise
    */
  public boolean add(T item){
    boolean result = true;
    firstNode = new Node(item, firstNode);
    size++;
    return result;
  }

  /** Removes an aribtrary instance of a given item from the bag.
    * @param item the item to be removed
    * @return the removed item, or null if item is not in the bag
    */
  public T remove(T item){
    T result = null;
    if(!isEmpty()){
      //go to the node containing item
      Node toRemove = referenceTo(item);
      if(toRemove != null){
        //save the value into result
        result = toRemove.data;
        //replace by firstNode's data
        toRemove.data = firstNode.data;
        //remove first node
        firstNode = firstNode.next;
        size--;
      }
    }
    return result;
  }

  /** Removes an arbitrary item from the Bag
    * @return the removed item, or null if the bag is empty
    */
  public T remove(){
    T result = null;
    if(!isEmpty()){
      result = firstNode.data;
      firstNode = firstNode.next;
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

  public boolean isFull(){
    return false;
  }

  //runtime = 3 + 3n + x (x is the frequency)
  public int getFrequencyOf(T item){
    int result = 0;
    Node current = firstNode;
    while(current != null){
        if(current.data.equals(item)){
          result++;
        }
        current = current.next;
    }
    /* while(firstNode != null){
      firstNode = firstNode.next;
    } */ // <= DON'T DO THAT
    return result;
  }

  public boolean contains(T item){
    return referenceTo(item) != null ;
  }

  public void clear(){
    firstNode = null;
    size=0;
  }

  public T[] toArray(){
    @SuppressWarnings("unchecked")
    T[] result = (T[])new Object[size];
    int index = 0;
    Node current = firstNode;
    while(current != null){
      result[index] = current.data;
      current = current.next;
      index++;
    }
    return result;
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

  private Node referenceTo(T item){
    Node result = null;
    Node current = firstNode;
    while(current != null){
      if(current.data.equals(item)){
        result = current;
        break;
      }
      current = current.next;
    }
    return result;

  }

  //nested class
  private class Node {
    T data;
    Node next;

    private Node(T data){
      this(data, null);
    }
    private Node(T data, Node next){
      this.data = data;
      this.next = next;
    }
  }

  /*
    for(int i=n; i>0; i = i/2 ){

    }
  */

}
