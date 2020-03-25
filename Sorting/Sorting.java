import java.util.Arrays;
public class Sorting{
  public static void main(String[] args){
    new Sorting();
  }

  public Sorting(){
    Integer[] array = new Integer[]{20, 10, 0, 30, 15, 1, 2, 90, 9, 35, -1, 3};
    //selectionSort(array);
    //insertionSort(array);
    ShellSort(array);
    System.out.println(Arrays.toString(array));
  }

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

  private <T> void swap(T[] array, int first, int second){
      T temp = array[first];
      array[first] = array[second];
      array[second] = temp;
  }

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

  public <T extends Comparable<? super T>> void ShellSort(T[] array){
    ShellSort(array, 0, array.length-1);
  }

  private <T extends Comparable<? super T>> void ShellSort(
              T[] array, int first, int last){
    int n = last-first+1;
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
}
