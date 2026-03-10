import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class double_delete {

    // Delete at Beginning
    static Node delHead(Node head) {

        if (head == null)
            return null;

        head = head.next;

        if (head != null)
            head.prev = null;

        return head;
    }

    // Delete at End
    static Node delLast(Node head) {

        if (head == null)
            return null;

        if (head.next == null)
            return null;

        Node curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.prev.next = null;

        return head;
    }

    // Delete at Position
    static Node delPos(Node head, int pos) {

        if (head == null)
            return head;

        Node curr = head;

        for (int i = 1; curr != null && i < pos; i++) {
            curr = curr.next;
        }

        if (curr == null)
            return head;

        if (curr.prev != null)
            curr.prev.next = curr.next;

        if (curr.next != null)
            curr.next.prev = curr.prev;

        if (curr == head)
            head = curr.next;

        return head;
    }

    // Display list
    static void display(Node head) {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data);

            if (curr.next != null)
                System.out.print(" <-> ");

            curr = curr.next;
        }

        System.out.println();
    }

    // Insert at End (to create list)
    static Node insertEnd(Node head, int data) {

        Node newNode = new Node(data);

        if (head == null)
            return newNode;

        Node curr = head;

        while (curr.next != null)
            curr = curr.next;

        curr.next = newNode;
        newNode.prev = curr;

        return head;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Node head = null;
        int choice;

        do {

            System.out.println("\n1 Insert Node (End)");
            System.out.println("2 Delete Beginning");
            System.out.println("3 Delete End");
            System.out.println("4 Delete Position");
            System.out.println("5 Display");
            System.out.println("6 Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    int val = sc.nextInt();
                    head = insertEnd(head, val);
                    break;

                case 2:
                    head = delHead(head);
                    break;

                case 3:
                    head = delLast(head);
                    break;

                case 4:
                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();
                    head = delPos(head, pos);
                    break;

                case 5:
                    display(head);
                    break;

                case 6:
                    System.out.println("Program Ended");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 6);

        sc.close();
    }
}
