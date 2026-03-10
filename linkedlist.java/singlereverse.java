import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int newData) {
        this.data = newData;
        this.next = null;
    }
}

public class singlereverse{

    // Recursive function to reverse linked list
    public static Node reverseList(Node head) {

        // Base condition
        if (head == null || head.next == null) {
            return head;
        }

        // Reverse the rest of the list
        Node rest = reverseList(head.next);

        // Make current node last
        head.next.next = head;

        // Set next of current node to null
        head.next = null;

        return rest;
    }

    // Print Linked List
    public static void printList(Node node) {

        while (node != null) {
            System.out.print(node.data);

            if (node.next != null) {
                System.out.print(" -> ");
            }

            node = node.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        Node head = null;
        Node temp = null;

        System.out.println("Enter values:");

        // Create linked list
        for (int i = 0; i < n; i++) {

            int val = sc.nextInt();
            Node newNode = new Node(val);

            if (head == null) {
                head = newNode;
                temp = head;
            } else {
                temp.next = newNode;
                temp = temp.next;
            }
        }

        System.out.println("Original List:");
        printList(head);

        // Reverse list using recursion
        head = reverseList(head);

        System.out.println("Reversed List:");
        printList(head);

        sc.close();
    }
}