/**
 * Created by Amysue on 2016/8/31.
 */
public class UniquePath6202 {
    public int uniquePaths(int m, int n) {
        if (m*n <= 2) {
            return 1;
        }
        int[][] datas = new int[m][n];
        for(int j = 0; j < n; j++) {
            datas[m-1][j] = 1;
        }
        for(int i = 0; i < m; i++) {
            datas[i][n-1] = 1;
        }
        for(int j = n-2; j >= 0; j--) {
            for(int i = m-2; i >= 0; i--) {
                datas[i][j] = datas[i + 1][j] + datas[i][j + 1];
            }
        }
        return datas[0][0];
    }

    public static void main(String[] args) {
        UniquePath6202 up = new UniquePath6202();
        int m = 0;
        int n = 0;
        int paths = up.uniquePaths(m, n);
        System.out.println("paths = " + paths);

        UniquePaths62 up1 = new UniquePaths62();
        int paths1 = up1.uniquePaths(m, n);
        System.out.println("paths1 = " + paths1);
    }
}
