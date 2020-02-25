package OopsJavaCalculator;

public class HandlingSign {

    public static String HandlingSigned(String expression)
    {   String newExpression="";
        for (int i=0;i<expression.length();i++)
        {
            if (i==0 && expression.charAt(i)=='-')
            {
                newExpression=newExpression+"0"+expression.charAt(i);
            }
            else if(expression.charAt(i)=='-' && ((expression.charAt(i-1)=='+' || expression.charAt(i-1)=='-') && expression.charAt(i-1)!=')'))
            {
                newExpression =newExpression+0+expression.charAt(i);
            }
            else
            {
                newExpression=newExpression+expression.charAt(i);
            }
        }
        System.out.println(newExpression);
        return newExpression;

    }

}
