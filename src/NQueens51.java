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
        if (n == 1) {
            List<String> result = Arrays.asList("Q");
            results.add(result);
            return results;
        }
        if (n <= 3) {
            return results;
        }
        Map<Integer, Integer> nq = new HashMap<>(n);
        N = n;
        MASK = (long) (1 << n) - 1;
        addQueen(nq, 0, 0L, 0L, 0L);
        return results;
    }

    private void addQueen(Map<Integer, Integer> nq, int row, long col, long ld, long rd) {
        if (row == N) {
            List<String> result1 = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                char[] queens = new char[N];
                Arrays.fill(queens, '.');
                int j = nq.get(i);
                queens[j] = 'Q';
                result1.add(new String(queens));
            }
            results.add(result1);
            return;
        }
        long status = ~(col | ld | rd) & MASK;
        while (status > 0) {
            long pos = status & -status;
            int j = getJ(pos);
            nq.put(row, j);
            addQueen(nq, row+1, col | pos, (ld | pos)<<1, (rd | pos)>>1);
            status -= pos;
        }

        return;
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
        int       n  = 7;
        List<List<String>> results = sn.solveNQueens(n);
        NQueens5102        sn2      = new NQueens5102();
        List<List<String>> results2 = sn2.solveNQueens(n);
//        NQueensTotal52     nt       = new NQueensTotal52();
//        int                total    = nt.totalNQueens(n);
        System.out.println(results.size());
        System.out.println(results2.size());
//        System.out.println(total);
        /*for (List<String> list : results) {
            System.out.println(list);
        }*/

    }
}
