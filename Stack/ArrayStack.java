public final class ArrayStack<T>
             implements StackInterface<T> {
      private final static int MAX_CAPACITY = 1000;
      private final static int DEFAULT_CAPACITY = 10;
      private T[] stack;
      private int topIndex;
      private boolean initialized;

      public ArrayStack(){
        this(DEFAULT_CAPACITY);
      }
      public ArrayStack(int capacity){
          checkCapacity(capacity);
          @SuppressWarnings("unchecked")
          T[] temp = (T[])new Object[capacity];
          stack = temp;
          topIndex = 0;
          initialized = true;
      }

      public boolean push(T item){
        checkInitialized();
        boolean result = false;
        if(!isFull()){
          stack[topIndex] = item;
          topIndex++;
          result = true;
        }
        return result;
      }

      public T pop(){
        T result = null;
        if(!isEmpty()){
          result = stack[topIndex-1];
          stack[topIndex-1] = null;
          topIndex--;
        }
        return result;
      }

      public T top(){
        T result = null;
        if(!isEmpty()){
          result = stack[topIndex-1];
        }
        return result;
      }

      public boolean isEmpty(){
        return topIndex == 0;
      }

      public boolean isFull(){
        return topIndex == stack.length;
      }

      public int size(){
        return topIndex;
      }

      public void clear(){
        while(!isEmpty()){
          pop();
        }

        // int size = size();
        // for(int i=0; i<size; i++){
        //   pop();
        // }
      }

      private void checkCapacity(int capacity){
        if(capacity <= 0 || capacity > MAX_CAPACITY){
          throw new IllegalStateException(
                "Attempting to create an ArrayStack with invalid capacity.");
        }
      }

      private void checkInitialized(){
        if(!initialized){
          throw new SecurityException(
                "Attempting to access an uninitialized ArrayStack");
        }
      }
}
