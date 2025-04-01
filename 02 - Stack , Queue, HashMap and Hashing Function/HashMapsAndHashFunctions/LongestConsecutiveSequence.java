import java.util.*;

public class LongestConsecutiveSequence {
    public static int longestConsecutiveSequence(int[] arr) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : arr) {
            numSet.add(num);
        }
        int longestStreak = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int streak = 1;
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    streak += 1;
                }
                longestStreak = Math.max(longestStreak, streak);
            }
        }
        return longestStreak;
    }
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutiveSequence(arr));
    }
}
