/**
 * Created by Amysue on 2016/8/31.
 */
public class UniquePathsWithObstacles6302 {
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
        int[][] datas = new int[m][n];
        for (int j = n-1; j >= 0; j--) {
            if (obstacleGrid[m - 1][j] == 1) {
                break;
            }
            datas[m - 1][j] = 1;
        }
        for (int i = m-1; i >= 0; i--) {
            if (obstacleGrid[i][n - 1] == 1) {
                break;
            }
            datas[i][n - 1] = 1;
        }
        int blockCount = 0;
        for(int j = n-2; j >= 0; j--) {
            if (datas[m - 1][j] == 0) {
                blockCount++;
            }
            for(int i = m-2; i >= 0; i--) {
                if (obstacleGrid[i][j] != 1) {
                    datas[i][j] = datas[i + 1][j] + datas[i][j + 1];
                } else {
                    blockCount++;
                }
            }
            if (blockCount == m) {
                break;
            }
            blockCount = 0;
        }
        return datas[0][0];
    }

    public static void main(String[] args) {
        UniquePathsWithObstacles6302 up1 = new UniquePathsWithObstacles6302();
        UniquePathsWithObstacles63 up2 = new UniquePathsWithObstacles63();
//        int                        m            = 3;
//        int                        n            = 3;
        int                        m            = 3;
        int                        n            = 2;
        int[][]                    obstacleGrid = new int[m][n];
//        obstacleGrid[1][1] = 1;
        obstacleGrid[1][0] = 1;
        obstacleGrid[1][1] = 1;
        int paths1 = up1.uniquePathsWithObstacles(obstacleGrid);
        int paths2 = up2.uniquePathsWithObstacles(obstacleGrid);
        System.out.println("paths1 = " + paths1);
        System.out.println("paths2 = " + paths2);
    }
}
