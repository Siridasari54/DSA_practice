import java.util.*;
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
class Solution {
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenhead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenhead;

        return head;
    }
}

public class Oddevenlist {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of nodes

        if (n == 0) {
            System.out.println("Empty list");
            return;
        }

        ListNode head = new ListNode(sc.nextInt());
        ListNode temp = head;

        for (int i = 1; i < n; i++) {
            temp.next = new ListNode(sc.nextInt());
            temp = temp.next;
        }

        Solution sol = new Solution();
        head = sol.oddEvenList(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}

// //public Node segregateEvenOdd(Node head) {

//         // Edge case: If list is empty or has only one node
//         if (head == null || head.next == null) return head;

//         // Create pointers for the heads and tails of even and odd lists
//         Node evenHead = null, evenTail = null;
//         Node oddHead = null, oddTail = null;

//         // Pointer to traverse the list
//         Node current = head;

//         // Traverse the linked list
//         while (current != null) {

//             // If the current node has even value
//             if (current.data % 2 == 0) {

//                 // First even node
//                 if (evenHead == null) {
//                     evenHead = current;
//                     evenTail = current;
//                 } else {
//                     evenTail.next = current;
//                     evenTail = current;
//                 }

//             } else {
//                 // If the current node has odd value

//                 // First odd node
//                 if (oddHead == null) {
//                     oddHead = current;
//                     oddTail = current;
//                 } else {
//                     oddTail.next = current;
//                     oddTail = current;
//                 }
//             }

//             // Move to next node
//             current = current.next;
//         }

//         // If no even nodes found, return odd list
//         if (evenHead == null) return oddHead;

//         // If no odd nodes found, return even list
//         if (oddHead == null) return evenHead;

//         // Combine even and odd lists
//         evenTail.next = oddHead;

//         // Set end of list to null
//         oddTail.next = null;

//         return evenHead;
//     }
// }