import java.util.*;
public class InfixToPostfix {

    static int prec(char c) {
        if (c == '^')
            return 3;
        else if (c == '/' || c == '*')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }
    static boolean isRightAssociative(char c) {
        return c == '^';
    }
    static String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                res.append(c);
            } else if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    res.append(st.pop());
                }
                st.pop();
            } else {
                while (!st.isEmpty() && st.peek() != '(' &&
                        (prec(st.peek()) > prec(c) ||
                         (prec(st.peek()) == prec(c) && !isRightAssociative(c)))) {
                    res.append(st.pop());
                }
                st.push(c);
            }
        }
        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        return res.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter infix expression: ");
        String exp = sc.nextLine();
        String result = infixToPostfix(exp);
        System.out.println("Postfix expression: " + result);
        sc.close();
    }
}