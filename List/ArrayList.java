public final class ArrayList<T> implements ListInterface<T> {
  private final T[] list;
  private int size;
  private boolean initialized;
  private static final int DEFAULT_CAPACITY = 10;
  private static final int MAX_CAPACITY = 1000;

  public ArrayList(){
    this(DEFAULT_CAPACITY);
  }

  public ArrayList(int capacity){
    @SuppressWarnings("unchecked")
    T[] temp = (T[]) new Object[capacity];
    list = temp;
    size=0;
    initialized=true;
  }
  public boolean add(T item, int position){
    checkPositionForAdd(position);
    boolean result = false;
    if(!isEmpty()){
      makeSpace(position);
      list[position] = item;
      size++;
      result = true;
    }
    return result;
  }

  public T remove(int position){
    checkPosition(position);
    T result = null;
    if(!isEmpty()){
      result = list[position];
      fillGap(position);
      list[size-1] = null;
      size--;
    }
    return result;
  }

  public T itemAt(int position){
    checkPosition(position);
    return list[position];
  }

  public boolean isEmpty(){
    return size == 0;
  }

  private void makeSpace(int position){
    for(int i = size-1; i>= position; i--){
      list[i+1] = list[i];
    }
  }

  private void fillGap(int position){
    for(int i = position+1; i<size; i++){
      list[i-1] = list[i];
    }
  }

  private void checkPositionForAdd(int pos){
    if(pos < 0 || pos > size){
      throw new IndexOutOfBoundsException("Invalid position.");
    }
  }

  private void checkPosition(int pos){
    if(pos < 0 || pos > size-1){
      throw new IndexOutOfBoundsException("Invalid position");
    }
  }

}
