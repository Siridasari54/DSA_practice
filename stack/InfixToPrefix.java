package stack;
import java.util.*;
public class InfixToPrefix {

    static int precedence(char c) {
        if (c == '^') return 3;
        else if (c == '*' || c == '/') return 2;
        else if (c == '+' || c == '-') return 1;
        else return -1;
    }

    static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }

    static boolean isRightAssociative(char c) {
        return c == '^';
    }

    static String infixToPrefix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
            else if (c == ')') {
                st.push(c);
            }
            else if (c == '(') {
                while (!st.isEmpty() && st.peek() != ')') {
                    result.append(st.pop());
                }
                if (!st.isEmpty()) st.pop();
            }
            else if (isOperator(c)) {
                while (!st.isEmpty() && isOperator(st.peek()) &&
                        (precedence(st.peek()) > precedence(c) ||
                         (precedence(st.peek()) == precedence(c) && isRightAssociative(c)))) {
                    result.append(st.pop());
                }
                st.push(c);
            }
        }

        // pop remaining operators
        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        // reverse to get prefix
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter infix expression: ");
        String exp = sc.nextLine();

        System.out.println("Prefix: " + infixToPrefix(exp));

        sc.close();
    }
}