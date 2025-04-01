public class SearchIn2DMatrix {
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
        System.out.println(""Found: "" + found);
    }
}
