package Mid_section_b;


//    Q1. implement a Cpp program that simulates the cyclic behaviour of traffic signals
//    at an intersection using a circular linked list.
//        Requirements:
//        Part A : (implementing the circular singly linked list)
//        Define a TrafficSignalNode Class with attributes signalColor(string) and
//        duration(int) to represent each traffic light phase and its duration
//        Implement a circular singly linked list with methods for insertion(insertSignal)
//        and display (displaySignals). the list should maintain the circular property after
//        each insertion.
//        Part B : (Simulating Traffic Signals):
//        develop a method simulateTrafficSignals(int cycles) to iterate through the traffic signals for a given number of cycles
//        , where a cycle consists of transitioning  through Red->Green->Yellow
//        phases in order
public class LinkedList {

    private static class ListNode {
        int data;
        ListNode next;

        ListNode(int val) {
            data = val;
            next = null;
        }
    }

    private ListNode head;


    public void addNode(int val) {
        if (head == null) {
            head = new ListNode(val);
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(val);
    }


    public void displayList() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }


    public void removeDuplicates() {
        ListNode current = head;
        while (current != null) {
            ListNode runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addNode(2);
        list.addNode(3);
        list.addNode(2);
        list.addNode(5);
        list.addNode(3);
        list.addNode(5);

        System.out.println("Original List:");
        list.displayList();


        list.removeDuplicates();

        System.out.println("List after removing duplicates:");
        list.displayList();
    }
}


