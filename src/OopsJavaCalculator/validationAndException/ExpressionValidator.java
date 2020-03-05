package OopsJavaCalculator.validationAndException;

import OopsJavaCalculator.token.BinaryOperator;
import OopsJavaCalculator.token.Operand;
import OopsJavaCalculator.token.Token;
import OopsJavaCalculator.token.UnaryOperator;

import java.util.ArrayList;

public class ExpressionValidator {
    public static int Validation(ArrayList<Token> tokenList) throws CustomException {

        //for checking if the expression is only operator like sin,+,-,cos,etc
        if (tokenList.size() == 1 && !( tokenList.get(0).getType() == Operand.type ))
            throw new CustomException("only operator is not a valid expression");

        //for checking if +,/,* is at the beginning
        if (tokenList.get(0).getType().equals(BinaryOperator.type) && !"-".equals(tokenList.get(0).getName()))
            throw new CustomException(tokenList.get(0).getName() + " at the beginning is not a valid expression");

        for (int i = 1; i < tokenList.size() - 1; i++) {


            //for checking if ++,**,//,+*,+/.-+,-* are together
            if (( "*".equals(tokenList.get(i).getName()) || "/".equals(tokenList.get(i).getName()) || "+".equals(tokenList.get(i).getName()) || "-".equals(tokenList.get(i).getName()) ) && ( "*".equals(tokenList.get(i + 1).getName()) || "/".equals(tokenList.get(i + 1).getName()) || "+".equals(tokenList.get(i + 1).getName()) ))
                throw new CustomException("except '-' two binary operator cannot be together");

            //for checking cases like tan+4,sin+9
            if (tokenList.get(i).getType() == UnaryOperator.type && tokenList.get(i + 1).getType() == BinaryOperator.type)
                throw new CustomException(tokenList.get(i).getName() + tokenList.get(i + 1).getName() + " invalid Operator arrangement in expression");

            //for checking if there is operator at the end like sin2+, 10+, 10sin
            if (tokenList.get(tokenList.size() - 1).getName().matches(UnaryOperator.regex) || tokenList.get(tokenList.size() - 1).getName().matches(BinaryOperator.regex))
                throw new CustomException("Expression cannot have operator at the end");

            //if --,++,+- like cases at the beginning
            if (i - 1 == 0 && tokenList.get(i - 1).getType().equals(BinaryOperator.type) && tokenList.get(i).getType().equals(BinaryOperator.type))
                throw new CustomException(tokenList.get(i - 1).getName() + tokenList.get(i).getName() + " is not a valid operator");

            //cases of three operator together +++,---,*/+, etc.
            if (tokenList.get(i - 1).getType().equals(BinaryOperator.type) && tokenList.get(i).getType().equals(BinaryOperator.type) && tokenList.get(i + 1).getType().equals(BinaryOperator.type))
                throw new CustomException(tokenList.get(i - 1).getName() + tokenList.get(i).getName() + tokenList.get(i + 1).getName() + " is not a valid operator");

            if ("#".equals(tokenList.get(i).getName()) && BinaryOperator.type.equals(tokenList.get(i + 1).getType()))
                throw new CustomException("Three binary operators together is not valid");

            //for 4sin,8.9sin
            if(Operand.type.equals(tokenList.get(i)) && UnaryOperator.type.equals(tokenList.get(i+1)))
                throw new CustomException("not a valid expression");

        }
        return 0;
    }
}
