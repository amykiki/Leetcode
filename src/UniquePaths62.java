import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Amysue on 2016/8/30.
 */
public class UniquePaths62 {
    public int uniquePaths(int m, int n) {
        int   nBlocks = m * n;
        int[] blocks  = new int[m * n];
        if (nBlocks <= 2) {
            return 1;
        }
        List<Integer> paths = new ArrayList<>();
        paths.add(0);
        blocks[0] = 1;
        int XMAX = (m - 1) * n;
        int YMAX = n - 1;
        int index = 0;
        while (index != paths.size() && index != nBlocks - 1) {
            int i = paths.get(index);
            if (i % n < YMAX) {
                int xNext = i + 1;
                add(paths, blocks, i, xNext);
            }
            if (i < XMAX) {
                int yNext = i + n;
                add(paths, blocks, i, yNext);
            }
            index++;
        }
        return blocks[nBlocks-1];
    }

    private void add(List<Integer> paths, int[] blocks, int last, int crt) {
        if (blocks[crt] == 0) {
            paths.add(crt);
        }
        blocks[crt] += blocks[last];
    }
    public static void main(String[] args) {
        UniquePaths62 up    = new UniquePaths62();
        int           m     = 3;
        int           n     = 7;
        int           paths = up.uniquePaths(m, n);
        System.out.println("paths = " + paths);
    }
}
