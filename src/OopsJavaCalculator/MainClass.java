package OopsJavaCalculator;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

public String expression;
    public static void main(String[] args) {
        System.out.println("Enter the no. of times u want to run the loop");

        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.println("Enter an expression");
            Scanner exp=new  Scanner(System.in);
            String expression = exp.nextLine();
            expression = expression.replaceAll("\\s", "");
            expression=HandlingSign.HandlingSigned(expression);
            ParenthesisChecker pc = new ParenthesisChecker(expression);
            Tokenizer obj = new Tokenizer(expression);
            ArrayList<Token> tokenList = obj.getTokenList();
            ExpressionValidation ex = new ExpressionValidation(tokenList);
            for (Token each : tokenList) {
                System.out.print(each.getName() + " ");
                //System.out.print(each.getType()+" ");
                //System.out.print(each.getTokenValue());
                //System.out.println("");
                //System.out.println(each.getPrecedenceGroup());

            }
            System.out.println("");

            // System.out.println(EvaluateInfixExpression.evaluate(tokenList));


            InfixToPostfix postfix = new InfixToPostfix(tokenList);
            ArrayList<Token> postfixList = postfix.getPostfixList();
            for (Token each : postfixList) {
                System.out.print(each.getName() + " ");
            }
            System.out.println(" ");
            System.out.println(PostfixEvaluation.evaluatePostfix(postfixList));


        }
    }
}
