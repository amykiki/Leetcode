import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Amysue on 2016/8/31.
 */
public class MinPathSum64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] datas = new int[m][n];
        int maxX = m-1;
        int maxY = n-1;
        datas[0][0] = grid[0][0];
        datas[maxX][maxY] = grid[maxX][maxY];
        for(int j = n-2; j >= 0; j--) {
            datas[maxX][j] = grid[maxX][j] + datas[maxX][j + 1];
        }
        for(int i = m-2; i >= 0; i--) {
            datas[i][maxY] = grid[i][maxY] + datas[i + 1][maxY];
        }

        for(int j = n-2; j >= 0; j--) {
            for(int i = m-2; i >= 0; i--) {
                datas[i][j] = grid[i][j] + Math.min(datas[i+1][j], datas[i][j+1]);
            }
        }
        return datas[0][0];
    }

    public static void main(String[] args) {
        MinPathSum64 mp = new MinPathSum64();
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int result = mp.minPathSum(grid);
        System.out.println("result = " + result);
    }
}
