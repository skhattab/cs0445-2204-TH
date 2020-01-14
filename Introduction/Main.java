public class Main {
  public static void main(String[] args){
    Square<Double> aSquare;
    ColoredSquare<Double> aColoredSquare;

    //aSquare = new Measurable(); //ILLEGAL
    aSquare = new Square<Double>(10.0);
    //Double is type argument
    //Double is an actual type parameter

    aColoredSquare = new ColoredSquare<Double>(20.0, "Blue");

    System.out.println(aSquare);
    System.out.println(aColoredSquare);
    Square<Double>[] shapes; //(1)

    @SuppressWarnings("unchecked")
    //This cast is OK because the array contains only null values
    Square<Double>[] temp = (Square<Double>[]) new Square<?>[3];//(2)
    shapes = temp;


    shapes[0] = aSquare; //(3)
    shapes[1] = aColoredSquare;//(4)
    shapes[2] = new ColoredSquare<Double>(2.0, "Gold"); //(5)

    Measurable result = getMin(shapes);
    System.out.println(result);

  }

  private static <T extends Comparable<T>> T getMin(T[] items){
    T result = null;
    if(items.length > 0){
      result = items[0];
      for(T m: items){
        if(m.compareTo(result) < 0){
          result = m;
        }
      }
    }
    return result;
  }

}
