import java.util.Arrays;
public class Sorting{
  public static void main(String[] args){
    new Sorting();
  }

  public Sorting(){
    Integer[] array = new Integer[]{20, 10, 0, 30, 15, 1, 2, 90, 9, 35, -1, 3};
    //selectionSort(array);
    //insertionSort(array);
    //ShellSort(array);
    //recursiveInsertionSort(array, 0, array.length-1);
    //recursiveSelectionSort(array, 0, array.length-1);
    //recursiveSelectionSort2(array, 0, array.length-1);
    //System.out.println(Arrays.toString(array));

    Node<Integer> firstNode = createChain(array);
    firstNode = chainInsertionSort(firstNode);
    printChain(firstNode);
  }
  /* ==============*/
  /* Selection Sort*/
  /* ==============*/

  public <T extends Comparable<? super T>>
  void selectionSort(T[] array){
    for(int i=0; i<array.length; i++){
      int indexOfSmallest =
      getIndexOfSmallest(array, i, array.length-1);
      swap(array, indexOfSmallest, i);
    }
  }

  private <T extends Comparable<? super T>>
  int getIndexOfSmallest(T[] array, int first, int last){
    T smallest = array[first];
    int indexOfSmallest = first;
    for(int i=first+1; i<=last; i++){
      if(array[i].compareTo(smallest) < 0){
        smallest = array[i];
        indexOfSmallest = i;
      }
    }
    return indexOfSmallest;
  }

  private <T extends Comparable<? super T>>
  int getIndexOfLargest(T[] array, int first, int last){
    T largest = array[first];
    int indexOfLargest = first;
    for(int i=first+1; i<=last; i++){
      if(array[i].compareTo(largest) > 0){
        largest = array[i];
        indexOfLargest = i;
      }
    }
    return indexOfLargest;
  }

  private <T> void swap(T[] array, int first, int second){
    T temp = array[first];
    array[first] = array[second];
    array[second] = temp;
  }

  private <T extends Comparable<? super T>>
  void recursiveSelectionSort(T[] array, int first, int last){
    if(last - first + 1 > 1){
      int smallestIndex = getIndexOfSmallest(array, first, last);
      swap(array, first, smallestIndex);
      recursiveSelectionSort(array, first+1, last);
    }
  }

  private <T extends Comparable<? super T>>
  void recursiveSelectionSort2(T[] array, int first, int last){
    if(last - first + 1 > 1){
      int largestIndex = getIndexOfLargest(array, first, last);
      swap(array, last, largestIndex);
      recursiveSelectionSort(array, first, last-1);
    }
  }

  /* ==============*/
  /* Insertion Sort*/
  /* ==============*/


  public <T extends Comparable<? super T>> void insertionSort(T[] array){
    insertionSort(array, 0, array.length-1);
  }

  private <T extends Comparable<? super T>>
  void insertionSort(T[] array, int first, int last){
    for(int unsorted=first+1; unsorted<=last; unsorted++){
      insertInOrder(array, first, unsorted-1, array[unsorted]);
    }
  }

  private <T extends Comparable<? super T>>
  void insertInOrder(T[] array, int begin, int end, T item){
    int index = end;
    while(index >= begin && array[index].compareTo(item)>0){
      array[index+1] = array[index];
      index--;
    }
    array[index+1] = item;
  }

  private <T extends Comparable<? super T>>
  void recursiveInsertionSort(T[] array, int first, int last){
    if(last-first > 0){
      recursiveInsertionSort(array, first, last-1);
      recursiveInsertInOrder(array, first, last-1, array[last]);
    }
  }

  private <T extends Comparable<? super T>>
  void recursiveInsertInOrder(T[] array, int begin, int end, T item){
    if(item.compareTo(array[end]) >= 0){
      array[end+1] = item;
    } else if(begin == end){
      array[end+1] = array[end];
      array[end] = item;
    } else {
      array[end+1] = array[end];
      recursiveInsertInOrder(array, begin, end-1, item);
    }
  }

  /* ==============*/
  /* Shell Sort*/
  /* ==============*/


  public <T extends Comparable<? super T>>
  void ShellSort(T[] array){
    ShellSort(array, 0, array.length-1);
  }

  private <T extends Comparable<? super T>>
  void ShellSort(T[] array, int first, int last){
    int n = last - first + 1;
    for(int space=n/2; space>0; space=space/2){
      if(space%2 == 0){
        space++;
      }
      for(int i=0; i<space; i++){
        incrementalInsertionSort(array, first+i, last, space);
      }
    }
  }

  private <T extends Comparable<? super T>>
  void incrementalInsertInOrder(T[] array, int begin, int end,
  T item, int space){
    int index = end;
    while(index >= begin && array[index].compareTo(item)>0){
      array[index+space] = array[index];
      index = index - space;
    }
    array[index+space] = item;
  }

  private <T extends Comparable<? super T>>
  void incrementalInsertionSort(T[] array, int first, int last, int space){
    for(int unsorted=first+space; unsorted<=last; unsorted+=space){
      incrementalInsertInOrder(array, first, unsorted-space, array[unsorted], space);
    }
  }

  private <T extends Comparable<? super T>>
  Node<T> chainInsertionSort(Node<T> firstNode){
    Node<T> unsorted = firstNode.next;
    firstNode.next = null;
    Node<T> current = unsorted;
    while(current != null){
      Node<T> next = current.next;
      firstNode = chainInsertInOrder(firstNode, current);
      current = next;
    }
    return firstNode;
  }

  private <T extends Comparable<? super T>>
  Node<T> chainInsertInOrder(Node<T> sorted, Node<T> item){
    if(sorted.data.compareTo(item.data) >= 0){
      item.next = sorted;
      sorted = item;
    } else {
      Node<T> current = sorted;
      while(current != null &&
      current.next != null &&
      current.next.data.compareTo(item.data) < 0){
        current = current.next;
      }
      item.next = current.next;
      current.next = item;
    }
    return sorted;
  }

  private <T> void printChain(Node<T> firstNode){
    Node<T> current = firstNode;
    while(current != null){
      System.out.print(current.data + " ");
      current = current.next;
    }
    System.out.println();
  }

  private <T> Node<T> createChain(T[] array){
    Node<T> firstNode = new Node<>(array[array.length-1]);
    for(int i=array.length-2; i>=0; i--){
      firstNode = new Node<T>(array[i], firstNode);
    }
    return firstNode;
  }


  private class Node<T> {
    T data;
    Node<T> next;
    private Node(T data){
      this(data, null);
    }
    private Node(T data, Node<T> next){
      this.data = data;
      this.next = next;
    }
  }


}
