package OopsJavaCalculator.UnsedClasses;

import OopsJavaCalculator.Operation;
import OopsJavaCalculator.Token;

public class Definition implements Operation {


    @Override
    public double sin(Token tk) {

        return Math.sin(tk.getTokenValue());
    }

    @Override
    public double cos(Token tk) {
        return Math.cos(tk.getTokenValue());
    }

    @Override
    public double tan(Token tk) {
        return Math.tan(tk.getTokenValue());
    }

    @Override
    public double add(Token tk1, Token tk2) {
        return tk1.getTokenValue()+tk2.getTokenValue();
    }
}
