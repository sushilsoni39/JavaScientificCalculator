package OopsJavaCalculator;

import java.util.ArrayList;
import java.util.Stack;

public class InfixToPostfix {
    private ArrayList<Token> postfixList=new ArrayList<Token>();
    private Stack<Token> operatorStack=new Stack<Token>();

    public static int getPrecedence(String name)
    {
        switch (name)
        {
            case "+":
            case "-":
            {
                 return Precedence.Addition_Subtraction.ordinal();
            }
            case "*":
            case"/":
            {
                return Precedence.Multiplication_division.ordinal();
            }
            case "^":
            {
                return Precedence.Exponential.ordinal();
            }
            case "sin":
            case "cos":
            case "tan":
            {
                return Precedence.Trigonometry.ordinal();
            }
            default: return -1;
        }

    }


    public InfixToPostfix(ArrayList<Token> tokenList) {
        for (int i = 0; i < tokenList.size(); i++) {
            if (tokenList.get(i).getName().matches(Operand.regex))
                postfixList.add(tokenList.get(i));

            else if ( "(".equals(tokenList.get(i).getName()))
                operatorStack.push(tokenList.get(i));

            else if ( ")".equals(tokenList.get(i).getName())) {
                while (!operatorStack.isEmpty() &&  !"(".equals(operatorStack.peek().getName()))
                    postfixList.add(operatorStack.pop());

                if (!operatorStack.isEmpty() &&  !"(".equals(operatorStack.peek().getName()))
                    throw new CustomException("Expression is not valid");

                else operatorStack.pop();
            }
            else {
                while (!operatorStack.isEmpty() && (getPrecedence(tokenList.get(i).getName()) <= getPrecedence(operatorStack.peek().getName()))) {
                    if ( "(".equals(operatorStack.peek().getName()))
                        throw new CustomException("Expression is invalid");
                    postfixList.add(operatorStack.pop());
                }
                operatorStack.push(tokenList.get(i));
            }
        }


        while (!operatorStack.isEmpty()) {
            if ( "(".equals(operatorStack.peek().getName()))
                throw new CustomException(" Invalid Expression");
            postfixList.add(operatorStack.pop());

        }
    }


    public ArrayList<Token> getPostfixList() {
        return postfixList;
    }
}

