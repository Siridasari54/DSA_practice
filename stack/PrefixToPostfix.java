package stack;
import java.util.*;
public class PrefixToPostfix {
    static boolean isOperator(char x) {
        return (x == '+' || x == '-' || x == '*' ||
                x == '/' || x == '^' || x == '%');
    }
    static String convert(String str) {
        Stack<String> stack = new Stack<>();
        int l = str.length();
        for (int i = l - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (isOperator(c)) {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String temp = op1 + op2 + c;
                stack.push(temp);
            } else {
                stack.push(c + "");
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter prefix expression: ");
        String exp = sc.nextLine();
        System.out.println("Postfix : " + convert(exp));
        sc.close();
    }
}