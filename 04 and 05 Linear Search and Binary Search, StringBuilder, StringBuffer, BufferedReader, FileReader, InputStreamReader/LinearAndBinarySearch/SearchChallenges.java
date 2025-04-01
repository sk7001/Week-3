import java.util.Arrays;
public class SearchChallenges {
    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        int missing = findMissingPositive(arr.clone());
        System.out.println(""First missing positive: "" + missing);
        Arrays.sort(arr);
        int target = 4;
        int index = binarySearch(arr, target);
        System.out.println(""Index of target ("" + target + ""): "" + index);
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
