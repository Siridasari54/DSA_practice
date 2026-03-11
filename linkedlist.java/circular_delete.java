import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class circular_delete {
    static Node last = null;
    static void insert(int data) {
        Node newNode = new Node(data);
        if (last == null) {
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
    }
    static void deleteFirst() {
        if (last == null) {
            System.out.println("List is empty");
            return;
        }

        Node head = last.next;

        if (head == last) {
            last = null;
        } else {
            last.next = head.next;
        }

        System.out.println("First node deleted");
    }

    // Delete Specific Node
    static void deleteSpecific(int key) {

        if (last == null) {
            System.out.println("List empty");
            return;
        }

        Node curr = last.next;
        Node prev = last;

        if (curr == last && curr.data == key) {
            last = null;
            return;
        }

        if (curr.data == key) {
            last.next = curr.next;
            return;
        }

        while (curr != last && curr.data != key) {
            prev = curr;
            curr = curr.next;
        }

        if (curr.data == key) {
            prev.next = curr.next;

            if (curr == last) {
                last = prev;
            }
        } else {
            System.out.println("Element not found");
        }
    }

    // Delete Last Node
    static void deleteLast() {

        if (last == null) {
            System.out.println("List empty");
            return;
        }

        Node head = last.next;

        if (head == last) {
            last = null;
            return;
        }

        Node curr = head;

        while (curr.next != last) {
            curr = curr.next;
        }

        curr.next = head;
        last = curr;

        System.out.println("Last node deleted");
    }

    // Display List
    static void display() {

        if (last == null) {
            System.out.println("List is empty");
            return;
        }

        Node head = last.next;

        do {
            System.out.print(head.data + " ");
            head = head.next;
        } while (head != last.next);

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {

            System.out.println("\n1.Insert");
            System.out.println("2.Delete First");
            System.out.println("3.Delete Specific");
            System.out.println("4.Delete Last");
            System.out.println("5.Display");
            System.out.println("6.Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter data: ");
                    int data = sc.nextInt();
                    insert(data);
                    break;

                case 2:
                    deleteFirst();
                    break;

                case 3:
                    System.out.print("Enter element to delete: ");
                    int key = sc.nextInt();
                    deleteSpecific(key);
                    break;

                case 4:
                    deleteLast();
                    break;

                case 5:
                    display();
                    break;

                case 6:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}