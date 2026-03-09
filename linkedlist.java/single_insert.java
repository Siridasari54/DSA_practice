import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class single_insert {

    // Print Linked List
    public static void printList(Node head) {
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) {
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }

    // Insert at beginning
    public static Node insertAtFront(Node head, int x) {
        Node newNode = new Node(x);
        newNode.next = head;
        return newNode;
    }

    // Insert at end
    public static Node insertAtEnd(Node head, int x) {

        Node newNode = new Node(x);

        if (head == null) {
            return newNode;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

        return head;
    }

    // Insert at position
    public static Node insertAtPosition(Node head, int pos, int val) {

        if (pos == 1) {
            return insertAtFront(head, val);
        }

        Node curr = head;

        for (int i = 1; i < pos - 1 && curr != null; i++) {
            curr = curr.next;
        }

        if (curr == null) {
            System.out.println("Invalid Position");
            return head;
        }

        Node newNode = new Node(val);

        newNode.next = curr.next;
        curr.next = newNode;

        return head;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Node head = null;

        int choice;

        do {
            System.out.println("\n----- Linked List Menu -----");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Print List");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    int frontVal = sc.nextInt();
                    head = insertAtFront(head, frontVal);
                    break;

                case 2:
                    System.out.print("Enter value: ");
                    int endVal = sc.nextInt();
                    head = insertAtEnd(head, endVal);
                    break;

                case 3:
                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();

                    System.out.print("Enter value: ");
                    int val = sc.nextInt();

                    head = insertAtPosition(head, pos, val);
                    break;

                case 4:
                    System.out.println("Linked List:");
                    printList(head);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
