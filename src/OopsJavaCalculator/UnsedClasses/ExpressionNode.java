package OopsJavaCalculator.UnsedClasses;

public class ExpressionNode {
    public String value;
    ExpressionNode left, right;

    ExpressionNode(String val) {
        this.value = val;
        left = right = null;
    }
}
