import java.util.Scanner;
public class Calculator{

  public static void main(String[] args){
    new Calculator();
  }

  public Calculator(){
    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter an infix expression:");
    String infix = scan.nextLine();
    scan.close();
    if(!checkBalance(infix)){
      System.out.println("Unbalanced brackets!");
    } else {
      System.out.println(evaluateInfix(infix));
    }
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
    StackInterface<Double> operandStack =
          new LinkedStack<Double>();

    for(int i=0; i<infix.length(); i++){
      char c = infix.charAt(i);
      if(isOperand(c)){
        operandStack.push(Double.valueOf(c + ""));
      } else if(isOperator(c)){
        if(c == ')'){
          char topOperator = operatorStack.pop();
          while(topOperator != '('){
            Double secondOperand = operandStack.pop();
            Double firstOperand = operandStack.pop();
            Double result = compute(topOperator, firstOperand,
                                    secondOperand);
            operandStack.push(result);
            topOperator = operatorStack.pop();
          }
        } else if(c == '(' || c == '^' || operatorStack.isEmpty()){
          operatorStack.push(c);
        } else {
          Character topOperator = operatorStack.top();
          while(!operatorStack.isEmpty() &&
                precedence(topOperator.charValue()) >= precedence(c)){
            popOperator(operatorStack, operandStack);
            topOperator = operatorStack.top();
          }
          operatorStack.push(c);
        }
      }
    }
    while(!operatorStack.isEmpty()){
      popOperator(operatorStack, operandStack);
    }
    return operandStack.top();
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

  private boolean isOperand(char c){
    return c == '0' || c == '1' || c == '2' ||
           c == '3' || c == '4' || c == '5' ||
           c == '6' || c == '7' || c == '8' ||
           c == '9';
  }

  private boolean isOperator(char c){
    return c == '+' || c == '-' || c == '/' ||
           c == '*' || c == '^' || c == '(' ||
           c == ')';
  }

  private Double compute(char operator, Double firstOperand,
                         Double secondOperand){
      Double result = 0.0;
      switch(operator){
        case '+':
          result = firstOperand + secondOperand;
          break;
        case '-':
            result = firstOperand - secondOperand;
            break;
        case '*':
          result = firstOperand * secondOperand;
          break;
        case '/':
          result = firstOperand / secondOperand;
          break;
        case '^':
          result = Math.pow(firstOperand, secondOperand);
          break;
        default:
          System.out.println("Undefined operator!");
      }
      return result;
  }

  private int precedence(char operator){
    int result = -1;
    switch(operator){
      case '(':
        result = 0;
        break;
      case '+':
      case '-':
        result = 1;
        break;
      case '*':
      case '/':
        result = 2;
        break;
      case '^':
        result = 3;
        break;
      default:
        System.out.println("Unknown operator!");
    }
    return result;
  }

  private void popOperator(StackInterface<Character> operatorStack,
                           StackInterface<Double> operandStack){
    char topOperator = operatorStack.pop();
    Double secondOperand = operandStack.pop();
    Double firstOperand = operandStack.pop();
    Double result = compute(topOperator, firstOperand,
                            secondOperand);
    operandStack.push(result);
  }
}
