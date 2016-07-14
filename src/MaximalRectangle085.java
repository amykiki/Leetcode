import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Amysue on 2016/7/14.
 */
public class MaximalRectangle085 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        char c0 = '0';
        char c1 = '1';
        int maxRect = 0;
        int[][] heights = new int[matrix.length][];
        int[] change = new int[matrix.length];
        for(int i = 0; i < matrix.length; i++) {
            int xlen = matrix[i].length;
            heights[i] = new int[xlen];
            for(int j = 0; j <xlen; j++) {
                if (matrix[i][j] == c0) {
                    heights[i][j] = 0;
                    if (i > 0 && heights[i - 1][j] > 0) {
                        change[i] = -1;
                    }
                } else {
                    if (i > 0 && heights[i - 1][j] > 0) {
                        heights[i][j] = heights[i - 1][j] + 1;
                    } else {
                        heights[i][j] = 1;
                    }
                }
            }
        }
        for(int i = matrix.length - 1; i >= 0; i--) {
            if (i < matrix.length - 1 && change[i + 1] == 0) {
                continue;
            }
            maxRect = Math.max(maxRect, largestRectangleArea(heights[i]));
        }
        /*printIntMatrix(heights);
        System.out.println("==========");
        System.out.println(Arrays.toString(change));*/
        return maxRect;
    }
    private int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        } else if (heights.length == 1) {
            return heights[0];
        }
        int                 largestRect = Integer.MIN_VALUE;
        LinkedList<Integer> index       = new LinkedList<>();
        int                 i           = 0;
        while (i < heights.length) {
            if (index.isEmpty() || heights[index.peek()] <= heights[i]) {
                index.push(i);
                i++;
            } else {
                largestRect = Math.max(largestRect, popLarge(index, heights, i));
            }
        }
        while (i == heights.length && !index.isEmpty()) {
            largestRect = Math.max(largestRect, popLarge(index, heights, i));
        }

        return largestRect;
    }

    private int popLarge(LinkedList<Integer> index, int[] heights, int i) {
        int height = heights[index.pop()];
        while (!index.isEmpty() && heights[index.peek()] == height) {
            index.pop();
        }
        return height*(index.isEmpty() ? i : i - index.peek() - 1);
    }
    public void printIntMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public char[][] getMatrix() {
        Random random = new Random();
        int x = 0;
        while (x == 0) {
            x = random.nextInt(11);
        }
        int y = 0;
        while (y == 0) {
            y = random.nextInt(11);
        }
        char[][] matrix = new char[x][y];
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                int m = random.nextInt(2);
                if (m == 0) {
                    matrix[i][j] = '0';
                } else {
                    matrix[i][j] = '1';
                }
            }
        }
        return matrix;
    }

    public void printMatrix(char[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
    public static void main(String[] args) {
        MaximalRectangle085 mr = new MaximalRectangle085();
        char[][] matrix = mr.getMatrix();
       /* char[][] matrix = {{'0', '1', '1'},{'1', '0', '1'},{'1', '0', '1'},
                           {'0', '0', '1'},{'1', '1', '1'},{'1', '0', '1'},
                           {'1', '0', '0'}
        };*/
        mr.printMatrix(matrix);
        System.out.println("===================");
        int maxRect = mr.maximalRectangle(matrix);
        System.out.println("maxRect = " + maxRect);
    }
}
