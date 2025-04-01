import java.util.Arrays;

public class SelectionSortSortExamScores {
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
