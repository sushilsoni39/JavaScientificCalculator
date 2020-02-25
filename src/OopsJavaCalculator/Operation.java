package OopsJavaCalculator;

import javax.lang.model.type.TypeKind;

public interface Operation {
    public double sin(Token tk);
    public double cos(Token tk);
    public double tan(Token tk);
    public double add(Token tk1,Token tk2);
}
