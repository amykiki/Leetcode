import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Amysue on 2016/8/18.
 */
public class Permutations46 {
    private List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<Integer> datas = new ArrayList<>(nums.length);
        for(int i = 0; i < nums.length; i++) {
            datas.add(nums[i]);
        }
        concat(new Integer[nums.length], datas, 0);
        return results;
    }

    private void concat(Integer[] result, List<Integer> datas, int start) {
        if (start == result.length - 1) {
            result[start] = datas.get(0);
            results.add(new ArrayList<>(Arrays.asList(result)));
            return;
        }
        for (int i = 0; i < datas.size(); i++) {
            result[start] = datas.get(i);
            List<Integer> next = new ArrayList<>();
            next.addAll(datas.subList(0, i));
            next.addAll(datas.subList(i + 1, datas.size()));
            concat(result, next, start+1);
        }
    }

    public static void main(String[] args) {
        Permutations46      pt      = new Permutations46();
//        int[]               nums    = {1, 2, 3, 4, 5};
        int[]               nums    = {1, 2, 3, 4};
        List<List<Integer>> results = pt.permute(nums);
        System.out.println(results);
    }

}
