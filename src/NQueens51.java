import java.util.*;

/**
 * Created by Amysue on 2016/8/22.
 */
/*改用bitwise来解决问题，效率更高，基本思想一致*/
public class NQueens51 {
    private List<List<String>> results = new ArrayList<>();
    private int                N       = 0;
    private Long               MASK    = 0L;

    public List<List<String>> solveNQueens(int n) {
        N = n;
        MASK = (long) (1 << n) - 1;
        addQueen(0, 0L, 0L, 0L, new ArrayList<>());
        return results;
    }

    private void addQueen(int row, long col, long ld, long rd, List<String> crt) {
        if (row == N) {
            results.add(new ArrayList<>(crt));
            return;
        }
        long status = ~(col | ld | rd) & MASK;
        while (status > 0) {
            long pos = status & -status;
            addStr(pos, crt);
            addQueen(row+1, col | pos, (ld | pos)<<1, (rd | pos)>>1, crt);
            status -= pos;
            crt.remove(row);
        }
        return;
    }

    private void addStr(long pos, List<String> crt) {
        int j = getJ(pos);
        char[] queens = new char[N];
        Arrays.fill(queens, '.');
        queens[j] = 'Q';
        crt.add(new String(queens));
    }

    private int getJ(long pos) {
        int i = N;
        while (pos > 0) {
            pos >>= 1;
            i--;
        }
        return i;
    }


    public static void main(String[] args) {
        NQueens51 sn = new NQueens51();
        int       n  = 4;
        List<List<String>> results = sn.solveNQueens(n);
        NQueens5102        sn2      = new NQueens5102();
        List<List<String>> results2 = sn2.solveNQueens(n);
//        NQueensTotal52     nt       = new NQueensTotal52();
//        int                total    = nt.totalNQueens(n);
        System.out.println(results.size());
        System.out.println(results2.size());
//        System.out.println(total);
        for (List<String> list : results) {
            System.out.println(list);
        }

    }
}
