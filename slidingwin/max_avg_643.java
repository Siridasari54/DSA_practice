package slidingwin;

import java.util.*;

public class max_avg_643{

    public static double findMaxAverage(int[] nums, int k) {
        int s = 0;
        for (int i = 0; i < k; i++) {
            s += nums[i];
        }
        int maxs = s;
        for (int i = k; i < nums.length; i++) {
            s += nums[i];
            s -= nums[i - k];
            maxs = Math.max(maxs, s);
        }
        return (double) maxs / k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size:");
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println("Enter k:");
        int k = sc.nextInt();
        double result = findMaxAverage(nums, k);
        System.out.println("Maximum Average: " + result);
        sc.close();
    }
}

