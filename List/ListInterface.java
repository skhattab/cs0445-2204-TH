public interface ListInterface<T> {
  public boolean add(T item, int position);

  public T remove(int position);

  public T itemAt(int position);

}
