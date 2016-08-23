import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Amysue on 2016/8/23.
 */
public class NQueensTotal5202 {
    private int total = 0;
    private int N = 0;
    private int Len = 0;
    private int M = 0;
    public int totalNQueens(int n) {
        if (n == 1) {
            return 1;
        }
        if (n <= 3) {
            return 0;
        }
        N = n - 1;
        Len = n;
        Map<Integer, Integer> nq = new HashMap<>(n);
        addQueen(nq, 0);
        return total;
    }
    private void addQueen(Map<Integer, Integer> nq, int row) {
        if (row == N) {
            boolean addTwo = nq.get(0)*2 < (N-1) ? true : false;
            if (addTwo) {
                total += 2;
            } else {
                total += 1;
            }
            return;
        }
        int[] candidate = new int[N];
        if (row > 0) {
            for (int i = 0; i < row; i++) {
                int len = row - i;
                int y   = nq.get(i);
                candidate[y] = -1;
                int y1 = y + len;
                removeItem(y1, candidate, N - 1);
                int y2 = y - len;
                removeItem(y2, candidate, N - 1);

            }
        }
        for (int i = 0; i < candidate.length; i++) {
            if (row == 0 && i * 2 > (N - 1)) {
                break;
            }
            if (candidate[i] != -1) {
                nq.put(row, i);
                addQueen(nq, row + 1);
            }

        }

        return;
    }

    private void removeItem(int value, int[] candidate, int Max) {
        if (value >= 0 && value <= Max) {
            candidate[value] = -1;
            return;
        }
        return;
    }
    public int compute(int n) {
        int m = (1 <<n) - 1;
        return m;
    }

    public void computbit(int n) {
        BitSet bs = new BitSet();
        bs.set(0, true);
        bs.set(n-1, true);
    }

    public static void main(String[] args) {
        NQueensTotal5202 nt2 = new NQueensTotal5202();
        int n = 9;
        long m = (long)(1<<n) - 1;
        System.out.println(m);
        System.out.println(Long.toBinaryString(m));
        nt2.computbit(n);
        int i = 0x15;
        System.out.println(Integer.toBinaryString(i));
        while (i > 0) {
            int pos = i & -i;
            System.out.println(Integer.toBinaryString(pos));
            int pos2 = i & (i-1);
            System.out.println(Integer.toBinaryString(pos2));
            i = pos2;
        }


    }
}
