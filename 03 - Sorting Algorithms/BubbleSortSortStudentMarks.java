import java.util.Arrays;

public class BubbleSortSortStudentMarks {
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
