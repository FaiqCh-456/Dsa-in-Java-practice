package Queue;

import java.util.Stack;

public class CircularQueueUsingArray {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int flag = 1;

    public CircularQueueUsingArray() {
        stack1 = new Stack<>();
        stack2 =new Stack<>();
    }


    public void enqueue(int item) {
        if (flag == 1){
            stack1.push(item);
            System.out.println(item + " is pushed");
        }else{
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            flag = 1;
        }
    }


    public int dequeue() {
        if (flag==1){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }if (!stack2.isEmpty()) {
                flag = 0;
                return stack2.pop();
            }else {
                System.out.println("Queue is Empty");
                return -1;
            }
        }else {
            if (!stack2.isEmpty())
                return stack2.pop();
            else {
                System.out.println("Queue is Empty");
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        CircularQueueUsingArray queue = new CircularQueueUsingArray();
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