package OopsJavaCalculator.validationAndException;

public class NegativeSignHandler {

    public static String handleNegation(String expression) {
        String newExpression = "";
        for (int i = 0; i < expression.length(); i++) {
            if (i == 0 && expression.charAt(i) == '-') {
                newExpression = newExpression + "0" + "#";
            } else if (expression.charAt(i) == '-' && ( ( expression.charAt(i - 1) == '+' || expression.charAt(i - 1) == '-' || expression.charAt(i - 1) == '*' || expression.charAt(i - 1) == '/' || expression.charAt(i - 1) == '^' ) || expression.charAt(i - 1) == '(' )) {
                newExpression = newExpression + "0" + "#";
            } else {
                newExpression = newExpression + expression.charAt(i);
            }
        }
        System.out.println(newExpression);
        return newExpression;

    }

}
