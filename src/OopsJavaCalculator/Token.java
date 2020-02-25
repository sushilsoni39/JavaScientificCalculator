package OopsJavaCalculator;

import java.util.ArrayList;

public class Token implements Operator,Operand,Parenthesis{
    private String name;
    private String type;




    public Token(String name)
    {
        //this.value=value;
        this.name=name;
        if(name.matches(Operand.regex)) this.type=Operand.type;
        if(name.matches(BinaryOperator.regex)) this.type=BinaryOperator.type;
        if(name.matches(UnaryOperator.regex)) this.type=UnaryOperator.type;
        if(name.matches(Parenthesis.regex)) this.type=Parenthesis.type;
        if(type==null) throw new CustomException(name+" is not a valid token");



    }
    public String getName()
    {
        return this.name;
    }
    public String getType()
    {
        return this.type;
    }
    public double getTokenValue()
    {
        if (this.type=="operand")
        return Double.parseDouble(this.name);
        return 0;
    }

}
