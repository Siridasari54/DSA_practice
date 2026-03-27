package stack;
import java.util.*;
public class PostfixToInfix {
    static boolean isOperand(char x) {
        return (x >= 'a' && x <= 'z') ||
               (x >= 'A' && x <= 'Z');
    }
    static String getInfix(String exp) {
        Stack<String> s = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            // If operand → push
            if (isOperand(c)) {
                s.push(c + "");
            }
            // If operator
            else {
                String op1 = s.pop();
                String op2 = s.pop();
                String temp = "(" + op2 + c + op1 + ")";
                s.push(temp);
            }
        }

        return s.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter postfix expression: ");
        String exp = sc.nextLine();
        System.out.println("Infix: " + getInfix(exp));

        sc.close();
    }
}