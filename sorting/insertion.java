package sorting;

import java.util.Scanner;

class Solution {
    public int[] insertionSort(int[] nums) {
        int n = nums.length; 
        for (int i = 1; i < n; i++) {
            int key = nums[i]; // Current element as key 
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }

            nums[j + 1] = key; // Insert key at correct position
        }

        return nums;
    }
}

public class insertion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println("Before Using Insertion Sort: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        Solution solution = new Solution();
        nums = solution.insertionSort(nums);
        System.out.println("After Using Insertion Sort: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        sc.close();
    }
}

