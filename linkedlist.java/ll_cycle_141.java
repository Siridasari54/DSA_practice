import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class ll_cycle_141 {
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n == 0) {
            System.out.println(false);
            
        }

        ListNode head = new ListNode(sc.nextInt());
        ListNode temp = head;
        ListNode[] nodes = new ListNode[n];
        nodes[0] = head;

        for (int i = 1; i < n; i++) {
            ListNode newNode = new ListNode(sc.nextInt());
            temp.next = newNode;
            temp = newNode;
            nodes[i] = newNode;
        }
        int pos = sc.nextInt();

        if (pos != -1) {
            temp.next = nodes[pos];
        }

        boolean result = hasCycle(head);
        System.out.println(result);

        sc.close();
    }
}