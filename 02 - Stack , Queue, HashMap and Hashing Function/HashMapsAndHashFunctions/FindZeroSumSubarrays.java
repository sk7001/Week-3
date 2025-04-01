import java.util.*;

public class FindZeroSumSubarrays {
    public static List<List<Integer>> findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) result.add(Arrays.asList(0, i));
            if (map.containsKey(sum)) {
                for (int startIndex : map.get(sum)) {
                    result.add(Arrays.asList(startIndex + 1, i));
                }
            }
            map.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {6, -3, 4, -2, -1, 3, 1, -3, 2};
        List<List<Integer>> subarrays = findZeroSumSubarrays(arr);
        for (List<Integer> subarray : subarrays) {
            System.out.println(subarray);
        }
    }
}
