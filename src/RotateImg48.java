import java.util.Arrays;

/**
 * Created by Amysue on 2016/8/19.
 */
public class RotateImg48 {
    public void rotate(int[][] matrix) {
        int Len = matrix.length - 1;
        for(int i = 0; i <= Len; i++) {
            for(int j = i; j <= Len; j++) {
                if (i + j >= Len) {
                    break;
                }
                int first = matrix[i][j];
                matrix[i][j] = matrix[Len - j][i];
                matrix[Len - j][i] = matrix[Len - i][Len - j];
                matrix[Len - i][Len - j] = matrix[j][Len - i];
                matrix[j][Len-i] = first;
            }
        }
    }

    public static void main(String[] args) {
        RotateImg48 rt = new RotateImg48();
        int N = 4;
        int num = 1;
        int[][] matrix = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                matrix[i][j] = num++;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        rt.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));

    }
}
