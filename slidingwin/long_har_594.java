package slidingwin;
import java.util.*;
public class long_har_594 {

    public static int findLHS(int[] nums) {
        Arrays.sort(nums);

        int maxlen = 0;
        int j = 0;

        for (int i = 0; i < nums.length; i++) {

            while (nums[i] - nums[j] > 1) {
                j++;
            }

            if (nums[i] - nums[j] == 1) {
                maxlen = Math.max(maxlen, i - j + 1);
            }
        }

        return maxlen;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array size:");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = findLHS(nums);

        System.out.println("Longest Harmonious Subsequence Length: " + result);

        sc.close();
    }
}

