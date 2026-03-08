import java.util.*;
public class code_iter_recur {
    public static int bs(int arr[],int low,int high,int k){
        while(low<=high){
            int mid=low+((high-low)/2);
            if(arr[mid]==k)
                return mid;
            else if(arr[mid]>k){
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int target=sc.nextInt();
        Arrays.sort(arr);
        int res=bs(arr,0,n-1,target);
        System.out.println(res);
        sc.close();
    }
}
// recursive fun
// public static int bs(int arr[], int low, int high, int k){

//     if(low > high)
//         return -1;

//     int mid = low + (high - low) / 2;

//     if(arr[mid] == k)
//         return mid;

//     else if(arr[mid] > k)
//         return bs(arr, low, mid - 1, k);

//     else
//         return bs(arr, mid + 1, high, k);
// }