package Lab;

public class Queue {
    int maxsize;
    int[] array;
    int front;
    int rear;

    Queue(int size) {
        maxsize = size;
        array = new int[maxsize];
        front = 0;
        rear = -1;
    }

    void enqueue(int item) {
        if (rear == maxsize - 1) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        rear++;
        array[rear] = item;
        System.out.println(item + " enqueued in the queue");
    }

     int dequeue() {
        if (front > rear) {
            System.out.println("Queue is empty.Cannot dequeue.");
            return 1;
        }
        int dequeueitem = array[front];
        front++;
        return dequeueitem;
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.dequeue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        queue.enqueue(60);

        System.out.println("Dequeuing elements: ");

        for (int i = 0; i < 5; i++) {
            int dequeueitem = queue.dequeue();
            if (dequeueitem != -1) {
                System.out.println(dequeueitem + " dequeued from the queue");
            }
        }

        queue.dequeue();

    }
}
