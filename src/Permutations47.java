import java.util.*;

/**
 * Created by Amysue on 2016/8/18.
 */
public class Permutations47 {
    List<List<Integer>> results = new ArrayList<>();
    int Len = 0;
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null) {
            return null;
        }
        ArrayList<Integer> nLists = new ArrayList<>(nums.length);
        Len = nums.length;
        Arrays.sort(nums);
        ArrayList<Integer> result = new ArrayList<>(nums.length);
        for(int i = 0; i < nums.length; i++) {
            nLists.add(nums[i]);
            result.add(0);
        }
        concat(nLists, result, 0);
        return results;
    }

    private void concat(ArrayList<Integer> nLists, ArrayList<Integer> result, int count) {
        if (count == Len - 1) {
            result.set(count, nLists.get(0));
            results.add((List)result.clone());
            return;
        }
        int last = 0;
        for(int i = 0; i < nLists.size(); i++) {
            if (i > 0 && nLists.get(i)== last) {
                continue;
            }
            int current = nLists.get(i);
            result.set(count, current);
            ArrayList<Integer> nexts = (ArrayList<Integer>)nLists.clone();
            nexts.remove(i);
            concat(nexts, result, count+1);
            last = current;
        }
    }

    public static void main(String[] args) {
        Permutations47 ptt = new Permutations47();
//        int[] nums = {1, 2, 1, 4, 3, 3};
        int[] nums = {2,2,1,1};
//        int[] nums = {1, 1, 2};
        List<List<Integer>> results = ptt.permuteUnique(nums);
        System.out.println(results.size());
        System.out.println(results);
    }
}
