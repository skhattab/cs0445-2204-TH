public class Recursion {

  public static void main(String[] args){
    countDown(10);
    display(new Integer[]{1, 6, 7, 10});
  }

  private static void countDown(int n){
    System.out.println(n);
    if(n > 1 ){
      countDown(n-1);
    }
  }

  public static <T> void display(T[] array){
    displayHelper(array, 0);
  }

  private static <T> void displayHelper(T[] array, int start){
    if(array.length != 0){
      System.out.println(array[start]);
      if(start != array.length-1){
        displayHelper(array, start+1);
      }
    }
  }
}
