import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class single_delete {

    // Delete head node
    public static Node deleteHead(Node head) {
        if (head == null) {
            return null;
        }
        return head.next;
    }

    // Delete last node
    public static Node deleteLast(Node head) {

        if (head == null || head.next == null) {
            return null;
        }

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
        return head;
    }

    // Delete node at position
    public static Node deleteAtPosition(Node head, int pos) {

        if (head == null)
            return null;

        if (pos == 1)
            return deleteHead(head);

        Node temp = head;
        Node prev = null;

        for (int i = 1; i < pos; i++) {
            prev = temp;
            temp = temp.next;

            if (temp == null)
                return head;
        }

        prev.next = temp.next;

        return head;
    }

    // Print linked list
    public static void printList(Node head) {

        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data);

            if (curr.next != null)
                System.out.print(" -> ");

            curr = curr.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Node head = null;
        Node temp = null;

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter values:");

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

        int choice;

        do {

            System.out.println("\n--- Linked List Menu ---");
            System.out.println("1. Delete Head Node");
            System.out.println("2. Delete Last Node");
            System.out.println("3. Delete Node at Position");
            System.out.println("4. Print List");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    head = deleteHead(head);
                    System.out.println("Head deleted");
                    break;

                case 2:
                    head = deleteLast(head);
                    System.out.println("Last node deleted");
                    break;

                case 3:
                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();
                    head = deleteAtPosition(head, pos);
                    break;

                case 4:
                    System.out.println("Linked List:");
                    printList(head);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
