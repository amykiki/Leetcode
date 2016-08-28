import java.util.*;

/**
 * Created by Amysue on 2016/8/28.
 */
public class PermutationSequence60 {
    private static int[] fac = computeFac();
    private static int[] computeFac() {
        int[] fac = new int[9];
        fac[0] = 1;
        fac[1] = 1;
        for(int i = 2; i <= 8; i++) {
            fac[i] = i * fac[i-1];
        }
        return fac;
    }
    public String getPermutation(int n, int k) {
        char[] nums = new char[n];
        List<Character> list = new ArrayList<>(n);
        for(int i = 1; i <= n; i++) {
            char c = (char) (i + '0');
            list.add(c);
        }
        fill(n, k, nums, 0, list);
        return new String(nums);
    }
    private void fill(int n, int k, char[] nums, int i, List<Character> list) {
        if (n == 1) {
            nums[i] = list.get(0);
            return;
        }
        int fnum = fac[n-1];
        int index = (k-1)/ fnum;
        nums[i] = list.get(index);
        list.remove(index);
        fill(n - 1, k - index*fnum, nums, i+1, list);
    }

    public static void main(String[] args) {
        PermutationSequence60 ps = new PermutationSequence60();
        int n = 4;
        int k = 6;
        String s = ps.getPermutation(n, k);
        System.out.println("s = " + s);

    }
}
