public class FirstAndLastOccurrence {
    public static void main(String[] args) {
        int[] arr = {2, 4, 4, 4, 5, 6, 7};
        int target = 4;
        int first = findOccurrence(arr, target, true);
        int last = findOccurrence(arr, target, false);
        System.out.println(""First Occurrence: "" + first);
        System.out.println(""Last Occurrence: "" + last);
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
