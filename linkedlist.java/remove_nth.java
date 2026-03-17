import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dum = new ListNode(0, head);
        ListNode s = dum;
        ListNode f = dum;
        for (int i = 0; i <= n; i++) {
            f = f.next;
        }
        while (f != null) {
            s = s.next;
            f = f.next;
        }
        s.next = s.next.next;
        return dum.next;
    }
}
public class remove_nth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt(); 
        if (size == 0) {
            System.out.println("Empty List");
        }
        ListNode head = new ListNode(sc.nextInt());
        ListNode temp = head;
        for (int i = 1; i < size; i++) {
            temp.next = new ListNode(sc.nextInt());
            temp = temp.next;
        }
        int n = sc.nextInt(); 
        Solution sol = new Solution();
        head = sol.removeNthFromEnd(head, n);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

        sc.close();
    }
}


// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         ListNode temp1=head;
//         int c=0;
//         while(temp1!=null){
//             c++;
//             temp1=temp1.next;
//         }
//         if(c==n)
//         return head.next;
//         int res=c-n;
//         ListNode temp=head;
//         while(temp!=null){
//             res--;
//             if(res==0)
//             break;
//             temp=temp.next;
//         }
//         temp.next=temp.next.next;
//         return head;
//     }
// }