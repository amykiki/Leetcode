import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amysue on 2016/8/25.
 */
public class SpiralMatrix54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int m = matrix.length;
        int[] arr = matrix[0];
        if (arr == null || arr.length == 0) {
            return result;
        }
        int n = arr.length;
        addList(0, m-1, 0, n-1, matrix, result);
        return result;
    }

    private void addList(int rowL, int rowH, int colL, int colH, int[][] matrix, List<Integer> result) {
        if (rowH < rowL || colH < colL) {
            return;
        }
        for(int j = colL; j <= colH; j++) {
            result.add(matrix[rowL][j]);
        }
        if (rowH > rowL) {
            for(int i = rowL+1; i < rowH; i++) {
                result.add(matrix[i][colH]);
            }
            for (int j = colH; j >= colL; j--) {
                result.add(matrix[rowH][j]);
            }
            if (colH > colL) {
                for(int i = rowH - 1; i > rowL; i--) {
                    result.add(matrix[i][colL]);
                }
            }
        }
        addList(rowL+1, rowH-1, colL+1, colH-1, matrix, result);
    }

    public static void main(String[] args) {
        SpiralMatrix54 sm = new SpiralMatrix54();
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7,8,9}, {10,11,12}};
        int[][]matrix = {};
        List<Integer> result = sm.spiralOrder(matrix);
        System.out.println(result);
    }
}
