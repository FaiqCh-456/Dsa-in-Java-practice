package Sir_practice;


class PNode {
    int id;
    int executionTime;
    PNode next;

    public PNode(int id, int executionTime) {
        this.id = id;
        this.executionTime = executionTime;
        this.next = null;
    }
}

class CircularSinglyLinkedList {
    private PNode head;

    public void insertAtEnd(int id, int executionTime) {
        PNode newNode = new PNode(id, executionTime);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            PNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    public void deleteValue(int id) {
        if (head == null) {
            return;
        }

        PNode current = head;
        PNode prev = null;

        do {
            if (current.id == id) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                break;
            }
            prev = current;
            current = current.next;
        } while (current != head && current != null);

        if (current == head && current.id == id) {
            if (head.next == head) {
                head = null;
            } else {
                prev.next = head.next;
                head = head.next;
            }
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        PNode current = head;
        do {
            System.out.println("Task ID: " + current.id + ", Execution Time: " + current.executionTime);
            current = current.next;
        } while (current != head);
    }

    public void simulateRR(int quantum) {
        if (head == null) {
            System.out.println("No tasks to simulate.");
            return;
        }

        PNode current = head;
        do {
            if (current.executionTime <= quantum) {
                System.out.println("Task ID " + current.id + " completed.");
                deleteValue(current.id);
            } else {
                System.out.println("Task ID " + current.id + " execution time reduced by " + quantum);
                current.executionTime -= quantum;
            }
            current = current.next;
        } while (current != head); // Update the loop condition
    }




    public static void main(String[] args) {
        CircularSinglyLinkedList scheduler = new CircularSinglyLinkedList();


        scheduler.insertAtEnd(1, 8);
        scheduler.insertAtEnd(2, 5);
        scheduler.insertAtEnd(3, 10);
        scheduler.insertAtEnd(4, 3);

        System.out.println("Tasks before simulation:");
        scheduler.display();

        System.out.println("\nSimulating Round-Robin Scheduler with quantum 5:");
        scheduler.simulateRR(5);

        System.out.println("\nTasks after simulation:");
        scheduler.display();
    }
}

