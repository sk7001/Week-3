/*
Problem 1
import java.util.Arrays;

public class SortingAlgorithms {
    public static void main(String[] args) {
        int[] marks = {85, 70, 95, 60, 90};
        for (int i = 0; i < marks.length - 1; i++) {
            for (int j = 0; j < marks.length - 1 - i; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                }
            }
        }
        System.out.println("Sorted Student Marks: " + Arrays.toString(marks));
    }
}
*/

/*
Problem 2
import java.util.Arrays;

public class SortingAlgorithms {
    public static void main(String[] args) {
        int[] employeeIDs = {104, 101, 105, 102, 103};
        for (int i = 1; i < employeeIDs.length; i++) {
            int key = employeeIDs[i];
            int j = i - 1;
            while (j >= 0 && employeeIDs[j] > key) {
                employeeIDs[j + 1] = employeeIDs[j];
                j--;
            }
            employeeIDs[j + 1] = key;
        }
        System.out.println("Sorted Employee IDs: " + Arrays.toString(employeeIDs));
    }
}
*/

/*
Problem 3
import java.util.Arrays;

public class SortingAlgorithms {
    public static void main(String[] args) {
        int[] prices = {500, 300, 450, 200, 350};
        mergeSort(prices, 0, prices.length - 1);
        System.out.println("Sorted Book Prices: " + Arrays.toString(prices));
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);
        int i = 0, j = 0, k = left;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }
    }
}
*/

/*
Problem 4
import java.util.Arrays;

public class SortingAlgorithms {
    public static void main(String[] args) {
        int[] prices = {700, 200, 500, 300, 600};
        quickSort(prices, 0, prices.length - 1);
        System.out.println("Sorted Product Prices: " + Arrays.toString(prices));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }
}
*/

/*
Problem 5
import java.util.Arrays;

public class SortingAlgorithms {
    public static void main(String[] args) {
        int[] scores = {78, 95, 60, 85, 70};
        for (int i = 0; i < scores.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < scores.length; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = scores[i];
            scores[i] = scores[minIndex];
            scores[minIndex] = temp;
        }
        System.out.println("Sorted Exam Scores: " + Arrays.toString(scores));
    }
}
*/

/*
Problem 6
import java.util.Arrays;

public class SortingAlgorithms {
    public static void main(String[] args) {
        int[] salaries = {30000, 50000, 25000, 60000, 40000};
        heapSort(salaries);
        System.out.println("Sorted Salaries: " + Arrays.toString(salaries));
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0]; arr[0] = arr[i]; arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i, l = 2 * i + 1, r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest]) largest = l;
        if (r < n && arr[r] > arr[largest]) largest = r;
        if (largest != i) {
            int temp = arr[i]; arr[i] = arr[largest]; arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }
}
*/

/*
Problem 7
import java.util.Arrays;

public class SortingAlgorithms {
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
*/
