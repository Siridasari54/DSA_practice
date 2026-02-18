package slidingwin;
import java.util.*;

class Solution {
    public int longestOnes(int[] nums, int k) {

        int left = 0;
        int zeros = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] == 0) {
                zeros++;
            }

            while (zeros > k) {//here it is better to use while loop only not if
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}

public class max_con_one_1004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        Solution sol = new Solution();
        System.out.println(sol.longestOnes(nums, k));
        sc.close();
    }
}


