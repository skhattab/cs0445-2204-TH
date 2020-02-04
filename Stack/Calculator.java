import java.util.Scanner;
public class Calculator{

  public static void main(String[] args){
    new Calculator();
  }

  public Calculator(){
    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter an infix expression:");
    String infix = scan.nextLine();
    System.out.println(checkBalance(infix));
  }
  private boolean checkBalance(String expression){
    boolean result = true;
    StackInterface<Character> stack =
        new LinkedStack<Character>();
    for(int i = 0; i<expression.length(); i++){
      char c = expression.charAt(i);
      if(isOpening(c)){
        stack.push(c);
      } else if(isClosing(c)){
        if(!stack.isEmpty()){
          char fromStack = stack.pop();
          if(!isMatchingPair(fromStack, c)){
            result = false;
            break;
          }
        } else{
          result = false;
          break;
        }
      }
    }
    if(!stack.isEmpty()){
      result = false;
    }
    return result;
  }

  private double evaluateInfix(String infix){
    StackInterface<Character> operatorStack =
          new LinkedStack<Character>();
    StackInterface<Integer> operandStack =
          new LinkedStack<Integer>();

    for(int i=0; i<infix.length(); i++){
      char c = infix.charAt(i);
    }
    //TO-DO
    return 0;
  }

  private boolean isOpening(char paren){
    return paren == '{' || paren == '[' || paren == '(';
  }

  private boolean isClosing(char paren){
    return paren == '}' || paren == ']' || paren == ')';
  }

  private boolean isMatchingPair(char open, char close){
    return (open == '{' && close == '}') ||
           (open == '[' && close == ']') ||
           (open == '(' && close == ')');
  }
}
