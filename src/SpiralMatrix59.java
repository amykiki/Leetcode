import java.util.Arrays;

/**
 * Created by Amysue on 2016/8/28.
 */
public class SpiralMatrix59 {
    public int[][] generateMatrix(int n) {
        int[][] results = new int[n][n];
        generate(results, 0, n-1, 1);
        return results;
    }

    private void generate(int[][] results, int low, int high,  int n) {
        if (low > high) {
            return;
        }
        for(int j = low; j <= high; j++) {
            results[low][j] = n++;
        }
        if (high > low) {
            for(int i = low + 1; i < high; i++) {
                results[i][high] = n++;
            }
            for(int j = high; j >= low; j--) {
                results[high][j] = n++;
            }
            for(int i = high - 1; i > low; i--) {
                results[i][low] = n++;
            }
        }
        generate(results, low + 1, high - 1, n);
    }

    public static void main(String[] args) {
        SpiralMatrix59 sm = new SpiralMatrix59();
        int n = 5;
        int[][] results = sm.generateMatrix(n);
        for(int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(results[i]));
        }
    }
}
