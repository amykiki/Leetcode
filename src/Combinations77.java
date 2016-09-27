import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Amysue on 2016/9/27.
 */
public class Combinations77 {
    public List<List<Integer>> combine(int n, int k) {
        if(k <= 0 || n <= 0 || k > n) return null;
        Integer[] results = new Integer[k];
        List<List<Integer>> lists = new ArrayList<>();
        int start = 1;
        int end = n - k + 1;
        add(start, end, 0, results, lists, n, k);
        return lists;
    }

    private void add(int start, int end, int i, Integer[] results, List<List<Integer>> lists, int n, int k) {
        if (end == n) {
            for (int m = start; m <= n; m++) {
                results[i] = m;
                lists.add(new ArrayList<Integer>(Arrays.asList(results)));
            }
        } else {
            for(int m = start; m <= end; m++) {
                results[i] = m;
                add(m + 1, end + 1, i + 1, results, lists, n, k);
            }
        }
    }

    public static void main(String[] args) {
        Combinations77 cb = new Combinations77();
        int n = 2;
        int k = 2;
        List<List<Integer>> lists = cb.combine(n, k);
        System.out.println("lists = " + lists);
    }
}
