import java.util.*;

/**
 * Created by Amysue on 2016/8/22.
 */
public class NQueens51 {
    private List<List<String>> results = new ArrayList<>();
    private int                N       = 0;

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
        List<Integer> candidate = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            candidate.add(i);
        }
        addQueen(nq, 0);
        return results;
    }

    private void addQueen(Map<Integer, Integer> nq, int row) {
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


    public static void main(String[] args) {
        NQueens51          sn      = new NQueens51();
        int                n       = 10;
        List<List<String>> results = sn.solveNQueens(n);
        NQueens5102 sn2 = new NQueens5102();
        List<List<String>> results2 = sn2.solveNQueens(n);
        System.out.println(results.size());
        System.out.println(results2.size());
        for (List<String> list : results) {
//            System.out.println(list);
        }

    }
}
