package Queue;

import java.util.Stack;

public class QueueUsingStacks {

    Stack<Integer> inbox;
    Stack<Integer> outbox;

    public QueueUsingStacks() {
        inbox = new Stack<>();
        outbox = new Stack<>();
    }

    public void enqueue(int item) {
        inbox.push(item);
        System.out.println(item + " is enqueued");
    }

    public int dequeue() {
        if (outbox.isEmpty()) {
            if (inbox.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            } else {
                while (!inbox.isEmpty()) {
                    outbox.push(inbox.pop());
                }
            }
        }
        return outbox.pop();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(2);
        queue.enqueue(6);
        queue.enqueue(8);
        queue.enqueue(9);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(12);
        queue.enqueue(45);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
