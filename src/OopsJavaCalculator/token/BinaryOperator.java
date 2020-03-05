package OopsJavaCalculator.token;

import OopsJavaCalculator.token.Operator;

public interface BinaryOperator extends Operator {
    public String regex = "\\*|\\/|\\^|\\+|\\-|\\#";
    public String type = "binaryOperator";
}
