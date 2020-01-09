public class Main {
  public static void main(String[] args){
    Measurable aSquare, aColoredSquare;

    //aSquare = new Measurable(); //ILLEGAL
    aSquare = new Square<Double>(10.0);
    //Double is type argument
    //Double is an actual type parameter

    aColoredSquare = new ColoredSquare<Double>(20.0, "Blue");

    System.out.println(aSquare);
    System.out.println(aColoredSquare);

  }

  private Measurable getMin(Measurable[] shapes){
    Measurable result = null;
    if(shapes.length > 0){
      result = shapes[0];
      for(Measurable m: shapes){
        if(m.compareTo(result) < 0){
          result = m;
        }        
      }
    }
    return result;
  }

}
