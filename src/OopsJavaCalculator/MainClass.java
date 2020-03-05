package OopsJavaCalculator;

import OopsJavaCalculator.evaluation.InfixToPostfixConverter;
import OopsJavaCalculator.evaluation.PostfixEvaluator;
import OopsJavaCalculator.token.Token;
import OopsJavaCalculator.token.Tokenizer;
import OopsJavaCalculator.validationAndException.CustomException;
import OopsJavaCalculator.validationAndException.ExpressionValidator;
import OopsJavaCalculator.validationAndException.NegativeSignHandler;
import OopsJavaCalculator.validationAndException.ParenthesisChecker;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) throws CustomException {
        System.out.println("Enter the no. of times u want to run the loop");

        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.println("Enter an expression");
            Scanner exp = new Scanner(System.in);
            String expression = exp.nextLine();
            if ("".equals(expression)) {
                System.out.println("expression cannot be null");
                return;
            }


            expression = expression.replaceAll("\\s", "");
            expression = NegativeSignHandler.handleNegation(expression);
            ParenthesisChecker.checkParenthesis(expression);
            Tokenizer obj = new Tokenizer();
            ArrayList<Token> tokenList = obj.getTokenList(expression);
            ExpressionValidator.Validation(tokenList);
            for (Token each : tokenList) {
                System.out.print(each.getName() + " ");
            }
            System.out.println("");
            InfixToPostfixConverter postfix = new InfixToPostfixConverter();
            ArrayList<Token> postfixList = postfix.getPostfixList(tokenList);
            for (Token each : postfixList) {
                System.out.print(each.getName() + " ");
            }
            System.out.println(" ");
            System.out.println(PostfixEvaluator.evaluatePostfix(postfixList));
        }
    }
}
