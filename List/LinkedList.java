public class LinkedList<T> implements ListInterface<T> {
  private Node firstNode;
  private int size;

  public LinkedList(){
    firstNode = null;
    size = 0;
  }

  public boolean add(T item, int position){
    checkPositionForAdd(position);
    boolean result = true;
    if(position == 0){
      firstNode = new Node(item, firstNode);
    } else {
      Node before = referenceTo(position-1);
      Node at = before.next;

      before.next = new Node(item, at);
    }
    size++;
    return result;
  }

  public T remove(int position){
    T result = null;
    checkPosition(position);
    if(position == 0){
      result = firstNode.data;
      firstNode = firstNode.next;
    } else {
      Node before = referenceTo(position-1);
      Node at = before.next;
      result = at.data;
      before.next = at.next;
    }
    size--;
    return result;
  }

  public T itemAt(int position){
    checkPosition(position);
    return referenceTo(position).data;
  }

  private Node referenceTo(int position){
    Node result = null;
    Node current = firstNode;
    int index = 0;
    while(current != null && index < position){
      index++;
      current = current.next;
    }
    result = current;
    return result;
  }

  private void checkPositionForAdd(int pos){
    if(pos < 0 || pos > size){
      throw new IndexOutOfBoundsException("Invalid position");
    }
  }

  private void checkPosition(int pos){
    if(pos < 0 || pos > size-1){
      throw new IndexOutOfBoundsException("Invalid position");
    }
  }


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
}
