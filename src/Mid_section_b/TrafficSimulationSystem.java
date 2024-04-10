package Mid_section_b;


//Q2. create a Cpp method that removes all duplicate values from an unsorted
//        singly linked list without using additional data structures for storage
//        .
//        Requirements:
//        Implementing the singly linked list:
//        Define a ListNode class with int data and ListNode next attributes
//        Implement methods to add new nodes to the end of the list and to display the list
//        Removing Duplicates :
//        Implement a method removeDuplicates() in uour list class that iterates through
//        the list, removing all nodes that contain duplicates values.
//        Hints :
//        use two pointers: current to iterate over the list and the runner to check each subsequent node
//        for duplicates of current.
//        when runner finds a duplicate (i.e runner.next.data == current.data) adjust
//        pointers to skip the duplicate node, removing it from list


class TrafficSignalSimulation {

    private static class TrafficSignalNode {
        String signalColor;
        int duration;
        TrafficSignalNode next;

        TrafficSignalNode(String color, int dur) {
            signalColor = color;
            duration = dur;
            next = null;
        }
    }


    private static class CircularLinkedList {
        private TrafficSignalNode head;

        CircularLinkedList() {
            head = null;
        }


        void insertSignal(String color, int duration) {
            TrafficSignalNode newNode = new TrafficSignalNode(color, duration);
            if (head == null) {
                head = newNode;
                head.next = head;
            } else {
                TrafficSignalNode temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = newNode;
                newNode.next = head;
            }
        }


        void displaySignals() {
            if (head == null) {
                System.out.println("No traffic signals");
                return;
            }
            TrafficSignalNode temp = head;
            do {
                System.out.println("Signal Color: " + temp.signalColor + ", Duration: " + temp.duration);
                temp = temp.next;
            } while (temp != head);
        }


        void simulateTrafficSignals(int cycles) {
            if (head == null) {
                System.out.println("No traffic signals to simulate");
                return;
            }
            TrafficSignalNode temp = head;
            for (int i = 0; i < cycles; ++i) {
                do {
                    System.out.println("Signal Color: " + temp.signalColor + ", Duration: " + temp.duration);
                    temp = temp.next;
                } while (temp != head);
            }
        }
    }

    public static void main(String[] args) {
        CircularLinkedList trafficSignals = new CircularLinkedList();

        trafficSignals.insertSignal("Red", 10);
        trafficSignals.insertSignal("Green", 15);
        trafficSignals.insertSignal("Yellow", 5);


        System.out.println("Traffic Signals:");
        trafficSignals.displaySignals();


        System.out.println("\nSimulating traffic signals for 3 cycles:");
        trafficSignals.simulateTrafficSignals(3);
    }
}


