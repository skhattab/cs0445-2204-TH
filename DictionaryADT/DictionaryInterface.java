public interface DictionaryInterface<T>{

  public boolean add(T item);

  public T remove(T item);

  public boolean contains(T item);

  public T getItem(T item);
}
