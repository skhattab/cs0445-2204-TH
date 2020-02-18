public class Recursion {

  public static void main(String[] args){
    countDown(10);
    display(new Integer[]{1, 6, 7, 10});
    int n = 5;
    System.out.println(n + "! = " + factorial(n));
    n = 1;
    System.out.println(n + "! = " + factorial(n));
    int x=2;
    int y=8;
    System.out.println(x+"^"+y+" = " + power(x, y));
    x=2;
    y=9;
    System.out.println(x+"^"+y+" = " + power(x, y));
    n = 10;
    System.out.println("fib("+n+") = " + fib(n));
    displayArray2(new Integer[]{1, 6, 7, 10});
    displayArray2(new Integer[]{1, 13, 6, 7, 10});
    towersOfHanoi(3, 0, 2, 1);
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

  public static int factorial(int n){
    if(n < 0){
      throw new IllegalArgumentException("Cannot compute factorial of a negative number");
    }
    int result = 1;
    if(n > 0){//base case
      result = n * factorial(n-1);
    }
    return result;
  }

  public static int power(int x, int y){
    int result = 1;
    if(y > 0){
      int temp = power(x, y/2);
      result = temp * temp;
      if(y%2 == 1){
        result = x * result;
      }
    }
    return result;
  }

  public static int fib(int n){
    int result = 1;
    if(n == 0){
      result = 0;
    } else if(n > 1){
      result = fib(n-1) + fib(n-2);
    }
    return result;
  }

  public static <T> void displayArray2(T[] array){
    displayArrayHelper2(array, 0, array.length-1);
  }

  private static <T> void displayArrayHelper2(
              T[] array, int start, int end){
      if(start == end){
        System.out.println(array[start]);
      } else {
        int mid = start + (end-start)/2;
        displayArrayHelper2(array, start, mid);
        displayArrayHelper2(array, mid+1, end);
        // displayArrayHelper2(array, mid+1, end);
        // displayArrayHelper2(array, start, mid); //<== DISPLAY IN REVERSE*/
      }
  }

  public static void towersOfHanoi(
            int n, int start, int end, int aux){
      if(n == 1){
        System.out.println(
        "Move one disk from " + start + " to " + end);
      } else{
        towersOfHanoi(n-1, start, aux, end);
        System.out.println(
          "Move one disk from " + start + " to " + end);
        towersOfHanoi(n-1, aux, end, start);
      }
  }
}
