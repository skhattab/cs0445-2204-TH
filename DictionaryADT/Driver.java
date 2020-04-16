public class Driver {
  public static void main(String[] args){
    testBST();
  }

  public static void testBST(){
    BinarySearchTree<Character> bst = new BinarySearchTree<>();
    bst.add('G');
    bst.add('D');
    bst.add('B');
    bst.add('E');
    bst.add('A');
    bst.add('C');
    bst.add('F');
    bst.add('K');
    bst.add('N');
    bst.add('I');
    bst.add('L');
    bst.add('H');
    bst.add('J');
    bst.add('M');

    System.out.println("Original BST:");
    System.out.print("\tInorder traversal:\t");
    bst.inOrderTraverse();
    System.out.print("\tPreorder traversal:\t");
    bst.preOrderTraverse();
    System.out.print("\tPostorder traversal:\t");
    bst.postOrderTraverse();

    System.out.println("\tHeight of tree is: " +
    bst.getRoot().getHeight());
    System.out.println("\tNumber of nodes is: " +
    bst.getRoot().getNumberOfNodes());

    System.out.println("Copy of Original BST:");
    BinarySearchTree<Character> copy = new BinarySearchTree<>(bst.getRoot().copy());
    System.out.print("\tInorder traversal:\t");
    copy.inOrderTraverse();
    System.out.print("\tPreorder traversal:\t");
    copy.preOrderTraverse();
    System.out.print("\tPostorder traversal:\t");
    copy.postOrderTraverse();
    System.out.println("\tHeight of tree is: " +
    bst.getRoot().getHeight());
    System.out.println("\tNumber of nodes is: " +
    bst.getRoot().getNumberOfNodes());

    System.out.println("Testing contains:");
    System.out.println("\tcontains('H')?\t" + bst.contains('H'));
    System.out.println("\tcontains('A')?\t" + bst.contains('A'));
    System.out.println("\tcontains('X')?\t" + bst.contains('X'));

    System.out.println("Testing getItem:");
    System.out.println("\tgetItem('G'):\t" + bst.getItem('G'));
    System.out.println("\tgetItem('X'):\t" + bst.getItem('X'));

    System.out.println("\tcontains('H')?\t" + bst.contains('H'));

    System.out.println("After removing 'G' (" + bst.remove('G') + ") :");
    System.out.println("\tcontains('G')?\t" + bst.contains('G'));
    System.out.print("\tInorder traversal:\t");
    bst.inOrderTraverse();
    System.out.print("\tPreorder traversal:\t");
    bst.preOrderTraverse();
    System.out.print("\tPostorder traversal:\t");
    bst.postOrderTraverse();

    System.out.println("After removing 'M' (" + bst.remove('M') + ") :");
    System.out.println("After removing 'E' (" + bst.remove('E') + ") :");
    System.out.println("After removing 'N' (" + bst.remove('N') + ") :");

    System.out.print("\tInorder traversal:\t");
    bst.inOrderTraverse();
    System.out.print("\tPreorder traversal:\t");
    bst.preOrderTraverse();
    System.out.print("\tPostorder traversal:\t");
    bst.postOrderTraverse();

    System.out.println("\tHeight of tree is: " +
    bst.getRoot().getHeight());
    System.out.println("\tNumber of nodes is: " +
    bst.getRoot().getNumberOfNodes());

    System.out.println("Copy of Original BST:");
    System.out.print("\tInorder traversal:\t");
    copy.inOrderTraverse();
    System.out.print("\tPreorder traversal:\t");
    copy.preOrderTraverse();
    System.out.print("\tPostorder traversal:\t");
    copy.postOrderTraverse();
    System.out.println("\tHeight of tree is: " +
    copy.getRoot().getHeight());
    System.out.println("\tNumber of nodes is: " +
    copy.getRoot().getNumberOfNodes());
  }
}
