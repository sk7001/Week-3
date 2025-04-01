import java.util.Arrays;

public class CountingSortSortStudentAges {
    public static void main(String[] args) {
        int[] ages = {14, 12, 15, 13, 12, 14, 10};
        int[] sorted = countingSort(ages, 10, 18);
        System.out.println("Sorted Student Ages: " + Arrays.toString(sorted));
    }

    public static int[] countingSort(int[] arr, int min, int max) {
        int range = max - min + 1;
        int[] count = new int[range];
        for (int num : arr) {
            count[num - min]++;
        }
        int[] sorted = new int[arr.length];
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i]-- > 0) {
                sorted[index++] = i + min;
            }
        }
        return sorted;
    }
}
