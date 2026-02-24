import java.util.*;

public class fiandlast_34 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        int[] result = searchRange(nums, target);

        System.out.println(result[0] + " " + result[1]);
        sc.close();
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);

        return result;
    }
    public static int findFirst(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                index = mid;
                high = mid - 1;   // move left
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return index;
    }
    public static int findLast(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                index = mid;
                low = mid + 1;   // move right
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return index;
    }
}