public class FindPeakElement {
    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            boolean leftBigger = (mid > 0) && (arr[mid] < arr[mid - 1]);
            boolean rightBigger = (mid < arr.length - 1) && (arr[mid] < arr[mid + 1]);
            if (!leftBigger && !rightBigger) {
                System.out.println(""Peak element: "" + arr[mid]);
                return;
            } else if (leftBigger) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }
}
