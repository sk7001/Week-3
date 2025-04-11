/*
Problem 1
import java.util.*;

public class HashMapsAndHashFunctions {
    public static List<List<Integer>> findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                result.add(Arrays.asList(0, i));
            }
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
*/

/*
Problem 3
import java.util.*;

public class HashMapsAndHashFunctions {
    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (seen.contains(target - num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 3, 1};
        int target = 10;
        System.out.println(hasPairWithSum(arr, target));
    }
}
 */

/*
Problem 3
import java.util.*;

public class HashMapsAndHashFunctions {
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
*/

/*
Problem 4
public class HashMapsAndHashFunctions {
    static class CustomHashMap<K, V> {
        private class Node {
            K key;
            V value;
            Node next;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private Node[] table;
        private static final int INITIAL_CAPACITY = 16;

        @SuppressWarnings("unchecked")
        public CustomHashMap() {
            table = (Node[]) new HashMapsAndHashFunctions.CustomHashMap<?,?>.Node[INITIAL_CAPACITY];
        }

        private int hash(K key) {
            return Math.abs(key.hashCode()) % table.length;
        }

        public void put(K key, V value) {
            int index = hash(key);
            Node node = table[index];
            while (node != null) {
                if (node.key.equals(key)) {
                    node.value = value;
                    return;
                }
                node = node.next;
            }
            Node newNode = new Node(key, value);
            newNode.next = table[index];
            table[index] = newNode;
        }

        public V get(K key) {
            int index = hash(key);
            Node node = table[index];
            while (node != null) {
                if (node.key.equals(key)) {
                    return node.value;
                }
                node = node.next;
            }
            return null;
        }

        public void remove(K key) {
            int index = hash(key);
            Node node = table[index];
            Node prev = null;
            while (node != null) {
                if (node.key.equals(key)) {
                    if (prev == null) {
                        table[index] = node.next;
                    } else {
                        prev.next = node.next;
                    }
                    return;
                }
                prev = node;
                node = node.next;
            }
        }
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        System.out.println(map.get("apple"));
        map.remove("apple");
        System.out.println(map.get("apple"));
    }
}
*/

/*
Problem 5
import java.util.*;

public class HashMapsAndHashFunctions {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
 */