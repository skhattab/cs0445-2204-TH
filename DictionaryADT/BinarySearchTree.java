public class BinarySearchTree<T extends Comparable<? super T>>
implements DictionaryInterface<T>{

  private BinaryNode<T> root;

  public BinarySearchTree(){
    this(null);
  }

  public BinarySearchTree(BinaryNode<T> root){
    this.root = root;
  }

  public BinaryNode<T> getRoot(){
    return root;
  }

  public void inOrderTraverse(){
    inOrderTraverse(root);
    System.out.println();
  }

  public void preOrderTraverse(){
    preOrderTraverse(root);
    System.out.println();
  }

  public void postOrderTraverse(){
    postOrderTraverse(root);
    System.out.println();
  }

  private void inOrderTraverse(BinaryNode<T> root){
    if(root != null){
      if(root.hasLeftChild()){
        inOrderTraverse(root.getLeftChild());
      }
      System.out.print(root.getData() + " ");
      if(root.hasRightChild()){
        inOrderTraverse(root.getRightChild());
      }
    }
  }

  private void preOrderTraverse(BinaryNode<T> root){
    if(root != null){
      System.out.print(root.getData() + " ");
      if(root.hasLeftChild()){
        preOrderTraverse(root.getLeftChild());
      }
      if(root.hasRightChild()){
        preOrderTraverse(root.getRightChild());
      }
    }
  }

  private void postOrderTraverse(BinaryNode<T> root){
    if(root != null){
      if(root.hasLeftChild()){
        postOrderTraverse(root.getLeftChild());
      }
      if(root.hasRightChild()){
        postOrderTraverse(root.getRightChild());
      }
      System.out.print(root.getData() + " ");
    }
  }

  public T add(T item){
    T result = null;
    if(root == null){
      root = new BinaryNode<T>(item);
    } else {
      result = add(root, item);
    }
    return result;
  }

  public T remove(T item){
    Envelope envelope = new Envelope(null);
    root = remove(root, item, envelope);
    return envelope.item;
  }

  public boolean contains(T item){
    return getItem(item) != null;
  }

  public T getItem(T item){
    return find(root, item);
  }

  private T find(BinaryNode<T> root, T item){
    T result = null;
    if(root != null){
      int compareResult = root.getData().compareTo(item);
      if(compareResult == 0){//equal
        result = root.getData();
      } else if(compareResult > 0){//root > item
        result = find(root.getLeftChild(), item);
      } else{ //root < item
        result = find(root.getRightChild(), item);
      }
    }
    return result;
  }

  private T add(BinaryNode<T> root, T item){
    T result = null;
    int compareResult = root.getData().compareTo(item);
    if(compareResult == 0){//root == item
      result = root.getData();
      root.setData(item);
    } else if(compareResult > 0){ //root > item
      if(!root.hasLeftChild()){
        BinaryNode<T> newNode = new BinaryNode<>(item);
        root.setLeftChild(newNode);
      } else {
        result = add(root.getLeftChild(), item);
      }
    } else { //root < item
      if(!root.hasRightChild()){
        root.setRightChild(new BinaryNode<T>(item));
      } else {
        result = add(root.getRightChild(), item);
      }
    }
    return result;
  }

  private BinaryNode<T> findLargest(BinaryNode<T> root){
    BinaryNode<T> result = null;
    if(root.hasRightChild()){
      result = findLargest(root.getRightChild());
    } else {
      result = root;
    }
    return result;
  }

  private BinaryNode<T> removeLargest(BinaryNode<T> root){
    BinaryNode<T> result = null;
    if(root.hasRightChild()){
      root.setRightChild(removeLargest(root.getRightChild()));
      result = root;
    } else {
      result = root.getLeftChild();
    }
    return result;
  }

  private BinaryNode<T> removeRoot(BinaryNode<T> root){
    BinaryNode<T> result = null;
    if(root.isLeaf()){
      result = null;
    } else if(root.hasLeftChild() && root.hasRightChild()){
      BinaryNode<T> largest = findLargest(root.getLeftChild());
      root.setData(largest.getData());
      root.setLeftChild(removeLargest(root.getLeftChild()));
      result = root;
    } else { //one child
      if(root.hasLeftChild()){
        result = root.getLeftChild();
      } else {
        result = root.getRightChild();
      }
    }
    return result;
  }

  private BinaryNode<T> remove(BinaryNode<T> root, T item, Envelope envelope){
    BinaryNode<T> result = null;
    if(root != null){
      int compareResult = root.getData().compareTo(item);
      if(compareResult == 0){ //equal
        envelope.item = root.getData();
        result = removeRoot(root);
      } else if(compareResult > 0){//root > item
        root.setLeftChild(remove(root.getLeftChild(), item, envelope));
        result = root;
      } else{ //root < item
        root.setRightChild(remove(root.getRightChild(), item, envelope));
        result = root;
      }
    }
    return result;
  }

  private class Envelope{
    T item;
    private Envelope(T item){
      this.item = item;
    }
  }
}
