package OopsJavaCalculator.UnsedClasses;

import OopsJavaCalculator.BinaryOperator;
import OopsJavaCalculator.Token;
import OopsJavaCalculator.UnaryOperator;

import java.util.ArrayList;
import java.util.Stack;

public class EvaluateInfixExpression {


        public static double evaluate ( ArrayList<Token> tokenList)
        {
            Stack<Double> values = new Stack<Double>();
            Stack<String> ops = new Stack<String>();

            for (int i = 0; i < tokenList.size(); i++) {
                if ("operand".equals(tokenList.get(i).getType()))
                {
                    values.push(tokenList.get(i).getTokenValue());
                }

                // Current token is an opening brace, push it to 'ops'
                else if ("(".equals(tokenList.get(i).getName()))
                    ops.push(tokenList.get(i).getName());

                else if (")".equals(tokenList.get(i).getName())) {
                    while ( !"(".equals(ops.peek())) {
                        if(ops.peek().matches(BinaryOperator.regex))
                        values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                        if(ops.peek().matches(UnaryOperator.regex))
                            values.push(applyOp(ops.pop(),values.pop(),0.0));
                    }
                    ops.pop();
                }

                // Current token is an operator.
                else if (UnaryOperator.regex.equals(tokenList.get(i).getName()) || BinaryOperator.regex.equals(tokenList.get(i).getName())) {
                    // While top of 'ops' has same or greater precedence to current
                    // token, which is an operator. Apply operator on top of 'ops'
                    // to top two elements in values stack
                    while (!ops.empty() && hasPrecedence(tokenList.get(i).getName())<= hasPrecedence(ops.peek()))
                        {
                            if(ops.peek().matches(BinaryOperator.regex))
                                values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                            if(ops.peek().matches(UnaryOperator.regex))
                                values.push(applyOp(ops.pop(),values.pop(),0.0));
                        }

                    // Push current token to 'ops'.
                    ops.push(tokenList.get(i).getName());
                }
            }

            // Entire expression has been parsed at this point, apply remaining
            // ops to remaining values
            while (!ops.empty())
            {
                if(ops.peek().matches(BinaryOperator.regex))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                if(ops.peek().matches(UnaryOperator.regex))
                    values.push(applyOp(ops.pop(),values.pop(),0.0));
            }

            // Top of 'values' contains result, return it
            return values.pop();
        }

        // Returns true if 'op2' has higher or same precedence as 'op1',
        // otherwise returns false.
        public static int hasPrecedence ( String op1)
        {
            if ("+".equals(op1) || "-".equals(op1)) return 1;
            else if ("*".equals(op1) || "/".equals(op1)) return 2;
            else if("^".equals(op1)) return 3;
            else if("sin|cos|tan".matches(op1)) return 4;
            else return -1;
        }

        // A utility method to apply an operator 'op' on operands 'a'
        // and 'b'. Return the result.
        public static double applyOp ( String op, double b, double a)
        {
            switch (op) {
                case "sin":
                    return Math.sin(b);
                case "+":
                    return a + b;
                case "-":
                    return a - b;
                case "*":
                    return a * b;
                case "/":
                    if (b == 0)
                        throw new
                                UnsupportedOperationException("Cannot divide by zero");
                    return a / b;
            }
            return 0;
        }
    }

