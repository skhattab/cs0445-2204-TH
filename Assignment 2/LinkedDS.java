import java.util.Arrays;
import java.util.ArrayList;

public class LinkedDS<T> implements SequenceInterface<T>, ReorderInterface {

  private ArrayList<Node> array; //1-D array
  private int size; //the number of items in the sequence
  private T[] alphabet; //the possible item values (e.g., the decimal digits)
  private T firstItem; //the first item in the sequence
  private T lastItem; //the last item in the sequence

  public LinkedDS(T[] alphabet){
    array = new ArrayList<Node>(alphabet.length);
    for(int i=0; i<alphabet.length; i++){
      array.add(i, null);
    }
    this.alphabet = alphabet;
    firstItem = lastItem = null;
    size = 0;
  }

  public LinkedDS(LinkedDS<T> other){
    alphabet = other.alphabet;
    array = new ArrayList<Node>(alphabet.length);
    for(int i=0; i<alphabet.length; i++){
      array.add(i, null);
    }
    size = other.size;
    firstItem = other.firstItem;
    lastItem = other.lastItem;

    for(int i=0; i<alphabet.length; i++){
      if(other.array.get(i) != null){
        array.add(i, new Node(other.array.get(i).indexInAlphabet));
        array.get(i).copyPositions((ResizableArrayBag<Integer>)other.array.get(i).positions);
        Node otherCurrent = other.array.get(i).next;
        Node current = array.get(i);
        while(otherCurrent != null){
          current.next = new Node(otherCurrent.indexInAlphabet);
          current.next.copyPositions((ResizableArrayBag<Integer>)otherCurrent.positions);
          current = current.next;
          otherCurrent = otherCurrent.next;
        }
      }
    }
  }

  // Node current = array.get(7);
  // while(current != null){
  //   curent = current.next;
  // }
  public void append(T item){
    //TODO
  }

  public void prefix(T item){
    //TODO
  }

  public T deleteHead(){
    //TODO
    return null;
  }

  public T deleteTail(){
    //TODO
    return null;
  }

  public int getFrequencyOf(T item){
    //TODO
    return 0;
  }

  public T[] toArray(){
    //TODO
    return null;
  }

  public boolean isEmpty(){
    //TODO
    return false;
  }

  public int size(){
    //TODO
    return 0;
  }

  public void clear() {
    //TODO
  }

  public T itemAt(int position) {
    //TODO
    return null;
  }

  public int firstOccurrenceOf(T item) {
    //TODO
    return 0;
  }

  public T first(){
    //TODO
    return null;
  }

  public T last(){
    //TODO
    return null;
  }

  public boolean hasSubsequence(SequenceInterface<T> another){
    //TODO
    return false;
  }

  public void reverse() {
    //TODO
  }

  public void rotateRight() {
    //TODO
  }


  public void rotateLeft() {
    //TODO
  }

  public String toString(){
    StringBuilder result = new StringBuilder();
    int index = indexInAlphabet(firstItem);
    for(int i=0; i<size; i++){
      result.append(alphabet[index]);
      index = nextIndex(alphabet[index], i);
    }
    return result.toString();
  }

  public void display(){
    System.out.println(firstItem + " " + lastItem + " " + size);
    for(int i=0; i<alphabet.length; i++){
      Node current = array.get(i);
        System.out.print(alphabet[i] + ": ");
        while(current != null){
          System.out.print("(" + alphabet[current.indexInAlphabet] + ", " + current.positions + ") ");
          current = current.next;
        }
        System.out.println();
      }
  }

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

  public int nextIndex(T item, int position){
    //TODO
    return 0;
  }

  public int prevIndex(T item, int position){
    //TODO
    return 0;
  }

  public boolean predecessor(T first, T second){
    //TODO
    return false;
  }

  private class Node {
    private int indexInAlphabet;
    private BagInterface<Integer> positions;
    private Node next;

    private Node(int indexInAlphabet){
      this(indexInAlphabet, null);
    }
    private Node(int indexInAlphabet, Node next){
      this.indexInAlphabet = indexInAlphabet;
      this.positions = null;
      this.next = next;
    }
    private void addPosition(int position){
      if(positions == null){
        positions = new ResizableArrayBag<Integer>();
      }
      positions.add(position);
    }
    private void deletePosition(int position){
      positions.remove(position);
    }
    private void copyPositions(ResizableArrayBag<Integer> other){
      positions = new ResizableArrayBag<Integer>();
      Object[] objs = other.toArray();
      for(Object obj : objs){
        Integer pos = (Integer) obj;
        positions.add(pos);
      }
    }
  }
}
