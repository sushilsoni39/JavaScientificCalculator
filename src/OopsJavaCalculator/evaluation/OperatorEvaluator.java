package OopsJavaCalculator.evaluation;

import OopsJavaCalculator.token.Token;
import OopsJavaCalculator.validationAndException.CustomException;

import java.util.Stack;

public class OperatorEvaluator {
    private String operator;

    public static double eval(String operator, Stack<Double> stack) {
        double val1;
        double val2;
        double result;
        switch (operator) {
            case "+":
                val1 = stack.pop();
                val2 = stack.pop();
                result = val1 + val2;
                break;

            case "-":
            case "#":
                val1 = stack.pop();
                val2 = stack.pop();
                result = val2 - val1;
                break;

            case "/":
                val1 = stack.pop();
                val2 = stack.pop();
                if (val1 == 0) {
                    throw new IllegalArgumentException("Divide by zero is not valid");
                } else {
                    result = val2 / val1;
                }
                break;

            case "*":
                val1 = stack.pop();
                val2 = stack.pop();
                result = val2 * val1;
                break;


            case "sin":
                val1 = stack.pop();
                result = Math.sin(val1);
                break;

            case "cos":
                val1 = stack.pop();
                result = Math.cos(val1);
                break;

            case "tan":
                val1 = stack.pop();
                result = Math.tan(val1);
                break;

            case "log":
                val1 = stack.pop();
                if (val1 <= 0)
                    throw new IllegalArgumentException("value inside log cannot be negative");
                result = Math.log(val1);
                break;

            case "^":
                val1 = stack.pop();
                val2 = stack.pop();
                result = Math.pow(val2, val1);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
        return result;

    }
}

