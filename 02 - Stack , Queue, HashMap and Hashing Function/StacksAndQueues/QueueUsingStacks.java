import java.util.Stack;

public class QueueUsingStacks {
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
        QueueUsingStacks q = new QueueUsingStacks();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}
