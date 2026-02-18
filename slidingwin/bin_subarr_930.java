package slidingwin;
import java.util.*;

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }//Subarrays with sum ≤ 2,Subarrays with sum ≤ 1
    private int atMost(int[] nums, int k) {

        if (k < 0) return 0;

        int left = 0;
        int sum = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum > k) {
                sum -= nums[left];
                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }
}

public class bin_subarr_930 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int goal = sc.nextInt();
        Solution sol = new Solution();
        System.out.println(sol.numSubarraysWithSum(nums, goal));
        sc.close();
    }
}

