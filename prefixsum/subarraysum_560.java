package prefixsum;
import java.util.*;
public class subarraysum_560 {
    public static int subarraySum(int[] nums, int k) {
        int presum = 0, c = 0;
        HashMap<Integer, Integer> arr = new HashMap<>();
        arr.put(0, 1); // initial sum 0 appears once

        for (int num : nums) {
            presum += num;
            if (arr.containsKey(presum - k)) {
                c += arr.get(presum - k);
            }
            arr.put(presum, arr.getOrDefault(presum, 0) + 1);
        }
        return c;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter target k: ");
        int k = sc.nextInt();
        int result = subarraySum(nums, k);
        System.out.println("Number of subarrays with sum " + k + " = " + result);

        sc.close();
    }
}

