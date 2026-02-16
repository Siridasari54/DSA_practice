package prefixsum;

import java.util.*;

class Solution {
    public boolean continousubarr_523(int[] nums, int k) { // corrected method name
        HashMap<Integer,Integer> remindex = new HashMap<>();
        remindex.put(0,-1); // edhi am cheputhundhi ante epudu manam index -1 dheggara 0 ane oka value pettukunam (just assumption for every code anamata)
        int s = 0;
        for(int i = 0; i < nums.length; i++){
            s += nums[i]; // tot sum chesav prev index left side sum tho kalipi
    
            int rem = s % k;
            if(remindex.containsKey(rem)){ // dhenntlo manam aa rem value already vachindha ledha chustham oka vel vunte lopaliki
                if(i - remindex.get(rem) > 1){ // ikkada i-aa rem index value in thesukuntam yendukante ques lo eles anevi >= 2 annadu
                    return true;
                }       
            }
            else{
                remindex.put(rem, i); // edhi yenti ante okavela rem exist avakapothe rem and index ni manam store chesukuntam
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter elements:");
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter value of k: ");
        int k = sc.nextInt();

        boolean result = sol.continousubarr_523(nums, k); // fixed call
        System.out.println("Subarray with sum multiple of k exists? " + result);

        // example in ques
        // i = 0
        // sum = 23 → rem = 5
        // store → 5 → 0

        // i = 1
        // sum = 25 → rem = 1
        // store → 1 → 1

        // i = 2
        // sum = 29 → rem = 5

        // 5 already exists at index 0

        // length = 2 - 0 = 2
        // 2 > 1 

        // return true

        sc.close();
    }
}
