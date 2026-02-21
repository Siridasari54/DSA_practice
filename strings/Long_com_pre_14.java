import java.util.*;

public class Long_com_pre_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); 
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }
        if (strs == null || strs.length == 0) {
            System.out.println("");
            return;
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    System.out.println(strs[0].substring(0, i));
                    return;
                }
            }
        }
        System.out.println(strs[0]);
        sc.close();
    }
}
