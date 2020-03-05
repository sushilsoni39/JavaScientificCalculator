package OopsJavaCalculator.token;

import OopsJavaCalculator.validationAndException.CustomException;

public class Token {
    private String name;
    private String type;

    public Token(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getType() throws CustomException {
        if (name.matches(Operand.regex)) this.type = Operand.type;
        if (name.matches(BinaryOperator.regex)) this.type = BinaryOperator.type;
        if (name.matches(UnaryOperator.regex)) this.type = UnaryOperator.type;
        if (name.matches(Parenthesis.regex)) this.type = Parenthesis.type;
        if (type == null) {
            throw new CustomException(name + " is not a valid token");
        }
        return this.type;
    }

    public double getTokenValue() throws CustomException {
        if (this.getType() == "operand")
            return Double.parseDouble(this.name);
        return 0;
    }

}
