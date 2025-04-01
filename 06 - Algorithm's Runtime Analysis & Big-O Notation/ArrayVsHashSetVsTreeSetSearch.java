import java.util.*;

public class ArrayVsHashSetVsTreeSetSearch {
    public static void main(String[] args) {
        int size = 1000000;
        int[] array = new int[size];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            int num = rand.nextInt(size);
            array[i] = num;
            hashSet.add(num);
            treeSet.add(num);
        }

        int target = array[size / 2];

        long start = System.nanoTime();
        for (int i : array) {
            if (i == target) break;
        }
        System.out.println("Array Search Time: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        hashSet.contains(target);
        System.out.println("HashSet Search Time: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        treeSet.contains(target);
        System.out.println("TreeSet Search Time: " + (System.nanoTime() - start) + " ns");
    }
}
