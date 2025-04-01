import java.util.*;

public class SlidingWindowMaximum {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public void enqueue(int x) {
        stack1.push(x);
    }
    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) stack2.push(stack1.pop());
        }
        if (stack2.isEmpty()) throw new NoSuchElementException("Queue is empty");
        return stack2.pop();
    }
    public static void main(String[] args) {
        SlidingWindowMaximum queue = new SlidingWindowMaximum();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue.dequeue());
        queue.enqueue(40);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
