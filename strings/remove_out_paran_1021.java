import java.util.*;
public class remove_out_paran_1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        if (n <= 2) {
            System.out.println("");
        }
        StringBuilder sb = new StringBuilder();
        int open = 1; 
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '(') {
                open++;
                if (open > 1) {
                    sb.append('(');
                }
            } else {
                if (open > 1) {
                    sb.append(')');
                }
                open--;
            }
        }
        System.out.println(sb.toString());
        sc.close();
    }
}
