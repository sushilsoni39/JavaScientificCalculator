package OopsJavaCalculator.token;

import OopsJavaCalculator.token.Token;

import java.util.ArrayList;

public class Tokenizer {
    private ArrayList<Token> tokenList = new ArrayList<Token>();

    public Tokenizer() {
    }

    public ArrayList getTokenList(String expression) {
        String token = "";
        String val = "";
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) >= 48 && expression.charAt(i) <= 57 || expression.charAt(i) == 46) {
                token = token + expression.charAt(i);
                if (i + 1 < expression.length() && ( ( expression.charAt(i + 1) >= 48 && expression.charAt(i + 1) <= 57 ) || expression.charAt(i + 1) == 46 )) {
                    continue;
                } else {
                    val = token;
                    token = "";
                }
            } else if (expression.charAt(i) == 40 || expression.charAt(i) == 41 || expression.charAt(i) == 91 || expression.charAt(i) == 93) {
                token = token + expression.charAt(i);
                val = token;
                token = "";
            } else if (expression.charAt(i) >= 97 && expression.charAt(i) <= 122) {
                token = token + expression.charAt(i);
                if (i + 1 < expression.length() && expression.charAt(i + 1) >= 97 && expression.charAt(i + 1) <= 122)
                    continue;
                else {
                    val = token;
                    token = "";
                }
            } else if (expression.charAt(i) >= 42 && expression.charAt(i) <= 47 || expression.charAt(i) == 94 || expression.charAt(i) == 35) {
                token = token + expression.charAt(i);
                val = token;
                token = "";

            } else {
                token = token + expression.charAt(i);
                val = token;

            }
            Token tok = new Token(val);
            tokenList.add(tok);
        }
        return tokenList;
    }
}
