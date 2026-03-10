import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class double_insert {

    // Insert at Beginning
    static Node insertFront(Node head, int data) {

        Node newNode = new Node(data);

        newNode.next = head;

        if (head != null) {
            head.prev = newNode;
        }

        head = newNode;

        return head;
    }

    // Insert at End
    static Node insertEnd(Node head, int data) {

        Node newNode = new Node(data);

        if (head == null) {
            return newNode;
        }

        Node curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = newNode;
        newNode.prev = curr;

        return head;
    }

    // Insert at Position
    static Node insertAtPos(Node head, int pos, int data) {

        Node newNode = new Node(data);

        if (pos == 1) {
            newNode.next = head;

            if (head != null) {
                head.prev = newNode;
            }

            return newNode;
        }

        Node curr = head;

        for (int i = 1; i < pos - 1 && curr != null; i++) {
            curr = curr.next;
        }

        if (curr == null) {
            System.out.println("Position out of range");
            return head;
        }

        newNode.next = curr.next;
        newNode.prev = curr;

        if (curr.next != null) {
            curr.next.prev = newNode;
        }

        curr.next = newNode;

        return head;
    }

    // Display List
    static void display(Node head) {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data);

            if (curr.next != null) {
                System.out.print(" <-> ");
            }

            curr = curr.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Node head = null;
        int choice;

        do {

            System.out.println("\n1.Insert at Beginning");
            System.out.println("2.Insert at End");
            System.out.println("3.Insert at Position");
            System.out.println("4.Display");
            System.out.println("5.Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    int val1 = sc.nextInt();
                    head = insertFront(head, val1);
                    break;

                case 2:
                    System.out.print("Enter value: ");
                    int val2 = sc.nextInt();
                    head = insertEnd(head, val2);
                    break;

                case 3:
                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();

                    System.out.print("Enter value: ");
                    int val3 = sc.nextInt();

                    head = insertAtPos(head, pos, val3);
                    break;

                case 4:
                    display(head);
                    break;

                case 5:
                    System.out.println("Program Ended");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);

        sc.close();
    }
}