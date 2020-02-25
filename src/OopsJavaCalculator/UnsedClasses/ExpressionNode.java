package OopsJavaCalculator.UnsedClasses;

public class ExpressionNode {
    private String value;
    ExpressionNode left,right;
    ExpressionNode(String val)
    {
        this.value=val;
        left=right=null;
    }
}
