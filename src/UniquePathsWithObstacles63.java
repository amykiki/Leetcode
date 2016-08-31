import java.util.LinkedList;

/**
 * Created by Amysue on 2016/8/30.
 */
public class UniquePathsWithObstacles63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        if (obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        int                 nBlocks = m * n;
        int[]               blocks  = new int[m * n];
        LinkedList<Integer> paths   = new LinkedList<>();
        blocks[0] = 1;
        paths.add(0);
        int XMAX = (m - 1) * n;
        int YMAX = n - 1;
        while (!paths.isEmpty()) {
            int i = paths.pop();
            if (i % n < YMAX) {
                int xNext = i + 1;
                add(paths, blocks, i, xNext, obstacleGrid, n);
            }
            if (i < XMAX) {
                int yNext = i + n;
                add(paths, blocks, i, yNext, obstacleGrid, n);
            }
        }
        return blocks[nBlocks - 1];

    }

    private void add(LinkedList<Integer> paths, int[] blocks, int last, int crt, int[][] grid, int n) {
        if (blocks[crt] == -1) {
            return;
        }
        if (blocks[crt] == 0) {
            int x = crt / n;
            int y = crt % n;
            if (grid[x][y] == 1) {
                blocks[crt] = -1;
            } else {
                paths.add(crt);
                blocks[crt] = blocks[last];
            }
        } else {
            blocks[crt] += blocks[last];
        }
    }

    public static void main(String[] args) {
        UniquePathsWithObstacles63 up           = new UniquePathsWithObstacles63();
        int                        m            = 3;
        int                        n            = 3;
        int[][]                    obstacleGrid = new int[m][n];
        obstacleGrid[1][1] = 1;
        int paths = up.uniquePathsWithObstacles(obstacleGrid);
        System.out.println("paths = " + paths);
    }
}
