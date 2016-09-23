import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by Amysue on 2016/9/23.
 */
public class SetZeroes73 {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int rmark = -1;
        int cmark = -1;
        for(int i = 0; i < rows; i++) {
            if (cmark >= 0 && matrix[i][cmark] == -1) {
                markRowZeros(matrix, rmark, cmark, rows, cols, i);
            } else {
                for(int j = 0; j < cols; j++) {
                    if (matrix[i][j] != 0) {
                        continue;
                    }
                    if (cmark >= 0 && matrix[rmark][j] == -1) {
                        continue;
                    }
                    if (cmark == -1) {
                        rmark = i;
                        cmark = j;
                    }
                    markRowZeros(matrix, rmark, cmark, rows, cols, i);
                    break;
                }
            }
        }
        if (cmark >= 0) {
            for(int i = 0; i < rows; i++) {
                matrix[i][cmark] = 0;
            }
            for(int j = 0; j < cols; j++) {
                matrix[rmark][j] = 0;
            }
        }
        return;
    }

    private void markRowZeros(int[][] matrix, int rmark, int cmark, int rows, int cols, int i) {
        for(int j = 0; j < cols; j++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = 0;
            } else {
                if (matrix[rmark][j] != -1) {
                    markColZeors(matrix, cmark, rows, j, i);
                    matrix[rmark][j] = -1;
                }
            }
        }
    }

    private void markColZeors(int[][] matrix, int cmark, int rows, int j, int origI) {
        for(int i = 0; i < rows; i++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = 0;
            } else {
                if (i > origI) {
                    matrix[i][cmark] = -1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int row = 4;
        int col = 5;
        int[][] matrix = new int[row][col];
        for(int i = 0; i < row; i++) {
            Arrays.fill(matrix[i], 2);
        }
        matrix[1][0] = 0;
        matrix[1][2] = 0;
        matrix[2][0] = 0;
        matrix[3][2] = 0;
        SetZeroes73 sz = new SetZeroes73();
        sz.setZeroes(matrix);
        System.out.println("finish");
    }
}
