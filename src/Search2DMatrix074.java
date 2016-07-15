/**
 * Created by Amysue on 2016/7/14.
 */
public class Search2DMatrix074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int col = matrix[0].length;
        int low = 0;
        int high = row*col - 1;
        int middle;
        while (low <= high) {
            middle = low + (high - low)/2;
            int[] index = getIndex(col, middle);
            int value = matrix[index[0]][index[1]];
            if (value == target) {
//                System.out.println("(" + index[0] + ", " + index[1] + ")");
                return true;
            } else if (value > target) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return false;
    }

    private int[] getIndex(int M, int i) {
        int x = i / M;
        int y = i % M;
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        Search2DMatrix074 sm = new Search2DMatrix074();
        int[][]matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
//        int[][]matrix = {{1}};
        int target = 16;
        boolean find = sm.searchMatrix(matrix, target);
        System.out.println("find = " + find);
    }
}
