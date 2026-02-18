package slidingwin;
import java.util.*;

class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];
        int left = 0, right = 0;
        int maxCount = 0;
        int maxLength = 0;

        while (right < s.length()) {

            freq[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, freq[s.charAt(right) - 'A']);

            while ((right - left + 1) - maxCount > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}

public class long_repeat_424{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        Solution sol = new Solution();
        System.out.println(sol.characterReplacement(s, k));
        sc.close();
    }
}

