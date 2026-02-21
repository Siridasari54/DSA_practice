import java.util.*;

public class odd_string_1903 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        String result = "";
        for (int i = num.length() - 1; i >= 0; i--) {
            char ch = num.charAt(i);
            if ((ch - '0') % 2 != 0) {
                result = num.substring(0, i + 1);
                break;
            }
        }
        System.out.println(result);
        sc.close();
    }
}