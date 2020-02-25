package OopsJavaCalculator;

import java.util.ArrayList;

public class ExpressionValidation {
    public ExpressionValidation(ArrayList<Token> tokenList)
    {
        if(tokenList.size()==1 && !( tokenList.get(0).getType() ==Operand.type ))
            throw new CustomException("only operator is not a valid expression");
        for (int i=1;i<tokenList.size()-1;i++)
        {
            if(tokenList.get(i).getType()==UnaryOperator.type && tokenList.get(i+1).getType()==BinaryOperator.type )
                throw new CustomException(tokenList.get(i).getName()+tokenList.get(i+1).getName()+" invalid Operator arrangement in expression");

            if(tokenList.get(tokenList.size()-1).getName().matches(UnaryOperator.regex) || tokenList.get(tokenList.size()-1).getName().matches(BinaryOperator.regex) )
                throw new CustomException("Expression cannot have operator at the end");
            if(i-1==0 && tokenList.get(i-1).getType()==BinaryOperator.type && tokenList.get(i).getType()==BinaryOperator.type)
                throw new CustomException(tokenList.get(i-1).getName()+tokenList.get(i).getName()+" is not a valid operator");
            if(tokenList.get(i-1).getType()==BinaryOperator.type && tokenList.get(i).getType()==BinaryOperator.type && tokenList.get(i+1).getType()==BinaryOperator.type)
                throw new CustomException(tokenList.get(i-1).getName()+tokenList.get(i).getName()+tokenList.get(i+1).getName()+" is not a valid operator");
            }
    }
}
