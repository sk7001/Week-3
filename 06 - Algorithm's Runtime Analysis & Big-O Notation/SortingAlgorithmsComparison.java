import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithmsComparison {
    public static void main(String[] args) {
        int[] arr1 = generateArray(100000);
        int[] arr2 = arr1.clone();
        int[] arr3 = arr1.clone();

        long start = System.nanoTime();
        bubbleSort(arr1);
        System.out.println("Bubble Sort Time: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        Arrays.sort(arr2); // Default is Dual-Pivot QuickSort
        System.out.println("Java Arrays.sort Time: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        mergeSort(arr3, 0, arr3.length - 1);
        System.out.println("Merge Sort Time: " + (System.nanoTime() - start) + " ns");
    }

    public static int[] generateArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt();
        return arr;
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = temp;
                }
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int[] left = Arrays.copyOfRange(arr, l, m + 1);
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);
        int i = 0, j = 0, k = l;

        while (i < left.length && j < right.length)
            arr[k++] = left[i] <= right[j] ? left[i++] : right[j++];
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }
}
