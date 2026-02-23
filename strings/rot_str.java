import java.util.Scanner;

public class rot_str {

    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        return (s + s).contains(goal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string s: ");
        String s = sc.nextLine();
        System.out.print("Enter string goal: ");
        String goal = sc.nextLine();
        boolean result = rotateString(s, goal);
        System.out.println("Output: " + result);
        sc.close();
    }
}