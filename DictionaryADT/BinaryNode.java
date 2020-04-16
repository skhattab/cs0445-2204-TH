public class BinaryNode<T> {
  private T data;
  private BinaryNode<T> left;
  private BinaryNode<T> right;

  public BinaryNode(){
    this(null);
  }

  public BinaryNode(T data){
    this.data = data;
    left = right = null;
  }

  public T getData(){
    return data;
  }

  public void setData(T data){
    this.data = data;
  }

  public BinaryNode<T> getLeftChild(){
    return left;
  }

  public void setLeftChild(BinaryNode<T> left){
    this.left = left;
  }

  public BinaryNode<T> getRightChild(){
    return right;
  }

  public void setRightChild(BinaryNode<T> right){
    this.right = right;
  }

  public boolean hasLeftChild(){
    return left != null;
  }

  public boolean hasRightChild(){
    return right != null;
  }

  public boolean isLeaf(){
    return left == null && right == null;
  }

  public int getHeight(){
    int leftHeight = 0;
    int rightHeight = 0;
    if(hasLeftChild()){
       leftHeight = left.getHeight();
     }
     if(hasRightChild()){
       rightHeight = right.getHeight();
     }
     return 1 + Math.max(leftHeight, rightHeight);
  }

  public int getNumberOfNodes(){
    int leftCount = 0;
    int rightCount = 0;
    if(hasLeftChild()){
      leftCount = left.getNumberOfNodes();
    }
    if(hasRightChild()){
      rightCount = right.getNumberOfNodes();
    }
    return 1 + leftCount + rightCount;
  }

  public BinaryNode<T> copy(){
    BinaryNode<T> result = new BinaryNode<>(data);
    if(hasLeftChild()){
      result.left = left.copy();
    }
    if(hasRightChild()){
      result.right = right.copy();
    }
    return result;
  }


}
