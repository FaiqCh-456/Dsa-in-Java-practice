package LinkedList;


class Doubly {
    int data;
    Doubly prev;
    Doubly next;

    public Doubly(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Doubly head;
    Doubly tail;

    public void insert(int data) {
        Doubly newDoubly = new Doubly(data);
        if (head == null) {
            head = tail = newDoubly;
        } else {
            tail.next = newDoubly;
            newDoubly.prev = tail;
            tail = newDoubly;
        }
    }

    public void moveForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.print("Forward : ");
        Doubly current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void moveBackward() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.print("Backward : ");
        Doubly current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }
    void display()
    {
        Doubly temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

 class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.display();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.display();

        list.moveForward();

        list.moveBackward();
    }
}

