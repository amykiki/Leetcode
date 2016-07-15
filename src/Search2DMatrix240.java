/**
 * Created by Amysue on 2016/7/15.
 */
public class Search2DMatrix240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int col = matrix[0].length;
        if (col == 0) {
            return false;
        }
        return searchSmall(matrix, target, row - 1, 0);
    }

    private boolean searchSmall(int[][] matrix, int target, int xend, int ystart) {
        if (xend < 0 || ystart > matrix[0].length - 1) {
            return false;
        }
        int insertion;
        if (xend == 0) {
            insertion = find(0, matrix[0].length - 1, target, matrix, "x");
            if (insertion < 0) {
                return false;
            }
        } else {
            insertion = find(ystart, xend, target, matrix, "y");
        }
        if (insertion >= 0) {
            return true;
        } else {
            insertion = -insertion - 1;
            return searchSmall(matrix, target, insertion - 1, ystart + 1);
        }
    }

    public int find(int index, int high, int target, int[][] matrix, String dir) {
        int low = 0;
        int value;
        while (low <= high) {
            int middle = (high - low) / 2 + low;
            if (dir.equals("y")) {
                value = matrix[middle][index];
            } else {
                value = matrix[index][middle];
            }
            if (value == target) {
                return middle;
            } else if (value > target) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -(low + 1);
    }

    public static void main(String[] args) {
        Search2DMatrix240 sm = new Search2DMatrix240();
       /* int[][] matrix = {{1, 4, 7, 11, 15},
                          {2, 5, 8, 12, 19},
                          {3, 6, 9, 16, 22},
                          {10, 13, 14, 17, 24},
                          {18, 21, 23, 26, 30},
                          {20, 25, 27, 28, 31}};*/
        int[][] matrix = {{1, 1}};
//        int[][] matrix = {{2},{3},{4},{5},{6},{7}};
        int target = 25;
        boolean find = sm.searchMatrix(matrix, target);
        System.out.println("find = " + find);
//        int index = sm.find(0, 5, target, matrix, "y");
//        int index = sm.find(1, 5, target, matrix, "y");
//        System.out.println("index = " + index);
    }
}
