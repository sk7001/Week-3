import java.util.Arrays;
import java.util.Random;

public class LinearVsBinarySearch {
    public static void main(String[] args) {
        int[] data = new int[1000000];
        Random rand = new Random();
        for (int i = 0; i < data.length; i++) data[i] = rand.nextInt(1000000);
        int target = data[777777];

        long startLinear = System.nanoTime();
        for (int i : data) {
            if (i == target) break;
        }
        long endLinear = System.nanoTime();
        System.out.println("Linear Search Time: " + (endLinear - startLinear) + " ns");

        Arrays.sort(data);
        long startBinary = System.nanoTime();
        Arrays.binarySearch(data, target);
        long endBinary = System.nanoTime();
        System.out.println("Binary Search Time: " + (endBinary - startBinary) + " ns");
    }
}
