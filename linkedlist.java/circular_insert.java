import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class circular_insert {

    // Insert at Beginning
    static Node insertBeginning(Node head, int data) {

        Node newNode = new Node(data);

        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node temp = head;

        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;

        head = newNode;

        return head;
    }

    // Insert at End
    static Node insertEnd(Node head, int data) {

        Node newNode = new Node(data);

        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node temp = head;

        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;

        return head;
    }

    // Insert at Position
    static Node insertPosition(Node head, int data, int pos) {

        if (pos == 1)
            return insertBeginning(head, data);

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }

    // Display
    static void display(Node head) {

        if (head == null) {
            System.out.println("List empty");
            return;
        }

        Node temp = head;

        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(head)");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Node head = null;
        int choice;

        do {

            System.out.println("\n1 Insert Beginning");
            System.out.println("2 Insert End");
            System.out.println("3 Insert Position");
            System.out.println("4 Display");
            System.out.println("5 Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    int v1 = sc.nextInt();
                    head = insertBeginning(head, v1);
                    break;

                case 2:
                    System.out.print("Enter value: ");
                    int v2 = sc.nextInt();
                    head = insertEnd(head, v2);
                    break;

                case 3:
                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();

                    System.out.print("Enter value: ");
                    int v3 = sc.nextInt();

                    head = insertPosition(head, v3, pos);
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