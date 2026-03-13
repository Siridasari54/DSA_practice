import java.util.*;
class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class middle_ll_876{

    static Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("List is empty");
        }
        Node head = new Node(sc.nextInt());
        Node temp = head;
        for (int i = 1; i < n; i++) {
            Node newNode = new Node(sc.nextInt());
            temp.next = newNode;
            temp = newNode;
        }
        Node middleNode = findMiddle(head);
        System.out.println("The middle node value is: " + middleNode.data);
        sc.close();
    }
}
//brute force code
// if (head == null || head.next == null) {
//             return head;
//         }

//         Node temp = head;
//         int count = 0;

//         // Count number of nodes
//         while (temp != null) {
//             count++;
//             temp = temp.next;
//         }

//         int mid = count / 2 + 1;
//         temp = head;

//         while (temp != null) {
//             mid--;

//             if (mid == 0) {
//                 break;
//             }

//             temp = temp.next;
//         }

//         return temp;