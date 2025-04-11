/*
Problem 1
import java.util.Stack;
public class StacksAndQueues {
    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();
    public void enqueue(int number){
        in.push(number);
    }
    public int dequeue(){
        if(out.isEmpty()){
            while (!in.isEmpty()) out.push(in.pop());
        }
        return out.isEmpty() ? -1 : out.pop();
    }
    public static void main(String[] args){
        StacksAndQueues q = new StacksAndQueues();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}
 */

/*
Problem 2
import java.util.*;

public class StacksAndQueues {
    public static void sort(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int x = s.pop();
            sort(s);
            insert(s, x);
        }
    }

    public static void insert(Stack<Integer> s, int x) {
        if (s.isEmpty() || x > s.peek()) {
            s.push(x);
            return;
        }
        int y = s.pop();
        insert(s, x);
        s.push(y);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        sort(stack);
        while (!stack.isEmpty()) System.out.println(stack.pop());
    }
}
 */

/*
Problem 3
import java.util.*;
public class StacksAndQueues {
    public static int[] calculateSpan(int[] prices) {
        int[] span = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) stack.pop();
            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = calculateSpan(prices);
        for (int s : span) System.out.print(s + " ");
    }
}
*/

/*
Problem 4
import java.util.*;

public class StacksAndQueues {
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
        StacksAndQueues queue = new StacksAndQueues();
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
*/

/*
Problem 5
import java.util.*;

class PetrolPump {
    int petrol;
    int distance;

    PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

public class StacksAndQueues {
    public static int circularTour(PetrolPump[] pumps) {
        Queue<PetrolPump> queue = new LinkedList<>();
        Collections.addAll(queue, pumps);
        int start = 0;
        int totalPetrol = 0;
        int totalDistance = 0;

        for (PetrolPump p : pumps) {
            totalPetrol += p.petrol;
            totalDistance += p.distance;
        }

        if (totalPetrol < totalDistance) return -1;

        int balance = 0;
        int index = 0;
        int i = 0;

        while (i < pumps.length * 2) {
            PetrolPump current = queue.poll();
            queue.add(current);

            balance += current.petrol - current.distance;

            if (balance < 0) {
                index = i + 1;
                balance = 0;
            }

            i++;
            if (index >= pumps.length) return -1;
        }

        return index;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
                new PetrolPump(6, 4),
                new PetrolPump(3, 6),
                new PetrolPump(7, 3)
        };
        System.out.println(circularTour(pumps));
    }
}
 */