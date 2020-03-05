package OopsJavaCalculator.evaluation;

import OopsJavaCalculator.token.Operand;
import OopsJavaCalculator.token.Token;
import OopsJavaCalculator.validationAndException.CustomException;

import java.util.ArrayList;
import java.util.Stack;

public class PostfixEvaluator {
    public static double evaluatePostfix(ArrayList<Token> tokenList) throws CustomException {
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < tokenList.size(); i++) {
            String c = tokenList.get(i).getName();
            if (c.matches(Operand.regex))
                stack.push(tokenList.get(i).getTokenValue());

            else {

                stack.push(OperatorEvaluator.eval(c, stack));
            }
        }

        return stack.pop();
    }
}
