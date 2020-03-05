package OopsJavaCalculator.UnsedClasses;

import OopsJavaCalculator.token.Token;
import OopsJavaCalculator.validationAndException.CustomException;

public interface Operation {
    public double sin(Token tk) throws CustomException;

    public double cos(Token tk) throws CustomException;

    public double tan(Token tk) throws CustomException;

    public double add(Token tk1, Token tk2) throws CustomException;
}
