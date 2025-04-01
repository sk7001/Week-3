public class RecursiveVsIterativeFibonacci {
    public static void main(String[] args) {
        int n = 30;

        long start = System.nanoTime();
        int rec = fibonacciRecursive(n);
        System.out.println("Recursive Fibonacci: " + rec + " Time: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        int itr = fibonacciIterative(n);
        System.out.println("Iterative Fibonacci: " + itr + " Time: " + (System.nanoTime() - start) + " ns");
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
