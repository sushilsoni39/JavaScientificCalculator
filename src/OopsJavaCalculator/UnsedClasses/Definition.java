package OopsJavaCalculator.UnsedClasses;

import OopsJavaCalculator.token.Token;
import OopsJavaCalculator.validationAndException.CustomException;

public class Definition implements Operation {


    @Override
    public double sin(Token tk) throws CustomException {

        return Math.sin(tk.getTokenValue());
    }

    @Override
    public double cos(Token tk) throws CustomException {
        return Math.cos(tk.getTokenValue());
    }

    @Override
    public double tan(Token tk) throws CustomException {
        return Math.tan(tk.getTokenValue());
    }

    @Override
    public double add(Token tk1, Token tk2) throws CustomException {
        return tk1.getTokenValue() + tk2.getTokenValue();
    }
}
