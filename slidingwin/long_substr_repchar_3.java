package slidingwin;

import java.util.*;

public class long_substr_repchar_3{

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> seen = new HashSet<>();
        int mlen = 0, left = 0;

        for (int right = 0; right < n; right++) {
            while (seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(s.charAt(right));
            mlen = Math.max(mlen, right - left + 1);
        }

        return mlen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String s = sc.nextLine();

        int result = lengthOfLongestSubstring(s);

        System.out.println("Length of Longest Substring Without Repeating Characters: " + result);

        sc.close();
    }
}

