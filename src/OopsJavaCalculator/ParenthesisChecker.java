package OopsJavaCalculator;

import java.util.Stack;

public class ParenthesisChecker {
    public ParenthesisChecker(String expression) {
        ParenthesisChecker(expression);
    }

    public static void ParenthesisChecker(String expression) {
        Stack<Character> Parenthesis = new Stack<Character>();
        int flag=0;
        for (int i = 0; i < expression.length(); i++) {
            if((expression.charAt(i) == ')' || expression.charAt(i) == '}' || expression.charAt(i) == ']') && Parenthesis.size()==0)
            {

                flag=1;
                break;
            }
            if (expression.charAt(i) == '(' || expression.charAt(i) == '{' || expression.charAt(i) == '[')
                Parenthesis.push(expression.charAt(i));
            if ((expression.charAt(i) == ')' && Parenthesis.peek() == '(') || (expression.charAt(i) == '}' && Parenthesis.peek() == '{') || (expression.charAt(i) == ']' && Parenthesis.peek() == '[')) {
                Parenthesis.pop();
            }
        }
        if (Parenthesis.size() == 0 && flag==0)
            System.out.println("Balanced Parenthesis expression");
        if(Parenthesis.size()>0 || flag==1)
            throw new CustomException("Parenthesis not balanced");
    }
}
