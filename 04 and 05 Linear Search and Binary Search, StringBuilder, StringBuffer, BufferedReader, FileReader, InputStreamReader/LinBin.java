/*
Linear Problem 1
public class LinBin {
    public static void main(String[] args) {
        int[] arr = {5, 2, 3, -4, 7, -8};
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                index = i;
                break;
            }
        }
        System.out.println("First negative number index: " + index);
    }
}
*/

/*
Linear Problem 2
public class LinBin {
    public static void main(String[] args) {
        String[] sentences = {
                "Java is fun.",
                "We are learning programming.",
                "This is a search example.",
                "Binary search is powerful."
        };
        String word = "search";
        String result = "Not Found";

        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                result = sentence;
                break;
            }
        }
        System.out.println("Result: " + result);
    }
}
*/

/*
Binary Search Problem 1
public class LinBin {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println("Rotation point index: " + left);
    }
}
 */

/*
Binary Search Problem 2
public class LinBin {
    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            boolean leftBigger = (mid > 0) && (arr[mid] < arr[mid - 1]);
            boolean rightBigger = (mid < arr.length - 1) && (arr[mid] < arr[mid + 1]);

            if (!leftBigger && !rightBigger) {
                System.out.println("Peak element: " + arr[mid]);
                return;
            } else if (leftBigger) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }
}
*/

/*
Binary Search Problem 3
public class LinBin {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int target = 3;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0, right = rows * cols - 1;
        boolean found = false;

        while (left <= right) {
            int mid = (left + right) / 2;
            int row = mid / cols;
            int col = mid % cols;
            int midVal = matrix[row][col];

            if (midVal == target) {
                found = true;
                break;
            } else if (target < midVal) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println("Found: " + found);
    }
}
*/

/*
Binary Search Problem 4
public class LinBin {
    public static void main(String[] args) {
        int[] arr = {2, 4, 4, 4, 5, 6, 7};
        int target = 4;

        int first = findOccurrence(arr, target, true);
        int last = findOccurrence(arr, target, false);

        System.out.println("First Occurrence: " + first);
        System.out.println("Last Occurrence: " + last);
    }

    static int findOccurrence(int[] arr, int target, boolean findFirst) {
        int left = 0, right = arr.length - 1, result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                result = mid;
                if (findFirst)
                    right = mid - 1;
                else
                    left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
 */

/*
Challenge Problem
import java.util.Arrays;

public class LinBin {
    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        int missing = findMissingPositive(arr.clone());
        System.out.println("First missing positive: " + missing);

        Arrays.sort(arr);
        int target = 4;
        int index = binarySearch(arr, target);
        System.out.println("Index of target (" + target + "): " + index);
    }

    static int findMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }

    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
*/