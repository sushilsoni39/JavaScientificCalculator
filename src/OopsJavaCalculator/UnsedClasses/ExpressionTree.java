//package OopsJavaCalculator.UnsedClasses;
//
//import java.util.Stack;
//
//public class ExpressionTree {
//        boolean isOperator(char c) {
//            if (c == '+' || c == '-'
//                    || c == '*' || c == '/'
//                    || c == '^') {
//                return true;
//            }
//            return false;
//        }
//
//        void inorder(ExpressionNode t) {
//            if (t != null) {
//                inorder(t.left);
//                System.out.print(t.value + " ");
//                inorder(t.right);
//            }
//        }
//
//        ExpressionNode constructTree(char postfix[]) {
//            Stack<ExpressionNode> st = new Stack();
//            ExpressionNode t, t1, t2;
//
//            for (int i = 0; i < postfix.length; i++) {
//
//                if (!isOperator(postfix[i])) {
//                    t = new ExpressionNode(postfix[i]);
//                    st.push(t);
//                } else
//                {
//                    t = new ExpressionNode(postfix[i]);
//
//                    t1 = st.pop();
//                    t2 = st.pop();
//
//                    t.right = t1;
//                    t.left = t2;
//
//                    st.push(t);
//                }
//            }
//            t = st.peek();
//            st.pop();
//            return t;
//        }
//}
