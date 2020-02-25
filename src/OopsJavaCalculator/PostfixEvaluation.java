package OopsJavaCalculator;

import java.util.ArrayList;
import java.util.Stack;

public class PostfixEvaluation {
    static double evaluatePostfix(ArrayList<Token> tokenList)
    {
        //create a stack
        Stack<Double> stack=new Stack<>();

        // Scan all characters one by one
        for(int i=0;i<tokenList.size();i++)
        {
            String c=tokenList.get(i).getName();

            // If the scanned character is an operand (number here),
            // push it to the stack.
            if(c.matches(Operand.regex))
                stack.push(tokenList.get(i).getTokenValue());

                //  If the scanned character is an operator, pop two
                // elements from stack apply the operator
            else
            { double val1;
            double val2;


                switch(c)
                {
                    case "+":
                        val1 = stack.pop();
                         val2 = stack.pop();
                        stack.push(val2+val1);
                        break;

                    case "-":
                        val1 = stack.pop();
                        val2 = stack.pop();
                        stack.push(val2- val1);
                        break;

                    case "/":
                        val1 = stack.pop();
                        val2 = stack.pop();
                        stack.push(val2/val1);
                        break;

                    case "*":
                        val1 = stack.pop();
                        val2 = stack.pop();
                        stack.push(val2*val1);
                        break;

                    case "sin":
                        val1=stack.pop()*180/3.1414;
                        stack.push(Math.sin(val1));
                        break;

                    case "cos":
                        val1=stack.pop()*180/3.1414;
                        stack.push(Math.cos(val1));
                        break;

                    case "tan":
                        val1=stack.pop()*180*7/22;
                        stack.push(Math.tan(val1));
                        break;

                    case"^":
                        val1=stack.pop();
                        val2=stack.pop();
                        stack.push(Math.pow(val2,val1));}


                }
            }

        return stack.pop();
    }
}
