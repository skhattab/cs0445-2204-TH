public final class LinkedStack<T>
                   implements StackInterface<T>{
  private Node top;
  private int size;

  public LinkedStack(){
    clearHelper();
  }

  public boolean push(T item){
    boolean result = true;
    top = new Node(item, top);
    size++;
    return result;
  }

  public T pop(){
    T result = null;
    if(!isEmpty()){
      result = top.data;
      top = top.next;
      size--;
    }
    return result;
  }

  public T top(){
    T result = null;
    if(!isEmpty()){
      result = top.data;
    }
    return result;
  }

  public boolean isEmpty(){
    return size == 0;
  }

  public boolean isFull(){
    return false;
  }

  public int size(){
    return size;
  }

  public void clear(){
    clearHelper();
  }

  private void clearHelper(){
    top = null;
    size = 0;
  }

  private class Node{
    private T data;
    private Node next;
    private Node(T data){
      this(data, null);
    }

    private Node(T data, Node next){
      this.data = data;
      this.next = next;
    }
  }

}
