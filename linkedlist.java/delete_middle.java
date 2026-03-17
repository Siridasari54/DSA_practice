import java.util.*;
class Node {

    int data;
    Node next;

    Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }

    Node(int data1) {
        data = data1;
        next = null;
    }
}

class Solution {

    public Node deleteMiddle(Node head) {

        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head;
        Node fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}

public class delete_middle {
    public static void printLL(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of nodes

        if (n == 0) {
            System.out.println("Empty list");
            
        }

        Node head = new Node(sc.nextInt());
        Node temp = head;

        for (int i = 1; i < n; i++) {
            temp.next = new Node(sc.nextInt());
            temp = temp.next;
        }
        Solution obj = new Solution();
        head = obj.deleteMiddle(head);

        printLL(head);

        sc.close();
    }
}