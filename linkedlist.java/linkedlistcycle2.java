import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }
}
public class linkedlistcycle2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ListNode head = null;
        ListNode tail = null;

        ListNode[] arr = new ListNode[n];
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            arr[i] = new ListNode(val);

            if (head == null) {
                head = arr[i];
                tail = head;
            } else {
                tail.next = arr[i];
                tail = tail.next;
            }
        }
        int pos = sc.nextInt(); 
        if (pos != -1) {
            tail.next = arr[pos]; 
        }
        Solution sol = new Solution();
        ListNode result = sol.detectCycle(head);
        if (result != null)
            System.out.println("Cycle starts at node value: " + result.val);
        else
            System.out.println("No cycle");

        sc.close();
    }
}
