package LinkedList;

public class Node1 {
    int data;
    Node1 next;

    public Node1(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList1 {
    Node1 head;

    public LinkedList1() {
        this.head = null;
    }


    public void insertAtStart(int data) {
        Node1 newNode = new Node1(data);
        newNode.next = head;
        head = newNode;
    }


    public void insertAtEnd(int data) {
        Node1 newNode = new Node1(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node1 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }


    public void insertAtMiddle(int data, int position) {
        Node1 newNode = new Node1(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node1 temp = head;
        int count = 1;
        while (count < position - 1 && temp.next != null) {
            temp = temp.next;
            count++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }


    public void delete(int data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node1 temp = head;
        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }


    public void display() {
        Node1 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList1 list = new LinkedList1();
        System.out.println("Insertion at end");
        list.insertAtEnd(4);
        list.insertAtEnd(2);
        list.insertAtEnd(1);
        list.display();

        System.out.println("Insertion at start");
        list.insertAtStart(5);
        list.display();

        System.out.println("Insertion at middle");
        list.insertAtMiddle(3, 3);
        list.display();

        System.out.println("Deletion");
        list.delete(2);
        list.display();
    }
}

