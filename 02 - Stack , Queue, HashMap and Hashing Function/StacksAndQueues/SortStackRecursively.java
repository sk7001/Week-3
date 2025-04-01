import java.util.*;

public class SortStackRecursively {
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
