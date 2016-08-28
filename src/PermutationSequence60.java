import java.util.*;

/**
 * Created by Amysue on 2016/8/28.
 */
public class PermutationSequence60 {
    public String getPermutation(int n, int k) {
        StringBuilder nums = new StringBuilder(n);
        List<Integer> list = new ArrayList<>(n);
        for(int i = 1; i <= n; i++) {
            list.add(i);
        }
        Map<Integer, Integer> fac = new HashMap<>(n);
        computeFac(n - 1, fac);
        fill(n, k, nums, list, fac);
        return nums.toString();
    }

    private void fill(int n, int k, StringBuilder nums, List<Integer> list, Map<Integer, Integer> fac) {
        if (n == 1) {
            nums.append(list.get(0));
            return;
        }
        int fnum = fac.get(n-1);
        int index = (k-1)/ fnum;
        int i = list.get(index);
        nums.append(i);
        list.remove(index);
        fill(n - 1, k - index*fnum, nums, list, fac);
    }
    private void computeFac(int n, Map<Integer, Integer> fac) {
        fac.put(0, 1);
        fac.put(1, 1);
        if (n <= 1) {
            return;
        }
        for(int i = 2; i <= n; i++) {
            fac.put(i, i * fac.get(i - 1));
        }
    }

    public static void main(String[] args) {
        PermutationSequence60 ps = new PermutationSequence60();
        int n = 4;
        int k = 5;
        String s = ps.getPermutation(n, k);
        System.out.println("s = " + s);

    }
}
