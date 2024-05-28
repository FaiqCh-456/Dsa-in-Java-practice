package LinkedList;

public class node {
    public int data;
    node prev;
    public node next;

    public node(int data)
    {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
class Doubly_linkedlist{
     static node head = null;
     node tail = null;
     void insertAtBeginning(int data)
    {
        node temp = new node(data);
        if (head == null) {
            head = temp;
            tail = temp;
        }
        else {
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
    }

     void insertAtEnd(int data)
    {
        node temp = new node(data);
        if (tail == null) {
            head = temp;
            tail = temp;
        }
        else {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
    }

    void insertAtPosition(int data, int position)
    {
        node temp = new node(data);
        if (position == 1) {
            insertAtBeginning(data);
        }
        else {
            node current = head;
            int currPosition = 1;
            while (current != null
                    && currPosition < position) {
                current = current.next;
                currPosition++;
            }
            if (current == null) {
                insertAtEnd(data);
            }
            else {
                temp.next = current;
                temp.prev = current.prev;
                current.prev.next = temp;
                current.prev = temp;
            }
        }
    }

     void deleteAtBeginning()
    {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        node temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;
    }

     void deleteAtEnd()
    {
        if (tail == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        node temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
    }

     void deleteAtSpecificPosition(int pos)
    {
        if (head == null) {
            return;
        }

        if (pos == 1) {
            deleteAtBeginning();
            return;
        }

        node current = head;
        int count = 1;

        while (current != null && count != pos) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Position wrong");
            return;
        }

        if (current == tail) {
            deleteAtEnd();
            return;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
        current.prev = null;
        current.next = null;
    }

     void display(node head)
    {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }


    public static void main(String[] args)
    {
        Doubly_linkedlist list =new Doubly_linkedlist();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);

        System.out.print("After insertion at tail: ");
        list.display(head);

        System.out.print("After insertion at head: ");
        list.insertAtBeginning(0);
        list.display(head);

        list.insertAtPosition(6, 2);
        System.out.print(
                "After insertion at 2nd position: ");
        list.display(head);

        list.deleteAtBeginning();
        System.out.print(
                "After deletion at the beginning: ");
        list.display(head);

        list.deleteAtEnd();
        System.out.print("After deletion at the end: ");
        list.display(head);

        list.deleteAtSpecificPosition(2);
        System.out.print(
                "After deletion at 2nd position: ");
        list.display(head);
    }
}
