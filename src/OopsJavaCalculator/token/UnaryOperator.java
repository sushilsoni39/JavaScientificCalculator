package OopsJavaCalculator.token;

import OopsJavaCalculator.token.Operator;

public interface UnaryOperator extends Operator {

    public String regex = "sin|cos|tan|log";
    public String type = "unaryOperator";
}
