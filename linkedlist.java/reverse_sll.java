import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
public class reverse_sll {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        ListNode cur;

        while (temp != null) {
            cur = temp.next;
            temp.next = prev;
            prev = temp;
            temp = cur;
        }

        return prev; 
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode head = new ListNode(sc.nextInt());
        ListNode temp = head;
        for (int i = 1; i < n; i++) {
            temp.next = new ListNode(sc.nextInt());
            temp = temp.next;
        }
        head = reverseList(head);
        printList(head);

        sc.close();
    }
}
