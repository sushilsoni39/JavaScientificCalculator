package OopsJavaCalculator.evaluation;

import OopsJavaCalculator.token.Operand;
import OopsJavaCalculator.token.Token;
import OopsJavaCalculator.validationAndException.CustomException;

import java.util.ArrayList;
import java.util.Stack;

public class InfixToPostfixConverter {
    private ArrayList<Token> postfixList = new ArrayList<Token>();
    private Stack<Token> operatorStack = new Stack<Token>();

    public InfixToPostfixConverter() {
    }

    public int getPrecedence(String name) {
        switch (name) {
            case "+":
            case "-": {
                return Precedence.ADDITION_SUBTRACTION.ordinal();
            }
            case "*":
            case "/": {
                return Precedence.MULTIPLICATION_DIVISION.ordinal();
            }
            case "^": {
                return Precedence.EXPONENTIAL.ordinal();
            }
            case "#": {
                return Precedence.UNARY_NEGATIVE.ordinal();
            }
            case "sin":
            case "cos":
            case "tan":
            case "log": {
                return Precedence.TRIGONOMETRY.ordinal();
            }
            default:
                return -1;
        }

    }


    public ArrayList<Token> getPostfixList(ArrayList<Token> tokenList) throws CustomException {

        for (int i = 0; i < tokenList.size(); i++) {
            if (tokenList.get(i).getName().matches(Operand.regex))
                postfixList.add(tokenList.get(i));

            else if ("(".equals(tokenList.get(i).getName()))
                operatorStack.push(tokenList.get(i));

            else if (")".equals(tokenList.get(i).getName())) {
                while (!operatorStack.isEmpty() && !"(".equals(operatorStack.peek().getName()))
                    postfixList.add(operatorStack.pop());

                if (!operatorStack.isEmpty() && !"(".equals(operatorStack.peek().getName()))
                    throw new CustomException("Expression is not valid");

                else operatorStack.pop();
            } else {
                while (!operatorStack.isEmpty() && ( getPrecedence(tokenList.get(i).getName()) <= getPrecedence(operatorStack.peek().getName()) )) {
                    if ("(".equals(operatorStack.peek().getName()))
                        throw new CustomException("Expression is invalid");
                    postfixList.add(operatorStack.pop());
                }
                operatorStack.push(tokenList.get(i));
            }
        }


        while (!operatorStack.isEmpty()) {
            if ("(".equals(operatorStack.peek().getName()))
                throw new CustomException(" Invalid Expression");
            postfixList.add(operatorStack.pop());

        }
        return postfixList;
    }
}

