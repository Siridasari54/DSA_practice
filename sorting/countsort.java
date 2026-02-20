package sorting;
import java.util.*;

public class countsort {

    public static void countingSort(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] < min)
                min = nums[i];
            if (nums[i] > max)
                max = nums[i];
        }
        int range = max - min + 1;
        int[] count = new int[range];
        for (int i = 0; i < n; i++) {
            count[nums[i] - min]++;
        }
        int k = 0;
        for (int i = 0; i < range; i++) {
            while (count[i]-- > 0) {
                nums[k++] = i + min;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        countingSort(nums);

        System.out.println("Sorted Array:");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}