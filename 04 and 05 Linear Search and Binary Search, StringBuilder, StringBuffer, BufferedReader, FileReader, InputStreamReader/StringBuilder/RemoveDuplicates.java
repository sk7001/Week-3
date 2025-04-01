import java.util.*;
public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (!set.contains(c)) {
                sb.append(c);
                set.add(c);
            }
        }
        System.out.println(sb.toString());
    }
}
