package Lab;

public class QueueWithTwoArrays {
     int size = 100;
     int[] arr1;
     int[] arr2;
     int index1;
    int index2;

    public QueueWithTwoArrays() {
        arr1 = new int[size];
        arr2 = new int[size];
        index1 = 0;
        index2 = 0;
    }

     void enqueue(int item) {
         arr1[index1++] = item;
    }

    public int dequeue() {
        if (index2 >= index1) {
            System.out.println("Queue is empty");
            return -1;
        }
        int dequeuedItem = arr1[index2];
        arr2[index2++] = dequeuedItem;
        return dequeuedItem;
    }

    public void printQueue() {
        if (index2 == index1) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue: ");
        for (int i = index2; i < index1; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueWithTwoArrays q = new QueueWithTwoArrays();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.printQueue();
        System.out.println("Dequeue: " + q.dequeue());
        q.printQueue();
        q.enqueue(4);
        q.printQueue();
    }
}

